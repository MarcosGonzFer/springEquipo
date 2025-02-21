package padel.springindividual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import padel.springindividual.model.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}
