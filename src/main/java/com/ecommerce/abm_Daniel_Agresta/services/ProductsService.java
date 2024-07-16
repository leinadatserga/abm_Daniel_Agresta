package com.ecommerce.abm_Daniel_Agresta.services;

import com.ecommerce.abm_Daniel_Agresta.entities.Product;
import com.ecommerce.abm_Daniel_Agresta.repositories.CartsRepository;
import com.ecommerce.abm_Daniel_Agresta.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository repository;
    private CartsRepository cartsRepository;

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