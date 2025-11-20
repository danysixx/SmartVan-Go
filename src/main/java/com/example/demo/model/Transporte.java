package com.example.demo.model;

import jakarta.persistence.*;


@Entity
public class Transporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String punto;
    private int personas;

    private String uuid; // NUEVO: identificador único por sesión/usuario

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPunto() { return punto; }
    public void setPunto(String punto) { this.punto = punto; }

    public int getPersonas() { return personas; }
    public void setPersonas(int personas) { this.personas = personas; }

    public String getUuid() { return uuid; }       // NUEVO
    public void setUuid(String uuid) { this.uuid = uuid; } // NUEVO
}
