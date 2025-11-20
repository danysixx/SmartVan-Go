package com.example.demo.service;

import com.example.demo.model.Transporte;
import com.example.demo.repository.TransporteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransporteServiceImpl implements TransporteService {

    private final TransporteRepository repository;

    public TransporteServiceImpl(TransporteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Transporte> listar() {
        return repository.findAll();
    }

    @Override
    public Transporte guardar(Transporte transporte) {
        return repository.save(transporte);
    }

    @Override
    public boolean existePorUuid(String uuid) {
        return repository.existsByUuid(uuid);
    }

    @Override
    public Transporte obtenerPorUuid(String uuid) {
        return repository.findByUuid(uuid);
    }
}

