package com.example.Primerproyecto.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Primerproyecto.Repositorio.AsociacionRepository;
import com.example.Primerproyecto.entidad.Asociacion;

@Service
public class AsociacionService implements IAsociacionService {

    @Autowired
    private AsociacionRepository asociacionRepo;

    @Override
    public List<Asociacion> findAll() {
        return asociacionRepo.findAll();
    }

    @Override
    public Optional<Asociacion> findById(Long id) {
        return asociacionRepo.findById(id);
    }

    @Override
    public Asociacion create(Asociacion asociacion) {
        return asociacionRepo.save(asociacion);
    }

    @Override
    public Asociacion update(Asociacion asociacion) {
        return asociacionRepo.save(asociacion);
    }

    @Override
    public void delete(Long id) {
        asociacionRepo.deleteById(id);
    }
}
