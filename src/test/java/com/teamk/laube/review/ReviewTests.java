package com.teamk.laube.review;

import static org.assertj.core.api.Assertions.assertThat;

import com.teamk.laube.domain.review.Review;
import com.teamk.laube.domain.review.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@SpringBootTest
@PropertySource("classpath:config.properties")
public class ReviewTests {
    @Autowired
    ReviewRepository reviewRepository;
//    @Test
//    void save(){
//        Review params = Review.builder()
//                .userId(1L)
//                .content("내용")
//                .username("ㅇㅇ")
//                .perfumeId(1L)
//                .rate(5)
//                .id(1L)
//                .build();
//        reviewRepository.save(params);
//
//        Review entity = reviewRepository.findById(1L).get();
//        assertThat(entity.getContent()).isEqualTo("내용");
//        assertThat(entity.getUserId()).isEqualTo(1L);
//        assertThat(entity.getUsername()).isEqualTo("ㅇㅇ");
//    }
    @Test
    void findAll(){
        long reviewsCount = reviewRepository.count();
        List<Review> reviews = reviewRepository.findAll();
    }
//    @Test
//    void delete() {
//
//        // 1. 게시글 조회
//        Review entity = reviewRepository.findById((long)1).get();
//
//        // 2. 게시글 삭제
//        reviewRepository.delete(entity);
//    }

}
