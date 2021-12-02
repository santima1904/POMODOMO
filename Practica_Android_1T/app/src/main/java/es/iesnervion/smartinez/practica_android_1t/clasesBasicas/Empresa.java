package es.iesnervion.smartinez.practica_android_1t.clasesBasicas;

import java.io.Serializable;

public class Empresa implements Serializable {
    //Atributos
    private String nombre;

    //Constructor
    //Con parámetros
    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    //Por defecto
    public Empresa() {
        this.nombre = " ";
    }

    //Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
