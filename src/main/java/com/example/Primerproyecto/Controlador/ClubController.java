package com.example.Primerproyecto.Controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.Primerproyecto.Servicio.ClubService;
import com.example.Primerproyecto.entidad.Club;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/clubes")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping("/list")
    public List<Club> getClubes() {
        return clubService.getClubes();
    }

    @GetMapping("/list/{id}")
    public Club getClub(@PathVariable Long id) {
        return clubService.buscarClub(id);
    }

    @PostMapping("/")
    public Club crearClub(@RequestBody Club club) {
        return clubService.guardarClub(club);
    }

    @PutMapping("/")
    public Club actualizarClub(@RequestBody Club club) {
        return clubService.guardarClub(club);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarClub(@PathVariable Long id) {
        Club club = clubService.buscarClub(id);
        if (club != null) {
            clubService.borrarClub(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
