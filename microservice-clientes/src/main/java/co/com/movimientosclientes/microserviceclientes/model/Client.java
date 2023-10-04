package co.com.movimientosclientes.microserviceclientes.model;

import co.com.movimientosclientes.microserviceclientes.dto.AccountDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "password", nullable = false, length = 4)
    private int password;

    @Column(name = "status")
    private int status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    @JsonIgnoreProperties("client")
    private Person person;


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
