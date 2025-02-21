package padel.springindividual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import padel.springindividual.model.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {
}
