package co.com.movimientosclientes.microserviceclientes.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name = "gender", length = 150, nullable = false)
    private String gender;

    @Column(name = "age", length = 150, nullable = false)
    private int age;

    @Column(name = "identification", length = 150, nullable = false)
    private int identification;

    @Column(name = "address", length = 150, nullable = false)
    private String address;

    @Column(name = "phone", length = 150, nullable = false)
    private String phone;

    @OneToOne(mappedBy = "clients")
    private Client client;
}
