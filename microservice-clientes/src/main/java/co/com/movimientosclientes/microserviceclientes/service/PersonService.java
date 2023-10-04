package co.com.movimientosclientes.microserviceclientes.service;

import co.com.movimientosclientes.microserviceclientes.model.Person;

public interface PersonService {
    Person findByIdentification(int identification);
}
