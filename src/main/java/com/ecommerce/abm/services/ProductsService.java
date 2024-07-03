package com.ecommerce.abm.services;

import com.ecommerce.abm.entities.Client;
import com.ecommerce.abm.entities.Product;
import com.ecommerce.abm.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository repository;

    public void newProduct(Product product) {
        repository.save(product);
    }

    public List<Product> readAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> readProductById(Long id) {
        return repository.findById(id);
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
