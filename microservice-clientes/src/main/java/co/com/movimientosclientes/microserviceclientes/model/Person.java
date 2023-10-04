package co.com.movimientosclientes.microserviceclientes.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "person")
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

    @Column(name = "identification", length = 150, nullable = false, unique = true)
    private int identification;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", length = 150, nullable = false)
    private String phone;

    @OneToOne(mappedBy = "person")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Person() {
    }

    public Person(String name, String gender, int age, int identification, String address, String phone) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.identification = identification;
        this.address = address;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", identification=" + identification +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", client=" + client +
                '}';
    }
}
