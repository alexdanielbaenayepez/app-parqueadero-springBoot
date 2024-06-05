package org.crud.appparqueadero.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;


@Component
@Entity
@Table(name = "registros")
@Data //esta es la documentacion  https://projectlombok.org/features/Data Lombok

public class RegistroVehiculo {

    public RegistroVehiculo(String placa, String tipoVehiculo){
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
    }

    @Id
    @Column(name = "placa", nullable=false, unique = true)
    private String placa;

    @Column(name = "fecha_entrada", nullable = false )
    private LocalDateTime fechaEntrada = LocalDateTime.now();

    @Column(name = "fecha_salida", nullable = false )
    private LocalDateTime fechaSalida = now();

    @Column(name = "tipo_vehiculo")
    private String tipoVehiculo;

    public RegistroVehiculo() {

    }
}
