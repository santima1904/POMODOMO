package es.iesnervion.smartinez.practica_android_1t.clasesBasicas;

import java.util.List;

import es.iesnervion.smartinez.practica_android_1t.R;

public class EmpresaTecnologica extends Empresa {

    //Atributos
    private int logo;
    private String web;
    private String mailContacto;
    private String localizacion;
    private String direccion;
    private String telefonoContacto;
    private List<Persona> personasContacto;

    //Constructor
    //Con parámetros
    public EmpresaTecnologica(String nombre, int logo, String web, String mailContacto, String localizacion, String direccion, String telefonoContacto, List<Persona> personasContacto) {
        super(nombre);
        this.logo = logo;
        this.web = web;
        this.mailContacto = mailContacto;
        this.localizacion = localizacion;
        this.direccion = direccion;
        this.telefonoContacto = telefonoContacto;
        this.personasContacto = personasContacto;
    }

    //Por defecto
    public EmpresaTecnologica() {
        super(" ");
        this.logo = R.drawable.nofoto;
        this.web = " ";
        this.mailContacto = " ";
        this.localizacion = " ";
        this.direccion = " ";
        this.telefonoContacto = " ";
        this.personasContacto = null;
    }

    //Getters and setters
    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getMailContacto() {
        return mailContacto;
    }

    public void setMailContacto(String mailContacto) {
        this.mailContacto = mailContacto;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public List<Persona> getPersonasContacto() {
        return personasContacto;
    }

    public void setPersonasContacto(List<Persona> personasContacto) {
        this.personasContacto = personasContacto;
    }
}
