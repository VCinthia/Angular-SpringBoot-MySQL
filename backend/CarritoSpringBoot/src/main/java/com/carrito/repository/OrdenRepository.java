package com.carrito.repository;

import com.carrito.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository<Orden, Long>{
    
}
