package com.guillermo.droguedam.Login;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.guillermo.droguedam.R;
import com.guillermo.droguedam.Utilidades.Utilidades;

public class CreateAccount extends AppCompatActivity {

    private EditText email, nickname, password, password2;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        getSupportActionBar().setTitle("Crear cuenta");

        nickname = findViewById(R.id.EditTextNickName);
        email = findViewById(R.id.EditTextMail);
        password = findViewById(R.id.EditTextPasswordCreateCount01);
        password2 = findViewById(R.id.EditTextPasswordCreateCount02);
        progressDialog = new ProgressDialog(this, R.style.ProgressDialogStyle);
        mAuth = FirebaseAuth.getInstance();
    }

    /**
     * Intenta crear una cuenta en la base de datos de FireBase.
     * @param v Vista sobre la que se ha pulsado, en este caso el boton de crearCuenta.
     */
    public void createAccount(View v){
        if(comprobarCampos()){//Si los campos son validos intentamos registrar al usuario.
            //Mostramos dialogo de carga.
            progressDialog.setMessage("Creando cuenta. Puede tardar unos minutos");
            progressDialog.show();
            mAuth.createUserWithEmailAndPassword(email.getText().toString().trim(), password.getText().toString().trim()).addOnCompleteListener(this, task -> {
                if(task.isSuccessful()){
                    //Añadimos el nombre de usuario.
                    Utilidades.actualizarNombreUsuario(this, nickname.getText().toString());
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "No se ha podido crear", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            });
        }
    }

    /**
     * Comprueba que el campo del email no esta vacio y las contraseñas coincidan.
     * @return True si el email y contraseñas son validos. False en caso contrario.
     */
    private boolean comprobarCampos(){
        boolean ret =  true;

        if(nickname.getText().toString().isEmpty()){
            ret = false;
            Toast.makeText(this, "El nombre está vacío", Toast.LENGTH_SHORT).show();
        } else if(email.getText().toString().isEmpty()){ //Si el email esta vacio
            ret = false;
            Toast.makeText(this, "El email está vacío", Toast.LENGTH_SHORT).show();
        }else if(!password2.getText().toString().equals(password.getText().toString())){ //Si las contraseñas no coinciden
            ret = false;
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }else if(password2.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
            ret = false;
            Toast.makeText(this, "Contraseña vacía", Toast.LENGTH_SHORT).show();
        }else if(password.length() < 6){ //Si la contraseña tiene menos de 6 caracteres.
            ret = false;
            Toast.makeText(this, "Contraseña inferior a 6 caracteres", Toast.LENGTH_SHORT).show();
        }

        return ret;
    }
}