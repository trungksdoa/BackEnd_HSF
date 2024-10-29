package com.koisystem.repositories;

import com.koisystem.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByOrderId(Long orderId);
    List<Feedback> findByCustomerId(Long customerId);
    List<Feedback> findByRatingGreaterThanEqual(Integer rating);
}
