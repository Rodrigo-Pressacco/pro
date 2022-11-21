package com.DH.ProyectoFinal.Controller;

import com.DH.ProyectoFinal.Dto.ImagenDto;
import com.DH.ProyectoFinal.Dto.ReservaDto;
import com.DH.ProyectoFinal.Service.ReservaService;
import com.DH.ProyectoFinal.exceptions.ResourceBadRequestException;
import com.DH.ProyectoFinal.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;
    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> guardar(@RequestBody ReservaDto r) throws ResourceBadRequestException {

        ReservaDto respuesta = reservaService.guardar(r);
        //logger.debug("Operación exitosa de creado de reserva");
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) throws ResourceNotFoundException {
        ReservaDto respuesta = reservaService.buscarPorId(id);
        //logger.debug("Buscando a la reserva con id: " + id);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ReservaDto>> buscarTodos(){
        List<ReservaDto> reservas = new ArrayList<>();
        try{
            reservas = this.reservaService.buscarTodos();
            for (ReservaDto c : reservas) {
            }
        } catch (Exception e){
        }
        return ResponseEntity.ok(reservas);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody ReservaDto r) throws ResourceNotFoundException {
        ReservaDto respuesta = reservaService.actualizar(r);
        //logger.debug("Se ha actualizado correctamente la reserva");
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Integer id) throws ResourceNotFoundException {
        reservaService.borrar(id);
        //logger.debug("Se eliminó la reserva");
        return ResponseEntity.ok("La reserva con id: " + id + " fue eliminada.");
    }
}
