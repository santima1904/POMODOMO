package es.iesnervion.smartinez.pruebaevaluable2t.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class ListadoProductosActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, View.OnClickListener{

    SearchView txtbuscar;
    RecyclerView listadoProductos;
    Spinner filtrador;
    Button add, details;
    ImageButton shopping;
    MainViewModel miViewModel;
    ProductoAdapter recycler_adapter;
    SpinnerAdapter spinnerAdapter;

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

        spinnerAdapter = new SpinnerAdapter(this);
        recycler_adapter = new ProductoAdapter(miViewModel.getListadoProductosCompleto());
        recycler_adapter.setOnItemClickListener((position, v) -> {
            miViewModel.setProductoSeleccionado(miViewModel.getListadoProductosCompleto().get(position));
            recycler_adapter.notifyItemChanged(position);
        });

        listadoProductos.setLayoutManager(new LinearLayoutManager(this));
        listadoProductos.setAdapter(recycler_adapter);
        filtrador.setAdapter(spinnerAdapter);
        txtbuscar.setOnQueryTextListener(this);
        details.setOnClickListener(this);
        add.setOnClickListener(this);
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

        switch (v.getId()){
            case R.id.lista_productos_btn_detalles:
                 intent = new Intent(ListadoProductosActivity.this, DetallesActivity.class);
                intent.putExtra("producto", miViewModel.getProductoSeleccionado());
                startActivity(intent);
                break;

            case R.id.lista_productos_btn_anhadir:
                intent = new Intent(ListadoProductosActivity.this, ShoppingCartActivity.class);
                intent.putExtra("carrito", miViewModel.getProductoSeleccionado());
                startActivity(intent);
                break;
        }
    }


}