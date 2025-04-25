package com.example.Primerproyecto.Controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.Primerproyecto.Servicio.EntrenadorService;
import com.example.Primerproyecto.entidad.Entrenador;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping("/list")
    public List<Entrenador> getEntrenadores() {
        return entrenadorService.getEntrenadores();
    }

    @GetMapping("/list/{id}")
    public Entrenador getEntrenador(@PathVariable Long id) {
        return entrenadorService.buscarEntrenador(id);
    }

    @PostMapping("/")
    public Entrenador crearEntrenador(@RequestBody Entrenador entrenador) {
        return entrenadorService.guardarEntrenador(entrenador);
    }

    @PutMapping("/")
    public Entrenador actualizarEntrenador(@RequestBody Entrenador entrenador) {
        return entrenadorService.guardarEntrenador(entrenador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEntrenador(@PathVariable Long id) {
        Entrenador entrenador = entrenadorService.buscarEntrenador(id);
        if (entrenador != null) {
            entrenadorService.borrarEntrenador(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}