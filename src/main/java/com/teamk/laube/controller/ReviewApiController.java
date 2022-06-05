package com.teamk.laube.controller;

import com.teamk.laube.dto.ReviewRequestDto;
import com.teamk.laube.dto.ReviewResponseDto;
import com.teamk.laube.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ReviewApiController {
    private final ReviewService reviewService;

    @PostMapping("/reviews")
    public Long save(@RequestBody final ReviewRequestDto params){
        return reviewService.save(params);
    }

    @GetMapping("/reviews")
    public List<ReviewResponseDto> findAll(){
        return reviewService.findAll();
    }

    @GetMapping("/reviews/{id}")
    public Optional<ReviewResponseDto> findById(@PathVariable final Long id){
        return reviewService.findById(id);
    }

    @PatchMapping("/reviews/{id}")
    public Long save(@PathVariable final Long id, @RequestBody final ReviewRequestDto params){
        return reviewService.update(id, params);
    }
}
