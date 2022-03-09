package com.guillermo.droguedam.MiCuenta;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.guillermo.droguedam.R;
import com.guillermo.droguedam.Utilidades.Utilidades;

public class MiCuentaFragment extends Fragment {

    private EditText nombre;
    Button btnEditar;

    public MiCuentaFragment() {
    }

    public static MiCuentaFragment newInstance() {
        MiCuentaFragment fragment = new MiCuentaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mis_citas, container, false);

        btnEditar = view.findViewById(R.id.guardarCambios);
        EditText email = view.findViewById(R.id.editEmail);
        nombre = view.findViewById(R.id.editName);

        //Obtenemos los datos del usuario
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        email.setText(mAuth.getCurrentUser().getEmail());
        obtenerNombreUsuario();

        //Listener del boton editar
        btnEditar.setOnClickListener(this::actualizarDatosUsuario);

        return view;
    }

    /**
     * Actualiza los datos del usuario
     * @param view Vista pulsada. En este caso el boton de guardar cambios
     */
    public void actualizarDatosUsuario(View view){
        Utilidades.actualizarNombreUsuario(getActivity(), nombre.getText().toString());
        Toast.makeText(getActivity(), "Datos actualizados correctamente", Toast.LENGTH_SHORT).show();
    }

    /**
     * Obtiene el nombre de usuario almacenado
     */
    private void obtenerNombreUsuario(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("datosUsuario", MODE_PRIVATE);
        String name = sharedPreferences.getString("nombre", "");
        nombre.setText(name);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}