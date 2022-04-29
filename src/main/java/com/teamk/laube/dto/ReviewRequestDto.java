package com.teamk.laube.dto;

import com.teamk.laube.domain.perfume.Perfume;
import com.teamk.laube.domain.review.Review;
import com.teamk.laube.domain.member.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewRequestDto {
    private String content;
    private int rate;
    private Member member;
    private Perfume perfume;

    public Review toEntity(){
        return Review.builder()
                .member(member)
                .perfume(perfume)
                .content(content)
                .rate(rate)
                .build();
    }

}
