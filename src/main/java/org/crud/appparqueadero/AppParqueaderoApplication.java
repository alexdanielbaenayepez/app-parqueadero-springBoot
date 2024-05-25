package org.crud.appparqueadero;

import org.crud.appparqueadero.model.RegistroVehiculo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AppParqueaderoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppParqueaderoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(1235+ "hola-------------------------------------");

        RegistroVehiculo r = new RegistroVehiculo();
        System.out.println("ENTRADA "+r.getFechaEntrada());
        System.out.println("SALIDA "+r.getFechaSalida());
    }
}
