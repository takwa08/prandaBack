package com.esprit.carts.controller;


import com.esprit.carts.entity.Cart;
import com.esprit.carts.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService productService;

    @PostMapping
    public Cart createCart(@RequestBody Cart product) {
        return productService.createCart(product);
    }

    @GetMapping
    public List<Cart> getAllCarts() {
        return productService.getAllCarts();
    }

    @GetMapping("/{id}")
    public Optional<Cart> getCartById(@PathVariable Long id) {
        return productService.getCartById(id);
    }

    @PutMapping("/{id}")
    public Cart updateCart(@PathVariable Long id, @RequestBody Cart product) {
        return productService.updateCart(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id) {
        productService.deleteCart(id);
    }
}