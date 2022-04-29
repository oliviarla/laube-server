package com.teamk.laube.dto;

import com.teamk.laube.domain.perfume.Perfume;
import lombok.Getter;

@Getter
public class PerfumeResponseDto {
    private Long price;
    private String name;
    private String brand;
    private String content;
    private String image;

    public PerfumeResponseDto(Perfume entity){
        this.price=entity.getPrice();
        this.content=entity.getContent();
        this.brand=entity.getBrand();
        this.name=entity.getName();
        this.image=entity.getImage();
    }
}
