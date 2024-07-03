package com.ecommerce.abm_Daniel_Agresta.controllers;

import com.ecommerce.abm_Daniel_Agresta.entities.Product;
import com.ecommerce.abm_Daniel_Agresta.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "api/v1/products")
public class ProductsController {

    @Autowired
    private ProductsService service;

    @PostMapping()
    public void newProduct(@RequestBody Product product) {
        try {
            service.newProduct(product);
        } catch (Exception exception) {
            System.out.println(exception);
            throw new RuntimeException("Error in Product creation");
        }
    }

    @GetMapping()
    public List<Product> readAllProducts() {
        try {
            return service.readAllProducts();
        } catch (Exception exception) {
            System.out.println(exception);
            throw new RuntimeException("Error in Products list");
        }
    }

    @GetMapping("/{id}")
    public Optional<Product> readProductById(@PathVariable("id") Long id) {
        try {
            return service.readProductById(id);
        } catch (Exception exception) {
            System.out.println(exception);
            throw new RuntimeException("Error in Product obtain");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        try {
            service.deleteProduct(id);
        } catch (Exception exception) {
            System.out.println(exception);
            throw new RuntimeException("Error in Product deletion");
        }
    }
}