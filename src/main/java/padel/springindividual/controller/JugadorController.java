package padel.springindividual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import padel.springindividual.model.Jugador;

import padel.springindividual.repository.JugadorRepository;

import java.util.Optional;

@Controller
@RequestMapping("/jugador")
public class JugadorController {
    private final JugadorRepository repository;

    public JugadorController(JugadorRepository repository) {
        this.repository = repository;
    }

    @GetMapping({"/", ""})
    public String listar(Model model) {
        model.addAttribute("jugador", repository.findAll());
        return "jugador";
    }

    @GetMapping("/crear")
    public String formulario(Model model) {
        model.addAttribute("jugador", new Jugador());
        return "crear_jugador";
    }

    @PostMapping("/guardar")
    public String agregar(@ModelAttribute Jugador jugador, Model model) {
        repository.save(jugador);
        return "redirect:/jugador";
    }


    @GetMapping("/editar/{id}")
    public String editarJugador(@PathVariable Long id, Model model) {
        Optional<Jugador> jugador = repository.findById(id);
        if (jugador.isPresent()) {
            model.addAttribute("jugador", jugador.get());
            return "editar_jugador";
        }
        return "redirect:/jugadores";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarJugador(@PathVariable Long id, @ModelAttribute Jugador jugador) {
        jugador.setId(id);
        repository.save(jugador);
        return "redirect:/jugador";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/jugador";
    }
}