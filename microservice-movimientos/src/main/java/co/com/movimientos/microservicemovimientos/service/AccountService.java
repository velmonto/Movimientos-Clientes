package co.com.movimientos.microservicemovimientos.service;

import co.com.movimientos.microservicemovimientos.dto.ResponseDTO;
import co.com.movimientos.microservicemovimientos.model.Account;

public interface AccountService {
    ResponseDTO getClientByIdentification(int identification);

    Account saveAccount(Account account);
}
