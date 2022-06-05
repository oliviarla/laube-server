package com.teamk.laube.controller;

import com.teamk.laube.domain.user.User;
import com.teamk.laube.domain.user.UserRepository;
import com.teamk.laube.dto.ReviewResponseDto;
import com.teamk.laube.dto.UserDto;
import com.teamk.laube.exception.ResourceNotFoundException;
import com.teamk.laube.security.CurrentUser;
import com.teamk.laube.security.UserPrincipal;
import com.teamk.laube.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService memberService;

    @CrossOrigin("http://localhost:3000")
    @PostMapping(value="/user", consumes = "application/json")
    public Long save(@RequestBody UserDto memberDto){
        System.out.println(memberDto.getId());
        return memberService.save(memberDto);
    }

    @GetMapping("/user")
    public List<ReviewResponseDto> findReviews(@RequestParam("id") String id){
        return memberService.findReviews(id);
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
