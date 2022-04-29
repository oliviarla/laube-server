package com.teamk.laube.controller;

import com.teamk.laube.domain.perfume.Perfume;
import com.teamk.laube.dto.NoteResponseDto;
import com.teamk.laube.dto.PerfumeResponseDto;
import com.teamk.laube.dto.ReviewResponseDto;
import com.teamk.laube.service.PerfumeService;
import com.teamk.laube.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PerfumeApiController {
    private final PerfumeService perfumeService;
    private final ReviewService reviewService;

    @GetMapping("/perfumes")
    public List<PerfumeResponseDto> findByName(@RequestParam("name") final String name){
        return perfumeService.findByName(name);
    }

    @GetMapping("/perfumes/{id}")
    public JSONObject findById(@PathVariable final Long id){
        // 향수 정보 반환 + 해당 향수에 대한 리뷰들 모두 전달해주어야 함
        // Transient, model.attribute 찾아보았으나 그냥 JsonObject로 합쳐서 반환하면 됨
        Optional<PerfumeResponseDto> perfume = perfumeService.findById(id);
        List<NoteResponseDto> perfumeTopList=perfumeService.findTopNoteById(id);
        List<NoteResponseDto> perfumeMidList=perfumeService.findMidNoteById(id);
        List<NoteResponseDto> perfumeBaseList=perfumeService.findBaseNoteById(id);
        List<ReviewResponseDto> reviews = reviewService.findByPerfumeId(id);
        JSONObject perfumeInstance = new JSONObject();

        perfumeInstance.put("perfume", perfume);
        perfumeInstance.put("top", perfumeTopList);
        perfumeInstance.put("mid", perfumeMidList);
        perfumeInstance.put("base", perfumeBaseList);

        perfumeInstance.put("reviews", reviews);
        return perfumeInstance;
    }

    @GetMapping("/")
    public List<Object[]> getPageByRate(){
        return perfumeService.getPageByRate();
    }

    @GetMapping("/popular")
    public List<Object[]> getPageByReviews(){
        return perfumeService.getPageByReviews();
    }
}
