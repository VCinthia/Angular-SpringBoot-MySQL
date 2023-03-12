package com.carrito.repository;

import com.carrito.model.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleRepository extends JpaRepository<DetalleOrden, Long>{
    
    
}
