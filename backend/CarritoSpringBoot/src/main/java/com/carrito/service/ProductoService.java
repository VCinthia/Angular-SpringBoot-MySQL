package com.carrito.service;

import com.carrito.model.Producto;
import java.util.List;

public interface ProductoService {
    
    public List<Producto> getProducto();    
    public void createProducto(Producto producto);    
    public void deleteProducto(Long id);    
    public Producto findProducto(Long id);    
    public void saveProducto(Producto producto);
    
}
