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

    @PostMapping(path = "")
    public void addCustomer(@RequestBody Customer customer) {
        cR.insertWithEntityManager(customer);
    }

    @GetMapping(path = "")
    public List<Customer> customers() {
        return cR.getAllCustomers();
    }

    @GetMapping(path = "/{id}")
    public Customer getCustomerById(@PathVariable(value = "id") int customerId) {
        return cR.getCustomerByIdWithEntityManager(customerId);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCustomerById(@PathVariable(value = "id") int customerId) {
        Customer customer = getCustomerById(customerId);
        cR.deleteCustomerWithEntityManager(customer);
    }

    @PutMapping(path = "")
    public Customer updateCustomer(@RequestBody Customer updatedCustomer) {
        Customer oldCustomer = cR.getCustomerByIdWithEntityManager(updatedCustomer.getId());
        oldCustomer.setFirstName(updatedCustomer.getFirstName());
        oldCustomer.setLastName(updatedCustomer.getLastName());
        cR.insertWithEntityManager(oldCustomer);
        return oldCustomer;
    }

}
