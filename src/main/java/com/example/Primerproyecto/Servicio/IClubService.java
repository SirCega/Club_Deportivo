package com.example.Primerproyecto.Servicio;

import java.util.List;
import com.example.Primerproyecto.entidad.Club;

public interface IClubService {
    List<Club> getClubes();
    Club buscarClub(Long id);
    Club guardarClub(Club club);
    void borrarClub(Long id);
}
