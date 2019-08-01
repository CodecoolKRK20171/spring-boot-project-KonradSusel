package com.codecool.onlinestore.controller;

import com.codecool.onlinestore.model.Customer;
import com.codecool.onlinestore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository cR;

    @PostMapping(path = "/insert")
    public void addCustomer(@RequestBody Customer customer) {
        cR.insertWithEntityManager(customer);
    }

    @GetMapping(path = "/getall")
    public List<Customer> customers() {
        return cR.getAllCustomers();
    }

    @GetMapping(path = "/get/{id}")
    public Customer getCustomerById(@PathVariable(value = "id") int customerId) {
        return cR.getCustomerByIdWithEntityManager(customerId);
    }
}
