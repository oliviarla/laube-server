package com.teamk.laube.domain.perfume;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Perfume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String brand;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;


    @Builder
    public Perfume(String name, Long price, String brand, String content){
        this.name=name;
        this.price=price;
        this.brand=brand;
        this.content=content;
    }
}