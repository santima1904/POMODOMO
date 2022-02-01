package es.iesnervion.smartinez.ejerciciofragments;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import es.iesnervion.smartinez.ejerciciofragments.modelo.Persona;

public class MainViewModel extends ViewModel {
    List<Persona> listadoPersonas;
    Persona personaSeleccionada;

    public MainViewModel() {
        rellenarListado();
    }

    private void rellenarListado(){
        listadoPersonas = new ArrayList<>();
        listadoPersonas.add(new Persona("CANTACTA A", "APALLADA A", "111111111", "Calla A"));
        listadoPersonas.add(new Persona("CENTECTE E", "EPELLEDE E", "111111111", "Celle E"));
        listadoPersonas.add(new Persona("CINTICTI I", "IPILLIDI I", "111111111", "Cilli I"));
        listadoPersonas.add(new Persona("CONTOCTO O", "OPOLLODO O", "111111111", "Collo O"));
        listadoPersonas.add(new Persona("CUNTUCTU U", "UPULLUDU U", "111111111", "Cullu U"));
    }
}
