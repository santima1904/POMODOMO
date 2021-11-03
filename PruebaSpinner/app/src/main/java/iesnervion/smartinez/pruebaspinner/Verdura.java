package iesnervion.smartinez.pruebaspinner;

public class Verdura {
    String nombre;
    int image;

    public Verdura(String nombre, int image) {
        this.nombre = nombre;
        this.image = image;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", image=" + image +
                '}';
    }
}
