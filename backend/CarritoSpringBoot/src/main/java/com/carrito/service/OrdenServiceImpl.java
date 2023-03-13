package com.carrito.service;

import com.carrito.model.Orden;
import com.carrito.repository.OrdenRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenServiceImpl implements OrdenService {
    
    @Autowired
    private OrdenRepository ordenRepository;

    @Override
    public List<Orden> getOrden() {
        return ordenRepository.findAll();
    }

    @Override
    public void createOrden(Orden orden) {
        ordenRepository.save(orden);
    }

    @Override
    public void deleteOrden(Long id) {
        ordenRepository.deleteById(id);
    }

    @Override
    public Orden findOrden(Long id) {
        return ordenRepository.findById(id).orElse(null);
    }

    @Override
    public void saveOrden(Orden orden) {
        ordenRepository.save(orden);
    }

    
}
