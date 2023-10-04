package co.com.movimientosclientes.microserviceclientes.controller;

import co.com.movimientosclientes.microserviceclientes.exception.ResourceNotFoundException;
import co.com.movimientosclientes.microserviceclientes.model.Client;
import co.com.movimientosclientes.microserviceclientes.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    public static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<?> getClients(){
        logger.info("Se inicia consulta de los clientes");
        return ResponseEntity.ok(clientService.getClients());
    }

    @PostMapping
    public ResponseEntity<?> saveClient(@RequestBody Client client){
        logger.info("Se inicia creacion de los clientes");
        return new ResponseEntity<>(clientService.saveClient(client), HttpStatus.CREATED);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId){
        logger.info("Se inicia eliminacion de los clientes");
        clientService.deleteClient(clientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> updateClient(@PathVariable Long clientId, @RequestBody Client detailClient){
        Client client = clientService.findAllClientById(clientId).orElseThrow(() -> new ResourceNotFoundException("No se encontro el cliente con Id: "+clientId));
        logger.info("Se encontro el siguiente cliente: "+client.toString());
        client.setPassword(detailClient.getPassword());
        client.setStatus(detailClient.getStatus());
        client.setPerson(detailClient.getPerson());
        Client clientUpdated = clientService.saveClient(client);
        return ResponseEntity.ok(clientUpdated);
    }
}
