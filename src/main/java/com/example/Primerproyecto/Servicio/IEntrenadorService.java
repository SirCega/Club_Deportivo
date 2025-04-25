package com.example.Primerproyecto.Servicio;

import java.util.List;
import com.example.Primerproyecto.entidad.Entrenador;

public interface IEntrenadorService {
    List<Entrenador> getEntrenadores();
    Entrenador buscarEntrenador(Long id);
    Entrenador guardarEntrenador(Entrenador entrenador);
    void borrarEntrenador(Long id);
}