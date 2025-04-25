package com.example.Primerproyecto.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "clubes")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "asociacion_id")
    private Long asociacionId;

    @Column(name = "entrenador_id")
    private Long entrenadorId;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getAsociacionId() {
        return asociacionId;
    }

    public void setAsociacionId(Long asociacionId) {
        this.asociacionId = asociacionId;
    }

    public Long getEntrenadorId() {
        return entrenadorId;
    }

    public void setEntrenadorId(Long entrenadorId) {
        this.entrenadorId = entrenadorId;
    }
}
