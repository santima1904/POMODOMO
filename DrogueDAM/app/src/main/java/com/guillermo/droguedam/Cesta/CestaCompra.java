package com.guillermo.droguedam.Cesta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.guillermo.droguedam.Objetos.ClsProducto;
import com.guillermo.droguedam.Productos.Space;
import com.guillermo.droguedam.R;
import com.guillermo.droguedam.Utilidades.Utilidades;
import java.util.ArrayList;

public class CestaCompra extends AppCompatActivity {

    private LottieAnimationView animacion;
    private ArrayList<ClsProducto> listaCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cesta_compra);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewDemo);

        obtenerListaCompra();
        establecerContenidoUI();
        CestaAdapter adaptador = new CestaAdapter(listaCompra, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new Space(20, 1));
        recyclerView.setAdapter(adaptador);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        TextView cesta = findViewById(R.id.precioTotalCesta);
        cesta.setText(calcularMulta());
    }

    //Vaciamos la cesta y finalizamos la activity
    public void vaciarCesta(View view){
        Toast.makeText(this, "Pedido realizado", Toast.LENGTH_SHORT).show();
        Utilidades.almacenarDatos(this, new ArrayList<>());
        finish();
    }

    /**
     * Obtenemos los objetos que hemos añadido a la cesta.
     */
    private void obtenerListaCompra(){
        listaCompra = Utilidades.obtenerListaProductosAlmacenada(this);
    }

    /**
     * Calcula el precio total a pagar
     * @return Precio total.
     */
    private String calcularMulta(){
        double total = 0;
        for(int i =0; i < listaCompra.size();i++){
            total += listaCompra.get(i).getPrecio();
        }

        return total + "€";
    }

    private void establecerContenidoUI(){
        if(listaCompra.size() == 0){
            animacion = findViewById(R.id.animacionInvite);
            animacion.setAnimation(R.raw.vacio);
            animacion.playAnimation();
        }
    }

}