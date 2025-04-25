package com.example.Primerproyecto.Servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.Primerproyecto.Repositorio.EntrenadorRepository;
import com.example.Primerproyecto.entidad.Entrenador;

@Service
@Transactional
public class EntrenadorService implements IEntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepo;

    @Override
    public List<Entrenador> getEntrenadores() {
        return entrenadorRepo.findAll();
    }

    @Override
    public Entrenador buscarEntrenador(Long id) {
        return entrenadorRepo.findById(id).orElse(null);
    }

    @Override
    public Entrenador guardarEntrenador(Entrenador entrenador) {
        return entrenadorRepo.save(entrenador);
    }

    @Override
    public void borrarEntrenador(Long id) {
        entrenadorRepo.deleteById(id);
    }
}
