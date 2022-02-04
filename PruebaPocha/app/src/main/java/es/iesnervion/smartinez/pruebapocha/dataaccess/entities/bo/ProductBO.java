package es.iesnervion.smartinez.pruebapocha.dataaccess.entities.bo;

//Objeto que usaremos en nuestra aplicacion

public class ProductBO {

    private int id;
    private String name;
    private double price;
    private String photo;

    public ProductBO(int id, String name, double price, String photo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.photo = photo;
    }

    public ProductBO() {
        this.id = 0;
        this.name = " ";
        this.price = 0;
        this.photo = " ";
    }
}
