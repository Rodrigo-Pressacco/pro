package com.DH.ProyectoFinal.Service;

import com.DH.ProyectoFinal.Dto.CategoriaDto;
import com.DH.ProyectoFinal.Service.IService.ICategoriaService;
import com.DH.ProyectoFinal.exceptions.ResourceBadRequestException;
import com.DH.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.DH.ProyectoFinal.persistence.entities.Categoria;
import com.DH.ProyectoFinal.persistence.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService implements ICategoriaService<CategoriaDto> {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public CategoriaDto guardar(CategoriaDto categoria) throws ResourceBadRequestException {
        CategoriaDto response;
        if(categoria != null){
            Categoria categoria1 = categoriaRepository.save(categoria.toEntity());
            response = new CategoriaDto(categoria1);
        } else {
            throw new ResourceBadRequestException("No se puede guardar la categoría en null");
        }

        return response;
    }

    @Override
    public List<CategoriaDto> buscarTodos(){
        List<CategoriaDto> categoriaDto = new ArrayList<>();

        for (Categoria c: categoriaRepository.findAll()){
            categoriaDto.add(new CategoriaDto(c));
        }
       return categoriaDto;
    }

    @Override
    public CategoriaDto buscarPorId(Integer id) throws ResourceNotFoundException {
        CategoriaDto response = null;
        Categoria categoria = categoriaRepository.findById(id).orElse(null);
        if(categoria == null)
            throw new ResourceNotFoundException("No existe la categoría con id: " + id);
        else {
            response = new CategoriaDto(categoriaRepository.getById(id));
        }

        return response;
    }

    @Override
    public void borrar(Integer id) throws ResourceNotFoundException {

        if(categoriaRepository.findById(id).orElse(null) == null)
            throw new ResourceNotFoundException("No existe la categoría con id: " + id);
        else {
            categoriaRepository.deleteById(id);
        }

    }

    @Override
    public CategoriaDto actualizar(CategoriaDto c) throws ResourceNotFoundException {
        Categoria categoria = categoriaRepository.findAll().stream().filter(categoria1 -> categoria1.getId().equals(c.getId())).findFirst().get();
        CategoriaDto categoriaDto = new CategoriaDto(categoria);
        if(buscarPorId(c.getId()) == null)
            throw new ResourceNotFoundException("No existe la categoría con id: " + c.getId());
        else {
            categoriaDto.setTitulo(c.getTitulo());
            categoriaDto.setDescripcion(c.getDescripcion());
            categoriaDto.setUrl_imagen(c.getUrl_imagen());
            categoriaRepository.save(categoriaDto.toEntity());
        }

        return categoriaDto;
    }

}
