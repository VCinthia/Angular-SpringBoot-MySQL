package com.carrito.controller;

import com.carrito.model.DetalleOrden;
import com.carrito.model.Orden;
import com.carrito.model.Producto;
import com.carrito.model.Usuario;
import com.carrito.service.OrdenService;
import com.carrito.service.UsuarioService;
import java.util.Date;
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
//@RequestMapping("/ordenes")
@CrossOrigin(origins = "*")
public class OrdenController {
    
    @Autowired
    private OrdenService ordenService;
    @Autowired
    private UsuarioService usuarioService;
    
    
    @GetMapping("/ordenes/show")
    @ResponseBody
    public List<Orden> getOrden() {
        return ordenService.getOrden();
    }
    
    @GetMapping("/ordenes/{id}")
    public Orden findOrden(@PathVariable Long id){
        return ordenService.findOrden(id);
    }
    
    //////////////////
    
    @PostMapping("/ordenes/create")
    @ResponseBody//Usuario ManyToOne | DetalleOrden OneToMany
    public String createOrden(@RequestBody Orden orden) {
        if (orden.getUsuario() == null) {
        return "El usuario asociado a la orden no puede ser nulo";
    }
        Usuario usuario = usuarioService.findUsuario(orden.getUsuario().getId());
        orden.setUsuario(usuario);
        ordenService.createOrden(orden);
        return "La Orden fue cargada correctamente";
    }
    
    //////////////////
    
    @DeleteMapping("/ordenes/delete/{id}")
    public void deleteOrden(@PathVariable Long id) {
        ordenService.deleteOrden(id);
    }

    @PutMapping("/ordenes/save")
    public String saveOrden(@RequestBody Orden orden) {
        ordenService.saveOrden(orden);
        return "La orden fue guardada correctamente";
    }
    
    /////////////////
    
    @PutMapping("/ordenes/editar/{id}")
    public Orden editOrden(
            @PathVariable Long id,
            @RequestParam("fechaCreacion") Date nuevaFecha,
            @RequestParam("subtotal") Double nuevoSubtotal,
            @RequestParam("es_promocional") boolean nuevoEsProm,
            @RequestParam("total") Double nuevoTotal,
            @RequestParam("usuario") Usuario nuevoUsuario
    ) {
        Orden orden = ordenService.findOrden(id);
        orden.setFechaCreacion(nuevaFecha);
        orden.setSubtotal(nuevoSubtotal);
        orden.setEs_promocional(nuevoEsProm);
        orden.setTotal(nuevoTotal);
        orden.setUsuario(nuevoUsuario);        
        ordenService.saveOrden(orden);
        return orden;
    }
    
}
