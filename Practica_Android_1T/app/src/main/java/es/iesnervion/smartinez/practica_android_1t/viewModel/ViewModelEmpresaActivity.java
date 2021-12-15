package es.iesnervion.smartinez.practica_android_1t.viewModel;

import androidx.lifecycle.MutableLiveData;

import es.iesnervion.smartinez.practica_android_1t.clasesBasicas.EmpresaTecnologica;

//Esta clase no se usa
public class ViewModelEmpresaActivity {
    private MutableLiveData<EmpresaTecnologica> empresaSeleccionada;

    public MutableLiveData<EmpresaTecnologica> getEmpresaSeleccionada() {
        if(empresaSeleccionada == null){
            empresaSeleccionada = new MutableLiveData<>();
        }
        return empresaSeleccionada;
    }

    public void setEmpresaSeleccionada(MutableLiveData<EmpresaTecnologica> empresaSeleccionada) {
        this.empresaSeleccionada = empresaSeleccionada;
    }
}

