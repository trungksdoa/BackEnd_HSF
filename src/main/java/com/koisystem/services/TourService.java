package com.koisystem.services;

import com.koisystem.models.Tour;
import com.koisystem.repositories.TourRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TourService {
    private final TourRepository tourRepository;
    
    public List<Tour> getUpcomingTours() {
        return tourRepository.findByStartDateAfter(LocalDateTime.now());
    }
    
    public List<Tour> getToursByFarm(Long farmId) {
        return tourRepository.findByFarmId(farmId);
    }
    
    public Tour saveTour(Tour tour) {
        return tourRepository.save(tour);
    }
    
    public void deleteTour(Long id) {
        tourRepository.deleteById(id);
    }
}
