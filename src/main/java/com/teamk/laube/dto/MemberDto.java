package com.teamk.laube.dto;

import com.teamk.laube.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String name;
    private String email;
    private String imageUrl;

    @Builder
    public MemberDto(Long id, String name, String email, String imageUrl, String token){
        this.id=id;
        this.name=name;
        this.email=email;
        this.imageUrl=imageUrl;
    }

    public Member toEntity(){
        return Member.builder()
                .name(name)
                .email(email)
                .imageUrl(imageUrl)
                .build();
    }
}
