package com.teamk.laube.controller;

import com.teamk.laube.exception.CustomException;
import com.teamk.laube.exception.ErrorCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ReviewApiController {
    @GetMapping("/test")
    public String test(){
        throw new CustomException(ErrorCode.POSTS_NOT_FOUND);
    }
}
