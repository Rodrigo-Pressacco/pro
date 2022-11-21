package com.DH.ProyectoFinal.Service;

import com.DH.ProyectoFinal.Dto.CategoriaDto;
import com.DH.ProyectoFinal.Dto.CiudadDto;
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
public class CiudadServiceTest {

    @Autowired
    private CiudadService ciudadService;

    private CiudadDto ciudad;

    public void cargarDataSet () throws ResourceBadRequestException {
        this.ciudadService.guardar(new CiudadDto(1, "Mendoza", "Argentina"));
    }

    @Test
    public void Test01Guardar () throws ResourceBadRequestException {
        CiudadDto ciudad1 = new CiudadDto();
        ciudad1.setId(2);
        ciudad1.setNombre("Buenos Aires");
        ciudad1.setPais("Argentina");
        Assertions.assertTrue(ciudad1.getId() != null);
    }

    @Test
    public void Test02Listar() throws ResourceBadRequestException {
        //Dado
        cargarDataSet();
        List<CiudadDto> listaCiudades = new ArrayList<>();
        Integer respuestaEsperada = 1;
        //Cuando
        Integer respuestaObtenida = ciudadService.buscarTodos().size();
        //Entonces
        Assertions.assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    @Transactional
    public void Test03Borrar() throws ResourceBadRequestException, ResourceNotFoundException {
        cargarDataSet();
        List<CiudadDto> listaCiudades = new ArrayList<>();
        ciudadService.borrar(1);
        Integer respuestaEsperada = 0;
        //Cuando
        Integer respuestaObtenida = ciudadService.buscarTodos().size();
        //Entonces
        Assertions.assertEquals(respuestaEsperada, respuestaObtenida);
    }

}