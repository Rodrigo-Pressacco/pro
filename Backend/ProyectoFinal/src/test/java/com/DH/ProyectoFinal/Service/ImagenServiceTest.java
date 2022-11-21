package com.DH.ProyectoFinal.Service;

import com.DH.ProyectoFinal.Dto.CategoriaDto;
import com.DH.ProyectoFinal.Dto.CiudadDto;
import com.DH.ProyectoFinal.Dto.ImagenDto;
import com.DH.ProyectoFinal.Dto.ProductoDto;
import com.DH.ProyectoFinal.exceptions.ResourceBadRequestException;
import com.DH.ProyectoFinal.exceptions.ResourceNotFoundException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ImagenServiceTest {

    @Autowired
    private ImagenService imagenService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CiudadService ciudadService;

    @Autowired
    private CategoriaService categoriaService;

    private ProductoDto producto;

    ImagenDto imagen;

    public ImagenServiceTest() {
    }

//    public void cargarDataSet () throws ResourceBadRequestException {
//        CategoriaDto categoria = new CategoriaDto(1, "Casas", "Lindo hogar", "https://images.unsplash.com/photo-1484154218962-a197022b5858?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=874&q=80");
//        this.categoriaService.guardar(categoria);
//        CiudadDto ciudad = new CiudadDto(1, "Mendoza", "Argentina");
//        this.ciudadService.guardar(ciudad);
//        ProductoDto producto = new ProductoDto(1, "Hotel Hyatt Mendoza", "500 habitaciones", ciudad, categoria);
//        this.productoService.guardar(producto);
//        this.imagenService.guardar(new ImagenDto(1, "Cocina", "https://images.unsplash.com/photo-1556911220-bff31c812dba?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=968&q=80", producto));
//    }
//
//    @Test
//    public void Test01Guardar () throws ResourceBadRequestException {
//        CategoriaDto categoria = new CategoriaDto(2, "Casas", "Lindo hogar", "https://images.unsplash.com/photo-1484154218962-a197022b5858?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=874&q=80");
//        CiudadDto ciudad = new CiudadDto(2, "Mendoza", "Argentina");
//        ProductoDto producto = new ProductoDto(2, "Hotel Hyatt Mendoza", "500 habitaciones", ciudad, categoria);
//        ImagenDto imagen1 = new ImagenDto();
//        imagen1.setId(2);
//        imagen1.setTitulo("Aire Acondicionado");
//        imagen1.setUrl_imagen("<i class=\"fas fa-air-conditioner\"></i>");
//        imagen1.setProducto(producto);
//        Assertions.assertTrue(imagen1.getId() != null);
//    }
//
//    @Test
//    public void Test02Listar() throws ResourceBadRequestException {
//        //Dado
//        cargarDataSet();
//        List<ImagenDto> listaImagenes = new ArrayList<>();
//        Integer respuestaEsperada = 1;
//        //Cuando
//        Integer respuestaObtenida = imagenService.buscarTodos().size();
//        //Entonces
//        Assertions.assertEquals(respuestaEsperada, respuestaObtenida);
//    }
//
//    @Test
//    @Transactional
//    public void Test03Borrar() throws ResourceBadRequestException, ResourceNotFoundException {
//        cargarDataSet();
//        List<ImagenDto> listaImagenes = new ArrayList<>();
//        imagenService.borrar(1);
//        Integer respuestaEsperada = 0;
//        //Cuando
//        Integer respuestaObtenida = imagenService.buscarTodos().size();
//        //Entonces
//        Assertions.assertEquals(respuestaEsperada, respuestaObtenida);
//    }
}