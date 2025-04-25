package com.example.Primerproyecto.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Primerproyecto.Repositorio.AsociacionRepository;
import com.example.Primerproyecto.entidad.Asociacion;



@Service
@Transactional
public class AsociacionService implements IAsociacionService {

    @Autowired
    AsociacionRepository asociacionRepo;

    
    
    @Override
    public List<Asociacion> getAsociaciones() {
        return asociacionRepo.findAll();
    }
    

    


    @Override
    public Asociacion buscarAsociacion(Long id) {
        return asociacionRepo.findById(id).orElse(null);
    }

    
    @Override
    public Asociacion nuevoAsociacion(Asociacion asociacion) {
        return asociacionRepo.save(asociacion);
    }

    
    
    @Override
     public void borrarAsociacion(Long id) {
        asociacionRepo.deleteById(id);
    }
}
