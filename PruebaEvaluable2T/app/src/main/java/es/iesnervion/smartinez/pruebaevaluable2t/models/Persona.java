package es.iesnervion.smartinez.pruebaevaluable2t.models;

public class Persona {

    //Atributos
    private String nombre;
    private String apellidos;
    private String email;
    private String usuario;
    private String contrasenha;

    //Constructor
    //Por defecto
    public Persona() {
        this.nombre = " ";
        this.apellidos = " ";
        this.email = " ";
        this.usuario = " ";
        this.contrasenha = " ";
    }

    //Por parametros
    public Persona(String nombre, String apellidos, String email, String usuario, String contrasenha) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.usuario = usuario;
        this.contrasenha = contrasenha;
    }

    //Getters and setters
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }
}
