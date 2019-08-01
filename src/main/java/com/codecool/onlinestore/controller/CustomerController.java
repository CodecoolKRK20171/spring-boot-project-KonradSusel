package com.codecool.onlinestore.controller;

import com.codecool.onlinestore.model.Customer;
import com.codecool.onlinestore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    CustomerRepository cR;

    @PostMapping(path = "/insert")
    public void addCustomer(@RequestBody Customer customer) {
        cR.insertWithEntityManager(customer);
    }
}
