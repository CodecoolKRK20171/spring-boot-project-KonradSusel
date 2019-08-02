package com.codecool.onlinestore.controller;

import com.codecool.onlinestore.model.Order;
import com.codecool.onlinestore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    private OrderRepository oR;

    @PostMapping
    public void addOrder(@RequestBody Order order) {
        oR.insertWithEntityManager(order);
    }

}
