package padel.springindividual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import padel.springindividual.model.Equipo;
import padel.springindividual.repository.EquipoRepository;

import java.util.Optional;

@Controller
@RequestMapping("/equipo")
public class EquiposController {
    private final EquipoRepository repository;

    public EquiposController(EquipoRepository repository) {
        this.repository = repository;
    }

    @GetMapping({"/", ""})
    public String listar(Model model) {
        model.addAttribute("equipos", repository.findAll());
        return "equipo";  // Este sería el nombre de la vista para listar equipos
    }

    @GetMapping("/crear")
    public String formulario(Model model) {
        model.addAttribute("equipo", new Equipo());
        return "crear_equipo";  // Este sería el nombre de la vista para crear un equipo
    }

    @PostMapping("/guardar")
    public String agregar(@ModelAttribute Equipo equipo, Model model) {
        repository.save(equipo);
        return "redirect:/equipo";  // Redirige al listado de equipos después de guardar
    }

    @GetMapping("/editar/{id}")
    public String editarEquipo(@PathVariable Long id, Model model) {
        Optional<Equipo> equipo = repository.findById(id);
        if (equipo.isPresent()) {
            model.addAttribute("equipo", equipo.get());
            return "editar_equipo";  // Este sería el nombre de la vista para editar un equipo
        }
        return "redirect:/equipo";  // Si no se encuentra el equipo, redirige a la lista
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarEquipo(@PathVariable Long id, @ModelAttribute Equipo equipo) {
        equipo.setId(id);  // Asigna el ID del equipo para asegurarse de que la actualización sea correcta
        repository.save(equipo);
        return "redirect:/equipo";  // Redirige al listado de equipos después de actualizar
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repository.deleteById(id);  // Elimina el equipo por ID
        return "redirect:/equipo";  // Redirige al listado de equipos después de eliminar
    }
}
