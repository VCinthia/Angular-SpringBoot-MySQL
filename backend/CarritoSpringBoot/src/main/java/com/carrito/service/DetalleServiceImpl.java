package com.carrito.service;

import com.carrito.model.DetalleOrden;
import com.carrito.repository.DetalleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleServiceImpl implements DetalleService{
    
    @Autowired
    private DetalleRepository detalleRepository;
    
    @Override
    public List<DetalleOrden> getDetalle() {
        return detalleRepository.findAll();
    }

    @Override
    public void createDetalle(DetalleOrden detalleOrden) {
        detalleRepository.save(detalleOrden);
    }

    @Override
    public void deleteDetalle(Long id) {
        detalleRepository.deleteById(id);
    }

    @Override
    public DetalleOrden findDetalle(Long id) {
        return detalleRepository.findById(id).orElse(null);
    }

    @Override
    public void saveDetalle(DetalleOrden detalleOrden) {
        detalleRepository.save(detalleOrden);
    }

    
}
