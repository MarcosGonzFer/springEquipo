package padel.springindividual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import padel.springindividual.model.Jugador;
import padel.springindividual.model.Equipo; // Importar la clase Equipo
import padel.springindividual.repository.JugadorRepository;
import padel.springindividual.repository.EquipoRepository; // Importar EquipoRepository

import java.util.Optional;

@Controller
@RequestMapping("/jugador")
public class JugadorController {

    private final JugadorRepository jugadorRepository;
    private final EquipoRepository equipoRepository;

    public JugadorController(JugadorRepository jugadorRepository, EquipoRepository equipoRepository) {
        this.jugadorRepository = jugadorRepository;
        this.equipoRepository = equipoRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("jugadores", jugadorRepository.findAll());
        return "jugadores";
    }

    @GetMapping("/crear")
    public String formulario(Model model) {
        model.addAttribute("jugador", new Jugador());
        model.addAttribute("equipos", equipoRepository.findAll());
        return "crear_jugador";
    }

    @PostMapping("/guardar")
    public String agregar(@ModelAttribute Jugador jugador, Model model) {
        jugadorRepository.save(jugador);
        return "redirect:/jugadores";
    }

    @GetMapping("/editar/{id}")
    public String editarJugador(@PathVariable Long id, Model model) {
        Optional<Jugador> jugador = jugadorRepository.findById(id);
        if (jugador.isPresent()) {
            model.addAttribute("jugador", jugador.get());
            model.addAttribute("equipo", equipoRepository.findAll());
            return "editar_jugador";
        }
        return "redirect:/jugadores";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarJugador(@PathVariable Long id, @ModelAttribute Jugador jugador) {
        jugador.setId(id);
        jugadorRepository.save(jugador);
        return "redirect:/jugadores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        jugadorRepository.deleteById(id);
        return "redirect:/jugadores";
    }
}
