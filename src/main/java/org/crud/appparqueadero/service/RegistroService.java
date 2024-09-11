package org.crud.appparqueadero.service;

import org.crud.appparqueadero.model.RegistroVehiculo;
import org.crud.appparqueadero.repositorio.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Optional;


import static java.time.LocalDateTime.*;

@Service
public class RegistroService {


    @Autowired
    private Repositorio repositorio;


    @Autowired
    private RegistroVehiculo registroVehiculo;


    public RegistroVehiculo salida (String placa, RegistroVehiculo registro){

        RegistroVehiculo registroVehiculo = repositorio.findById(placa).
                map(setSalida -> {
                   setSalida.setFechaSalida(LocalDateTime.now());
                    return repositorio.save(setSalida);
                }).
                orElseThrow(()-> new RuntimeException("placa no encontrada"));

        return repositorio.save(registroVehiculo);
    }








// el metodo esta mal hecho no esta cumpliendo su tarea de calcular la diferencia porque no puedo utilizar la placa para identificar el vehiculo

    public void calculateDifference(String placa, RegistroVehiculo registroVehiculo2, Repositorio repositorio) {

        Optional<RegistroVehiculo> registroVehiculo = repositorio.findById(placa);
        // Calcular la diferencia en días, meses y años
        Period period = Period.between(registroVehiculo.get().getFechaEntrada().toLocalDate(), registroVehiculo.get().getFechaSalida().toLocalDate());

        // Calcular la diferencia en horas y minutos
        Duration duration = Duration.between(registroVehiculo.get().getFechaEntrada(), registroVehiculo.get().getFechaSalida());

        // Extraer las diferencias
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;


        // Imprimir la diferencia
        System.out.println("Diferencia: " + years + " años, " + months + " meses, " + days + " días, " + hours + " horas, " + minutes + " minutos.");
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
        -------------------------------------------------------------------------------------


        import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateDifferenceCalculator {

    public static void calculateDifference(String pastDateString) {
        // Formato de la fecha de entrada
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Convertir la fecha de entrada a LocalDateTime
        LocalDateTime pastDate = LocalDateTime.parse(pastDateString, formatter);
        LocalDateTime currentDate = LocalDateTime.now();

        // Calcular la diferencia en días, meses y años
        Period period = Period.between(pastDate.toLocalDate(), currentDate.toLocalDate());

        // Calcular la diferencia en horas y minutos
        Duration duration = Duration.between(pastDate, currentDate);

        // Extraer las diferencias
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;

        // Imprimir la diferencia
        System.out.println("Diferencia: " + years + " años, " + months + " meses, " + days + " días, " + hours + " horas, " + minutes + " minutos.");
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String pastDateString = "2021-05-15 08:30:00";
        calculateDifference(pastDateString);
    }
}

*/