package co.com.movimientosclientes.microserviceclientes.service;

import co.com.movimientosclientes.microserviceclientes.model.Client;
import co.com.movimientosclientes.microserviceclientes.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienServiceImpl implements ClientService{


    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    @Override
    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long clientId){
        clientRepository.deleteById(clientId);
    }

    @Override
    public Client updateClient(Client client){
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> findAllClientById(Long id){
        return clientRepository.findById(id);
    }
}
