package com.example.Primerproyecto.Servicio;

import java.util.List;


import com.example.Primerproyecto.entidad.Asociacion;



public interface IAsociacionService {
	
    List<Asociacion> getAsociaciones();
    
    Asociacion buscarAsociacion(Long id);
    
    Asociacion nuevoAsociacion(Asociacion asociacion);
    
    
    void borrarAsociacion(Long id);
}