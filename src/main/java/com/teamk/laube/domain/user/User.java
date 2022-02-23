package com.teamk.laube.domain.user;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column
    private String picture;
    @Column(columnDefinition = "TEXT")
    private String token;
    @Builder
    public User(String id, String name, String email, String picture, String token){
        this.id = id;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.token=token;
    }
}
