package com.koisystem.repositories;

import com.koisystem.models.Order;
import com.koisystem.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(String status);

    @Query("select o from Order o where o.customer.id = ?1")
    List<Order> findByCustomerId(Long customer);
}
