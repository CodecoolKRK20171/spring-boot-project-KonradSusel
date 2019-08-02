package com.codecool.onlinestore.controller;

import com.codecool.onlinestore.model.Product;
import com.codecool.onlinestore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.getAllCustomers();
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productRepository.insertWithEntityMenager(product);
    }


//    @PostMapping
//    public void addProduct(@RequestBody Product product) {
//        productRepository.save(product);
//    }
//
//    @GetMapping(path="/{id}")
//    public Optional<Product> getProduct(@PathVariable(value="id") Long id) {
//        return productRepository.findById(id);
//    }
//
//    @GetMapping
//    public Iterable<Product> getAllProducts() {
//        return productRepository.findAll();
//    }
//
//    @DeleteMapping(path="/{id}")
//    public void deleteProduct(@PathVariable(value="id") Long id) {
//        productRepository.deleteById(id);
//    }
//
//    @DeleteMapping
//    public void deleteProduct(Product product) {
//        productRepository.delete(product);
//    }

}