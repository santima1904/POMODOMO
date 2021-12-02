package es.iesnervion.smartinez.practica_android_1t.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import es.iesnervion.smartinez.practica_android_1t.R;
import es.iesnervion.smartinez.practica_android_1t.clasesBasicas.EmpresaTecnologica;
import es.iesnervion.smartinez.practica_android_1t.viewModel.MiViewModel;

public class EmpresaActivity extends AppCompatActivity {
    MiViewModel miViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);
        //miViewModel = new ViewModelProvider(this).get(MiViewModel.class);
        TextView textView = findViewById(R.id.ejemplo);
        Bundle bundle = getIntent().getExtras();
        EmpresaTecnologica empresaTecnologica = (EmpresaTecnologica) bundle.get("empresa");
        textView.setText(empresaTecnologica.getNombre());
    }
}