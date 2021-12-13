package es.iesnervion.smartinez.practica_android_1t.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import es.iesnervion.smartinez.practica_android_1t.R;
import es.iesnervion.smartinez.practica_android_1t.clasesBasicas.EmpresaTecnologica;

public class EmpresaActivity extends AppCompatActivity implements View.OnClickListener {

    TextView nombre, web, mail, localizacion, direccion, telefono;
    ImageView logo;
    Button personasContactos;
    EmpresaTecnologica empresaTecnologica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);
        Bundle bundle = getIntent().getExtras();
        empresaTecnologica = (EmpresaTecnologica) bundle.get("empresa");
        nombre = findViewById(R.id.nombre);
        web = findViewById(R.id.web);
        mail = findViewById(R.id.mail);
        localizacion = findViewById(R.id.localizacion);
        direccion = findViewById(R.id.direccion);
        telefono = findViewById(R.id.telefono);
        logo = findViewById(R.id.logoEmpresa);
        personasContactos = findViewById(R.id.personasContactos);

        nombre.setText(empresaTecnologica.getNombre());
        web.setText(empresaTecnologica.getWeb());
        mail.setText(empresaTecnologica.getMailContacto());
        localizacion.setText(empresaTecnologica.getLocalizacion());
        direccion.setText(empresaTecnologica.getDireccion());
        telefono.setText(empresaTecnologica.getTelefonoContacto());
        logo.setImageResource(empresaTecnologica.getLogo());

        web.setOnClickListener(this);
        mail.setOnClickListener(this);
        localizacion.setOnClickListener(this);
        personasContactos.setOnClickListener(this);
    }

    public void searchWeb(String query) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.web:
                searchWeb(empresaTecnologica.getWeb());
                break;

            case R.id.mail:
                composeEmail(new String[]{empresaTecnologica.getMailContacto()}, "hola");
                break;

            case R.id.localizacion:
                showMap(Uri.parse("geo:0, 0?q="+empresaTecnologica.getLocalizacion()));
                break;

            case R.id.personasContactos:
                Intent intent = new Intent(v.getContext(), PersonasActivity.class);
                intent.putParcelableArrayListExtra("personas", empresaTecnologica.getPersonasContacto());
                startActivity(intent);
                break;
        }

    }
}