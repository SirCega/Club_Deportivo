package com.example.Primerproyecto.Servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.Primerproyecto.Repositorio.ClubRepository;
import com.example.Primerproyecto.entidad.Club;

@Service
@Transactional
public class ClubService implements IClubService {

    @Autowired
    private ClubRepository clubRepo;

    @Override
    public List<Club> getClubes() {
        return clubRepo.findAll();
    }

    @Override
    public Club buscarClub(Long id) {
        return clubRepo.findById(id).orElse(null);
    }

    @Override
    public Club guardarClub(Club club) {
        return clubRepo.save(club);
    }

    @Override
    public void borrarClub(Long id) {
        clubRepo.deleteById(id);
    }
}
