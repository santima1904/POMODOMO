package es.iesnervion.smartinez.ejercicio1_constraint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button one, two, three, four, five, six, seven, eigth, nine, cero, sum, minus, multiply, divide, equal;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = findViewById(R.id.number1);
        two = findViewById(R.id.number2);
        three = findViewById(R.id.number3);
        four = findViewById(R.id.number4);
        five = findViewById(R.id.number5);
        six = findViewById(R.id.number6);
        seven = findViewById(R.id.number7);
        eigth = findViewById(R.id.number8);
        nine = findViewById(R.id.number9);
        cero = findViewById(R.id.number0);
        sum = findViewById(R.id.sum);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        equal = findViewById(R.id.equal);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eigth.setOnClickListener(this);
        nine.setOnClickListener(this);
        cero.setOnClickListener(this);
        sum.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        equal.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        TextView text;

        text = findViewById(R.id.text);

        switch (view.getId()){

            case R.id.number1:
                text.setText(text.getText().toString()+"1");
                break;

            case R.id.number2:
                text.setText(text.getText().toString()+"2");
                break;

            case R.id.number3:
                text.setText(text.getText().toString()+"3");
                break;

            case R.id.number4:
                text.setText(text.getText().toString()+"4");
                break;

            case R.id.number5:
                text.setText(text.getText().toString()+"5");
                break;

            case R.id.number6:
                text.setText(text.getText().toString()+"6");
                break;

            case R.id.number7:
                text.setText(text.getText().toString()+"7");
                break;

            case R.id.number8:
                text.setText(text.getText().toString()+"8");
                break;

            case R.id.number9:
                text.setText(text.getText().toString()+"9");
                break;

            case R.id.sum:
                text.setText(text.getText().toString()+"+");
                break;

            case R.id.minus:
                text.setText(text.getText().toString()+"-");
                break;

            case R.id.multiply:
                text.setText(text.getText().toString()+"*");
                break;

            case R.id.divide:
                text.setText(text.getText().toString()+"/");
                break;

            case R.id.equal:

                text.setText("El resultado es: "+ calcularResultado(text.getText().toString()));
                break;

        }
    }

    //TODO con metodos clase String
    private int calcularResultado(String text){

        String [] cadenas;
        int resultado = 0;


        if(text.contains("+")){

            cadenas = text.split("\\+");
            resultado = Integer.parseInt(cadenas[0])+Integer.parseInt(cadenas[1]);

        }
        else{
            if(text.contains("-")){

                cadenas = text.split("-");
                resultado = Integer.parseInt(cadenas[0])-Integer.parseInt(cadenas[1]);

            }
            else{
                if(text.contains("*")){

                    cadenas = text.split("\\*");
                    resultado = Integer.parseInt(cadenas[0])*Integer.parseInt(cadenas[1]);

                }
                else{
                    if(text.contains("/")){

                        cadenas = text.split("/");
                        resultado = Integer.parseInt(cadenas[0])/Integer.parseInt(cadenas[1]);

                    }
                }
            }
        }

        return resultado;
    }
}