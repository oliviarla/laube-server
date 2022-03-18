package com.teamk.laube.perfume;

import com.teamk.laube.domain.note.Note;
import com.teamk.laube.domain.perfume.Perfume;
import com.teamk.laube.domain.perfume.PerfumeRepository;
import com.teamk.laube.domain.perfumebase.PerfumeBaseRepository;
import com.teamk.laube.domain.perfumemid.PerfumeMidRepository;
import com.teamk.laube.domain.perfumetop.PerfumeTop;
import com.teamk.laube.domain.perfumetop.PerfumeTopRepository;
import com.teamk.laube.domain.review.Review;
import com.teamk.laube.dto.NoteResponseDto;
import com.teamk.laube.dto.PerfumeResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
@PropertySource("classpath:config.properties")
public class PerfumeTests {
    @Autowired
    PerfumeRepository perfumeRepository;

    @Autowired
    PerfumeBaseRepository perfumeBaseRepository;

    @Autowired
    PerfumeMidRepository perfumeMidRepository;

    @Autowired
    PerfumeTopRepository perfumeTopRepository;

    @Test
    void findAll(){
        long perfumesCount = perfumeRepository.count();
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<Perfume> list = perfumeRepository.findAll(sort);
        System.out.println(list.stream().map(PerfumeResponseDto::new).collect(Collectors.toList()));

        System.out.println("perfume 개수: "+ perfumesCount);
    }

    @Test
    void findTopNoteByPerfume(){
        //향수 id로 향수의 top note 가져오기
        Collection<PerfumeTop> perfumeTopList = perfumeTopRepository.findByPerfume_Id((long)1);
        List<Note> perfumeTops = new ArrayList<>();
        perfumeTopList.forEach(perfumeTop -> perfumeTops.add(perfumeTop.getNote()));
        for(Note perfumeTop: perfumeTops){
            System.out.println(perfumeTop.getName_kor());
        }
//        perfumeTopRepository.findByPerfume_Id((long)1).forEach(perfumeTop -> System.out.println("결과: "+ perfumeTop.getNote().getName_kor()));
//        perfumeMidRepository.findByPerfume_Id((long)1).forEach(perfumeMid -> System.out.println("결과: "+ perfumeMid.getNote().getName_kor()));
//        perfumeBaseRepository.findByPerfume_Id((long)1).forEach(perfumeBase -> System.out.println("결과: "+ perfumeBase.getNote().getName_kor()));
    }

    @Test
    void findByName(){
        List<Perfume> perfumes = perfumeRepository.findByName("perfume");
        perfumes.forEach(perfume -> System.out.println(perfume.getContent()));
    }
}
