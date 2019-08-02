package com.codecool.onlinestore.repository;

import com.codecool.onlinestore.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@PersistenceContext
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithEntityMenager(Product product) {
        this.entityManager.persist(product);
    }

    @Transactional
    public List<Product> getAllCustomers(){
        return this.entityManager.createQuery("FROM Product", Product.class).getResultList();
    }


}
