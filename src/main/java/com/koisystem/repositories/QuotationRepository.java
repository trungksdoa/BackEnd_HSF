package com.koisystem.repositories;

import com.koisystem.models.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuotationRepository extends JpaRepository<Quotation, Long> {
    List<Quotation> findByOrderId(Long orderId);
    List<Quotation> findByStatus(String status);
}
