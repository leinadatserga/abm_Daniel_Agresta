package com.ecommerce.abm_Daniel_Agresta.services;

import com.ecommerce.abm_Daniel_Agresta.entities.Cart;
import com.ecommerce.abm_Daniel_Agresta.entities.Client;
import com.ecommerce.abm_Daniel_Agresta.repositories.CartsRepository;
import com.ecommerce.abm_Daniel_Agresta.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {
    @Autowired
    private ClientsRepository repository;

    @Autowired
    private CartsRepository cartsRepository;

    @Transactional
    public Client newClient(Client client) {
        if (client.getId() != null) {
            Optional<Client> existingClient = repository.findById(client.getId());
            if (existingClient.isPresent()) { return repository.save(client); }
        }
        Cart cart = new Cart();
        cart.setAmount(0);
        cart.setPrice(0.0);
        cart.setInvoice(null);
        cart.setClient(client);
        cartsRepository.save(cart);
        client.getCarts().add(cart);
        return repository.save(client);
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
