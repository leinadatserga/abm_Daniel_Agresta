package com.ecommerce.abm.controllers;

import com.ecommerce.abm.entities.Client;
import com.ecommerce.abm.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/clients")
public class ClientsController {

    @Autowired
    private ClientsService service;

    @PostMapping()
    public void newClient(@RequestBody Client client) {
        try {
            service.newClient(client);
        } catch (Exception exception) {
            System.out.println(exception);
            throw new RuntimeException("Error in Client creation");
        }
    }

    @GetMapping()
    public List<Client> readAllClients() {
        try {
            return service.readAllClients();
        } catch (Exception exception) {
            System.out.println(exception);
            throw new RuntimeException("Error in Clients list");
        }
    }

    @GetMapping("/{id}")
    public Optional<Client> readClientsById(@PathVariable("id") Long id) {
        try {
            return service.readClientById(id);
        } catch (Exception exception) {
            System.out.println(exception);
            throw new RuntimeException("Error in Client obtain");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        try {
            service.deleteClient(id);
        } catch (Exception exception) {
            System.out.println(exception);
            throw new RuntimeException("Error in Client deletion");
        }
    }
}
