package com.ecommerce.abm_Daniel_Agresta.controllers;

import com.ecommerce.abm_Daniel_Agresta.entities.Invoice;
import com.ecommerce.abm_Daniel_Agresta.repositories.InvoicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/invoices")
public class InvoiceController {
    @Autowired
    private InvoicesRepository invoicesRepository;

    // Obtener todas las facturas
    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoicesRepository.findAll();
    }

    // Obtener una factura por ID
    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
        Optional<Invoice> invoice = invoicesRepository.findById(id);
        if (invoice.isPresent()) {
            return ResponseEntity.ok(invoice.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear una nueva factura
    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return invoicesRepository.save(invoice);
    }

    // Actualizar una factura existente
    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable Long id, @RequestBody Invoice invoiceDetails) {
        Optional<Invoice> invoiceOptional = invoicesRepository.findById(id);
        if (invoiceOptional.isPresent()) {
            Invoice invoice = invoiceOptional.get();
            invoice.setCreatedAt(invoiceDetails.getCreatedAt());
            invoice.setTotal(invoiceDetails.getTotal());
            invoice.setClient(invoiceDetails.getClient());
            invoice.setCartDetails(invoiceDetails.getCartDetails());
            return ResponseEntity.ok(invoicesRepository.save(invoice));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una factura
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        Optional<Invoice> invoice = invoicesRepository.findById(id);
        if (invoice.isPresent()) {
            invoicesRepository.delete(invoice.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
