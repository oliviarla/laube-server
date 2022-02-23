package com.teamk.laube.domain.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamk.laube.domain.perfume.Perfume;
import com.teamk.laube.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "perfume_id")
    private Perfume perfume;

    private int rate;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime regdate=LocalDateTime.now();
    private LocalDateTime updatedate;

    @Builder
    public Review(User user, Perfume perfume, int rate, String content){
        this.user=user;
        this.perfume=perfume;
        this.content=content;
        this.rate=rate;
    }

    public void update(String content, User user){
        this.content=content;
        this.user=user;
        this.updatedate=LocalDateTime.now();
    }
}
