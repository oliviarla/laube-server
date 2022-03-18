package com.teamk.laube.service;

import com.teamk.laube.domain.note.Note;
import com.teamk.laube.domain.perfume.Perfume;
import com.teamk.laube.domain.perfume.PerfumeRepository;
import com.teamk.laube.domain.perfumebase.PerfumeBase;
import com.teamk.laube.domain.perfumebase.PerfumeBaseRepository;
import com.teamk.laube.domain.perfumemid.PerfumeMid;
import com.teamk.laube.domain.perfumemid.PerfumeMidRepository;
import com.teamk.laube.domain.perfumetop.PerfumeTop;
import com.teamk.laube.domain.perfumetop.PerfumeTopRepository;
import com.teamk.laube.dto.NoteResponseDto;
import com.teamk.laube.dto.PerfumeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PerfumeService {
    private final PerfumeRepository perfumeRepository;
    private final PerfumeTopRepository perfumeTopRepository;
    private final PerfumeMidRepository perfumeMidRepository;
    private final PerfumeBaseRepository perfumeBaseRepository;

    /**
     * 모든 향수 리스트 조회
     */
    @Transactional
    public List<PerfumeResponseDto> findAll(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<Perfume> list = perfumeRepository.findAll(sort);
        //PerfumeTop
        return list.stream().map(PerfumeResponseDto::new).collect(Collectors.toList());
    }

    /**
     * id로 향수 조회
     */
    public Optional<PerfumeResponseDto> findById(Long id){
        Optional<Perfume> perfume= perfumeRepository.findById(id);
        return perfume.map(PerfumeResponseDto::new);
    }

    /**
     * 이름으로 향수 조회
     */
    public List<PerfumeResponseDto> findByName(String name){
        List<Perfume> list = perfumeRepository.findByName(name);
        return list.stream().map(PerfumeResponseDto::new).collect(Collectors.toList());
    }

    /**
     * 향수 id로 top 노트 조회
     */
    public List<NoteResponseDto> findTopNoteById(Long id){
        Collection<PerfumeTop> perfumeTopList = perfumeTopRepository.findByPerfume_Id(id);
        List<Note> perfumeTops = new ArrayList<>();
        perfumeTopList.forEach(perfumeTop -> perfumeTops.add(perfumeTop.getNote()));
        return perfumeTops.stream().map(NoteResponseDto::new).collect(Collectors.toList());
    }
    /**
     * 향수 id로 mid 노트 조회
     */
    public List<NoteResponseDto> findMidNoteById(Long id){
        Collection<PerfumeMid> perfumeMidList = perfumeMidRepository.findByPerfume_Id(id);
        List<Note> perfumeMids = new ArrayList<>();
        perfumeMidList.forEach(perfumeMid -> perfumeMids.add(perfumeMid.getNote()));
        return perfumeMids.stream().map(NoteResponseDto::new).collect(Collectors.toList());
    }
    /**
     * 향수 id로 base 노트 조회
     */
    public List<NoteResponseDto> findBaseNoteById(Long id){
        Collection<PerfumeBase> perfumeBaseList = perfumeBaseRepository.findByPerfume_Id(id);
        List<Note> perfumeBases = new ArrayList<>();
        perfumeBaseList.forEach(perfumeBase -> perfumeBases.add(perfumeBase.getNote()));
        return perfumeBases.stream().map(NoteResponseDto::new).collect(Collectors.toList());
    }
}
