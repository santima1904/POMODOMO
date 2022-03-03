package es.iesnervion.smartinez.pruebaevaluable2t.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import es.iesnervion.smartinez.pruebaevaluable2t.R;
import es.iesnervion.smartinez.pruebaevaluable2t.models.Producto;

public class DetallesActivity extends AppCompatActivity {

    Producto productoSeleccionado;
    TextView nombre;
    TextView precioUni;
    TextView precioK;
    TextView cantidad;
    ImageView imagen;
    

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

        nombre.setText(productoSeleccionado.getNombre());
        precioUni.setText(String.valueOf(productoSeleccionado.getPrecioUnitario()));
        precioK.setText(String.valueOf(productoSeleccionado.getPrecioPorKoL()));
        cantidad.setText(String.valueOf(productoSeleccionado.getCantidad()));
        imagen.setImageResource(productoSeleccionado.getImage());
    }
}