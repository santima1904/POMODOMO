package es.iesnervion.smartinez.ejercicio231;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button rojo;
        Button azul;
        Button verde;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rojo = findViewById(R.id.rojo);
        azul = findViewById(R.id.azul);
        verde = findViewById(R.id.verde);

        rojo.setOnClickListener(this);
        azul.setOnClickListener(this);
        verde.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        TextView text;

        text = findViewById(R.id.text);

        switch (view.getId()){

            case R.id.rojo:
                text.setTextColor(Color.RED);
                break;

            case R.id.azul:
                text.setTextColor(Color.BLUE);
                break;

            case R.id.verde:
                text.setTextColor(Color.GREEN);
                break;

        }


    }
}