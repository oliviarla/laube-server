package com.teamk.laube.dto;

import com.teamk.laube.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberDto {
    private String id;
    private String name;
    private String email;
    private String image;
    private String token;

    @Builder
    public MemberDto(String id, String name, String email, String image, String token){
        this.id=id;
        this.name=name;
        this.email=email;
        this.image=image;
        this.token=token;
    }

    public Member toEntity(){
        return Member.builder().
                id(id)
                .name(name)
                .email(email)
                .image(image)
                .token(token)
                .build();
    }
}
