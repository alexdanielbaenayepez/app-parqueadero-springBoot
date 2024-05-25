package org.crud.appparqueadero.service;

import org.crud.appparqueadero.model.RegistroVehiculo;
import org.crud.appparqueadero.repositorio.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.*;

@Service
public class RegistroService {


    @Autowired
    private Repositorio repositorio;


    @Autowired
    private RegistroVehiculo registroVehiculo;


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

        RegistroVehiculo registroVehiculo = repositorio.findById(placa).
                map(setSalida -> {
                   setSalida.setFechaSalida(LocalDateTime.now());
                    return repositorio.save(setSalida);
                }).
                orElseThrow(()-> new RuntimeException("placa no encontrada"));

        return repositorio.save(registroVehiculo);
    }


    public RegistroVehiculo deleteOne(String placa){

        RegistroVehiculo registroVehiculo = repositorio.findById(placa).orElseThrow(()-> new RuntimeException("placa no encontrada"));
        repositorio.deleteById(placa);
        return registroVehiculo;
    }




    public long CalcularPrecio(String placa, Repositorio repositorio, LocalDateTime fechaSalida){

        int precio = 1750, total;
       // registroVehiculo.setFechaSalida(LocalDateTime.now());
        long diffInHours = Duration.between(repositorio.findFechaEntrada(), now()).toHours();
        return diffInHours * 1750;
    }
}







    /*  LocalDateTime today = now();
        System.out.println("Current DateTime= "+today);

        LocalDateTime specificDate = parse("2024-05-20T18:27:43.167794100");
        System.out.println("Specific Date= "+specificDate);

        long hours = ChronoUnit.HOURS.between(specificDate, today );
        long meses = ChronoUnit.MONTHS.between(specificDate, today);
        System.out.println("Hello world! hours is: "+hours +"   meses: " + meses);

        System.out.println("total cobro:  "+ hours*precio);
        total = (int) (hours*precio);
*/