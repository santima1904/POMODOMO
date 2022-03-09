package com.guillermo.droguedam.Productos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.andremion.counterfab.CounterFab;
import com.guillermo.droguedam.Cesta.CestaCompra;
import com.guillermo.droguedam.DetallesProducto.DetallesProducto;
import com.guillermo.droguedam.Objetos.ClsProducto;
import com.guillermo.droguedam.R;
import com.guillermo.droguedam.Utilidades.Constantes;
import com.guillermo.droguedam.Utilidades.Utilidades;
import java.util.ArrayList;

public class FragmentProductos extends Fragment{

    private ArrayList<ClsProducto> listaItems;
    private CounterFab fabButton;
    private ArrayList<String> listaCategorias;
    private ArrayList<String> listaOrdenar;
    private ArrayList<ClsProducto> listaProductosSeleccionados;
    private RecyclerView recyclerView;
    private int opcionOrdenar;

    public static FragmentProductos newInstance() {
        FragmentProductos fragment = new FragmentProductos();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewDemo);

        //Generamos las listas.
        listaItems = Utilidades.generarListaProductos();
        listaCategorias = Utilidades.generarListaCategorias();
        listaOrdenar = Utilidades.generarListaOrdenar();

        //Inicializar los spinners
        inicializarSpinners(view);

        //Fab button
        fabButton = view.findViewById(R.id.btnCesta);

        fabButton.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(), CestaCompra.class);
            startActivity(intent);
        });

        ProductosAdapter adaptador = new ProductosAdapter(listaItems, getContext());
        //Click listener
        adaptador.setOnItemClickListener((position, v) -> {
            if(v.getId() == R.id.addToCart){
                anadirACesta(position);
            }else{
                //Vamos a la pagina de detalle del producto pasandole el producto seleccionado
                Intent intent = new Intent(getContext(), DetallesProducto.class);
                intent.putExtra(Constantes.PRODUCTOS_SELECCIONADOS, listaItems.get(position));
                startActivity(intent);
            }
        });

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.addItemDecoration(new Space(20, 1));
        recyclerView.setAdapter(adaptador);

        //Obtenemos la lista de productos seleccionados en caso de que previamente se haya hecho.
        obtenerListaProductosAlmacenada();

        return view;
    }

    //Inicializa los spinners junto a los click listeners
    private void inicializarSpinners(View view){
        //Spinners
        Spinner spinCategorias = view.findViewById(R.id.spinnerModalidad);
        Spinner spinOrdenar = view.findViewById(R.id.spinnerOrdenar);

        ArrayAdapter aa = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, listaCategorias);
        aa.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinCategorias.setAdapter(aa);

        ArrayAdapter aa2 = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, listaOrdenar);
        aa.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinOrdenar.setAdapter(aa2);

        spinCategorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                filtrarPor(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });

        spinOrdenar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ordenarPor(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });
    }

    /**
     * Realiza la ordenacion segun la opcion del Spinner
     * @param pos Opcion elegida en el spinner
     */
    private void ordenarPor(int pos){
        opcionOrdenar = pos;

        switch (pos){
            case 0:
                listaItems = Utilidades.generarListaProductos();
                break;
            case 1:
                Utilidades.ordenarPrecioMayorMenor(listaItems);
                break;
            case 2:
                Utilidades.ordenarPrecioMenorMayor(listaItems);
                break;
            case 3:
                Utilidades.ordenarAlfabeticamenteAZ(listaItems);
                break;
            case 4:
                Utilidades.ordenarAlfabeticamenteZA(listaItems);
                break;
        }

        //Tenemos que notificar los cambios al adapter
        recyclerView.setAdapter(new ProductosAdapter(listaItems, getActivity()));
    }

    /**
     * Realiza los filtrados segun la opcion del Spinner
     * @param pos Opcion elegida en el spinner
     */
    private void filtrarPor(int pos){
        listaItems = Utilidades.generarListaProductos();

        switch (pos){
            case 1:
                listaItems = Utilidades.realizarFiltrado(listaItems, "Higiene");
                break;
            case 2:
                listaItems = Utilidades.realizarFiltrado(listaItems, "Limpieza");
                break;
            case 3:
                listaItems = Utilidades.realizarFiltrado(listaItems, "Perfume");
                break;
        }

        //Tenemos que mantener el orden seleccionado y notifica al adapter
        if(opcionOrdenar != 0) ordenarPor(opcionOrdenar);
        else recyclerView.setAdapter(new ProductosAdapter(listaItems, getActivity()));
    }

    /**
     * Obtenemos la lista de productos que tuvieramos almacenados en el dispositivo
     */
    private void obtenerListaProductosAlmacenada(){
        listaProductosSeleccionados = Utilidades.obtenerListaProductosAlmacenada(getActivity());

        //establecemos el numero en la cesta.
        if(listaProductosSeleccionados != null){
            fabButton.setCount(listaProductosSeleccionados.size());
        }else{
            listaProductosSeleccionados = new ArrayList<>();
            fabButton.setCount(0);
        }

    }

    /**
     * Añade a la cesta un producto si no esta previamente en ella.
     * @param pos posicion sobre el elemento de la lista en el que se ha pulsado.
     */
    private void anadirACesta(int pos){
        //Comprobamos si el producto ya se encuentra en la lista.
        if(!Utilidades.comprobarProductoExistente(listaProductosSeleccionados, listaItems.get(pos).getNumReferencia())){
            listaProductosSeleccionados.add(listaItems.get(pos));
            //Aumentamos el contador del fabButton
            fabButton.increase();
            Utilidades.almacenarDatos(getActivity(), listaProductosSeleccionados);
        }else{
            Toast.makeText(getContext(), "Este articulo ya se ha añadido", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onResume(){
        //Cuando volvemos a la actividad retomamos el numero en la cesta
        fabButton.setCount(Utilidades.obtenerListaProductosAlmacenada(getActivity()).size());
        super.onResume();
    }

}
