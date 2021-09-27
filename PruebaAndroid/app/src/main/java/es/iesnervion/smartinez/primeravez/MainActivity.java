package es.iesnervion.smartinez.primeravez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button boton;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = findViewById(R.id.btn1);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView text;
                text = findViewById(R.id.textView);
                text.setText("Amen");

                }
        });
    }


    /* Forma antigua de configurar un boton
    public void changeText (View v){
        TextView text;
        text = findViewById(R.id.textView);
        switch(v.getId()){
            case R.id.btn1:
                text.setText("Amen");
                break;
        }
    }
     */

    /*
    La forma más habitual de hacer un boton es
    boton.setOnClickListener(this)
    Refiriendose al activity main.
    Para esto, hace falta que implemente el OnclickListener
     */

}