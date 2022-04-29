package com.teamk.laube.like;

import com.teamk.laube.domain.like.LikeRepository;
import com.teamk.laube.domain.review.ReviewRepository;
import com.teamk.laube.domain.member.Member;
import com.teamk.laube.service.LikeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

@SpringBootTest
@PropertySource("classpath:config.properties")
public class LikeTests {
    @Autowired
    LikeRepository likeRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    LikeService likeService;

    Member user = Member.builder()
            .id("a")
            .name("이름")
            .email("a@gmail.com")
            .image("picture link")
            .token("tbjfh324biuy2")
            .build();
    @Test
    public void likeTest(){
        //likeRepository.findByReview_Id((long)2);
        likeService.count((long)2, user).forEach(s -> System.out.println(s));
    }
}
