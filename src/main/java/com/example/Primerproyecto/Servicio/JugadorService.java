package com.example.Primerproyecto.Servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.Primerproyecto.Repositorio.JugadorRepository;
import com.example.Primerproyecto.entidad.Jugador;

@Service
@Transactional
public class JugadorService implements IJugadorService {

    @Autowired
    private JugadorRepository jugadorRepo;

    @Override
    public List<Jugador> getJugadores() {
        return jugadorRepo.findAll();
    }

    @Override
    public Jugador buscarJugador(Long id) {
        return jugadorRepo.findById(id).orElse(null);
    }

    @Override
    public Jugador nuevoJugador(Jugador jugador) {
        return jugadorRepo.save(jugador);
    }

    @Override
    public void borrarJugador(Long id) {
        jugadorRepo.deleteById(id);
    }
}