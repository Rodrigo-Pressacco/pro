package com.DH.ProyectoFinal.Controller;

import com.DH.ProyectoFinal.Dto.ProductoDto;
import com.DH.ProyectoFinal.Service.ProductoService;
import com.DH.ProyectoFinal.exceptions.ResourceBadRequestException;
import com.DH.ProyectoFinal.exceptions.ResourceNotFoundException;
import org.apache.log4j.Logger;
import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;
    private static final Logger logger = Logger.getLogger(Service.class);

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> guardar(@RequestBody ProductoDto p) throws ResourceBadRequestException {

        ProductoDto respuesta = productoService.guardar(p);
        logger.debug("Operación exitosa de creado de producto");
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ProductoDto>> buscarTodos(){
        List<ProductoDto> productos = new ArrayList<>();
        try{
            productos = this.productoService.buscarTodos();
            logger.debug("Listando productos: " + productos);
            for (ProductoDto p : productos) {
                logger.info(p.toString());
            }
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        ProductoDto respuesta = productoService.buscarPorId(id);
        logger.debug("Buscando a el producto con id: " + id);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Integer id) throws ResourceNotFoundException {
        productoService.borrar(id);
        logger.debug("Se eliminó el producto");
        return ResponseEntity.ok("El producto con id: " + id + " fue eliminado.");
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody ProductoDto p) throws ResourceNotFoundException {
        ProductoDto respuesta = productoService.actualizar(p);
        logger.debug("Se ha actualizado correctamente el producto");
        return ResponseEntity.ok(respuesta);
    }

//    @GetMapping("caracteristicasPorId/{id}")
//    public ResponseEntity<?> verCaracteristicasPorProductoId(@PathVariable Integer id){
//        return ResponseEntity.ok(this.productoService.verCaracteristicasPorProductoId(id));
//    }
//
//    @GetMapping("imagenesPorId/{id}")
//    public ResponseEntity<?> verImagenesPorProductoId(@PathVariable Integer id){
//        return ResponseEntity.ok(this.productoService.buscarImagenPorPorductoId(id));
//    }

    @GetMapping("buscarPorCategoria/{categoria}")
    public ResponseEntity<?> buscarPorCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(this.productoService.listarPorCategoria(categoria));
    }

    @GetMapping("buscarPorCiudad/{ciudad}")
    public ResponseEntity<?> buscarPorCiudad(@PathVariable String ciudad) {
        return ResponseEntity.ok(this.productoService.listarPorCiudad(ciudad));
    }

    @GetMapping("buscarPorCiudadFecha/{fechaInicio}/{fechaFin}")
    public ResponseEntity<?> buscarPorCiudadFecha(@RequestParam(required = false) String ciudad, @PathVariable
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio, @PathVariable
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) throws ResourceNotFoundException {
        return ResponseEntity.ok(this.productoService.buscarPorCiudadyFecha(ciudad, fechaInicio, fechaFin));
    }


}

