package com.teamk.laube.dto;

import com.teamk.laube.domain.perfume.Perfume;
import com.teamk.laube.domain.review.Review;
import com.teamk.laube.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReviewResponseDto {
    private String content;
    private int rate;
    private String userId;
    private String userName;
    //private Perfume perfume;
    private LocalDateTime regdate;
    private LocalDateTime updatedate;

    public ReviewResponseDto(Review entity){
        this.userId=entity.getUser().getId();
        this.userName=entity.getUser().getName();
        this.content=entity.getContent();
        this.rate=entity.getRate();
        //this.perfume=entity.getPerfume();
        this.regdate=entity.getRegdate();
        this.updatedate=entity.getUpdatedate();
    }
}
