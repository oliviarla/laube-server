package com.teamk.laube.service;

import com.teamk.laube.domain.like.Like;
import com.teamk.laube.domain.like.LikeRepository;
import com.teamk.laube.domain.review.Review;
import com.teamk.laube.domain.review.ReviewRepository;
import com.teamk.laube.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final ReviewRepository reviewRepository;

    public boolean addLike(Member member, Long reviewId) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        Review review = (Review) optionalReview.ofNullable(null).get();
        if(!isAlreadyLike(member, review)){
            likeRepository.save(new Like(member, review));
            return true;
        }
        return false;
    }

    private void cancelLike(Member member, Long reviewId) throws Exception {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        Review review = (Review) optionalReview.ofNullable(null).get();
        Optional<Like> optionalLike = likeRepository.findByMemberAndReview(member, review);
        Like like = (Like) optionalLike.ofNullable(null).get();

        likeRepository.delete(like);
    }

    public List<String> count(Long reviewId, Member member) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        Review review = optionalReview.orElse(null);
        int reviewLikeCount = likeRepository.countByReview(review);

        List<String> resultData = new ArrayList<>(Arrays.asList(String.valueOf(reviewLikeCount)));

        if(Objects.nonNull(member)){
            resultData.add(String.valueOf(isAlreadyLike(member, review)));
            return resultData;
        }
        return resultData;
    }

    private boolean isAlreadyLike(Member member, Review review){
        return likeRepository.findByMemberAndReview(member, review).isPresent();
    }
}
