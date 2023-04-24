package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void addOrder(Order order){
        orderRepository.addOrder(order);
    }
    public void addPartner(String partnerId){
        orderRepository.addPartner(partnerId);
    }
    public void addOrderPartnerPair(String orderId, String partnerId){
        orderRepository.addOrderPartnerPair(orderId,partnerId);
    }
    public Order getOrderById(String orderId){
        return orderRepository.getOrderById(orderId);
    }
}
