package padel.springindividual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import padel.springindividual.repository.EquipoRepository;
import padel.springindividual.repository.JugadorRepository;

@Controller
public class HomeController {

    private final EquipoRepository equipoRepository;
    private final JugadorRepository jugadorRepository;

    public HomeController(EquipoRepository equipoRepository, JugadorRepository jugadorRepository) {
        this.equipoRepository = equipoRepository;
        this.jugadorRepository = jugadorRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        // Pasamos ambos modelos a la vista de inicio
        model.addAttribute("equipos", equipoRepository.findAll());
        model.addAttribute("jugadores", jugadorRepository.findAll());
        return "home"; // Vista que contiene tanto equipos como jugadores
    }
}
