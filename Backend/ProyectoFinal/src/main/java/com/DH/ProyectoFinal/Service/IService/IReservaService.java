package com.DH.ProyectoFinal.Service.IService;

import com.DH.ProyectoFinal.exceptions.ResourceBadRequestException;
import com.DH.ProyectoFinal.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IReservaService <T>{
    T guardar (T t) throws ResourceBadRequestException;
    T buscarPorId (Integer id) throws ResourceNotFoundException;
    List<T> buscarTodos();
    T actualizar (T t) throws ResourceNotFoundException;
    void borrar (Integer id) throws ResourceNotFoundException;
}
