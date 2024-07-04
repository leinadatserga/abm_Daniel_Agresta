package com.ecommerce.abm_Daniel_Agresta.services;

import com.ecommerce.abm_Daniel_Agresta.entities.Cart;
import com.ecommerce.abm_Daniel_Agresta.repositories.CartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartsRepository repository;

    public Cart newCart(Cart cart) {
        return repository.save(cart);
    }

    public List<Cart> readAllCarts() {
        return repository.findAll();
    }

    public Optional<Cart> readCartById(Long id) {
        return repository.findById(id);
    }

    public void deleteCart(Long id) {
        repository.deleteById(id);
    }
}
