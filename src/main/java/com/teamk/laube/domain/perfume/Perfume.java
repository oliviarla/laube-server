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

    @Transient
    private List<Review> reviews;
    @Transient
    private List<PerfumeTop> tops;
    @Transient
    private List<PerfumeMid> mids;
    @Transient
    private List<PerfumeBase> bases;

    @Builder
    public Perfume(String name, Long price, String brand, String content){
        this.name=name;
        this.price=price;
        this.brand=brand;
        this.content=content;
    }
}