package com.teamk.laube.controller;

import com.teamk.laube.dto.ReviewResponseDto;
import com.teamk.laube.dto.UserDto;
import com.teamk.laube.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @CrossOrigin("http://localhost:3000")
    @PostMapping(value="/user", consumes = "application/json")
    public String save(@RequestBody UserDto userDto){
        System.out.println(userDto.getId());
        return userService.save(userDto);
    }

    @GetMapping("/user")
    public List<ReviewResponseDto> findReviews(@RequestParam("id") String id){
        return userService.findReviews(id);
    }
}
