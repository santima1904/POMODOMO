package es.iesnervion.smartinez.ejercicio131;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button boton;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = findViewById(R.id.btn1);

        boton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        TextView text, text2, resultado;

        text = findViewById(R.id.sumando1);
        text2 = findViewById(R.id.sumando2);
        resultado = findViewById(R.id.resultado);

        resultado.setText("La suma es "+(Integer.valueOf(text.getText().toString())+Integer.valueOf(text2.getText().toString())));

    }
}