package com.DH.ProyectoFinal.Service;

import com.DH.ProyectoFinal.Dto.ProductoDto;
import com.DH.ProyectoFinal.Dto.ReservaDto;
import com.DH.ProyectoFinal.Service.IService.IReservaService;
import com.DH.ProyectoFinal.exceptions.ResourceBadRequestException;
import com.DH.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.DH.ProyectoFinal.persistence.entities.Producto;
import com.DH.ProyectoFinal.persistence.entities.Reserva;
import com.DH.ProyectoFinal.persistence.repository.ProductoRepository;
import com.DH.ProyectoFinal.persistence.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService implements IReservaService<ReservaDto> {

    private final ReservaRepository reservaRepository;
    private final ProductoRepository productoRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository, ProductoRepository productoRepository) {
        this.reservaRepository = reservaRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public ReservaDto guardar(ReservaDto reservaDto) throws ResourceBadRequestException {
        //Producto p = productoRepository.findAll().stream().filter(producto -> producto.getId().equals(reservaDto.getProducto())).findFirst().orElse(null);
        ReservaDto response;
        if (reservaDto != null){
            //reservaDto.setProducto(p.getId());
            Reserva r = reservaRepository.save(reservaDto.toEntity());
            response = new ReservaDto(r);
        }else{
            throw new ResourceBadRequestException("No se puede guardar la reserva en null");
        }
        return response;
    }

    @Override
    public ReservaDto buscarPorId(Integer id) throws ResourceNotFoundException {
        ReservaDto response;
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        if(reserva == null)
            throw new ResourceNotFoundException("No existe la reserva con id: " + id);
        else {
            response = new ReservaDto(reserva);
        }
        return response;
    }


    @Override
    public List<ReservaDto> buscarTodos() {
        List<ReservaDto> reservaDtos = new ArrayList<>();

        for (Reserva r: reservaRepository.findAll()){
            reservaDtos.add(new ReservaDto(r));
        }
        return reservaDtos;
    }

    @Override
    public ReservaDto actualizar(ReservaDto r) throws ResourceNotFoundException {
        Reserva reserva = reservaRepository.findAll().stream().filter(reserva1 -> reserva1.getId().equals(r.getId())).findFirst().get();
        ReservaDto reservaDto = new ReservaDto(reserva);
        if(buscarPorId(r.getId()) == null)
            throw new ResourceNotFoundException("No existe la reserva con id: " + r.getId());

        Producto p = productoRepository.findAll().stream().filter(producto -> producto.getId().equals(r.getProducto())).findFirst().orElse(null);
        reservaDto.setHoraLlegada(r.getHoraLlegada());
        reservaDto.setFechaInicio(r.getFechaInicio());
        reservaDto.setCiudadUsuario(r.getCiudadUsuario());
        reservaDto.setMensajeDuenio(r.getMensajeDuenio());
        reservaDto.setCovid(r.getCovid());
        reservaDto.setFechaFinal(r.getFechaFinal());
        reservaDto.setProducto(r.getProducto());
        reservaRepository.save(reservaDto.toEntity());


        return reservaDto;
    }

    @Override
    public void borrar(Integer id) throws ResourceNotFoundException {
        if(reservaRepository.findById(id).orElse(null) == null)
            throw new ResourceNotFoundException("No existe la reserva con id: " + id);
        else {
            reservaRepository.deleteById(id);
        }
    }
}
