package com.teamk.laube.like;

import com.teamk.laube.domain.like.LikesRepository;
import com.teamk.laube.domain.review.ReviewRepository;
import com.teamk.laube.domain.user.User;
import com.teamk.laube.service.LikeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

@SpringBootTest
@PropertySource("classpath:config.properties")
public class LikeTests {
    @Autowired
    LikesRepository likeRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    LikeService likeService;

    User user = User.builder()
            .name("이름")
            .email("a@gmail.com")
            .imageUrl("picture link")
            .build();
    @Test
    public void likeTest(){
        //likeRepository.findByReview_Id((long)2);
        likeService.count((long)1, user).forEach(s -> System.out.println(s));
    }
}
