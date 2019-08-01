package com.codecool.onlinestore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Customer {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int id;
        @NotBlank
        private String firstName;
        @NotBlank
        private String lastName;



        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
}

