package iesnervion.smartinez.pracitcaviewholderlayoutsdiferentes;

public class Oso {

    private String nombre;
    private int image;
    private String pais;

    public Oso(String nombre, int image, String pais) {
        this.nombre = nombre;
        this.image = image;
        this.pais = pais;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
