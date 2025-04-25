package com.example.Primerproyecto.Controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Primerproyecto.Servicio.AsociacionService;
import com.example.Primerproyecto.entidad.Asociacion;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/asociaciones")
public class AsociacionController {

    @Autowired
    private AsociacionService asociacionService;

    @GetMapping("/list")
    public List<Asociacion> cargarAsociaciones() {
        return asociacionService.getAsociaciones();
    }

    @GetMapping("/list/{id}")
    public Asociacion buscarPorId(@PathVariable Long id) {
        return asociacionService.buscarAsociacion(id);
                
    }

    @PostMapping("/")
    public Asociacion agregar(@RequestBody Asociacion asociacion) {
        return  asociacionService.nuevoAsociacion(asociacion);
    }

    @PutMapping("/")
    public Asociacion actualizar(@RequestBody Asociacion asociacion) {
        return asociacionService.nuevoAsociacion(asociacion);
                
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Asociacion> eliminar(@PathVariable Long id) {
    	Asociacion obj = asociacionService.buscarAsociacion(id);
    	if(obj != null) {
        	asociacionService.borrarAsociacion(id);
    	}else {
    		return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    	}
		return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    }

