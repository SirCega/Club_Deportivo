package com.example.Primerproyecto.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Primerproyecto.Repositorio.ClubRepository;
import com.example.Primerproyecto.Repositorio.JugadorRepository;
import com.example.Primerproyecto.entidad.Club;
import com.example.Primerproyecto.entidad.Jugador;

@Controller
public class JugadorController {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private ClubRepository clubRepository;

    @GetMapping("/verJugador")
    public String listarJugadores(Model model) {
        List<Jugador> listaJugador = jugadorRepository.findAll();
        model.addAttribute("listaJugador", listaJugador);
        return "verJugador";
    }

    @GetMapping("/verJugador/formJugador")
    public String mostrarFormulario(Model model) {
        model.addAttribute("jugador", new Jugador());
        List<Club> listaClub = clubRepository.findAll();
        model.addAttribute("listaClub", listaClub); 
        return "formJugador";
    }

    @PostMapping("/guardarJugador")
    public String guardarJugador(Jugador jugador) {
        jugadorRepository.save(jugador);
        return "redirect:/verJugador";
    }

    @GetMapping("/jugador/editar/{id}")
    public String modificarJugador(@PathVariable("id") Long id, Model model) {
        Jugador jugador = jugadorRepository.findById(id).get();
        model.addAttribute("jugador", jugador);
        List<Club> listaClub = clubRepository.findAll();
        model.addAttribute("listaClub", listaClub); 
        return "formJugador";
    }

    @GetMapping("/jugador/eliminar/{id}")
    public String eliminarJugador(@PathVariable("id") Long id) {
        jugadorRepository.deleteById(id);
        return "redirect:/verJugador";
    }
}
