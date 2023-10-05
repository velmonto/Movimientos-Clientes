package co.com.movimientos.microservicemovimientos.model;

import co.com.movimientos.microservicemovimientos.dto.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accountNo", nullable = false, length = 100, unique = true)
    private int accountNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "accountType", nullable = false)
    private AccountType accountType;

    @Column(name = "initialBalance", nullable = false)
    private float initialBalance;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "identificationClient")
    private int identificationClient;

    @Column(name = "nameClient")
    private String nameClient;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
    List<Movements> movements;


}
