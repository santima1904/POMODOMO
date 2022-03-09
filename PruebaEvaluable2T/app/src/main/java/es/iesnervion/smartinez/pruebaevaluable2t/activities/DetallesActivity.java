package es.iesnervion.smartinez.pruebaevaluable2t.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import es.iesnervion.smartinez.pruebaevaluable2t.R;
import es.iesnervion.smartinez.pruebaevaluable2t.models.Producto;

public class DetallesActivity extends AppCompatActivity implements View.OnClickListener{

    Producto productoSeleccionado;
    TextView nombre;
    TextView precioUni;
    TextView precioK;
    TextView cantidad;
    ImageView imagen;
    ImageButton shopping;
    Button add;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        Bundle bundle = getIntent().getExtras();
        productoSeleccionado = (Producto) bundle.get("producto");
        nombre = findViewById(R.id.detalles_txt_nombre);
        precioUni = findViewById(R.id.detalles_txt_precio_uni);
        precioK = findViewById(R.id.detalles_txt_precio_litro);
        cantidad = findViewById(R.id.detalles_txt_cantidad);
        imagen = findViewById(R.id.detalles_imagen);
        shopping = findViewById(R.id.detalles_shopping_cart);
        add = findViewById(R.id.detalles_btn_anhadir);

        shopping.setOnClickListener(this);
        add.setOnClickListener(this);

        nombre.setText(productoSeleccionado.getNombre());
        precioUni.setText(String.valueOf(productoSeleccionado.getPrecioUnitario()));
        precioK.setText(String.valueOf(productoSeleccionado.getPrecioPorKoL()));
        cantidad.setText(String.valueOf(productoSeleccionado.getCantidad()));
        imagen.setImageResource(productoSeleccionado.getImage());
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.detalles_btn_anhadir:
//                miViewModel.agregarCarrito(miViewModel.getProductoSeleccionado());
//                break;
//
//            case R.id.detalles_shopping_cart:
//                intent = new Intent(DetallesActivity.this, ShoppingCartActivity.class);
//                intent.putExtra("carrito", miViewModel.getCarrito());
//                startActivity(intent);
//                break;
//        }
    }
}