package org.crud.appparqueadero.repositorio;

import org.crud.appparqueadero.model.RegistroVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repositorio extends JpaRepository<RegistroVehiculo, String> {

}
