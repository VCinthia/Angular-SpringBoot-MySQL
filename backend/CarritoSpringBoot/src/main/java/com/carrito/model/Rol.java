package com.carrito.model;

public class Rol {
    private Integer id;
    private String tipo;

    public Rol() {
    }

    public Rol(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Rol{" + "id=" + id + ", tipo=" + tipo + '}';
    }    
    
}
