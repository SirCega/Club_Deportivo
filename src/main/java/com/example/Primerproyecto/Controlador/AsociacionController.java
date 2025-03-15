package com.example.Primerproyecto.Controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Primerproyecto.Servicio.AsociacionService;
import com.example.Primerproyecto.entidad.Asociacion;

@RestController
@RequestMapping("/api/asociaciones")
public class AsociacionController {

    @Autowired
    private AsociacionService asociacionService;

    @GetMapping
    public ResponseEntity<List<Asociacion>> findAll() {
        return ResponseEntity.ok(asociacionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asociacion> findById(@PathVariable Long id) {
        return asociacionService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Asociacion> create(@RequestBody Asociacion asociacion) {
        return new ResponseEntity<>(asociacionService.create(asociacion), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Asociacion> update(@RequestBody Asociacion asociacion) {
        return asociacionService.findById(asociacion.getId())
                .map(existing -> ResponseEntity.ok(asociacionService.update(asociacion)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return asociacionService.findById(id)
                .map(existing -> {
                    asociacionService.delete(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
