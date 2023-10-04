package co.com.movimientosclientes.microserviceclientes.repository;

import co.com.movimientosclientes.microserviceclientes.model.Client;
import co.com.movimientosclientes.microserviceclientes.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByIdentification(int identification);
}
