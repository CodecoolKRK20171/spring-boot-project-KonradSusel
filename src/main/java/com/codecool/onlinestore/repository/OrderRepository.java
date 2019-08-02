package com.codecool.onlinestore.repository;

import com.codecool.onlinestore.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithEntityManager(Order order) {
        this.entityManager.persist(order);
    }

    @Transactional
    public List<Order> getAllOrders() {
        return this.entityManager.createQuery("FROM Order", Order.class).getResultList();
    }

    public Order getOrderByIdWithEntityManager(int orderId) {
        return this.entityManager.find(Order.class, orderId);
    }

    @Transactional
    public void deleteOrderWithEntityManager(Order order) {
        entityManager.remove(order);
    }

}
