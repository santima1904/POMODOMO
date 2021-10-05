package es.iesnervion.smartinez.ejercicio232;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        RadioGroup group;
        EditText number1;
        EditText number2;
        TextView result;
        float num1, num2;

        group = findViewById(R.id.gruop);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        result = findViewById(R.id.result);

        num1 = Float.parseFloat(number1.getText().toString());
        num2 = Float.parseFloat(number2.getText().toString());

        switch (group.getCheckedRadioButtonId()) {

            case R.id.sum:

                result.setText(""+(num1 + num2));
                break;

            case R.id.minus:

                result.setText(""+(num1 - num2));
                break;

            case R.id.multiply:

                result.setText(""+(num1 * num2));
                break;

            case R.id.divide:

                result.setText(""+(num1 / num2));
                break;

        }
    }
}