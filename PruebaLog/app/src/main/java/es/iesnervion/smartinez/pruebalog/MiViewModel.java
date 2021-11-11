package es.iesnervion.smartinez.pruebalog;

import androidx.lifecycle.ViewModel;

public class MiViewModel extends ViewModel {

    private int contador = 0;

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

}
