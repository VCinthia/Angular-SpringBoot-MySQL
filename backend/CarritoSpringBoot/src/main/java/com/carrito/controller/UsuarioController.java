package com.carrito.controller;


import com.carrito.model.Usuario;
import com.carrito.service.UsuarioService;
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
//@RequestMapping("/usuarios")
@CrossOrigin(origins="*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/usuarios/show")
    @ResponseBody
    public List<Usuario> getUsuario () {
        return usuarioService.getUsuario();
    }
    
    @GetMapping("/usuarios/{id}")
    public Usuario findUsuario(@PathVariable Long id){
        return usuarioService.findUsuario(id);
    }
    
    @PostMapping("/usuarios/create")
    @ResponseBody
    public String createUsuario(@RequestBody Usuario usuario ){
        usuarioService.createUsuario(usuario);
        return "El usuario fue cargado correctamente";
    } 
    
    @DeleteMapping ("/usuarios/delete/{id}")
    public void deleteUsuario ( @PathVariable Long id){
        usuarioService.deleteUsuario(id);
    }
    
    @PutMapping("/usuarios/save")
    public String saveUsuario(@RequestBody Usuario usuario ){
        usuarioService.saveUsuario(usuario);
        return "El usuario fue guardado correctamente";
    } 
    
    @PutMapping ("/usuarios/editar/{id}")
    public Usuario editUsuario(
            @PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("email") String nuevoEmail,
            @RequestParam("password") String nuevoPassword,
            @RequestParam("es_vip") Boolean nuevoEsVip,
            @RequestParam("es_admin") Boolean nuevoEsAdmin){
        Usuario usuario = usuarioService.findUsuario(id);
        usuario.setNombre(nuevoNombre);        
        usuario.setApellido(nuevoEmail);
        usuario.setEmail(nuevoPassword);
        usuario.setPassword(nuevoPassword);
        usuario.setEs_vip(nuevoEsVip);
        usuario.setEs_admin(nuevoEsAdmin);
        usuarioService.saveUsuario(usuario);
        return usuario;
    }
}
