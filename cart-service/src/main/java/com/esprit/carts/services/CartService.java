package com.esprit.carts.services;

import com.esprit.carts.entity.Cart;
import com.esprit.carts.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class CartService {
        @Autowired
        private CartRepository productRepository;

        // Create operation
        public Cart createCart(Cart product) {
            return productRepository.save(product);
        }

        // Read operations
        public List<Cart> getAllCarts() {
            return productRepository.findAll();
        }

        public Optional<Cart> getCartById(Long id) {
            return productRepository.findById(id);
        }

        // Update operation
        public Cart updateCart(Long id, Cart product) {
            if (productRepository.existsById(id)) {
                product.setId(id); // assurez-vous que l'ID de l'objet à sauvegarder correspond à celui passé en paramètre
                return productRepository.save(product);
            } else {
                return null; // ou vous pouvez lever une exception selon vos besoins
            }
        }

        // Delete operation
        public void deleteCart(Long id) {
            productRepository.deleteById(id);
        }
    }

