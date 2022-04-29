package com.teamk.laube.service;

import com.teamk.laube.domain.review.Review;
import com.teamk.laube.domain.review.ReviewRepository;
import com.teamk.laube.domain.member.MemberRepository;
import com.teamk.laube.dto.ReviewResponseDto;
import com.teamk.laube.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public String save(MemberDto memberDto){
        return memberRepository.save(memberDto.toEntity()).getId();
    }

    public List<ReviewResponseDto> findReviews(String id){
        List<Review> list = reviewRepository.findByMember_Id(id);
        return list.stream().map(ReviewResponseDto::new).collect(Collectors.toList());
    }
}
