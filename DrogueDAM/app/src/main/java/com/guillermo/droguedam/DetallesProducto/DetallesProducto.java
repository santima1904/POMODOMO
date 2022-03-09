package com.guillermo.droguedam.DetallesProducto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.andremion.counterfab.CounterFab;
import com.guillermo.droguedam.Cesta.CestaCompra;
import com.guillermo.droguedam.Objetos.ClsProducto;
import com.guillermo.droguedam.R;
import com.guillermo.droguedam.Utilidades.Utilidades;
import java.util.ArrayList;

public class DetallesProducto extends AppCompatActivity {

    private DetallesVM vm;
    private ImageView img;
    private TextView nombre, precio, numRef, descripcion;
    private CounterFab fabButton;
    private ArrayList<ClsProducto> listaProductoSeleccionados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_producto);

        //Localizamos las vistas
        img = findViewById(R.id.imagenDetalle);
        nombre = findViewById(R.id.nombreDetalle);
        precio = findViewById(R.id.precioDetalle);
        numRef = findViewById(R.id.numReferenciaDetalle);
        descripcion = findViewById(R.id.descripcionDetalle);
        fabButton = findViewById(R.id.cartDetalles);

        //Obtenemos la lista
        obtenerProductosSeleccionados();

        //Obtenemos el objeto seleccionado y lo guardamos en el ViewModel
        vm = new ViewModelProvider(this).get(DetallesVM.class);
        vm.setProductoSelecciondo((ClsProducto) getIntent().getSerializableExtra("productoSeleccionado"));

        //Rellenamos las vistas con los datos
        rellenarVistas();
    }

    /**
     * Incrementa la cesta solo si el producto no ha sido previamente añadido.
     * @param v Vista pulsada.
     */
    public void incrementarCesta(View v){
        //Comprobamos si el producto ya se encuentra en la lista.
        if(!Utilidades.comprobarProductoExistente(listaProductoSeleccionados, vm.getProductoSelecciondo().getNumReferencia())){
            //Almacenamos los datos.
            listaProductoSeleccionados.add(vm.getProductoSelecciondo());
            Utilidades.almacenarDatos(this, listaProductoSeleccionados);
            fabButton.increase();
        }else{
            Toast.makeText(this, "Ya existe en la cesta", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Navega a la pagina de cesta y cierra esta.
     * @param view Boton sobre el que se ha pulsado, en este caso el fabButton
     */
    public void iraCesta(View view){
        Intent intent = new Intent(this, CestaCompra.class);
        startActivity(intent);
        finish();
    }

    /**
     * Rellena las vistas con los datos almacenados en el ViewModel
     */
    private void rellenarVistas(){
        img.setImageResource(vm.getProductoSelecciondo().getImagen());
        nombre.setText(vm.getProductoSelecciondo().getNombre());
        precio.setText(vm.getProductoSelecciondo().getPrecio() + "");
        numRef.setText(vm.getProductoSelecciondo().getNumReferencia() + "");
        descripcion.setText(vm.getProductoSelecciondo().getDescripcion());
    }

    /**
     * Obtiene los productos seleccionados, es decir, los que estan en la cesta.
     */
    private void obtenerProductosSeleccionados(){
        listaProductoSeleccionados = Utilidades.obtenerListaProductosAlmacenada(this);
        fabButton.setCount(listaProductoSeleccionados.size());
    }
}