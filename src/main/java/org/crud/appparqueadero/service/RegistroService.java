package org.crud.appparqueadero.service;

import org.crud.appparqueadero.model.RegistroVehiculo;
import org.crud.appparqueadero.repositorio.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistroService {

    @Autowired
    private Repositorio repositorio;

    public RegistroVehiculo guardar(RegistroVehiculo registroVehiculo){
        return repositorio.save(registroVehiculo);
    }

    public List<RegistroVehiculo> all() {
        return repositorio.findAll();
    }

    public RegistroVehiculo one(String placa){
        return repositorio.findById(placa).orElseThrow(()-> new RuntimeException("Placa no encontrada"));
    }

    public RegistroVehiculo update(String placa, RegistroVehiculo registro){
        RegistroVehiculo registroVehiculo = repositorio.findById(placa).orElseThrow(()-> new RuntimeException("placa no encontrada"));

        return registro;

        // en este metodo toca añadir una nueva bariable y es la cc del propietario para cambiar datos de la placa del
        // vehiculo osu misma cc en caso de ser mal añadida
        // ya que la fecha sera de forma automatica
    }

    public RegistroVehiculo deleteOne(String placa){
        RegistroVehiculo registroVehiculo = repositorio.findById(placa).orElseThrow(()-> new RuntimeException("placa no encontrada"));
        repositorio.deleteById(placa);
        return registroVehiculo;
    }



    /*
     * @param CalcularPrecio
     * Hacer un metodo que añ listar todos los vehiculos tambien erroje el total del producido de ese mes
     * un metodo que arroje el total del tiempo y el valor que un vehiculo ha estado en el parqueadero
     *
     */
    public long CalcularPrecio(String placa, long precio, LocalDateTime fechaEntrada, LocalDateTime fechaSalida){
       // en este metodo calcular el precio segun las horas contadas
       // en los parametros voy a necesitar la fecha de entrada y la salida
        // https://javautodidacta.es/tiempo-en-java-localdate-localtime/
        // https://www.digitalocean.com/community/tutorials/java-8-date-localdate-localdatetime-instant#3-localdatetime
        return precio;
    }
}
