package com.example.Primerproyecto.Servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.Primerproyecto.Repositorio.CompeticionRepository;
import com.example.Primerproyecto.entidad.Competicion;

@Service
@Transactional
public class CompeticionService implements ICompeticionService {

    @Autowired
    private CompeticionRepository competicionRepo;

    @Override
    public List<Competicion> getCompeticiones() {
        return competicionRepo.findAll();
    }

    @Override
    public Competicion buscarCompeticion(Long id) {
        return competicionRepo.findById(id).orElse(null);
    }

    @Override
    public Competicion nuevaCompeticion(Competicion competicion) {
        return competicionRepo.save(competicion);
    }

    @Override
    public void borrarCompeticion(Long id) {
        competicionRepo.deleteById(id);
    }
}