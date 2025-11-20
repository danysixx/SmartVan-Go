package com.example.demo.service;

import com.example.demo.model.Transporte;

import java.util.List;

public interface TransporteService {
    List<Transporte> listar();
    Transporte guardar(Transporte transporte);

    // NUEVOS métodos
    boolean existePorUuid(String uuid);
    Transporte obtenerPorUuid(String uuid);
}