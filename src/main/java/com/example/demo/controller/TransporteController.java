package com.example.demo.controller;

import com.example.demo.dto.TransporteDTO;
import com.example.demo.model.Transporte;
import com.example.demo.service.TransporteServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transporte")
@CrossOrigin(origins = "http://localhost:4200") // Cambia según tu frontend
public class TransporteController {

    private final TransporteServiceImpl service;

    public TransporteController(TransporteServiceImpl service) {
        this.service = service;
    }

    // Listar todos
    @GetMapping
    public List<Transporte> listar() {
        return service.listar();
    }

    // Guardar nuevo registro desde DTO, ahora con control de una sola persona
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody @Valid TransporteDTO dto,
                                     @RequestParam String uuid) {

        if (service.existePorUuid(uuid)) {
            return ResponseEntity.badRequest().body("Ya registraste un transporte para esta sesión");
        }

        Transporte t = new Transporte();
        t.setPunto(dto.getPunto());
        t.setPersonas(dto.getPersonas());
        t.setUuid(uuid); // asociamos la sesión

        return ResponseEntity.ok(service.guardar(t));
    }

    // Obtener el registro de la sesión actual
    @GetMapping("/miRegistro")
    public ResponseEntity<Transporte> miRegistro(@RequestParam String uuid) {
        Transporte t = service.obtenerPorUuid(uuid);
        if (t != null) return ResponseEntity.ok(t);
        else return ResponseEntity.noContent().build();
    }
}
