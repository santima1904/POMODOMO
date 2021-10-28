package iesnervion.smartinez.pracitcaviewholderlayoutsdiferentes;

public class Utensilio {

    private String nombre;
    private int imagen;

    public Utensilio(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return nombre;
    }
}


