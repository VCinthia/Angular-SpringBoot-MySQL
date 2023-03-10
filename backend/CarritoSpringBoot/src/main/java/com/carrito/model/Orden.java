package com.carrito.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;       
    private Date fechaCreacion;
    private double subtotal;
    private boolean es_promocional;
    private double total;
    @ManyToOne
    private Usuario usuario;
    @OneToMany(mappedBy = "orden")
    private List<DetalleOrden> detalleOrdenes;
    
    public Orden() {
    }

    public Orden(Integer id, Date fechaCreacion, double subtotal, boolean es_promocional, double total, Usuario usuario) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.subtotal = subtotal;
        this.es_promocional = es_promocional;
        this.total = total;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public boolean isEs_promocional() {
        return es_promocional;
    }

    public void setEs_promocional(boolean es_promocional) {
        this.es_promocional = es_promocional;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<DetalleOrden> getDetalleOrdenes() {
        return detalleOrdenes;
    }

    public void setDetalleOrdenes(List<DetalleOrden> detalleOrdenes) {
        this.detalleOrdenes = detalleOrdenes;
    } 

    @Override
    public String toString() {
        return "Orden{" + "id=" + id + ", fechaCreacion=" + fechaCreacion + ", subtotal=" + subtotal + ", es_promocional=" + es_promocional + ", total=" + total + ", usuario=" + usuario + ", detalleOrdenes=" + detalleOrdenes + '}';
    }
    
    
    
}
