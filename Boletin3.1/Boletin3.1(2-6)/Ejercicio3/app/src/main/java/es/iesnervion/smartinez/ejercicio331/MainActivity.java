package es.iesnervion.smartinez.ejercicio331;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        TextView text;

        text = findViewById(R.id.text);

        switch (view.getId()){

            case R.id.derecha:

                text.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                break;

            case R.id.izquierda:

                text.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                break;
        }
    }
}