package es.iesnervion.smartinez.ejercicio431;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

<<<<<<< HEAD
    List<Integer> lista = new ArrayList<>();
    int contador = 0;

=======
>>>>>>> master
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button anterior;
        Button siguiente;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anterior = findViewById(R.id.anterior);
        siguiente = findViewById(R.id.siguiente);

        anterior.setOnClickListener(this);
        siguiente.setOnClickListener(this);
<<<<<<< HEAD


        lista.add(R.drawable.diosito);
        lista.add(R.drawable.fifa);
        lista.add(R.drawable.saboresdelatierra);
        lista.add(R.drawable.daniel);

=======
>>>>>>> master
    }

    @Override
    public void onClick(View view) {

        ImageView imagen;

        imagen = findViewById(R.id.imagen);

<<<<<<< HEAD
        switch (view.getId()){
            case R.id.anterior:

                if (contador == 0){

                    contador = 3;
                }
                else {

                    contador--;
                }
                imagen.setTag(lista.get(contador));

                break;

            case R.id.siguiente:
                if (contador == 3){

                    contador = 4;
                }
                else {

                    contador++;
                }
                imagen.setTag(lista.get(contador));
                break;
        }



    }

=======
        List<Integer> lista = new ArrayList<>();

        lista.add(R.drawable.diosito);
        lista.add(R.drawable.fifa);
        lista.add(R.drawable.saboresdelatierra);
        lista.add(R.drawable.daniel);

    }
>>>>>>> master
}