package com.example.OrderService.service;

import com.example.OrderService.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private WebClient webClient;

    public Order saveOrder(Order order){
        webClient.get().
    }
}
