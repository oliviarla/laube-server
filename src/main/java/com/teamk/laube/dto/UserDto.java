package com.teamk.laube.dto;

import com.teamk.laube.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String imageUrl;

    @Builder
    public UserDto(Long id, String name, String email, String imageUrl, String token){
        this.id=id;
        this.name=name;
        this.email=email;
        this.imageUrl=imageUrl;
    }

    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .imageUrl(imageUrl)
                .build();
    }
}
