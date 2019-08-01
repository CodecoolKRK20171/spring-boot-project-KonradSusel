package com.codecool.onlinestore.repository;

import com.codecool.onlinestore.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithEntityManager(Customer customer) {
        this.entityManager.persist(customer);
    }

    @Transactional
    public List<Customer> getAllCustomers() {
        return this.entityManager.createQuery("FROM Customer", Customer.class).getResultList();
    }


    public Customer getCustomerByIdWithEntityManager(int customerId) {
        //this method searches for primarykey customerId
        return this.entityManager.find(Customer.class, customerId);
    }
}