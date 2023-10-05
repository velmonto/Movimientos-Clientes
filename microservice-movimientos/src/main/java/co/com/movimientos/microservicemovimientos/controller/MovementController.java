package co.com.movimientos.microservicemovimientos.controller;

import co.com.movimientos.microservicemovimientos.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movimientos")
public class MovementController {

    private static final Logger logger = LoggerFactory.getLogger(MovementController.class);

    @GetMapping
    public ResponseEntity<?> getMovementByAccountNo(int accountNo){
        return null;
    }
}
