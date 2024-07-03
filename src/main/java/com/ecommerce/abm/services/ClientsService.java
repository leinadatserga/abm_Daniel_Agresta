package com.ecommerce.abm.services;

import com.ecommerce.abm.entities.Client;
import com.ecommerce.abm.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {
    @Autowired
    private ClientsRepository repository;

    public void newClient(Client client) {
        repository.save(client);
    }

    public List<Client> readAllClients() {
        return repository.findAll();
    }

    public Optional<Client> readClientById(Long id) {
        return repository.findById(id);
    }

    public void deleteClient(Long id) {
        repository.deleteById(id);
    }
}
