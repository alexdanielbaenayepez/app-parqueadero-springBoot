package org.crud.appparqueadero.controlador;

import org.crud.appparqueadero.model.RegistroVehiculo;
import org.crud.appparqueadero.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador {

    @Autowired
    private RegistroService registroService;

    @PostMapping("/guardar")
    public ResponseEntity<RegistroVehiculo>     registrar(@RequestBody RegistroVehiculo registroVehiculo) {
        RegistroVehiculo registro = registroService.guardar(registroVehiculo);
        return ResponseEntity.ok(registro);
    }

    @GetMapping("/todos")
    public List<RegistroVehiculo> GetAll(){
        return registroService.all();
    }

    @DeleteMapping("/eliminarRegistro")
    public ResponseEntity<RegistroVehiculo> deleteOne(@RequestParam(name="placa") String placa){
        return ResponseEntity.ok(registroService.deleteOne(placa));
    }

}
