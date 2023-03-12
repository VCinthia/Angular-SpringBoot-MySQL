package com.carrito.service;

import com.carrito.model.Usuario;
import java.util.List;

public interface UsuarioService {
    public List<Usuario> getUsuario();
    
    public void createUsuario(Usuario usuario);
    public void deleteUsuario(Long id);
    public Usuario findUsuario(Long id);
    public void saveUsuario(Usuario usuario);
}
