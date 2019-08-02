package com.codecool.onlinestore.repository;

import com.codecool.onlinestore.model.Basket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class BasketRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithEntityMenager(Basket basket) {
        this.entityManager.persist(basket);
    }

    @Transactional
    public List<Basket> getAllBaskets() {
        return this.entityManager.createQuery("FROM Basket", Basket.class).getResultList();
    }
}
