package com.ANU.order_utility.repository;

import com.ANU.order_utility.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
