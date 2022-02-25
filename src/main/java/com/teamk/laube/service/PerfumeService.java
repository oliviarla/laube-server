package com.teamk.laube.service;

import com.teamk.laube.domain.perfume.Perfume;
import com.teamk.laube.domain.perfume.PerfumeRepository;
import com.teamk.laube.domain.perfumebase.PerfumeBaseRepository;
import com.teamk.laube.domain.perfumemid.PerfumeMidRepository;
import com.teamk.laube.domain.perfumetop.PerfumeTop;
import com.teamk.laube.domain.perfumetop.PerfumeTopRepository;
import com.teamk.laube.dto.PerfumeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public List<PerfumeResponseDto> findAll(){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<Perfume> list = perfumeRepository.findAll(sort);
        //PerfumeTop
        return list.stream().map(PerfumeResponseDto::new).collect(Collectors.toList());
    }

    public Optional<PerfumeResponseDto> findById(Long id){
        Optional<Perfume> perfume= perfumeRepository.findById(id);
        return perfume.map(PerfumeResponseDto::new);
    }

}
