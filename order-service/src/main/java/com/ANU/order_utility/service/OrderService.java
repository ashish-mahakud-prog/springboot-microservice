package com.ANU.order_utility.service;

import com.ANU.order_utility.model.Order;
import com.ANU.order_utility.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public void createNewOrder(Order order){
        orderRepository.save(order);

    }

    public void deleteOrderById(Long id){
        orderRepository.deleteById(id);
    }

}
