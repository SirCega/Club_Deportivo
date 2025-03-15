package com.example.Primerproyecto.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Primerproyecto.Repositorio.EntrenadorRepository;
import com.example.Primerproyecto.entidad.Entrenador;

@Controller
@RequestMapping
public class EntrenadorController {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @GetMapping({"/verEntrenador", "/mostrarEntrenador", "/listarEntrenador"})
    public String listarEntrenador(Model model) {
        List<Entrenador> listaEntrenador = entrenadorRepository.findAll();
        model.addAttribute("listaEntrenador", listaEntrenador);
        return "verEntrenador";
    }

    @GetMapping({"/verEntrenador/formEntrenador"})
    public String mostrarFormulario(Model model) {
        model.addAttribute("entrenador", new Entrenador());
        List<Entrenador> listaEntrenador = entrenadorRepository.findAll();
        model.addAttribute("listaEntrenador", listaEntrenador);
        return "formEntrenador";
    }

    @PostMapping({"/guardarEntrenador"})
    public String guardarEntrenador(Entrenador entrenador) {
        entrenadorRepository.save(entrenador);
        return "redirect:/verEntrenador";
    }

    @GetMapping("/entrenador/editar/{id}")
    public String modificarEntrenador(@PathVariable("id") Long id, Model model) {
        Entrenador entrenador = entrenadorRepository.findById(id).get();
        model.addAttribute("entrenador", entrenador);
        List<Entrenador> listaEntrenador = entrenadorRepository.findAll();
        model.addAttribute("listaEntrenador", listaEntrenador);
        return "formEntrenador";
    }

    @GetMapping("/entrenador/eliminar/{id}")
    public String eliminarEntrenador(@PathVariable("id") Long id, Model model) {
        entrenadorRepository.deleteById(id);
        return "redirect:/verEntrenador";
    }
}
