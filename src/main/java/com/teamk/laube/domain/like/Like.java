package com.teamk.laube.domain.like;

import com.teamk.laube.domain.review.Review;
import com.teamk.laube.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="review_id")
    private Review review;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Like(Review review, User user){
        this.review=review;
        this.user=user;
    }
}
