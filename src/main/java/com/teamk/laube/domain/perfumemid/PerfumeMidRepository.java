package com.teamk.laube.domain.perfumemid;

import com.teamk.laube.domain.perfumetop.PerfumeTop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface PerfumeMidRepository extends JpaRepository<PerfumeMid, Long> {
    public Collection<PerfumeMid> findByPerfume_Id(@Param(value="PerfumeId") long perfumeID);
}
