package com.example.Primerproyecto.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Primerproyecto.Repositorio.CompeticionRepository;
import com.example.Primerproyecto.entidad.Competicion;

@Controller
@RequestMapping
public class CompeticionController {

    @Autowired
    private CompeticionRepository competicionRepository;

    @GetMapping({"/verCompeticion", "/mostrarCompeticion", "/listarCompeticion"})
    public String listarCompeticion(Model model) {
        List<Competicion> listaCompeticion = competicionRepository.findAll();
        model.addAttribute("listaCompeticion", listaCompeticion);
        return "verCompeticion";
    }

    @GetMapping({"/verCompeticion/formCompeticion"})
    public String mostrarFormulario(Model model) {
        model.addAttribute("competicion", new Competicion());
        List<Competicion> listaCompeticion = competicionRepository.findAll();
        model.addAttribute("listaCompeticion", listaCompeticion);
        return "formCompeticion";
    }

    @PostMapping({"/guardarCompeticion"})
    public String guardarCompeticion(Competicion competicion) {
        competicionRepository.save(competicion);
        return "redirect:/verCompeticion";
    }

    @GetMapping("/competicion/editar/{id}")
    public String modificarCompeticion(@PathVariable("id") Long id, Model model) {
        Competicion competicion = competicionRepository.findById(id).get();
        model.addAttribute("competicion", competicion);
        List<Competicion> listaCompeticion = competicionRepository.findAll();
        model.addAttribute("listaCompeticion", listaCompeticion);
        return "formCompeticion";
    }

    @GetMapping("/competicion/eliminar/{id}")
    public String eliminarCompeticion(@PathVariable("id") Long id, Model model) {
        competicionRepository.deleteById(id);
        return "redirect:/verCompeticion";
    }
}
