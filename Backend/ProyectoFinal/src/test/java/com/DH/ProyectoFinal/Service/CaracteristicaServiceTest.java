package com.DH.ProyectoFinal.Service;

import com.DH.ProyectoFinal.Dto.CaracteristicaDto;
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
public class CaracteristicaServiceTest {

    @Autowired
    CaracteristicaService caracteristicaService;

    CaracteristicaDto caracteristicaDto;

    public void cargarDataSet () throws ResourceBadRequestException {
        this.caracteristicaService.guardar(new CaracteristicaDto(1, "Cocina", "<i class=\"fas fa-oven\"></i>" ));
    }

    @Test
    public void Test01Guardar () throws ResourceBadRequestException {
        CaracteristicaDto caracteristica1 = new CaracteristicaDto();
        caracteristica1.setId(2);
        caracteristica1.setNombre("Aire Acondicionado");
        caracteristica1.setIcono("<i class=\"fas fa-air-conditioner\"></i>");
        Assertions.assertTrue(caracteristica1.getId() != null);
    }

    @Test
    public void Test02Listar() throws ResourceBadRequestException {
        //Dado
        cargarDataSet();
        List<CaracteristicaDto> listaCaracteristicas = new ArrayList<>();
        Integer respuestaEsperada = 1;
        //Cuando
        Integer respuestaObtenida = caracteristicaService.buscarTodos().size();
        //Entonces
        Assertions.assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    @Transactional
    public void Test03Borrar() throws ResourceBadRequestException, ResourceNotFoundException {
        cargarDataSet();
        List<CaracteristicaDto> listaCaracteristicas = new ArrayList<>();
        caracteristicaService.borrar(1);
        Integer respuestaEsperada = 0;
        //Cuando
        Integer respuestaObtenida = caracteristicaService.buscarTodos().size();
        //Entonces
        Assertions.assertEquals(respuestaEsperada, respuestaObtenida);
    }
}