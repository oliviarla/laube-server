package com.teamk.laube.domain.like;

import com.teamk.laube.domain.review.Review;
import com.teamk.laube.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByMemberAndReview(Member member, Review review);
    Integer countByReview(Review review);
    Like findByReview_Id(@Param(value="ReviewId") long reviewId);
}
