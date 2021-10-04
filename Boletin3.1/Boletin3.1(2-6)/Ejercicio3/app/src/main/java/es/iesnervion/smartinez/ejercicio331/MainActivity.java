package es.iesnervion.smartinez.ejercicio331;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button botonDerecha;
        Button  botonIzquierda;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonDerecha = findViewById(R.id.derecha);
        botonIzquierda = findViewById(R.id.izquierda);

        botonDerecha.setOnClickListener(this);
        botonIzquierda.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        EditText text;

        text = findViewById(R.id.text);

        switch (view.getId()){

            case R.id.derecha:

                text.setGravity(Gravity.END);
                break;

            case R.id.izquierda:

                text.setGravity(Gravity.START);
                break;
        }
    }
}