package com.esprit.carts.services;

import com.esprit.carts.entity.Order;
import com.esprit.carts.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class OrderService {
        @Autowired
        private OrderRepository orderRepository;

        // Create operation
        public Order createOrder(Order product) {
            return orderRepository.save(product);
        }

        // Read operations
        public List<Order> getAllOrders() {
            return orderRepository.findAll();
        }

        public Optional<Order> getOrderById(Long id) {
            return orderRepository.findById(id);
        }

        // Update operation
        public Order updateOrder(Long id, Order product) {
            if (orderRepository.existsById(id)) {
                product.setId(id); // assurez-vous que l'ID de l'objet à sauvegarder correspond à celui passé en paramètre
                return orderRepository.save(product);
            } else {
                return null; // ou vous pouvez lever une exception selon vos besoins
            }
        }

        // Delete operation
        public void deleteOrder(Long id) {
            orderRepository.deleteById(id);
        }
    }

