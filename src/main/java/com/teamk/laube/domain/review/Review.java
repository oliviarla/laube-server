package com.teamk.laube.domain.review;

import com.teamk.laube.domain.like.Likes;
import com.teamk.laube.domain.perfume.Perfume;
import com.teamk.laube.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "perfume_id")
    private Perfume perfume;

    @OneToMany(cascade = CascadeType.ALL)
    Set<Likes> likes = new HashSet<>();

    private int rate;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime regdate=LocalDateTime.now();
    private LocalDateTime updatedate;

    @Builder
    public Review(Member member, Perfume perfume, int rate, String content) {
        this.member = member;
        this.perfume = perfume;
        this.content = content;
        this.rate = rate;
    }

    public void update(String content, Member member) {
        this.content = content;
        this.member = member;
        this.updatedate = LocalDateTime.now();
    }
}
