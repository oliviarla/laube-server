package com.teamk.laube.controller;

import com.teamk.laube.dto.ReviewRequestDto;
import com.teamk.laube.dto.ReviewResponseDto;
import com.teamk.laube.exception.CustomException;
import com.teamk.laube.exception.ErrorCode;
import com.teamk.laube.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
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

    @PatchMapping("/reviews/{id}")
    public Long save(@PathVariable final Long id, @RequestBody final ReviewRequestDto params){
        return reviewService.update(id, params);
    }

}
