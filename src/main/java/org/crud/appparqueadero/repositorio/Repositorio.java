package org.crud.appparqueadero.repositorio;

import org.crud.appparqueadero.model.RegistroVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.temporal.Temporal;

public interface Repositorio extends JpaRepository<RegistroVehiculo, String> {

    @Query(value = "SELECT  fecha_entrada  FROM registros", nativeQuery = true)
    Temporal  findFechaEntrada (String fecha);
}
