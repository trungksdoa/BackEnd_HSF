package com.koisystem.services;

import com.koisystem.models.KoiFish;
import com.koisystem.repositories.KoiFishRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KoiFishService {
    private final KoiFishRepository koiFishRepository;
    
    public List<KoiFish> getKoiFishByFarm(Long farmId) {
        return koiFishRepository.findByFarmId(farmId);
    }
    
    public List<KoiFish> getKoiFishByVariety(String variety) {
        return koiFishRepository.findByVariety(variety);
    }
    
    public KoiFish saveKoiFish(KoiFish koiFish) {
        return koiFishRepository.save(koiFish);
    }
}
