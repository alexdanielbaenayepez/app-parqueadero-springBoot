package org.crud.appparqueadero.service;

import org.crud.appparqueadero.model.RegistroVehiculo;
import org.crud.appparqueadero.repositorio.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.time.LocalDateTime.*;

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

    public RegistroVehiculo salida (String placa, RegistroVehiculo registro){
        RegistroVehiculo registroVehiculo = repositorio.findById(placa).orElseThrow(()-> new RuntimeException("placa no encontrada"));

        registroVehiculo.setFechaSalida(registro.getFechaSalida());


        repositorio.save(registroVehiculo);

        return registro;

    }

    public RegistroVehiculo deleteOne(String placa){
        RegistroVehiculo registroVehiculo = repositorio.findById(placa).orElseThrow(()-> new RuntimeException("placa no encontrada"));
        repositorio.deleteById(placa);
        return registroVehiculo;
    }



    /*
     * @param CalcularPrecio
     * Hacer un metodo que al listar todos los vehiculos tambien erroje el total del producido de ese mes
     * un metodo que arroje el total del tiempo y el valor que un vehiculo ha estado en el parqueadero
     *
     */
    public long CalcularPrecio(String placa, Repositorio repositorio, LocalDateTime fechaSalida){

        int precio = 1750, total;

        LocalDateTime today = now();
        System.out.println("Current DateTime= "+today);

        LocalDateTime specificDate = parse("2024-05-20T18:27:43.167794100");
        System.out.println("Specific Date= "+specificDate);

        long hours = ChronoUnit.HOURS.between(specificDate, today );
        long meses = ChronoUnit.MONTHS.between(specificDate, today);
        System.out.println("Hello world! hours is: "+hours +"   meses: " + meses);

        System.out.println("total cobro:  "+ hours*precio);
        total = (int) (hours*precio);

        long diffInHours = Duration.between(repositorio.findFechaEntrada(placa), now()).toHours();
        return diffInHours * 1750;
    }
}
