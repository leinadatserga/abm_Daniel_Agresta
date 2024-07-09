package com.ecommerce.abm_Daniel_Agresta.controllers;

import com.ecommerce.abm_Daniel_Agresta.entities.Client;
import com.ecommerce.abm_Daniel_Agresta.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/clients")
public class ClientsController {

    @Autowired
    private ClientsService service;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Client> create(@RequestBody Client dataClient) {
        try {
            Client client = service.newClient(dataClient);
            return new ResponseEntity<>(client, HttpStatus.CREATED);
        } catch (Exception exception) {
            System.out.println(exception);
            throw new RuntimeException("Error in Client creation/update");
        }
    }

    @GetMapping()
    public ResponseEntity <List<Client>> readAllClients() {
        try {
            List<Client> clients = service.readAllClients();
            return ResponseEntity.ok(clients);
        } catch (Exception exception) {
            System.out.println(exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> readClientsById(@PathVariable("id") Long id) {
        try {
            Optional<Client> client = service.readClientById(id);
            if (client.isPresent()) {
                return ResponseEntity.ok(client);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception exception) {
            System.out.println(exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Map<String, Object>> deleteClient(@PathVariable Long id) {
        try {
            service.deleteClient(id);
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            System.out.println(exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
