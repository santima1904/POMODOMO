package es.iesnervion.smartinez.practica_android_1t.clasesBasicas;

import android.os.Parcel;
import android.os.Parcelable;

public class Persona implements Parcelable {
    //Atributos
    private String nombre;
    private String apellidos;
    private String telefono;
    private String cargo;
    private String mail;

    //Constructor
    //Con parámetros
    public Persona(String nombre, String apellidos, String telefono, String cargo, String mail) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.cargo = cargo;
        this.mail = mail;
    }

    //Por defecto
    public Persona() {
        this.nombre = " ";
        this.apellidos = " ";
        this.telefono = " ";
        this.cargo = " ";
        this.mail = " ";
    }

    protected Persona(Parcel in) {
        nombre = in.readString();
        apellidos = in.readString();
        telefono = in.readString();
        cargo = in.readString();
        mail = in.readString();
    }

    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

    //Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(apellidos);
        dest.writeString(telefono);
        dest.writeString(cargo);
        dest.writeString(mail);
    }
}
