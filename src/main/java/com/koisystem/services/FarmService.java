package com.koisystem.services;

import com.koisystem.models.Farm;
import com.koisystem.repositories.FarmRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FarmService {
    private final FarmRepository farmRepository;
    
    public List<Farm> getAllFarms() {
        return farmRepository.findAll();
    }
    
    public Farm getFarmById(Long id) {
        return farmRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Farm not found"));
    }
    
    public Farm saveFarm(Farm farm) {
        return farmRepository.save(farm);
    }
    
    public void deleteFarm(Long id) {
        farmRepository.deleteById(id);
    }

    public Farm updateFarm(Long id, Farm farm) {
        Farm existingFarm = getFarmById(id);
        existingFarm.setName(farm.getName());
        existingFarm.setLocation(farm.getLocation());
        existingFarm.setDescription(farm.getDescription());
        return farmRepository.save(existingFarm);
    }
}
