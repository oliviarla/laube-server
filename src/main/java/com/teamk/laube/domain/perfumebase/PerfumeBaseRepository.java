package com.teamk.laube.domain.perfumebase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface PerfumeBaseRepository extends JpaRepository<PerfumeBase, Long> {
    public Collection<PerfumeBase> findByPerfume_Id(@Param(value="PerfumeId") long perfumeID);
}
