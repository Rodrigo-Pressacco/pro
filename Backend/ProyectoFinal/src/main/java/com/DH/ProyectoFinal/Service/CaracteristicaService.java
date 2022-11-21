package com.DH.ProyectoFinal.Service;

import com.DH.ProyectoFinal.Dto.CaracteristicaDto;
import com.DH.ProyectoFinal.Service.IService.ICaracteristicaService;
import com.DH.ProyectoFinal.exceptions.ResourceBadRequestException;
import com.DH.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.DH.ProyectoFinal.persistence.entities.Caracteristica;
import com.DH.ProyectoFinal.persistence.repository.CaracteristicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaracteristicaService implements ICaracteristicaService<CaracteristicaDto> {

    private final CaracteristicaRepository caracteristicaRepository;

    @Autowired
    public CaracteristicaService(CaracteristicaRepository caracteristicaRepository) {
        this.caracteristicaRepository = caracteristicaRepository;
    }

    @Override
    public CaracteristicaDto guardar(CaracteristicaDto caracteristica) throws ResourceBadRequestException {
        CaracteristicaDto response;
        if(caracteristica != null) {
            Caracteristica c = caracteristicaRepository.save(caracteristica.toEntity());
            response = new CaracteristicaDto(c);
        } else {
            throw new ResourceBadRequestException("No se puede guardar la característica en null");
        }
        return response;
    }

    @Override
    public CaracteristicaDto buscarPorId(Integer id) throws ResourceNotFoundException {
        CaracteristicaDto response = null;
        Caracteristica caracteristica = caracteristicaRepository.findById(id).orElse(null);
        if(caracteristica == null)
            throw new ResourceNotFoundException("No existe la característica con id: " + id);
        else {
            response = new CaracteristicaDto(caracteristicaRepository.getById(id));
        }

        return response;

    }

    @Override
    public List<CaracteristicaDto> buscarTodos() {
        List<CaracteristicaDto> caracteristicaDto = new ArrayList<>();

        for (Caracteristica c: caracteristicaRepository.findAll()){
            caracteristicaDto.add(new CaracteristicaDto(c));
        }
        return caracteristicaDto;
    }

    @Override
    public CaracteristicaDto actualizar(CaracteristicaDto c) throws ResourceNotFoundException {
        Caracteristica caracteristica = caracteristicaRepository.findAll().stream().filter(caracteristica1 -> caracteristica1.getId().equals(c.getId())).findFirst().get();
        CaracteristicaDto caracteristicaDto = new CaracteristicaDto(caracteristica);
        if(buscarPorId(c.getId()) == null)
            throw new ResourceNotFoundException("No existe la característica con id: " + c.getId());
        else {
            caracteristicaDto.setNombre(c.getNombre());
            caracteristicaDto.setIcono(c.getIcono());
            caracteristicaRepository.save(caracteristicaDto.toEntity());
        }

        return caracteristicaDto;
    }

    @Override
    public void borrar(Integer id) throws ResourceNotFoundException {
        if(caracteristicaRepository.findById(id).orElse(null) == null)
            throw new ResourceNotFoundException("No existe la característica con id: " + id);
        else {
            caracteristicaRepository.deleteById(id);
        }
    }


}
