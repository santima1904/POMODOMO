package es.iesnervion.smartinez.pruebaevaluable2t.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Spinner;
import es.iesnervion.smartinez.pruebaevaluable2t.R;
import es.iesnervion.smartinez.pruebaevaluable2t.adapters.ProductoAdapter;
import es.iesnervion.smartinez.pruebaevaluable2t.adapters.SpinnerAdapter;
import es.iesnervion.smartinez.pruebaevaluable2t.viewModels.MainViewModel;

public class ListadoProductosActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, View.OnClickListener, AdapterView.OnItemSelectedListener {

    //Constantes
    public final String FILTRADO_NOMBRE_ASC = "Nombre asc";
    public final String FILTRADO_NOMBRE_DESC = "Nombre desc";
    public final String FILTRADO_PRECIO_ASC = "Precio asc";
    public final String FILTRADO_PRECIO_DESC = "Precio desc";
    public final String CATEGORIA_HIGIENE = "Higiene personal";
    public final String CATEGORIA_LIMPIEZA = "Limpieza";
    public final String CATEGORIA_PERFUMERIA = "Perfumeria";

    SearchView txtbuscar;
    RecyclerView listadoProductos;
    Spinner filtrador, filtradoCategoria;
    Button add, details;
    ImageButton shopping;
    MainViewModel miViewModel;
    ProductoAdapter recycler_adapter;
    SpinnerAdapter spinnerAdapterCategoria, spinnerAdapter;
    String[] parametrosFiltrado = {FILTRADO_NOMBRE_ASC, FILTRADO_NOMBRE_DESC, FILTRADO_PRECIO_ASC, FILTRADO_PRECIO_DESC};
    String[] parametrosFiltradoCategorias = {CATEGORIA_HIGIENE, CATEGORIA_LIMPIEZA, CATEGORIA_PERFUMERIA};
    private int opcionOrdenar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_productos);
        miViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        listadoProductos = findViewById(R.id.listado_productos_recyclerview);
        filtrador = findViewById(R.id.listado_productos_spinner);
        add = findViewById(R.id.lista_productos_btn_anhadir);
        details = findViewById(R.id.lista_productos_btn_detalles);
        shopping = findViewById(R.id.listado_productos_shopping_cart);
        txtbuscar = findViewById(R.id.listado_productos_search);
        filtradoCategoria = findViewById(R.id.listado_productos_spinner_categoria);

        spinnerAdapterCategoria = new SpinnerAdapter(this, parametrosFiltrado);
        spinnerAdapter = new SpinnerAdapter(this, parametrosFiltradoCategorias);
        recycler_adapter = new ProductoAdapter(miViewModel.getListadoProductosCompleto());
        recycler_adapter.setOnItemClickListener((position, v) -> {
            miViewModel.setProductoSeleccionado(miViewModel.getListadoProductosCompleto().get(position));
            recycler_adapter.notifyItemChanged(position);
        });

        listadoProductos.setLayoutManager(new LinearLayoutManager(this));
        listadoProductos.setAdapter(recycler_adapter);
        filtrador.setAdapter(spinnerAdapter);
        filtradoCategoria.setAdapter(spinnerAdapterCategoria);
        txtbuscar.setOnQueryTextListener(this);
        shopping.setOnClickListener(this);
        details.setOnClickListener(this);
        add.setOnClickListener(this);
//        filtradoCategoria.setOnItemSelectedListener(this);
//        filtrador.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        recycler_adapter.filtrarProductos(newText);
        listadoProductos.setAdapter(recycler_adapter);
        return false;
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.lista_productos_btn_detalles:
                intent = new Intent(ListadoProductosActivity.this, DetallesActivity.class);
                intent.putExtra("producto", miViewModel.getProductoSeleccionado());
                startActivity(intent);
                break;

            case R.id.lista_productos_btn_anhadir:
                miViewModel.agregarCarrito(miViewModel.getProductoSeleccionado());
                break;

            case R.id.listado_productos_shopping_cart:
                intent = new Intent(ListadoProductosActivity.this, ShoppingCartActivity.class);
                intent.putExtra("carrito", miViewModel.getCarrito());
                startActivity(intent);
                break;
        }
    }

    private void ordenarPor(int pos) {
        opcionOrdenar = pos;

        switch (pos) {
            case 0:
                recycler_adapter.ordenarAlfabeticamenteZA();
                break;
            case 1:
                recycler_adapter.ordenarAlfabeticamenteAZ();
                break;
            case 2:
                recycler_adapter.ordenarPrecioMenorMayor();
                break;
            case 3:
                recycler_adapter.ordenarPrecioMayorMenor();
                break;
        }
        listadoProductos.setAdapter(recycler_adapter);
    }

    /**
     * Realiza los filtrados segun la opcion del Spinner
     * @param pos Opcion elegida en el spinner
     */
    private void filtrarPor(int pos){
        String categoria = " ";

        switch (pos){
            case 1:
                categoria = CATEGORIA_HIGIENE;
                break;
            case 2:
                categoria = CATEGORIA_LIMPIEZA;
                break;
            case 3:
                categoria = CATEGORIA_PERFUMERIA;
                break;
        }

        recycler_adapter.realizarFiltrado(categoria);
        listadoProductos.setAdapter(recycler_adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (view.getId() == R.id.listado_productos_spinner){
            ordenarPor(i);
        }
        else{
            filtrarPor(i);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}