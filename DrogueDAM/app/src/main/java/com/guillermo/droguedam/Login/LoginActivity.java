package com.guillermo.droguedam.Login;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.guillermo.droguedam.R;
import com.guillermo.droguedam.PaginaPrincipal;
import com.guillermo.droguedam.Utilidades.Constantes;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        //Obtenemos las vistas.
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        progressDialog = new ProgressDialog(this, R.style.ProgressDialogStyle);

        //Obtenemos al usuario
        user = FirebaseAuth.getInstance().getCurrentUser();

        //Si el usuario esta logueado y su email verificado puede entrar.
        if(user != null){
            finish();
            Intent i = new Intent(getApplicationContext(), PaginaPrincipal.class);
            startActivity(i);
        }
    }

    /**
     * Comprueba las credenciales que el usuario ha introducido.
     * Si son correctas puede entrar en la aplicacion. Sino, se le mostrará un mensaje por pantalla.
     * @param v Vista sobre la que se ha pulsado, en este caso sobre el boton de login.
     */
    public void comprobarCredenciales(View v){
        String correo, pass;
        //Mostramos un dialogo de carga
        progressDialog.setMessage("Iniciando sesion, puede durar unos segundos");
        progressDialog.show();

        //Si los campos no estan vacios
        if(!(correo = email.getText().toString().trim()).isEmpty() && !(pass = password.getText().toString().trim()).isEmpty()){
            mAuth.signInWithEmailAndPassword(correo, pass).addOnCompleteListener(this, task -> {
                if (task.isSuccessful()) {
                    user = FirebaseAuth.getInstance().getCurrentUser();
                    //Si se ha logueado correctamente...
                    Toast.makeText(getApplicationContext(), "Bienvenido!", Toast.LENGTH_SHORT).show();

                    //Lanzamos la actividad principal
                    finish();
                    Intent i = new Intent(getApplicationContext(), PaginaPrincipal.class);
                    startActivity(i);
                } else {
                    //Si el inicio de sesion falla mostramos un mensaje.
                    Toast.makeText(getApplicationContext(), "No se ha podido iniciar sesión.", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            });
        }else{
            Toast.makeText(getApplicationContext(), "Rellena los campos vacíos", Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
        }

    }

    /**
     * Lanza un actividad dependiendo de la vista que ha llamado a esta funcion.
     * @param v Vista sobre la que se ha pulsado
     * Sobre btnCreateCount, abrirá la actividad de crear cuenta.
     */
    public void navigateTo(View v){
        Intent i = new Intent(getApplicationContext(), CreateAccount.class);

        startActivity(i);
    }
}