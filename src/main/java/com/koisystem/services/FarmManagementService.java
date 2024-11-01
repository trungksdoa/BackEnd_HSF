package com.koisystem.services;

import com.koisystem.dto.ServiceResponse;
import com.koisystem.models.Farm;
import com.koisystem.models.KoiFish;
import com.koisystem.models.Tour;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FarmManagementService {
    private final FarmService farmService;
    private final KoiFishService koiFishService;
    private final TourService tourService;

    public ServiceResponse<List<Farm>> getAllFarms() {
        try {
            List<Farm> farms = farmService.getAllFarms();
            return ServiceResponse.success("Farms retrieved successfully", farms);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<Farm> getFarmById(Long id) {
        try {
            Farm farm = farmService.getFarmById(id);
            return ServiceResponse.success("Farm retrieved successfully", farm);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<Farm> createFarm(Farm farm) {
        try {
            Farm savedFarm = farmService.saveFarm(farm);
            return ServiceResponse.success("Farm created successfully", savedFarm);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<Farm> updateFarm(Long id, Farm farm) {
        try {
            farm.setId(id);
            Farm updatedFarm = farmService.saveFarm(farm);
            return ServiceResponse.success("Farm updated successfully", updatedFarm);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<Void> deleteFarm(Long id) {
        try {
            farmService.deleteFarm(id);
            return ServiceResponse.success("Farm deleted successfully", null);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<List<KoiFish>> getKoiFishByFarm(Long id) {
        try {
            List<KoiFish> koiFish = koiFishService.getKoiFishByFarm(id);
            return ServiceResponse.success("Koi fish retrieved successfully", koiFish);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<List<Tour>> getToursByFarm(Long id) {
        try {
            List<Tour> tours = tourService.getToursByFarm(id);
            return ServiceResponse.success("Tours retrieved successfully", tours);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }
} 