package com.koisystem.services;

import com.koisystem.models.KoiPurchase;
import com.koisystem.repositories.KoiPurchaseRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KoiPurchaseService {
    private final KoiPurchaseRepository koiPurchaseRepository;
    
    public List<KoiPurchase> getPurchasesByOrder(Long orderId) {
        return koiPurchaseRepository.findByOrderId(orderId);
    }
    
    public List<KoiPurchase> getPurchasesByFarm(Long farmId) {
        return koiPurchaseRepository.findByFarmId(farmId);
    }
    
    public List<KoiPurchase> getPurchasesByKoiFish(Long koiFishId) {
        return koiPurchaseRepository.findByKoiFishId(koiFishId);
    }
    
    public List<KoiPurchase> getPurchasesByStatus(String status) {
        return koiPurchaseRepository.findByStatus(status);
    }
    
    public KoiPurchase savePurchase(KoiPurchase purchase) {
        return koiPurchaseRepository.save(purchase);
    }
    
    public void deletePurchase(Long id) {
        koiPurchaseRepository.deleteById(id);
    }
    
    public KoiPurchase updatePurchaseStatus(Long id, String status) {
        KoiPurchase purchase = koiPurchaseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Purchase not found"));
        purchase.setStatus(status);
        return koiPurchaseRepository.save(purchase);
    }
}
