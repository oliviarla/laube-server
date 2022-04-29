package com.teamk.laube.domain.perfume;

import com.teamk.laube.domain.perfumebase.PerfumeBase;
import com.teamk.laube.domain.perfumemid.PerfumeMid;
import com.teamk.laube.domain.perfumetop.PerfumeTop;
import com.teamk.laube.domain.review.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    @Column(nullable = false)
    private String image;


    @Builder
    public Perfume(String name, Long price, String brand, String content, String image){
        this.name=name;
        this.price=price;
        this.brand=brand;
        this.content=content;
        this.image=image;
    }
}