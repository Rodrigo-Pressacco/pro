package com.DH.ProyectoFinal.Controller;

import com.DH.ProyectoFinal.Dto.CaracteristicaDto;
import com.DH.ProyectoFinal.Dto.CategoriaDto;
import com.DH.ProyectoFinal.Service.CaracteristicaService;
import com.DH.ProyectoFinal.exceptions.ResourceBadRequestException;
import com.DH.ProyectoFinal.exceptions.ResourceNotFoundException;
import org.apache.log4j.Logger;
import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/caracteristicas")
public class CaracteristicaController {

    private final CaracteristicaService caracteristicaService;

    @Autowired
    public CaracteristicaController(CaracteristicaService caracteristicaService) {
        this.caracteristicaService = caracteristicaService;
    }

    private static final Logger logger = Logger.getLogger(Service.class);

    @PostMapping("/nuevo")
    public ResponseEntity<?> guardar(@RequestBody CaracteristicaDto c) throws ResourceBadRequestException {

        CaracteristicaDto respuesta = caracteristicaService.guardar(c);
        logger.debug("Operación exitosa de creado de característica");
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        CaracteristicaDto respuesta = caracteristicaService.buscarPorId(id);
        logger.debug("Buscando a la característica con id: " + id);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<CaracteristicaDto>> buscarTodos(){
        List<CaracteristicaDto> características = new ArrayList<>();
        try{
            características = this.caracteristicaService.buscarTodos();
            logger.debug("Listando características: " + características);
            for (CaracteristicaDto c : características) {
                logger.info(c.toString());
            }
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return ResponseEntity.ok(características);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody CaracteristicaDto c) throws ResourceNotFoundException {
        CaracteristicaDto respuesta = caracteristicaService.actualizar(c);
        logger.debug("Se ha actualizado correctamente la característica");
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Integer id) throws ResourceNotFoundException {
        caracteristicaService.borrar(id);
        logger.debug("Se eliminó la característica");
        return ResponseEntity.ok("La característica con id: " + id + " fue eliminada.");
    }
}
