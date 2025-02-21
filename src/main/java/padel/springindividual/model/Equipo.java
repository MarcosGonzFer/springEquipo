package padel.springindividual.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

    @Entity
    @Table(name = "equipo")
    public class Equipo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String nombre;
        private String categoria;
        private String estado;

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

