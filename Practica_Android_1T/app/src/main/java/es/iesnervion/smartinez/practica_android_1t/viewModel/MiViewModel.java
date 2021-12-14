package es.iesnervion.smartinez.practica_android_1t.viewModel;

import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;
import es.iesnervion.smartinez.practica_android_1t.R;
import es.iesnervion.smartinez.practica_android_1t.clasesBasicas.Empresa;
import es.iesnervion.smartinez.practica_android_1t.clasesBasicas.EmpresaNoTecnologica;
import es.iesnervion.smartinez.practica_android_1t.clasesBasicas.EmpresaTecnologica;
import es.iesnervion.smartinez.practica_android_1t.clasesBasicas.Persona;

public class MiViewModel extends ViewModel {
    //Propiedad pública
    private List<Empresa> listadoEmpresas;
    private EmpresaTecnologica empresaSeleccionada;

    public MiViewModel() {
        this.listadoEmpresas = rellenarListadoEmpresa();
        //this.empresaSeleccionada = new EmpresaTecnologica();
    }

    public List<Empresa> getListadoEmpresas() {
        return listadoEmpresas;
    }

    public void setListadoEmpresas(List<Empresa> listadoEmpresas) {
        this.listadoEmpresas = listadoEmpresas;
    }

    public EmpresaTecnologica getEmpresaSeleccionada() {
        return empresaSeleccionada;
    }

    public void setEmpresaSeleccionada(EmpresaTecnologica empresaSeleccionada) {
        this.empresaSeleccionada = empresaSeleccionada;
    }

//Métodos
    /**
     * Cabecera: private List(Empresa) rellenarListadoEmpresa()
     * Descripción: Método para crear y rellenar un listado de Empresas
     *
     * @return List(Empresa)
     */
    private List<Empresa> rellenarListadoEmpresa(){
        List<Empresa> listaEmpresas = new ArrayList<>();
        listaEmpresas.add(new EmpresaTecnologica("Everis", R.drawable.everis, "https://es.nttdata.com", "everisbusines@gmail.com",
                "37.391441607244616, -6.010462061741051","C/ Gonzalo Jiménez de Quesada n2º pl. 7ª", "954660631", crearListadoPersonasContacto()));
        listaEmpresas.add(new EmpresaTecnologica("Synergia Soluciones Tecnologicas", R.drawable.synergia, "https://www.synergiasoluciones.es/", "contacto@synergiasoluciones.es",
                "37.308670917533384, -5.9413008883907406","C/ Fortuna, 1, Edificio Nuevo Tixe Oficina 6", " 902930363", crearListadoPersonasContacto()));
        listaEmpresas.add(new EmpresaNoTecnologica("Lidl", "034"));
        listaEmpresas.add(new EmpresaNoTecnologica("ToyRus", "058"));
        listaEmpresas.add(new EmpresaNoTecnologica("Cruzcampo", "018"));
        listaEmpresas.add(new EmpresaNoTecnologica("Game", "065"));
        listaEmpresas.add(new EmpresaTecnologica("Empresa ejemplo pa rellenar", R.drawable.nofoto, "https://www.webejemplonopulsar.es/", "ejemplo@nopulsesesto.es",
                "0,0","C/ No tenemos oficina porque es un ejemplo", " 902930363", crearListadoPersonasContacto()));
        listaEmpresas.add(new EmpresaTecnologica("Empresa ejemplo pa rellenar", R.drawable.nofoto, "https://www.webejemplonopulsar.es/", "ejemplo@nopulsesesto.es",
                "0,0","C/ No tenemos oficina porque es un ejemplo", " 902930363", crearListadoPersonasContacto()));
        listaEmpresas.add(new EmpresaTecnologica("Empresa ejemplo pa rellenar", R.drawable.nofoto, "https://www.webejemplonopulsar.es/", "ejemplo@nopulsesesto.es",
                "0,0","C/ No tenemos oficina porque es un ejemplo", " 902930363", crearListadoPersonasContacto()));

        return listaEmpresas;
    }

    /**
     * Cabecera: private List(Persona) crearListadoPersonasContacto()
     * Descripción: Método para crear y rellenar un listado de Personas
     *
     * @return List(Persona)
     */
    private ArrayList<Persona> crearListadoPersonasContacto(){
        ArrayList<Persona> listadoPersonas = new ArrayList<>();
        listadoPersonas.add(new Persona("Pepe", "Sánchez", "987654321", "Jefazo", "pepitosan27@gmail.com"));
        listadoPersonas.add(new Persona("Eduardo", "Lopez", "987654321", "Becario", "edulopz4@gmail.com"));
        listadoPersonas.add(new Persona("Herminia", "Nuñez", "34567456", "Lleva el cafe", "herminu86@gmail.com"));
        return listadoPersonas;
    }
}
