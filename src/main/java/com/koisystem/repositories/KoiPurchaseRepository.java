package com.koisystem.repositories;

import com.koisystem.models.KoiPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface KoiPurchaseRepository extends JpaRepository<KoiPurchase, Long> {
    List<KoiPurchase> findByOrderId(Long orderId);
    List<KoiPurchase> findByFarmId(Long farmId);
    List<KoiPurchase> findByKoiFishId(Long koiFishId);
    List<KoiPurchase> findByStatus(String status);
}
