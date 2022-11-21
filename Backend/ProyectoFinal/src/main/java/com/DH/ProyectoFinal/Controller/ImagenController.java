package com.DH.ProyectoFinal.Controller;

import com.DH.ProyectoFinal.Dto.CategoriaDto;
import com.DH.ProyectoFinal.Dto.ImagenDto;
import com.DH.ProyectoFinal.Service.ImagenService;
import com.DH.ProyectoFinal.exceptions.ResourceBadRequestException;
import com.DH.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.DH.ProyectoFinal.persistence.entities.Imagen;
import org.apache.log4j.Logger;
import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/imagenes")
public class ImagenController {

    private final ImagenService imagenService;

    @Autowired
    public ImagenController(ImagenService imagenService) {
        this.imagenService = imagenService;
    }

    private static final Logger logger = Logger.getLogger(Service.class);

    @PostMapping("/nuevo")
    public ResponseEntity<?> guardar(@RequestBody ImagenDto i) throws ResourceBadRequestException {

        ImagenDto respuesta = imagenService.guardar(i);
        logger.debug("Operación exitosa de creado de imagen");
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        ImagenDto respuesta = imagenService.buscarPorId(id);
        logger.debug("Buscando a la imagen con id: " + id);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ImagenDto>> buscarTodos(){
        List<ImagenDto> imagenes = new ArrayList<>();
        try{
            imagenes = this.imagenService.buscarTodos();
            logger.debug("Listando imagenes: " + imagenes);
            for (ImagenDto c : imagenes) {
                logger.info(c.toString());
            }
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return ResponseEntity.ok(imagenes);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody ImagenDto i) throws ResourceNotFoundException {
        ImagenDto respuesta = imagenService.actualizar(i);
        logger.debug("Se ha actualizado correctamente la imagen");
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Integer id) throws ResourceNotFoundException {
        imagenService.borrar(id);
        logger.debug("Se eliminó la imagen");
        return ResponseEntity.ok("La imagen con id: " + id + " fue eliminada.");
    }
}
