package com.carrito.service;

import com.carrito.model.Orden;
import java.util.List;

public interface OrdenService {
    
    public List<Orden> getOrden();    
    public void createOrden(Orden orden);
    public void deleteOrden(Long id);
    public Orden findOrden(Long id);
    public void saveOrden(Orden orden);
    
}
