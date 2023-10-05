package co.com.movimientos.microservicemovimientos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movements")
public class Movements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movementDate", nullable = false)
    private Date movementDate;

    @Column(name = "movementType", nullable = false)
    private String movementType;

    @Column(name = "balance", nullable = false)
    private float balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_account")
    private Account account;

    @Column(name = "detailMovement", nullable = true)
    private String detailMovement;

    @Column(name = "movement", nullable = true)
    private float movement;


}
