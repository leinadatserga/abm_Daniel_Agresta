package com.ecommerce.abm_Daniel_Agresta.repositories;

import com.ecommerce.abm_Daniel_Agresta.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<Client, Long> {
}
