package co.com.movimientos.microservicemovimientos.controller;

import co.com.movimientos.microservicemovimientos.dto.ResponseDTO;
import co.com.movimientos.microservicemovimientos.model.Account;
import co.com.movimientos.microservicemovimientos.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<?> saveAccount(@RequestBody Account account){
        logger.info("Se inicia creacion de cuenta");
        ResponseDTO responseDTO = accountService.getClientByIdentification(account.getIdentificationClient());
        account.setNameClient(responseDTO.getClientDTO().getPerson().getName());
        return new ResponseEntity<>(accountService.saveAccount(account), HttpStatus.CREATED);
    }
}
