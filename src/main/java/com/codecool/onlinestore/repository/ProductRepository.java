package com.codecool.onlinestore.repository;

import com.codecool.onlinestore.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithEntityMenager(Product product) {
        this.entityManager.persist(product);
    }
}
