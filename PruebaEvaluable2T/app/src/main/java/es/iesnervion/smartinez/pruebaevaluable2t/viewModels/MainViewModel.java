package es.iesnervion.smartinez.pruebaevaluable2t.viewModels;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import es.iesnervion.smartinez.pruebaevaluable2t.R;
import es.iesnervion.smartinez.pruebaevaluable2t.models.Carrito;
import es.iesnervion.smartinez.pruebaevaluable2t.models.Persona;
import es.iesnervion.smartinez.pruebaevaluable2t.models.Producto;

public class MainViewModel extends ViewModel {

    Persona usuario;
    Producto productoSeleccionado;
    List<Producto> listadoProductosCompleto;
    Carrito carrito;


    public MainViewModel() {
        this.usuario = new Persona("A", "a", "santima1904@gmail.com", "usuario", "contraseña");
        productoSeleccionado = new Producto();
        generarListado();
        carrito = new Carrito();
    }

    public void agregarCarrito(Producto producto){
        if (!carrito.getListadoProductos().contains(producto)){
            carrito.agregarCarrito(producto);
        }
    }

    public Persona getUsuario() {
        return usuario;
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

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    private void generarListado(){
        listadoProductosCompleto = new ArrayList<>();
        listadoProductosCompleto.add(new Producto(R.drawable.kh7, "Quitagrasas KH7", 2.5, 5, 8, "limpieza"));
        listadoProductosCompleto.add(new Producto(R.drawable.pato, "Pato discos activos", 3, 7, 10, "limpieza"));
        listadoProductosCompleto.add(new Producto(R.drawable.pastadientes, "Pasta de dientes vitis", 1.5, 3, 20, "higiene personal"));
        listadoProductosCompleto.add(new Producto(R.drawable.cars, "Shampoo de Rayo McQueen", 10, 38, 1, "higiene personal"));
        listadoProductosCompleto.add(new Producto(R.drawable.axe, "Desodorante axe", 4, 9.7, 5, "perfumeria"));
        listadoProductosCompleto.add(new Producto(R.drawable.spiderman, "Colonia de Spider-Man", 9, 36, 2, "perfumeria"));
    }
}
