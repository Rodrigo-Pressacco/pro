package com.DH.ProyectoFinal.Service;

import com.DH.ProyectoFinal.Dto.ImagenDto;
import com.DH.ProyectoFinal.Dto.ProductoDto;
import com.DH.ProyectoFinal.Service.IService.IImagenService;
import com.DH.ProyectoFinal.exceptions.ResourceBadRequestException;
import com.DH.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.DH.ProyectoFinal.persistence.entities.Imagen;
import com.DH.ProyectoFinal.persistence.entities.Producto;
import com.DH.ProyectoFinal.persistence.repository.ImagenRepository;
import com.DH.ProyectoFinal.persistence.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImagenService implements IImagenService<ImagenDto> {

    private final ImagenRepository imagenRepository;
    private final ProductoRepository productoRepository;

    @Autowired
    public ImagenService(ImagenRepository imagenRepository, ProductoRepository productoRepository) {
        this.imagenRepository = imagenRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public ImagenDto guardar(ImagenDto imagen) throws ResourceBadRequestException {
        Producto p = productoRepository.findAll().stream().filter(producto -> producto.getId().equals(imagen.getProducto())).findFirst().orElse(null);
        ImagenDto response;
        if(imagen != null) {
            imagen.setProducto(p.getId());
            Imagen i = imagenRepository.save(imagen.toEntity());
            response = new ImagenDto(i);
        } else {
            throw new ResourceBadRequestException("No se puede guardar la imagen en null");
        }
        return response;
    }

    @Override
    public ImagenDto buscarPorId(Integer id) throws ResourceNotFoundException {
        ImagenDto response = null;
        Imagen imagen = imagenRepository.findById(id).orElse(null);
        if(imagen == null)
            throw new ResourceNotFoundException("No existe la imagen con id: " + id);
        else {
            response = new ImagenDto(imagenRepository.getById(id));
        }

        return response;
    }

    @Override
    public List<ImagenDto> buscarTodos() {
        List<ImagenDto> imagenDto = new ArrayList<>();

        for (Imagen i: imagenRepository.findAll()){
            imagenDto.add(new ImagenDto(i));
        }
        return imagenDto;
    }

    @Override
    public ImagenDto actualizar(ImagenDto i) throws ResourceNotFoundException {
        Imagen imagen = imagenRepository.findAll().stream().filter(imagen1 -> imagen1.getId().equals(i.getId())).findFirst().get();
        ImagenDto imagenDto = new ImagenDto(imagen);
        if(buscarPorId(i.getId()) == null)
            throw new ResourceNotFoundException("No existe la imagen con id: " + i.getId());

        Producto p = productoRepository.findAll().stream().filter(producto -> producto.getId().equals(i.getProducto())).findFirst().orElse(null);
        imagenDto.setTitulo(i.getTitulo());
        imagenDto.setUrl_imagen(i.getUrl_imagen());
        imagenDto.setProducto(p.getId());
        imagenRepository.save(imagenDto.toEntity());


        return imagenDto;
    }

    @Override
    public void borrar(Integer id) throws ResourceNotFoundException {
        if(imagenRepository.findById(id).orElse(null) == null)
            throw new ResourceNotFoundException("No existe la imagen con id: " + id);
        else {
            imagenRepository.deleteById(id);
        }
    }

}
