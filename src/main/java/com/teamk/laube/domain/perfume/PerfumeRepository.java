package com.teamk.laube.domain.perfume;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PerfumeRepository extends JpaRepository<Perfume, Long> {
    List<Perfume> findByName(String name);
    @Query("select p.name, p.brand, p.image, round(avg(coalesce(r.rate,0)),2) from Perfume p " +
            //"left outer join " +
            "left outer join Review r on r.perfume = p group by p order by round(avg(coalesce(r.rate,0)),2) desc")
    Page<Object[]> getPageByRate(Pageable pageable);

    @Query("select p.name, p.brand, p.image, count(distinct r) from Perfume p " +
            "left outer join Review r on r.perfume = p group by p order by count(distinct r) desc")
    Page<Object[]> getPageByReviews(Pageable pageable);
}
