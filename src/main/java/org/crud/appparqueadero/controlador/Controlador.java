package org.crud.appparqueadero.controlador;

import org.crud.appparqueadero.model.RegistroVehiculo;
import org.crud.appparqueadero.repositorio.Repositorio;
import org.crud.appparqueadero.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador {

    @Autowired
    private RegistroService registroService;
    @Autowired
    private Repositorio repositorio;

    @PostMapping("/guardar")
    public ResponseEntity<RegistroVehiculo> registrar(@RequestBody String placa, String tipo) {

        RegistroVehiculo registro = new RegistroVehiculo(placa, tipo);
                registro.setPlaca(placa);
                registro.setTipoVehiculo(tipo);

        return ResponseEntity.ok(repositorio.save(registro));
    }

    @GetMapping("/todos")
    public List<RegistroVehiculo> GetAll(){
        return repositorio.findAll();
    }

    @PutMapping("/salida/{placa}")

    public RegistroVehiculo salida (@RequestBody RegistroVehiculo registroVehiculo, @PathVariable String placa) {
        return registroService.salida(placa, registroVehiculo);
    }



 /*   @DeleteMapping("/eliminarRegistro")
    public ResponseEntity<RegistroVehiculo> deleteOne(@RequestParam(name="placa") String placa){

        return ResponseEntity.ok(repositorio.deleteById(placa));
    }
*/
}
