package com.DH.ProyectoFinal.Service;

import com.DH.ProyectoFinal.Dto.CategoriaDto;
import com.DH.ProyectoFinal.Dto.CiudadDto;
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
public class ProductoServiceTest {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CiudadService ciudadService;

    @Autowired
    private CategoriaService categoriaService;

    private ProductoDto producto;
    private CiudadDto ciudad;
    private CategoriaDto categoria;

    public void cargarDataSet () throws ResourceBadRequestException {
        CiudadDto ciudad = new CiudadDto(1, "Mendoza", "Argentina");
        this.ciudadService.guardar(ciudad);
        CategoriaDto categoria = new CategoriaDto(1, "Hoteles", "200 hoteles", "https://www.hyatt.com/es-ES/hotel/argentina/park-hyatt-mendoza-hotel-casino-and-spa/menph");
        this.categoriaService.guardar(categoria);
        this.productoService.guardar(new ProductoDto(1, "Hotel Hyatt", "lugar bonito", ciudad, categoria));
    }

    @Test
    public void Test01Guardar () throws ResourceBadRequestException {
        ProductoDto producto1 = new ProductoDto();
        producto1.setId(2);
        producto1.setNombre("Hostel Sin City");
        producto1.setDescripcion("lugar excelente");
        producto1.setCiudad(new CiudadDto(2, "Buenos Aires", "Argentina"));
        producto1.setCategoria(new CategoriaDto(2, "Hostels", "200 hostels", "https://www.hyatt.com/es-ES/hotel/argentina/park-hyatt-mendoza-hotel-casino-and-spa/menph"));
        Assertions.assertTrue(producto1.getId() != null);
    }

    @Test
    public void Test02Listar() throws ResourceBadRequestException {
        //Dado
        cargarDataSet();
        List<ProductoDto> listaProductos = new ArrayList<>();
        Integer respuestaEsperada = 1;
        //Cuando
        Integer respuestaObtenida = productoService.buscarTodos().size();
        //Entonces
        Assertions.assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    @Transactional
    public void Test03Borrar() throws ResourceBadRequestException, ResourceNotFoundException {
        cargarDataSet();
        List<ProductoDto> listaProductos = new ArrayList<>();
        productoService.borrar(1);
        Integer respuestaEsperada = 0;
        //Cuando
        Integer respuestaObtenida = productoService.buscarTodos().size();
        //Entonces
        Assertions.assertEquals(respuestaEsperada, respuestaObtenida);
    }

}