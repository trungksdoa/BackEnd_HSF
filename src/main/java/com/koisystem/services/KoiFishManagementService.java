package com.koisystem.services;

import com.koisystem.dto.ServiceResponse;
import com.koisystem.models.KoiFish;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KoiFishManagementService {
    private final KoiFishService koiFishService;

    public ServiceResponse<List<KoiFish>> getKoiFishByFarm(Long farmId) {
        try {
            List<KoiFish> koiFish = koiFishService.getKoiFishByFarm(farmId);
            return ServiceResponse.success("Koi fish retrieved successfully", koiFish);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<List<KoiFish>> getKoiFishByVariety(String variety) {
        try {
            List<KoiFish> koiFish = koiFishService.getKoiFishByVariety(variety);
            return ServiceResponse.success("Koi fish retrieved successfully", koiFish);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<KoiFish> createKoiFish(KoiFish koiFish) {
        try {
            KoiFish savedKoiFish = koiFishService.saveKoiFish(koiFish);
            return ServiceResponse.success("Koi fish created successfully", savedKoiFish);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<KoiFish> updateKoiFish(Long id, KoiFish koiFish) {
        try {
            koiFish.setId(id);
            KoiFish updatedKoiFish = koiFishService.saveKoiFish(koiFish);
            return ServiceResponse.success("Koi fish updated successfully", updatedKoiFish);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }
} 