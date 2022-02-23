package com.teamk.laube.dto;

import com.teamk.laube.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDto {
    private String id;
    private String name;
    private String email;
    private String picture;
    private String token;

    @Builder
    public UserDto(String id, String name, String email, String picture, String token){
        this.id=id;
        this.name=name;
        this.email=email;
        this.picture=picture;
        this.token=token;
    }

    public User toEntity(){
        return User.builder().
                id(id)
                .name(name)
                .email(email)
                .picture(picture)
                .token(token)
                .build();
    }
}
