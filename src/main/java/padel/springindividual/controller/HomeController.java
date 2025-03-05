package padel.springindividual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import padel.springindividual.model.Equipo;
import padel.springindividual.model.Jugador;
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

    // Página principal
    @GetMapping("/")
    public String home() {
        return "home"; // Esta página contiene los enlaces a Equipos y Jugadores
    }

    // Página de Equipos
    @GetMapping("/equipo")
    public String equipos(Model model) {
        model.addAttribute("equipos", equipoRepository.findAll());
        model.addAttribute("nuevoEquipo", new Equipo());
        return "equipo";
    }


    @GetMapping("/jugadores")
    public String jugadores(Model model) {
        model.addAttribute("jugadores", jugadorRepository.findAll());
        model.addAttribute("nuevoJugador", new Jugador());
        return "jugadores";
   }
}
