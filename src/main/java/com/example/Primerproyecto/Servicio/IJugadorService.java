package com.example.Primerproyecto.Servicio;

import java.util.List;
import com.example.Primerproyecto.entidad.Jugador;

public interface IJugadorService {
    List<Jugador> getJugadores();
    Jugador buscarJugador(Long id);
    Jugador nuevoJugador(Jugador jugador);
    void borrarJugador(Long id);
}