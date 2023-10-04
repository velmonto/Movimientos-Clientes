package co.com.movimientosclientes.microserviceclientes.service;

import co.com.movimientosclientes.microserviceclientes.model.Client;
import co.com.movimientosclientes.microserviceclientes.model.Person;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getClients();

    Client saveClient(Client client);

    void deleteClient(Long clientId);

    Client updateClient(Client client);

    Optional<Client> findAllClientById(Long id);
}
