package co.com.movimientos.microservicemovimientos.service;

import co.com.movimientos.microservicemovimientos.model.Movements;
import co.com.movimientos.microservicemovimientos.repository.MovementRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovementServiceImpl implements MovementService{

    private static final Logger logger = LoggerFactory.getLogger(MovementServiceImpl.class);

    private final MovementRepository movementRepository;

}
