package com.teamk.laube.dto;

import com.teamk.laube.domain.review.Review;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReviewResponseDto {
    private String content;
    private int rate;
    private String userId;
    private String username;
    private LocalDateTime regdate;
    private LocalDateTime updatedate;

    public ReviewResponseDto(Review entity){
        this.userId=entity.getMember().getId();
        this.username=entity.getMember().getName();
        this.content=entity.getContent();
        this.rate=entity.getRate();
        this.regdate=entity.getRegdate();
        this.updatedate=entity.getUpdatedate();
    }
}
