package es.iesnervion.smartinez.ejercicio132;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button boton;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = findViewById(R.id.boton);

        boton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        TextView text = findViewById(R.id.text);

        CheckBox bold;
        CheckBox gigant;
        CheckBox tiny;
        CheckBox red;
        Switch invisible;

        bold = findViewById(R.id.bold);
        gigant = findViewById(R.id.gigant);
        tiny = findViewById(R.id.tiny);
        red = findViewById(R.id.red);
        invisible = findViewById(R.id.invisible);

       if (bold.isChecked()){

           text.setTypeface(Typeface.DEFAULT_BOLD);
       }else{

           text.setTypeface(Typeface.DEFAULT);
       }

       if (gigant.isChecked()){

           text.setTextSize(TypedValue.COMPLEX_UNIT_PX, 300);
       }else{

           text.setTextSize(TypedValue.COMPLEX_UNIT_PX, 45);
       }

        if (tiny.isChecked()){

            text.setTextSize(TypedValue.COMPLEX_UNIT_PX, 20);
        }else{

            text.setTextSize(TypedValue.COMPLEX_UNIT_PX, 45);
        }

        if (red.isChecked()){

            text.setTextColor(Color.RED);
        }else{

            text.setTextColor(Color.CYAN);
        }
        if (invisible.isChecked()){

            text.setVisibility(View.INVISIBLE);
        }else{

            text.setVisibility(View.VISIBLE);
        }

    }

}