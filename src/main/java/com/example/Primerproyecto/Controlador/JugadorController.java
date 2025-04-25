package com.example.Primerproyecto.Controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Primerproyecto.Servicio.JugadorService;
import com.example.Primerproyecto.entidad.Jugador;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping("/list")
    public List<Jugador> cargarJugadores() {
        return jugadorService.getJugadores();
    }

    @GetMapping("/list/{id}")
    public Jugador buscarPorId(@PathVariable Long id) {
        return jugadorService.buscarJugador(id);
    }

    @PostMapping("/")
    public Jugador agregar(@RequestBody Jugador jugador) {
        return jugadorService.nuevoJugador(jugador);
    }

    @PutMapping("/")
    public Jugador actualizar(@RequestBody Jugador jugador) {
        return jugadorService.nuevoJugador(jugador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Jugador> eliminar(@PathVariable Long id) {
        Jugador obj = jugadorService.buscarJugador(id);
        if (obj != null) {
            jugadorService.borrarJugador(id);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}