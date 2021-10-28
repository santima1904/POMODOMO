package iesnervion.smartinez.pruebaspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> verduras = new ArrayList<>();
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verduras.add("Berenjena");
        verduras.add("Cebolla");
        verduras.add("Patata");
        verduras.add("Puerro");

        spinner = findViewById(R.id.spinner);

        spinner.setAdapter(new ArrayAdapter<String>());

        
}