package co.com.movimientos.microservicemovimientos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;
    private String name;
    private String gender;
    private int age;
    private int identification;
    private String address;
    private String phone;

}
