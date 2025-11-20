package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class TransporteDTO {

    @NotBlank(message = "El punto no puede estar vacío")
    private String punto;

    @Min(value = 0, message = "El número de personas no puede ser negativo")
    private int personas;

    // Getters y Setters
    public String getPunto() { return punto; }
    public void setPunto(String punto) { this.punto = punto; }
    public int getPersonas() { return personas; }
    public void setPersonas(int personas) { this.personas = personas; }
}
