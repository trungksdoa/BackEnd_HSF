package com.koisystem.services;

import com.koisystem.dto.ServiceResponse;
import com.koisystem.models.Feedback;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackManagementService {
    private final FeedbackService feedbackService;

    public ServiceResponse<List<Feedback>> getFeedbackByOrder(Long orderId) {
        try {
            List<Feedback> feedback = feedbackService.getFeedbackByOrder(orderId);
            return ServiceResponse.success("Feedback retrieved successfully", feedback);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<List<Feedback>> getFeedbackByCustomer(Long customerId) {
        try {
            List<Feedback> feedback = feedbackService.getFeedbackByCustomer(customerId);
            return ServiceResponse.success("Feedback retrieved successfully", feedback);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<List<Feedback>> getHighRatedFeedback(Integer minRating) {
        try {
            List<Feedback> feedback = feedbackService.getHighRatedFeedback(minRating);
            return ServiceResponse.success("Feedback retrieved successfully", feedback);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<Feedback> createFeedback(Feedback feedback) {
        try {
            Feedback savedFeedback = feedbackService.saveFeedback(feedback);
            return ServiceResponse.success("Feedback created successfully", savedFeedback);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }

    public ServiceResponse<Void> deleteFeedback(Long id) {
        try {
            feedbackService.deleteFeedback(id);
            return ServiceResponse.success("Feedback deleted successfully", null);
        } catch (Exception e) {
            return ServiceResponse.error(e.getMessage());
        }
    }
} 