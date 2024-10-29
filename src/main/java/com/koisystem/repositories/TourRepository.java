package com.koisystem.repositories;

import com.koisystem.models.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDateTime;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    List<Tour> findByStartDateAfter(LocalDateTime date);
    List<Tour> findByFarmId(Long farmId);
}
