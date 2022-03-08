package es.iesnervion.smartinez.pruebaevaluable2t.viewModels;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import es.iesnervion.smartinez.pruebaevaluable2t.R;
import es.iesnervion.smartinez.pruebaevaluable2t.models.Persona;
import es.iesnervion.smartinez.pruebaevaluable2t.models.Producto;

public class MainViewModel extends ViewModel {

    Persona usuario;
    Producto productoSeleccionado;
    List<Producto> listadoProductosCompleto;
    double total;
    List<Producto> carrito;

    public MainViewModel() {
        this.usuario = new Persona("A", "a", "santima1904@gmail.com", "usuario", "contraseña");
        productoSeleccionado = new Producto();
        generarListado();
        total = 0;
        carrito = new ArrayList<>();
    }

    public List<Producto> getListadoProductosCompleto() {
        return listadoProductosCompleto;
    }

    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(Producto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Producto> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<Producto> carrito) {
        this.carrito = carrito;
    }

    private void generarListado(){
        listadoProductosCompleto = new ArrayList<>();
        listadoProductosCompleto.add(new Producto(R.drawable.kh7, "Quitagrasas KH7", 2.57, 5, 8, "limpieza"));
        listadoProductosCompleto.add(new Producto(R.drawable.pato, "Pato discos activos", 3.15, 7, 10, "limpieza"));
        listadoProductosCompleto.add(new Producto(R.drawable.pastadientes, "Pasta de dientes vitis", 1.5, 3, 20, "higiene personal"));
        listadoProductosCompleto.add(new Producto(R.drawable.cars, "Shampoo de Rayo McQueen", 10, 38, 1, "higiene personal"));
        listadoProductosCompleto.add(new Producto(R.drawable.axe, "Desodorante axe", 4.7, 9.75, 5, "perfumeria"));
        listadoProductosCompleto.add(new Producto(R.drawable.spiderman, "Colonia de Spider-Man", 9.99, 36, 2, "perfumeria"));
    }
}
