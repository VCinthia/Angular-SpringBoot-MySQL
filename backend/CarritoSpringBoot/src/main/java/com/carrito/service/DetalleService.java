package com.carrito.service;

import com.carrito.model.DetalleOrden;
import java.util.List;

public interface DetalleService {
    
    public List<DetalleOrden> getDetalle();    
    public void createDetalle(DetalleOrden detalleOrden);
    public void deleteDetalle(Long id);
    public DetalleOrden findDetalle(Long id);
    public void saveDetalle(DetalleOrden detalleOrden);
}
