package com.ecommerce.abm_Daniel_Agresta.repositories;

import com.ecommerce.abm_Daniel_Agresta.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartsRepository extends JpaRepository<Cart, Long> {
}
