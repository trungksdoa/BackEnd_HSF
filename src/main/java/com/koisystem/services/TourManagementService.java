package com.koisystem.services;

import com.koisystem.dto.ServiceResponse;
import com.koisystem.models.Tour;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TourManagementService {
    private final TourService tourService;

    public ServiceResponse<List<Tour>> getUpcomingTours() {
        try {
            List<Tour> tours = tourService.getUpcomingTours();
            return ServiceResponse.success("Upcoming tours retrieved successfully", tours);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<Tour> createTour(Tour tour) {
        try {
            Tour savedTour = tourService.saveTour(tour);
            return ServiceResponse.success("Tour created successfully", savedTour);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }
} 