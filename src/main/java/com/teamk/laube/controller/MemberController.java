package com.teamk.laube.controller;

import com.teamk.laube.domain.member.Member;
import com.teamk.laube.domain.member.MemberRepository;
import com.teamk.laube.dto.ReviewResponseDto;
import com.teamk.laube.dto.MemberDto;
import com.teamk.laube.exception.ResourceNotFoundException;
import com.teamk.laube.security.CurrentUser;
import com.teamk.laube.security.UserPrincipal;
import com.teamk.laube.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @CrossOrigin("http://localhost:3000")
    @PostMapping(value="/user", consumes = "application/json")
    public Long save(@RequestBody MemberDto memberDto){
        System.out.println(memberDto.getId());
        return memberService.save(memberDto);
    }

    @GetMapping("/user")
    public List<ReviewResponseDto> findReviews(@RequestParam("id") String id){
        return memberService.findReviews(id);
    }

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public Member getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return memberRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
