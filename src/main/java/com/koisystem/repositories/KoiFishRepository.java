package com.koisystem.repositories;

import com.koisystem.models.KoiFish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface KoiFishRepository extends JpaRepository<KoiFish, Long> {
    List<KoiFish> findByFarmId(Long farmId);
    List<KoiFish> findByVariety(String variety);
}
