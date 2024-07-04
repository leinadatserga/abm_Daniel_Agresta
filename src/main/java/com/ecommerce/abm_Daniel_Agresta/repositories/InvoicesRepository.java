package com.ecommerce.abm_Daniel_Agresta.repositories;

import com.ecommerce.abm_Daniel_Agresta.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoicesRepository extends JpaRepository<Invoice, Long> {
}
