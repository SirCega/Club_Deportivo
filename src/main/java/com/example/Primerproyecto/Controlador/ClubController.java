package com.example.Primerproyecto.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Primerproyecto.Repositorio.ClubRepository;
import com.example.Primerproyecto.Repositorio.EntrenadorRepository;
import com.example.Primerproyecto.Repositorio.AsociacionRepository;
import com.example.Primerproyecto.Repositorio.CompeticionRepository;
import com.example.Primerproyecto.Repositorio.JugadorRepository;
import com.example.Primerproyecto.entidad.Club;
import com.example.Primerproyecto.entidad.Entrenador;
import com.example.Primerproyecto.entidad.Asociacion;
import com.example.Primerproyecto.entidad.Competicion;
import com.example.Primerproyecto.entidad.Jugador;

@Controller
@RequestMapping
public class ClubController {

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Autowired
    private AsociacionRepository asociacionRepository;

    @Autowired
    private CompeticionRepository competicionRepository;

    @Autowired
    private JugadorRepository jugadorRepository;

   
    @GetMapping({"/verClub", "/mostrarClub", "/listarClub"})
    public String listarClub(Model model) {
        List<Club> listaClub = clubRepository.findAll();
        model.addAttribute("listaClub", listaClub);
        return "verClub"; 
    }
    
    @GetMapping({"/verClub/formClub"})
    public String mostrarFormulario(Model model) {
        model.addAttribute("club", new Club());
        
        
        List<Entrenador> entrenadores = entrenadorRepository.findAll();
        List<Asociacion> asociaciones = asociacionRepository.findAll();
        List<Competicion> competiciones = competicionRepository.findAll();
        List<Jugador> jugadores = jugadorRepository.findAll();

       
        model.addAttribute("entrenadores", entrenadores);
        model.addAttribute("asociaciones", asociaciones);
        model.addAttribute("competiciones", competiciones);
        model.addAttribute("jugadores", jugadores);
        
        return "formClub"; 
    }

    
    @PostMapping({"/guardarClub"})
    public String guardarClub(Club club) {
        clubRepository.save(club);
        return "redirect:/verClub"; 
    }

    
    @GetMapping("/club/editar/{id}")
    public String modificarClub(@PathVariable("id") Long id, Model model) {
        Club club = clubRepository.findById(id).get();
        model.addAttribute("club", club);
        
        
        List<Entrenador> entrenadores = entrenadorRepository.findAll();
        List<Asociacion> asociaciones = asociacionRepository.findAll();
        List<Competicion> competiciones = competicionRepository.findAll();
        List<Jugador> jugadores = jugadorRepository.findAll();

        model.addAttribute("entrenadores", entrenadores);
        model.addAttribute("asociaciones", asociaciones);
        model.addAttribute("competiciones", competiciones);
        model.addAttribute("jugadores", jugadores);
        
        return "formClub"; 
    }

    
    @GetMapping("/club/eliminar/{id}")
    public String eliminarClub(@PathVariable("id") Long id) {
        clubRepository.deleteById(id);
        return "redirect:/verClub"; 
    }
}
