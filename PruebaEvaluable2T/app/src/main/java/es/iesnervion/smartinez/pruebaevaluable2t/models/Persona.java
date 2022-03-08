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
        this.nombre = "Santiago";
        this.apellidos = "Martínez";
        this.email = "santima1904@gmail.com";
        this.usuario = "usuario";
        this.contrasenha = "123";
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }
}
