package com.DH.ProyectoFinal.Service;

import com.DH.ProyectoFinal.Dto.CategoriaDto;
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
public class CategoriaServiceTest {

    @Autowired
    private CategoriaService categoriaService;

    private CategoriaDto categoria;

    public void cargarDataSet () throws ResourceBadRequestException {
        this.categoriaService.guardar(new CategoriaDto(1, "Hoteles", "Hotel Park Hyatt Mendoza", "https://www.hyatt.com/es-ES/hotel/argentina/park-hyatt-mendoza-hotel-casino-and-spa/menph"));
    }

    @Test
    public void Test01Guardar () throws ResourceBadRequestException {
        CategoriaDto categoria1 = new CategoriaDto();
        categoria1.setId(2);
        categoria1.setTitulo("Hoteles");
        categoria1.setDescripcion("Hotel Sheraton Mendoza");
        categoria1.setUrl_imagen("https://www.espanol.marriott.com/hotels/travel/mdzsi-sheraton-mendoza-hotel/");
        Assertions.assertTrue(categoria1.getId() != null);
    }

    @Test
    public void Test02Listar() throws ResourceBadRequestException {
        //Dado
        cargarDataSet();
        List<CategoriaDto> listaCategorias = new ArrayList<>();
        Integer respuestaEsperada = 5;
        //Cuando
        Integer respuestaObtenida = categoriaService.buscarTodos().size();
        //Entonces
        Assertions.assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    @Transactional
    public void Test03Borrar() throws ResourceBadRequestException, ResourceNotFoundException {
        cargarDataSet();
        List<CategoriaDto> listaCategorias = new ArrayList<>();
        categoriaService.borrar(1);
        Integer respuestaEsperada = 4;
        //Cuando
        Integer respuestaObtenida = categoriaService.buscarTodos().size();
        //Entonces
        Assertions.assertEquals(respuestaEsperada, respuestaObtenida);
    }
}