package com.koisystem.services;

import com.koisystem.models.Quotation;
import com.koisystem.repositories.QuotationRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuotationService {
    private final QuotationRepository quotationRepository;
    
    public List<Quotation> getQuotationsByOrder(Long orderId) {
        return quotationRepository.findByOrderId(orderId);
    }
    
    public List<Quotation> getQuotationsByStatus(String status) {
        return quotationRepository.findByStatus(status);
    }
    
    public Quotation saveQuotation(Quotation quotation) {
        return quotationRepository.save(quotation);
    }
    
    public Quotation updateQuotationStatus(Long id, String status) {
        Quotation quotation = quotationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Quotation not found"));
        quotation.setStatus(status);
        return quotationRepository.save(quotation);
    }
}
