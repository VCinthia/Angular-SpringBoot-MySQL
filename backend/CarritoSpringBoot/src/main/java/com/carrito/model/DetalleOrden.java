package com.carrito.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table( name = "detalles")
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private Integer cantidad;
    //private Double precio;
    private Double subtotal;
    @ManyToOne
    //@JsonIgnore
    private Producto producto;
    @ManyToOne
    //@JsonIgnore
    private Orden orden;    

    public DetalleOrden() {
    }

    public DetalleOrden(Long id, Producto producto, Integer cantidad/*, Double precio*/, Double subtotal, Orden orden) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        //this.precio = precio;
        this.subtotal = subtotal;
        this.orden = orden;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /*public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }*/

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    @Override
    public String toString() {
        return "DetalleOrden{" + "id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + /*", precio=" + precio + */", subtotal=" + subtotal + ", orden=" + orden + '}';
    }
    
    
}
