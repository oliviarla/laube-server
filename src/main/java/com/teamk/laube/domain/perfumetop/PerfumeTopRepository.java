package com.teamk.laube.domain.perfumetop;

import com.teamk.laube.domain.perfume.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface PerfumeTopRepository extends JpaRepository<PerfumeTop, Long> {
    public Collection<PerfumeTop> findByPerfume_Id(@Param(value="PerfumeId") long perfumeID);
}