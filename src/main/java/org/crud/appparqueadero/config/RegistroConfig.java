/*package org.crud.appparqueadero.config;

import org.crud.appparqueadero.model.RegistroVehiculo;
import org.crud.appparqueadero.repositorio.Repositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegistroConfig {

    @Bean
    CommandLineRunner commandLineRunner(Repositorio repositorio){
        return args -> {
            RegistroVehiculo registroVehiculo = new RegistroVehiculo();
            repositorio.save(registroVehiculo);
        };
    }
}
*/