package com.DH.ProyectoFinal.Controller;

import com.DH.ProyectoFinal.Dto.CategoriaDto;
import com.DH.ProyectoFinal.Service.CategoriaService;
import com.DH.ProyectoFinal.exceptions.ResourceBadRequestException;
import com.DH.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.DH.ProyectoFinal.persistence.entities.Categoria;
import org.apache.log4j.Logger;
import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    private static final Logger logger = Logger.getLogger(Service.class);

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> guardar(@RequestBody CategoriaDto c) throws ResourceBadRequestException {

        CategoriaDto respuesta = categoriaService.guardar(c);
        logger.debug("Operación exitosa de creado de categoría");
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<CategoriaDto>> buscarTodos(){
        List<CategoriaDto> categorias = new ArrayList<>();
        try{
            categorias = this.categoriaService.buscarTodos();
            logger.debug("Listando categorías: " + categorias);
            for (CategoriaDto c : categorias) {
                logger.info(c.toString());
            }
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        CategoriaDto respuesta = categoriaService.buscarPorId(id);
        logger.debug("Buscando a la categoría con id: " + id);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Integer id) throws ResourceNotFoundException {
        categoriaService.borrar(id);
        logger.debug("Se eliminó la categoría");
        return ResponseEntity.ok("La categoría con id: " + id + " fue eliminada.");
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody CategoriaDto c) throws ResourceNotFoundException {
        CategoriaDto respuesta = categoriaService.actualizar(c);
        logger.debug("Se ha actualizado correctamente la categoría");
        return ResponseEntity.ok(respuesta);
    }


}
