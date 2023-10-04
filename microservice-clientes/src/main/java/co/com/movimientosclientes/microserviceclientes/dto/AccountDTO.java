package co.com.movimientosclientes.microserviceclientes.dto;

import javax.persistence.*;

public class AccountDTO {

    private Long id;
    private int accountNo;
    private AccountType accountType;
    private float initialBalance;
    private Status status;
}
