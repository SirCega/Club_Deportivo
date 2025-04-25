package com.example.Primerproyecto.Servicio;

import java.util.List;
import com.example.Primerproyecto.entidad.Competicion;

public interface ICompeticionService {
    List<Competicion> getCompeticiones();
    Competicion buscarCompeticion(Long id);
    Competicion nuevaCompeticion(Competicion competicion);
    void borrarCompeticion(Long id);
}