package com.codecool.onlinestore.controller;

import com.codecool.onlinestore.model.Basket;
import com.codecool.onlinestore.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private BasketRepository basketRepository;

    @PostMapping
    public void addBasket(@RequestBody Basket basket) {
        basketRepository.insertWithEntityMenager(basket);
    }

    @GetMapping
    public List<Basket> addBasket() {
        return basketRepository.getAllBaskets();
    }
}
