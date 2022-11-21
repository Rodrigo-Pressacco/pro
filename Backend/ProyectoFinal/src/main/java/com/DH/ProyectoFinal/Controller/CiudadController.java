package com.DH.ProyectoFinal.Controller;

import com.DH.ProyectoFinal.Dto.CiudadDto;
import com.DH.ProyectoFinal.Dto.ProductoDto;
import com.DH.ProyectoFinal.Service.CiudadService;
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
@RequestMapping("/ciudades")
public class CiudadController {

    private final CiudadService ciudadService;
    private static final Logger logger = Logger.getLogger(Service.class);

    @Autowired
    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> guardar(@RequestBody CiudadDto c) throws ResourceBadRequestException {
        CiudadDto respuesta = ciudadService.guardar(c);
        logger.debug("Operación exitosa de creado de ciudad");
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<CiudadDto>> buscarTodos(){
        List<CiudadDto> ciudad = new ArrayList<>();
        try{
            ciudad = this.ciudadService.buscarTodos();
            logger.debug("Listando ciudad: " + ciudad);
            for (CiudadDto p : ciudad) {
                logger.info(p.toString());
            }
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return ResponseEntity.ok(ciudad);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        CiudadDto respuesta = ciudadService.buscarPorId(id);
        logger.debug("Buscando a la ciudad con id: " + id);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Integer id) throws ResourceNotFoundException {
        ciudadService.borrar(id);
        logger.debug("Se eliminó la ciudad");
        return ResponseEntity.ok("La ciudad con id: " + id + " fue eliminada.");
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody CiudadDto c) throws ResourceNotFoundException {
        CiudadDto respuesta = ciudadService.actualizar(c);
        logger.debug("Se ha actualizado correctamente la ciudad");
        return ResponseEntity.ok(respuesta);
    }
}
