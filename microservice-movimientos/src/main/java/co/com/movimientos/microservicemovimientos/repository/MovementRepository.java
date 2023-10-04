package co.com.movimientos.microservicemovimientos.repository;

import co.com.movimientos.microservicemovimientos.model.Movements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movements, Long> {
}
