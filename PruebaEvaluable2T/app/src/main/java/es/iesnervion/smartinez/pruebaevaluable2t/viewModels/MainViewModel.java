package es.iesnervion.smartinez.pruebaevaluable2t.viewModels;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import es.iesnervion.smartinez.pruebaevaluable2t.R;
import es.iesnervion.smartinez.pruebaevaluable2t.models.Persona;
import es.iesnervion.smartinez.pruebaevaluable2t.models.Producto;

public class MainViewModel extends ViewModel {

    Persona usuario;
    List<Producto> listadoProductosCompleto;

    public MainViewModel() {
        this.usuario = new Persona("Rafael", "Leao", "santima1904@gmail.com", "usuario", "contraseña");
        generarListado();
    }

    private void generarListado(){
        listadoProductosCompleto.add(new Producto(R.drawable.kh7, "Quitagrasas KH7", 2.57, 5, 8, "limpieza"));
        listadoProductosCompleto.add(new Producto(R.drawable.axe, "Pato discos activos", 3.15, 7, 10, "limpieza"));
        listadoProductosCompleto.add(new Producto(R.drawable.pastadientes, "Pasta de dientes vitis", 1.5, 3, 20, "higiene personal"));
        listadoProductosCompleto.add(new Producto(R.drawable.cars, "Shampoo de Rayo McQueen", 10, 38, 1, "higiene personal"));
        listadoProductosCompleto.add(new Producto(R.drawable.axe, "Desodorante axe", 4.7, 9.75, 5, "perfumeria"));
        listadoProductosCompleto.add(new Producto(R.drawable.spiderman, "Colonia de Spider-Man", 9.99, 36, 2, "perfumeria"));
    }
}
