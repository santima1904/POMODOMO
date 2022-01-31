package es.iesnervion.smartinez.ejerciciofragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View contenedorGeneral = findViewById(R.id.fragmentInicial);

        if (contenedorGeneral!=null){
            ListFragment frag = new ListFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentInicial,frag)
                    .addToBackStack(null)
                    .commit();
        }
    }
}