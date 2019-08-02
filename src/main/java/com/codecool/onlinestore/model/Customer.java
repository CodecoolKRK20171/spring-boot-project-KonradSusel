package com.codecool.onlinestore.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int id;
        @NotBlank
        private String firstName;
        @NotBlank
        private String lastName;

        @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
        private Set<Order> orders;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getId() {
                return id;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }
}

