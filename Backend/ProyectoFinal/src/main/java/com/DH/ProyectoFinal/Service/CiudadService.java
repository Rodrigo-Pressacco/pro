package com.DH.ProyectoFinal.Service;

import com.DH.ProyectoFinal.Dto.CiudadDto;
import com.DH.ProyectoFinal.Service.IService.ICiudadService;
import com.DH.ProyectoFinal.exceptions.ResourceBadRequestException;
import com.DH.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.DH.ProyectoFinal.persistence.entities.Ciudad;
import com.DH.ProyectoFinal.persistence.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiudadService implements ICiudadService<CiudadDto> {

    private final CiudadRepository ciudadRepository;

    @Autowired
    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public CiudadDto guardar(CiudadDto ciudadDto) throws ResourceBadRequestException {
        if (ciudadDto==null)
            throw new ResourceBadRequestException("No se puede guardar la ciudad en null");
        Ciudad ciudad = ciudadRepository.save(ciudadDto.toEntity());
        return new CiudadDto(ciudad);
    }

    @Override
    public CiudadDto buscarPorId(Integer id) throws ResourceNotFoundException {
        CiudadDto response = null;
        Ciudad ciudad = ciudadRepository.findById(id).orElse(null);
        if(ciudad == null) {
            throw new ResourceNotFoundException("No existe la ciudad con id: " + id);
        }
        response = new CiudadDto(ciudadRepository.findById(id).get());
        return response;
    }

    @Override
    public List<CiudadDto> buscarTodos() {
        List<CiudadDto> ciudadDtos = new ArrayList<>();
        for (Ciudad p: ciudadRepository.findAll()){
            ciudadDtos.add(new CiudadDto(p));
        }
        return ciudadDtos;
    }

    @Override
    public CiudadDto actualizar(CiudadDto c) throws ResourceNotFoundException {
        Ciudad ciudad = ciudadRepository.findAll().stream().filter(ciudad1 -> ciudad1.getId().equals(c.getId())).findFirst().orElse(null);
        CiudadDto ciudadDto = new CiudadDto(ciudad);
        if (buscarPorId(c.getId())==null){
            throw new ResourceNotFoundException("No existe la ciudad con id: " + c.getId());
        }

        ciudadDto.setNombre(c.getNombre());
        ciudadDto.setPais(c.getPais());
        ciudadRepository.save(ciudadDto.toEntity());

        return ciudadDto;
    }

    @Override
    public void borrar(Integer id) throws ResourceNotFoundException {
        if (ciudadRepository.findById(id).orElse(null) == null){
            throw new ResourceNotFoundException("No existe la ciudad con id: " + id);
        }
        ciudadRepository.deleteById(id);
    }
}
