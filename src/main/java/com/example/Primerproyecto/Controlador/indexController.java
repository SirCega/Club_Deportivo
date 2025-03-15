package com.example.Primerproyecto.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

	@GetMapping({"/","/index","/inicio"})
	public String redirectToHomePage() {
		return "index";
	}
}