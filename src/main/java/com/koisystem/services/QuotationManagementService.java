package com.koisystem.services;

import com.koisystem.dto.ServiceResponse;
import com.koisystem.models.Quotation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuotationManagementService {
    private final QuotationService quotationService;

    public ServiceResponse<List<Quotation>> getQuotationsByOrder(Long orderId) {
        try {
            List<Quotation> quotations = quotationService.getQuotationsByOrder(orderId);
            return ServiceResponse.success("Quotations retrieved successfully", quotations);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<List<Quotation>> getQuotationsByStatus(String status) {
        try {
            List<Quotation> quotations = quotationService.getQuotationsByStatus(status);
            return ServiceResponse.success("Quotations retrieved successfully", quotations);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<Quotation> createQuotation(Quotation quotation) {
        try {
            Quotation savedQuotation = quotationService.saveQuotation(quotation);
            return ServiceResponse.success("Quotation created successfully", savedQuotation);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<Quotation> updateQuotationStatus(Long id, String status) {
        try {
            Quotation updatedQuotation = quotationService.updateQuotationStatus(id, status);
            return ServiceResponse.success("Quotation status updated successfully", updatedQuotation);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }
} 