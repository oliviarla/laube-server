package com.teamk.laube.domain.like;

import com.teamk.laube.domain.review.Review;
import com.teamk.laube.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private User member;

    public Likes(User member, Review review){
        this.member=member;
        this.review=review;
    }
}
