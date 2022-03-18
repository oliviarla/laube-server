package com.teamk.laube.domain.perfume;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerfumeRepository extends JpaRepository<Perfume, Long> {
    public List<Perfume> findByName(String name);
}
