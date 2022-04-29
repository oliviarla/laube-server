package com.teamk.laube.domain.member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "member")
public class Member {
    @Id
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column
    private String image;
    @Column(columnDefinition = "TEXT")
    private String token;
    @Builder
    public Member(String id, String name, String email, String image, String token){
        this.id = id;
        this.name = name;
        this.email = email;
        this.image = image;
        this.token=token;
    }
}
