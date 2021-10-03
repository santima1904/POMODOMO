package es.iesnervionsmartinez.ejercicio531;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button mas;
        Button  menos;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mas = findViewById(R.id.mas);
        menos = findViewById(R.id.menos);

        mas.setOnClickListener(this);
        menos.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TextView text;

        text = findViewById(R.id.text);

        switch (view.getId()){

            case R.id.mas:

                text.setTextSize(text.getTextSize()+2);
                break;

            case R.id.menos:

                text.setTextSize(text.getTextSize()-2);
                break;
        }
    }
}