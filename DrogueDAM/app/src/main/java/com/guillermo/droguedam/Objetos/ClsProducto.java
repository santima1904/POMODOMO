package com.guillermo.droguedam.Objetos;

import com.guillermo.droguedam.R;
import java.io.Serializable;

public class ClsProducto implements Serializable {

    private int imagen;
    private String nombre;
    private int cantidad;
    private double precio;
    private String numReferencia;
    private String descripcion;
    private String tipoProducto;

    //constructor por defecto
    public ClsProducto(){
        imagen = R.drawable.higiene1;
        nombre = "Producto";
        cantidad = 1;
        numReferencia = "Num ref: 00000";
        descripcion = "";
        tipoProducto = "";
        precio = 0.0;
    }

    //Constructor por parametros


    public ClsProducto(int imagen, String nombre, int cantidad, double precio, String numReferencia, String tipoProducto) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.numReferencia = "Num ref: " + numReferencia;
        this.descripcion = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum";
        this.tipoProducto = tipoProducto;
    }

    //Getters y setters
    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNumReferencia() {
        return numReferencia;
    }

    public void setNumReferencia(String numReferencia) {
        this.numReferencia = numReferencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
