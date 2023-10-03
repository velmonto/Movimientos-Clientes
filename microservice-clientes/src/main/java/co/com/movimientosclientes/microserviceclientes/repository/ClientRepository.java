package co.com.movimientosclientes.microserviceclientes.repository;

import co.com.movimientosclientes.microserviceclientes.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
