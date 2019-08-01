package com.codecool.onlinestore.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "basket_Sequence")
    @SequenceGenerator(name = "basket_Sequence", sequenceName = "basket_SEQ")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "basket")
    private List<Product> Products;

    public Basket() { }

    public Basket(String name, List<Product> products) {
        this.name = name;
        Products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }
}
