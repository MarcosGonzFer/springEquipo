package padel.springindividual.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
    @Table(name = "equipo")
    public class Equipo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String nombre;
        private String categoria;
        private String estado;

        @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
        private List<Jugador> jugadores;

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Equipo() {

        }
        public Equipo(String nombre, String categoria, String estado) {
            this.nombre = nombre;
            this.categoria = categoria;
            this.estado = estado;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getCategoria() {
            return categoria;
        }
        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }
        public String getEstado() {
            return estado;
        }
        public void setEstado(String estado) {
            this.estado = estado;
        }
        @Override
        public String toString() {
            return "Equipo [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", estado=" + estado + "]";
        }

    }

