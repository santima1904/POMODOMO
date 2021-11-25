package es.iesnervion.smartinez.ejerciciovm1;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MiViewModel extends ViewModel {

    public List<Equipo> listaEquipo = rellenarLista();

    private List<Equipo> rellenarLista(){
        List<Equipo> listado = new ArrayList<>();

        listado.add(new Equipo("Pelicans", R.drawable.pelicans));
        listado.add(new Equipo("Lakers", R.drawable.lakers));
        listado.add(new Equipo("Cavaliers", R.drawable.cavaliers));
        listado.add(new Equipo("Jazz", R.drawable.jazz));
        listado.add(new Equipo("Nuggets", R.drawable.nuggets));
        listado.add(new Equipo("Rockets", R.drawable.rockets));
        listado.add(new Equipo("TimberWolves", R.drawable.timberwolves));
        listado.add(new Equipo("Milwaukee", R.drawable.milwaukee));

        return listado;
    }
}
