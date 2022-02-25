package com.teamk.laube.controller;

import com.teamk.laube.dto.PerfumeResponseDto;
import com.teamk.laube.service.PerfumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PerfumeApiController {
    private final PerfumeService perfumeService;
    @GetMapping("/perfumes/{id}")
    public Optional<PerfumeResponseDto> findById(@PathVariable final Long id){
        //현재는 향수 정보만 반환
        //to-do: 해당 향수에 대한 리뷰들 모두 전달해주어야 함
        return perfumeService.findById(id);
    }


}
