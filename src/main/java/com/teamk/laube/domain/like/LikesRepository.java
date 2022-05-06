package com.teamk.laube.domain.like;

import com.teamk.laube.domain.review.Review;
import com.teamk.laube.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findByMemberAndReview(Member member, Review review);
    Integer countByReview(Review review);
    List<Likes> findByReview_Id(@Param(value="ReviewId") long reviewID);
}
