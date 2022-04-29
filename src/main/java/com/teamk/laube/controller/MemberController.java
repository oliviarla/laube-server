package com.teamk.laube.controller;

import com.teamk.laube.dto.ReviewResponseDto;
import com.teamk.laube.dto.MemberDto;
import com.teamk.laube.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @CrossOrigin("http://localhost:3000")
    @PostMapping(value="/user", consumes = "application/json")
    public String save(@RequestBody MemberDto memberDto){
        System.out.println(memberDto.getId());
        return memberService.save(memberDto);
    }

    @GetMapping("/user")
    public List<ReviewResponseDto> findReviews(@RequestParam("id") String id){
        return memberService.findReviews(id);
    }
}
