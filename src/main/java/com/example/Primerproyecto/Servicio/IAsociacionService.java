package com.example.Primerproyecto.Servicio;

import java.util.List;
import java.util.Optional;

import com.example.Primerproyecto.entidad.Asociacion;

public interface IAsociacionService {
    List<Asociacion> findAll();
    Optional<Asociacion> findById(Long id);
    Asociacion create(Asociacion asociacion);
    Asociacion update(Asociacion asociacion);
    void delete(Long id);
}