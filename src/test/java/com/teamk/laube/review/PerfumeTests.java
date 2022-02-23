package com.teamk.laube.review;

import com.teamk.laube.domain.perfume.Perfume;
import com.teamk.laube.domain.perfume.PerfumeRepository;
import com.teamk.laube.domain.perfumebase.PerfumeBaseRepository;
import com.teamk.laube.domain.perfumemid.PerfumeMidRepository;
import com.teamk.laube.domain.perfumetop.PerfumeTopRepository;
import com.teamk.laube.domain.review.Review;
import com.teamk.laube.dto.PerfumeResponseDto;
import com.teamk.laube.dto.ReviewResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Sort;

import java.util.List;
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
        //List<Review> reviews = reviewRepository.findAll();
        System.out.println("perfume 개수: "+ perfumesCount);
    }

}
