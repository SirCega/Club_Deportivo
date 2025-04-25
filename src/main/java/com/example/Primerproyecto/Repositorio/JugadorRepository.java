package com.example.Primerproyecto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Primerproyecto.entidad.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {
}