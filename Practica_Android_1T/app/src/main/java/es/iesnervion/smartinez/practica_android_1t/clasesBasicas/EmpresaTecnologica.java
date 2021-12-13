package es.iesnervion.smartinez.practica_android_1t.clasesBasicas;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import es.iesnervion.smartinez.practica_android_1t.R;

public class EmpresaTecnologica extends Empresa implements Parcelable {

    //Atributos
    private int logo;
    private String web;
    private String mailContacto;
    private String localizacion;
    private String direccion;
    private String telefonoContacto;
    private ArrayList<Persona> personasContacto;

    //Constructor
    //Con parámetros
    public EmpresaTecnologica(String nombre, int logo, String web, String mailContacto, String localizacion, String direccion, String telefonoContacto, ArrayList<Persona> personasContacto) {
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

    protected EmpresaTecnologica(Parcel in) {
        setNombre(in.readString());
        logo = in.readInt();
        web = in.readString();
        mailContacto = in.readString();
        localizacion = in.readString();
        direccion = in.readString();
        telefonoContacto = in.readString();
        personasContacto = in.readArrayList(getClass().getClassLoader());
    }

    public static final Creator<EmpresaTecnologica> CREATOR = new Creator<EmpresaTecnologica>() {
        @Override
        public EmpresaTecnologica createFromParcel(Parcel in) {
            return new EmpresaTecnologica(in);
        }

        @Override
        public EmpresaTecnologica[] newArray(int size) {
            return new EmpresaTecnologica[size];
        }
    };

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

    public ArrayList<Persona> getPersonasContacto() {
        return personasContacto;
    }

    public void setPersonasContacto(ArrayList<Persona> personasContacto) {
        this.personasContacto = personasContacto;
    }

    @Override
    public String toString() {
        return "EmpresaTecnologica{" +
                "logo=" + logo +
                ", web='" + web + '\'' +
                ", mailContacto='" + mailContacto + '\'' +
                ", localizacion='" + localizacion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefonoContacto='" + telefonoContacto + '\'' +
                ", personasContacto=" + personasContacto +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getNombre());
        dest.writeInt(logo);
        dest.writeString(web);
        dest.writeString(mailContacto);
        dest.writeString(localizacion);
        dest.writeString(direccion);
        dest.writeString(telefonoContacto);
        dest.writeList(personasContacto);
    }
}
