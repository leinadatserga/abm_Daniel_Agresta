package com.ecommerce.abm_Daniel_Agresta.controllers;

import com.ecommerce.abm_Daniel_Agresta.entities.Cart;
import com.ecommerce.abm_Daniel_Agresta.entities.Product;
import com.ecommerce.abm_Daniel_Agresta.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/carts")
public class CartsController {
    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<Object> createCart(@RequestBody Cart cart) {
        try {
            Cart newCart = cartService.newCart(cart);
            return new ResponseEntity<>(newCart, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts() {
        List<Cart> carts = cartService.readAllCarts();
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCartById(@PathVariable Long id) {
        try {
            Optional<Cart> cart = cartService.readCartById(id);
            if (cart.isPresent()) {
                return new ResponseEntity<>(cart.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cart not found", HttpStatus.NOT_FOUND);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{id}/product")
    public ResponseEntity<?> addProductToCart(@PathVariable Long id, @RequestBody List<Product> products) {
        try {
            Cart updatedCart = cartService.addProductToCart(id, products);
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/products")
    public ResponseEntity<Object> addProductsToCart(@PathVariable Long id, @RequestBody List<Long> productIds) {
        try {
            Cart updatedCart = cartService.addProductsToCart(id, productIds);
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCart(@PathVariable Long id) {
        try {
            cartService.deleteCart(id);
            return new ResponseEntity<>("Cart deleted successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
