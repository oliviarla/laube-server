package com.teamk.laube.controller;

import com.teamk.laube.service.LikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LikeApiController {
    private final LikeService likeService;

    @PostMapping("/like/{recipeId}")
    public ResponseEntity<String> addLike(
            @AuthenticationPrincipal MemberAdapter memberAdapter,
            @PathVariable Long recipeId) {

        boolean result = false;

        if (memberAdapter != null) {
            result = likeService.addLike(memberAdapter.getMember(), recipeId);
        }

        return result ?
                new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

//    @GetMapping("/like")
//    public List<String> getLikeCount(@RequestParam("id") Long id, @LoginMember User user) throws Exception {
//        log.info("review-id : {}", id);
//        log.info("loginMember : {}", user);
//
//        List<String> resultData = likeService.count(id, user);
//        log.info("likeCount : {}", resultData);
//
//        return resultData;
//    }
}
