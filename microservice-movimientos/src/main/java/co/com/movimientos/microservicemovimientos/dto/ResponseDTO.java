package co.com.movimientos.microservicemovimientos.dto;

import co.com.movimientos.microservicemovimientos.model.Movements;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {

    private Movements movements;
    private ClientDTO clientDTO;
}
