package com.carrito.controller;

import com.carrito.model.DetalleOrden;
import com.carrito.model.Orden;
import com.carrito.model.Producto;
import com.carrito.service.DetalleService;
import com.carrito.service.OrdenService;

import com.carrito.service.ProductoService;
import java.util.List;
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
//@RequestMapping("/detalles")
@CrossOrigin(origins = "*")
public class DetalleOrdenController {

    @Autowired
    private DetalleService detalleService;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private OrdenService ordenService;

    @GetMapping("/detalles/show")
    @ResponseBody
    public List<DetalleOrden> getDetalle() {
        return detalleService.getDetalle();
    }
    
    @GetMapping("/detalles/{id}")
    public DetalleOrden findDetalle(@PathVariable Long id){
        return detalleService.findDetalle(id);
    }

    @PostMapping("/detalles/create")
    @ResponseBody//Producto y Producto son ManyToOne de DetalleOrden
    public String createDetalle(@RequestBody DetalleOrden detalleOrden) {
        Producto producto = productoService.findProducto(detalleOrden.getProducto().getId());
        Orden orden = ordenService.findOrden(detalleOrden.getOrden().getId());
        detalleOrden.setProducto(producto);
        detalleOrden.setOrden(orden);
        detalleService.createDetalle(detalleOrden);
        return "El detalle fue cargado correctamente";
    }
    
    @DeleteMapping("/detalles/delete/{id}")
    public void deleteDetalle(@PathVariable Long id) {
        detalleService.deleteDetalle(id);
    }

    @PutMapping("/detalles/save")
    public String saveDetalle(@RequestBody DetalleOrden detalleOrden) {
        detalleService.saveDetalle(detalleOrden);
        return "El detalle fue guardado correctamente";
    }

    @PutMapping("/detalles/editar/{id}")
    public DetalleOrden editDetalle(
            @PathVariable Long id,
            @RequestParam("cantidad") Integer nuevaCantidad,
            //@RequestParam("precio") Double nuevoPrecio,
            @RequestParam("subtotal") Double nuevoSubtotal,
            @RequestParam("producto") Producto nuevoProducto,
            @RequestParam("orden") Orden nuevaOrden
    ) {
        DetalleOrden detalleOrden = detalleService.findDetalle(id);
        detalleOrden.setCantidad(nuevaCantidad);
        detalleOrden.setSubtotal(nuevoSubtotal);
        detalleOrden.setProducto(nuevoProducto);
        detalleOrden.setOrden(nuevaOrden);
        detalleService.saveDetalle(detalleOrden);
        return detalleOrden;
    }
}
