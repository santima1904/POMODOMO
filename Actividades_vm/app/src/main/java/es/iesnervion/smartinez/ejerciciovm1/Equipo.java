package es.iesnervion.smartinez.ejerciciovm1;

public class Equipo {

    private String nombre;
    private int foto;

    public Equipo(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
    }

    public Equipo() {
        this.nombre = " ";
        this.foto = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
