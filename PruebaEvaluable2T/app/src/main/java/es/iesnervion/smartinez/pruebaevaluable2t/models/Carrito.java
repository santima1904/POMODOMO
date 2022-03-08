package es.iesnervion.smartinez.pruebaevaluable2t.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Carrito implements Parcelable {
    List<Producto> listadoProductos;
    double total;

    public Carrito(List<Producto> listadoProductos) {
        this.listadoProductos = listadoProductos;
        this.total = 0;
    }

    public Carrito() {
        this.listadoProductos = new ArrayList<>();
        this.total = 0;
    }

    protected Carrito(Parcel in) {
        listadoProductos = in.readArrayList(getClass().getClassLoader());
        total = in.readDouble();
    }

    public static final Creator<Carrito> CREATOR = new Creator<Carrito>() {
        @Override
        public Carrito createFromParcel(Parcel in) {
            return new Carrito(in);
        }

        @Override
        public Carrito[] newArray(int size) {
            return new Carrito[size];
        }
    };

    public List<Producto> getListadoProductos() {
        return listadoProductos;
    }

    public void agregarCarrito(Producto p){
        listadoProductos.add(p);
        total += p.getPrecioUnitario();
    }

    public double getTotal() {
        return total;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(listadoProductos);
        parcel.writeDouble(total);
    }
}
