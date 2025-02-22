package padel.springindividual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import padel.springindividual.model.Equipo;
import padel.springindividual.repository.EquipoRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/equipo")
public class EquipoController {

    private final EquipoRepository repository;

    public EquipoController(EquipoRepository repository) {
        this.repository = repository;
    }

    // Listar todos los equipos
    @GetMapping({"/", ""})
    public String listarEquipos(Model model) {
        List<Equipo> equipos = repository.findAll();
        model.addAttribute("equipos", equipos);
        return "equipo";
    }

    // Mostrar formulario para crear un nuevo equipo
    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("equipo", new Equipo());
        return "crear_equipo";
    }

    // Guardar un nuevo equipo
    @PostMapping("/guardar")
    public String guardarEquipo(@ModelAttribute Equipo equipo) {
        repository.save(equipo);
        return "redirect:/equipo";
    }

    // Mostrar formulario para editar un equipo existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Optional<Equipo> equipo = repository.findById(id);
        if (equipo.isPresent()) {
            model.addAttribute("equipo", equipo.get());
            return "editar_equipo";
        }
        return "redirect:/equipo";
    }

    // Actualizar un equipo existente
    @PostMapping("/actualizar/{id}")
    public String actualizarEquipo(@PathVariable Long id, @ModelAttribute Equipo equipo) {
        equipo.setId(id);
        repository.save(equipo);
        return "redirect:/equipo";
    }

    // Eliminar un equipo
    @GetMapping("/eliminar/{id}")
    public String eliminarEquipo(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/equipo";
    }
}
