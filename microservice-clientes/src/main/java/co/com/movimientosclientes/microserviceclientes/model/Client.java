package co.com.movimientosclientes.microserviceclientes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Client() {
    }

    public Client(int password, int status) {
        this.password = password;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
