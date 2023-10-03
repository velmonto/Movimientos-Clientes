package co.com.movimientosclientes.microserviceclientes.repository;

import co.com.movimientosclientes.microserviceclientes.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
