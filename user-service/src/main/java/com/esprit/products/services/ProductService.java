package com.esprit.carts.services;

import com.esprit.carts.entity.Product;
import com.esprit.carts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class ProductService {
        @Autowired
        private ProductRepository productRepository;

        // Create operation
        public Product createProduct(Product product) {
            return productRepository.save(product);
        }

        // Read operations
        public List<Product> getAllProducts() {
            return productRepository.findAll();
        }

        public Optional<Product> getProductById(Long id) {
            return productRepository.findById(id);
        }

        // Update operation
        public Product updateProduct(Long id, Product product) {
            if (productRepository.existsById(id)) {
                product.setId(id); // assurez-vous que l'ID de l'objet à sauvegarder correspond à celui passé en paramètre
                return productRepository.save(product);
            } else {
                return null; // ou vous pouvez lever une exception selon vos besoins
            }
        }

        // Delete operation
        public void deleteProduct(Long id) {
            productRepository.deleteById(id);
        }
    }

