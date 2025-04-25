package com.example.Primerproyecto.Controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Primerproyecto.Servicio.CompeticionService;
import com.example.Primerproyecto.entidad.Competicion;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/competiciones")
public class CompeticionController {

    @Autowired
    private CompeticionService competicionService;

    @GetMapping("/list")
    public List<Competicion> cargarCompeticiones() {
        return competicionService.getCompeticiones();
    }

    @GetMapping("/list/{id}")
    public Competicion buscarPorId(@PathVariable Long id) {
        return competicionService.buscarCompeticion(id);
    }

    @PostMapping("/")
    public Competicion agregar(@RequestBody Competicion competicion) {
        return competicionService.nuevaCompeticion(competicion);
    }

    @PutMapping("/")
    public Competicion actualizar(@RequestBody Competicion competicion) {
        return competicionService.nuevaCompeticion(competicion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Competicion> eliminar(@PathVariable Long id) {
        Competicion obj = competicionService.buscarCompeticion(id);
        if (obj != null) {
            competicionService.borrarCompeticion(id);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}