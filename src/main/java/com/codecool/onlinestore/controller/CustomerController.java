package com.codecool.onlinestore.controller;

import com.codecool.onlinestore.model.Customer;
import com.codecool.onlinestore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository cR;

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        cR.insertWithEntityManager(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return cR.getAllCustomersWithEntityManager();
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

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer updatedCustomer) {
        Customer oldCustomer = cR.getCustomerByIdWithEntityManager(updatedCustomer.getId());
        oldCustomer.setFirstName(updatedCustomer.getFirstName());
        oldCustomer.setLastName(updatedCustomer.getLastName());
        cR.insertWithEntityManager(oldCustomer);
        return oldCustomer;
    }

}
