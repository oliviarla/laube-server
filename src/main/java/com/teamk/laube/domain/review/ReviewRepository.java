package com.teamk.laube.domain.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ReviewRepository extends JpaRepository<Review, Long> {
    public List<Review> findByPerfume_Id(@Param(value="PerfumeId") long perfumeID);
    public List<Review> findByMember_Id(@Param(value="MemberId") String userID);
}
