package com.ANU.order_utility.service;

import com.ANU.order_utility.model.Order;
import com.ANU.order_utility.model.Product;
import com.ANU.order_utility.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderService {

    private RestTemplate restTemplate;

    private OrderRepository orderRepository;

    public void createNewOrder(Order order){

        String requestBody = "body";
        //used to add headers
        HttpHeaders headers =new HttpHeaders();
        headers.add("Content-Type","application/json");

        // used to add header and data body that the api will send
        HttpEntity<String> entity =new HttpEntity(headers);
        restTemplate.getForObject("url", Product.class);
        restTemplate.getForEntity("url", String.class);
        var res = restTemplate.postForEntity("url", requestBody, String.class);
        restTemplate.exchange("url", HttpMethod.GET,entity, String.class);


        orderRepository.save(order);

    }

    public void deleteOrderById(Long id){
        orderRepository.deleteById(id);
    }

}
