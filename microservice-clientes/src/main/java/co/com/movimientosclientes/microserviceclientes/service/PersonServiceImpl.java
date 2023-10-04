package co.com.movimientosclientes.microserviceclientes.service;

import co.com.movimientosclientes.microserviceclientes.model.Person;
import co.com.movimientosclientes.microserviceclientes.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person findByIdentification(int identification){
        return personRepository.findByIdentification(identification);
    }
}
