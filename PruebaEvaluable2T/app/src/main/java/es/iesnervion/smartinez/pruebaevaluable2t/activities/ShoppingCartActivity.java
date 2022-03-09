package es.iesnervion.smartinez.pruebaevaluable2t.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import es.iesnervion.smartinez.pruebaevaluable2t.R;
import es.iesnervion.smartinez.pruebaevaluable2t.adapters.ProductoAdapter;
import es.iesnervion.smartinez.pruebaevaluable2t.models.Carrito;
import es.iesnervion.smartinez.pruebaevaluable2t.models.Producto;
import es.iesnervion.smartinez.pruebaevaluable2t.viewModels.MainViewModel;

public class ShoppingCartActivity extends AppCompatActivity implements View.OnClickListener {

    Carrito carrito;
    RecyclerView listadoProductos;
    TextView total;
    ProductoAdapter recycler_adapter;
    Button aceptar;
    MainViewModel miViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        Bundle bundle = getIntent().getExtras();
        carrito = (Carrito) bundle.get("carrito");
        miViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        listadoProductos = findViewById(R.id.lista_carrito);
        total = findViewById(R.id.total);
        aceptar = findViewById(R.id.aceptar);

        recycler_adapter = new ProductoAdapter(carrito.getListadoProductos());
        listadoProductos.setLayoutManager(new LinearLayoutManager(this));
        listadoProductos.setAdapter(recycler_adapter);
        aceptar.setOnClickListener(this);
        total.setText(String.valueOf(carrito.getTotal()));
    }

    @Override
    public void onClick(View view) {

        String[] addresses = new String[1];
        addresses[0] = miViewModel.getUsuario().getEmail();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Compra realizada");
        intent.putExtra(Intent.EXTRA_TEXT, "La cesta estará preparada en 2 horas. Precio de la compra: "+carrito.getTotal() + "€");
        startActivity(intent);
    }
}