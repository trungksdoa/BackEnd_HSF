package com.koisystem.services;

import com.koisystem.models.Feedback;
import com.koisystem.repositories.FeedbackRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    
    public List<Feedback> getFeedbackByOrder(Long orderId) {
        return feedbackRepository.findByOrderId(orderId);
    }
    
    public List<Feedback> getFeedbackByCustomer(Long customerId) {
        return feedbackRepository.findByCustomerId(customerId);
    }
    
    public List<Feedback> getHighRatedFeedback(Integer minRating) {
        return feedbackRepository.findByRatingGreaterThanEqual(minRating);
    }
    
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
    
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
