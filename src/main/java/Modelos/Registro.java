package Modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Registro {

    private LocalDateTime fechaHora;
    private Double temperatura;
    private Double humedad;

}
