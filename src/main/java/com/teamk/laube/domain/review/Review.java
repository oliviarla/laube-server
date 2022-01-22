package com.teamk.laube.domain.review;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Review {
    @Id
    private Long id;

    private String username;
    private Long userId;
    private Long perfumeId;

    private int rate;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime regdate=LocalDateTime.now();
    @Column
    private LocalDateTime updatedate;
    @Column
    private LocalDateTime deletedate;
    @Builder
    public Review(String username, Long userId, Long perfumeId, int rate, String content, Long id){
        this.username=username;
        this.userId=userId;
        this.perfumeId=perfumeId;
        this.content=content;
        this.rate=rate;
        this.id=id;
    }
}
