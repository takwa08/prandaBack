package com.esprit.carts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cart {
                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                private Long id;
                private Long productId;
                private int quantity;
                // other fields, constructors, getters, and setters
        }


