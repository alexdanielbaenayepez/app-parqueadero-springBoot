package org.crud.appparqueadero.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;


@Component
@Entity
@Table(name = "registros")
@Data // esta es la documentacion  https://projectlombok.org/features/Data Lombok
public class RegistroVehiculo {

    public RegistroVehiculo(){}

    @Id
    @Column(name = "placa", nullable=false, unique = true)
    private String placa;

    @Column(name="cc_propietario")
    private String ccPropietario;

    @Column(name = "fecha_entrada", nullable = false )
    private LocalDateTime fechaEntrada; // dia + hora https://javautodidacta.es/tiempo-en-java-localdate-localtime/


    @Column(name = "fecha_salida", nullable = true)
    private LocalDateTime fechaSalida;
   // private Duration fechaSalida = Duration.between(this.fechaEntrada, LocalDateTime.now());

    @Column(name = "tipo_vehiculo")// validar que sea un tipo de vehiculo https://docs.spring.io/spring-data/rest/reference/validation.html
    private String tipoVehiculo;

}
