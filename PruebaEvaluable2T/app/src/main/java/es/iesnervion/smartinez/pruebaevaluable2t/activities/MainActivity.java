package es.iesnervion.smartinez.pruebaevaluable2t.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import es.iesnervion.smartinez.pruebaevaluable2t.R;
import es.iesnervion.smartinez.pruebaevaluable2t.models.Persona;
import es.iesnervion.smartinez.pruebaevaluable2t.viewModels.MainViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button loggin, guardar, continuar;
    EditText usuario, contrasenha, correo;
    TextView nombre, apellidos;
    Persona persona;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.login_edtx_usuario);
        contrasenha = findViewById(R.id.login_edtx_contrasena);
        loggin = findViewById(R.id.login_button_signin);
        guardar = findViewById(R.id.guardar);
        continuar = findViewById(R.id.continuar);
        nombre = findViewById(R.id.nombre_usuario);
        apellidos = findViewById(R.id.apellidos_usuario);
        correo = findViewById(R.id.correo_usuario);
        cardView = findViewById(R.id.cardview);
        guardar.setOnClickListener(this);
        continuar.setOnClickListener(this);
        loggin.setOnClickListener(this);
        persona = new Persona();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_button_signin:
                if ((!usuario.getText().toString().equals(" ") && !contrasenha.getText().toString().equals(" "))
                        &&(usuario.getText().toString().equals(persona.getUsuario()) && (contrasenha.getText().toString().equals(persona.getContrasenha())))){
                    cardView.setVisibility(View.VISIBLE);
                    nombre.setText(persona.getNombre());
                    apellidos.setText(persona.getApellidos());
                    correo.setText(persona.getEmail());
                }
                break;

            case R.id.guardar:
                persona.setEmail(correo.getText().toString());
                break;

            case R.id.continuar:
                Intent intent = new Intent(MainActivity.this, ListadoProductosActivity.class);
                startActivity(intent);
                break;
        }


    }
}