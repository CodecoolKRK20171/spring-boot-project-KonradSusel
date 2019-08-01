package com.codecool.onlinestore.controller;

import com.codecool.onlinestore.model.Product;
import com.codecool.onlinestore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "name")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path = "/insert")
    public void addProduct(@RequestBody Product product) {
        productRepository.insertWithEntityMenager(product);
    }

}