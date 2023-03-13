package com.carrito.controller;

import com.carrito.model.Producto;
import com.carrito.service.ProductoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/productos")
@CrossOrigin(origins="*")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/productos/show")
    @ResponseBody
    public List<Producto> getProducto () {
        return productoService.getProducto();
    }
    
    @GetMapping("/productos/{id}")
    public Producto findProducto(@PathVariable Long id){
        return productoService.findProducto(id);
    }
    
    @PostMapping("/productos/create")
    @ResponseBody
    public String createProducto(@RequestBody Producto producto ){
        productoService.createProducto(producto);
        return "El producto fue cargado correctamente";
    } 
    
    @DeleteMapping ("/productos/delete/{id}")
    public void deleteProducto ( @PathVariable Long id){
        productoService.deleteProducto(id);
    }
    
    @PutMapping("/productos/save")
    public String saveProducto(@RequestBody Producto producto ){
        productoService.saveProducto(producto);
        return "El producto fue guardado correctamente";
    } 
    
    @PutMapping ("/productos/editar/{id}")
    public Producto editProducto(
            @PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("descripcion") String nuevaDescripcion,
            @RequestParam("imagen") String nuevaImagen,
            @RequestParam("precio") Double nuevoPrecio){
        Producto producto = productoService.findProducto(id);
        producto.setNombre(nuevoNombre);
        producto.setDescripcion(nuevaDescripcion);
        producto.setImagen(nuevaImagen);
        producto.setPrecio(nuevoPrecio);
        productoService.saveProducto(producto);
        return producto;
    }
    
}
