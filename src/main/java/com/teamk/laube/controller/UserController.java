package com.teamk.laube.controller;

import com.teamk.laube.dto.UserDto;
import com.teamk.laube.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @CrossOrigin("http://localhost:3000")
    @PostMapping(value="/api/user", consumes = "application/json")
    public String save(@RequestBody UserDto userDto){
        System.out.println(userDto.getId());
        return userService.save(userDto);
    }
}
