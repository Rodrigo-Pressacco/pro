package com.DH.ProyectoFinal.Service;

import com.DH.ProyectoFinal.Dto.*;
import com.DH.ProyectoFinal.Service.IService.IProductoService;
import com.DH.ProyectoFinal.exceptions.ResourceBadRequestException;
import com.DH.ProyectoFinal.exceptions.ResourceNotFoundException;
import com.DH.ProyectoFinal.persistence.entities.*;
import com.DH.ProyectoFinal.persistence.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService<ProductoDto> {

    private final ProductoRepository productoRepository;
    private final CiudadRepository ciudadRepository;
    private final CategoriaRepository categoriaRepository;
    private final CaracteristicaRepository caracteristicaRepository;
    private final ImagenRepository imagenRepository;
    private final ReservaRepository reservaRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository, CiudadRepository ciudadRepository, CategoriaRepository categoriaRepository, CaracteristicaRepository caracteristicaRepository, ImagenRepository imagenRepository, ReservaRepository reservaRepository) {
        this.productoRepository = productoRepository;
        this.ciudadRepository = ciudadRepository;
        this.categoriaRepository = categoriaRepository;
        this.caracteristicaRepository = caracteristicaRepository;
        this.imagenRepository = imagenRepository;
        this.reservaRepository = reservaRepository;
    }

    @Override
    public ProductoDto guardar(ProductoDto productoDto) throws ResourceBadRequestException {
        Ciudad ciu = ciudadRepository.findAll().stream().filter(ciudad -> ciudad.getId().equals(productoDto.getCiudad().getId())).findFirst().orElse(null);
        Categoria cat = categoriaRepository.findAll().stream().filter(categoria -> categoria.getId().equals(productoDto.getCategoria().getId())).findFirst().orElse(null);
        if (productoDto==null)
            throw new ResourceBadRequestException("No se puede guardar el producto en null");
        productoDto.setCiudad(new CiudadDto(ciu));
        productoDto.setCategoria(new CategoriaDto(cat));
        Producto producto = productoRepository.save(productoDto.toEntity());
        return new ProductoDto(producto);
    }

    @Override
    public ProductoDto buscarPorId(Integer id) throws ResourceNotFoundException {
        ProductoDto response = null;
        Producto producto = productoRepository.findById(id).orElse(null);
        if(producto == null) {
            throw new ResourceNotFoundException("No existe el producto con id: " + id);
        }
        response = new ProductoDto(productoRepository.findById(id).get());
        response.setImagen(buscarImagenPorPorductoId(response.getId()));
        response.setCaracteristicas(verCaracteristicasPorProductoId(response.getId()));
        response.setReservas(buscarReservasPorPorductoId(response.getId()));
        return response;
    }

    @Override
    public List<ProductoDto> buscarTodos() {
        List<ProductoDto> productoDtos = new ArrayList<>();
        for (Producto p: productoRepository.findAll()){
            ProductoDto pro = new ProductoDto(p);
            pro.setImagen(buscarImagenPorPorductoId(p.getId()));
            pro.setCaracteristicas(verCaracteristicasPorProductoId(p.getId()));
            pro.setReservas(buscarReservasPorPorductoId(p.getId()));
            productoDtos.add(pro);
        }
        return productoDtos;
    }

    @Override
    public ProductoDto actualizar(ProductoDto p) throws ResourceNotFoundException {
        Producto producto = productoRepository.findAll().stream().filter(producto1 -> producto1.getId().equals(p.getId())).findFirst().orElse(null);
        ProductoDto productoDto = new ProductoDto(producto);
        if (buscarPorId(p.getId())==null){
            throw new ResourceNotFoundException("No existe la producto con id: " + p.getId());
        }
        Ciudad ciu = ciudadRepository.findAll().stream().filter(ciudad -> ciudad.getId().equals(p.getCiudad().getId())).findFirst().orElse(null);
        Categoria cat = categoriaRepository.findAll().stream().filter(categoria -> categoria.getId().equals(p.getCategoria().getId())).findFirst().orElse(null);

        productoDto.setNombre(p.getNombre());
        productoDto.setDescripcion(p.getDescripcion());
        productoDto.setLatitud(p.getLatitud());
        productoDto.setLongitud(p.getLongitud());
        productoDto.setCiudad(new CiudadDto(ciu));
        productoDto.setCategoria(new CategoriaDto(cat));
        productoRepository.save(productoDto.toEntity());

        return productoDto;
    }

    @Override
    public void borrar(Integer id) throws ResourceNotFoundException {
        if (productoRepository.findById(id).orElse(null) == null){
            throw new ResourceNotFoundException("No existe el producto con id: " + id);
        }
        productoRepository.deleteById(id);
    }


    public List<ProductoDto> listarPorCategoria(String titulo){
        List<ProductoDto> product = new ArrayList<>();
        for (Producto p: productoRepository.findAll()){
            if (p.getCategoria().getTitulo().equals(titulo)){
                ProductoDto pro = new ProductoDto(p);
                pro.setImagen(buscarImagenPorPorductoId(p.getId()));
                pro.setCaracteristicas(verCaracteristicasPorProductoId(p.getId()));
                product.add(pro);
            }
        }
        return product;
    }

    public List<ProductoDto> listarPorCiudad(String ciudad){
        List<ProductoDto> product = new ArrayList<>();
        for (Producto p: productoRepository.findAll()){
            if (p.getCiudad().getNombre().equals(ciudad)){
                ProductoDto pro = new ProductoDto(p);
                pro.setImagen(buscarImagenPorPorductoId(p.getId()));
                pro.setCaracteristicas(verCaracteristicasPorProductoId(p.getId()));
                product.add(pro);
            }
        }
        return product;
    }
    public List<ProductoDto> buscarPorCiudadyFecha(String ciudad, LocalDate fechaInicio, LocalDate fechaFin) throws ResourceNotFoundException {
        List<ProductoDto> productos = new ArrayList<>();
        for (Producto p: productoRepository.findAll()){
        int reservasDisponibles = 0;
            if (p.getCiudad().getNombre().equals(ciudad) || ciudad==null) {
                if (p.getReservas().size() != 0) {
                    for (Reserva r : p.getReservas()) {
                        if (fechaInicio.isBefore(r.getFechaInicio()) && fechaFin.isBefore(r.getFechaInicio()) || fechaInicio.isAfter(r.getFechaFinal()) && fechaFin.isAfter(r.getFechaFinal())) {
                            reservasDisponibles++;
                        }
                    }
                    if(reservasDisponibles==p.getReservas().size()){
                        ProductoDto productoDto = new ProductoDto(p);
                        productoDto.setImagen(buscarImagenPorPorductoId(p.getId()));
                        productoDto.setCaracteristicas(verCaracteristicasPorProductoId(p.getId()));
                        productos.add(productoDto);
                    }
                }else{
                    ProductoDto productoDto = new ProductoDto(p);
                    productoDto.setImagen(buscarImagenPorPorductoId(p.getId()));
                    productoDto.setCaracteristicas(verCaracteristicasPorProductoId(p.getId()));
                    productos.add(productoDto);
                }
            }
        }
        return productos;
    }

    //Setear caracteristecas, imagenes y reservas
    public Set<ImagenDto> buscarImagenPorPorductoId(Integer id) {
        Set<ImagenDto> imagen = new HashSet<>();

        for (Imagen i: imagenRepository.findAll()){
            if (i.getProducto().getId().equals(id)) {
                imagen.add(new ImagenDto(i));
            }
        }
        return imagen;
    }

    public Set<Caracteristica> verCaracteristicasPorProductoId(Integer id){
        Set<Caracteristica> caract = new HashSet<>();
        caracteristicaRepository.findAll().stream().forEach(caracteristica -> caracteristica.getProductos().stream().forEach(producto ->
                {
                    if (producto.getId().equals(id))
                        caract.add(caracteristica);
                }
        ));
        return caract;
    }

    public Set<ReservaDto> buscarReservasPorPorductoId(Integer id) {
        Set<ReservaDto> reservas = new HashSet<>();

        for (Reserva r: reservaRepository.findAll()){
            if (r.getProducto().getId().equals(id)) {
                reservas.add(new ReservaDto(r));
            }
        }
        return reservas;
    }



}
