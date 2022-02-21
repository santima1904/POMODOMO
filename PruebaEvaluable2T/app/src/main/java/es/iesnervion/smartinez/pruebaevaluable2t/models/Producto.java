package es.iesnervion.smartinez.pruebaevaluable2t.models;

public class Producto {
    //Atributos
    private int image;
    private String nombre;
    private double precioUnitario;
    private double precioPorKoL;
    private double cantidad;
    private String categoria;

    //Constructor
    //Por defecto
    public Producto() {
        this.image = 0;
        this.nombre = " ";
        this.precioUnitario = 0;
        this.precioPorKoL = 0;
        this.cantidad = 0;
        this.categoria = " ";
    }

    //Con parametros
    public Producto(int image, String nombre, double precioUnitario, double precioPorKoL, double cantidad, String categoria) {
        this.image = image;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.precioPorKoL = precioPorKoL;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    //Getters and setters
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioPorKoL() {
        return precioPorKoL;
    }

    public void setPrecioPorKoL(double precioPorKoL) {
        this.precioPorKoL = precioPorKoL;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
