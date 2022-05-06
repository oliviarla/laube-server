package com.teamk.laube.review;

import static org.assertj.core.api.Assertions.assertThat;

import com.teamk.laube.domain.member.AuthProvider;
import com.teamk.laube.domain.perfume.Perfume;
import com.teamk.laube.domain.perfume.PerfumeRepository;
import com.teamk.laube.domain.review.Review;
import com.teamk.laube.domain.review.ReviewRepository;
import com.teamk.laube.domain.member.Member;
import com.teamk.laube.domain.member.MemberRepository;
import com.teamk.laube.dto.ReviewResponseDto;
import com.teamk.laube.exception.CustomException;
import com.teamk.laube.exception.ErrorCode;
import com.teamk.laube.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
@PropertySource("classpath:config.properties")
public class ReviewTests {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    PerfumeRepository perfumeRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ReviewService reviewService;
    @Test
    void save(){
        Perfume perfume = Perfume.builder()
                .name("perfume")
                .price((long)150000)
                .brand("brand")
                .content("information")
                .image("links")
                .build();
        perfumeRepository.save(perfume);

        Member member = Member.builder()
                .name("tom")
                .email("tom@gmail.com")
                .emailVerified(true)
                .imageUrl("picture link")
                .password("1234")
                .provider(AuthProvider.google)
                .providerId("tom")
                .build();
        memberRepository.save(member);
        Review params = Review.builder()
                .member(member)
                .content("내용")
                .rate(5)
                .perfume(perfume)
                .build();
        reviewRepository.save(params);

        Review entity = reviewRepository.findById(1L).get();
        assertThat(entity.getContent()).isEqualTo("내용");
    }
    @Test
    void findAll(){
        long reviewsCount = reviewRepository.count();
        Sort sort = Sort.by(Sort.Direction.DESC, "id", "regdate");
        List<Review> list = reviewRepository.findAll(sort);
        System.out.println(list.stream().map(ReviewResponseDto::new).collect(Collectors.toList()));
        //List<Review> reviews = reviewRepository.findAll();
        System.out.println("review 개수: "+ reviewsCount);
    }

    @Test
    void findById(){
        Optional<Review> review = reviewRepository.findById((long)2);
        System.out.println(review.toString());
    }

    @Test
    void delete() {
        // 1. 게시글 조회
        Review entity = reviewRepository.findById((long)1).get();

        // 2. 게시글 삭제
        reviewRepository.delete(entity);
    }
    @Test
    void update(){
        Review entity= reviewRepository.findById((long)2).orElseThrow(()->new CustomException(ErrorCode.POSTS_NOT_FOUND));
        System.out.println("내용:"+entity.getContent());
        Member member = Member.builder()
                .name("이름")
                .email("a@gmail.com")
                .imageUrl("picture link")
                .build();
        entity.update("good!", member);
        System.out.println("내용:"+entity.getContent());
        reviewRepository.save(entity);
    }



}
