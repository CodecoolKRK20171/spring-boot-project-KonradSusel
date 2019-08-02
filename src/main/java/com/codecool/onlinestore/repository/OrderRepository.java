package com.codecool.onlinestore.repository;

import com.codecool.onlinestore.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithEntityManager(Order order) {
        this.entityManager.persist(order);
    }

}
