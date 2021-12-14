package es.iesnervion.smartinez.practica_android_1t.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import es.iesnervion.smartinez.practica_android_1t.R;
import es.iesnervion.smartinez.practica_android_1t.clasesBasicas.EmpresaTecnologica;
import es.iesnervion.smartinez.practica_android_1t.clasesBasicas.Persona;

public class PersonasActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    ArrayList<Persona> listadoPersonas;
    TextView telefono_persona, cargo_persona, mail_persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);
        Bundle bundle = getIntent().getExtras();
        listadoPersonas = bundle.getParcelableArrayList("personas");
        spinner = findViewById(R.id.spinner);
        IconicAdapter<Persona> adapter = new IconicAdapter<>(this);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        telefono_persona = findViewById(R.id.telefono_persona);
        cargo_persona = findViewById(R.id.cargo_persona);
        mail_persona = findViewById(R.id.mail_persona);

        telefono_persona.setText(listadoPersonas.get(position).getTelefono());
        cargo_persona.setText(listadoPersonas.get(position).getCargo());
        mail_persona.setText(listadoPersonas.get(position).getMail());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    class IconicAdapter<T> extends BaseAdapter implements SpinnerAdapter {

        Context contextAdapter;

        //Constructor
        public IconicAdapter(Context context) {
            contextAdapter = context;
        }

        @Override
        public int getCount() {
            return listadoPersonas.size();
        }

        @Override
        public Object getItem(int position) {
            return listadoPersonas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            ViewHolder holder;
            View row = convertView;
            TextView nombre;
            TextView apellidos;

            if (row == null){
                LayoutInflater inflater = getLayoutInflater();

                row = inflater.inflate(R.layout.layout_spinner, parent, false);

                nombre = (TextView) row.findViewById(R.id.nombre_persona);
                apellidos = (TextView) row.findViewById(R.id.apellidos_persona);

                holder = new ViewHolder(nombre,apellidos);
                row.setTag(holder);
            }else{
                holder = (ViewHolder) row.getTag();
            }

            holder.getNombre().setText(listadoPersonas.get(position).getNombre());
            holder.getApellidos().setText(listadoPersonas.get(position).getApellidos());

            return row;
        }

    }

    class ViewHolder{
        TextView nombre;
        TextView apellidos;

        public ViewHolder(TextView nombre, TextView apellidos) {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }

        public TextView getNombre() {
            return nombre;
        }

        public void setNombre(TextView nombre) {
            this.nombre = nombre;
        }

        public TextView getApellidos() {
            return apellidos;
        }

        public void setApellidos(TextView apellidos) {
            this.apellidos = apellidos;
        }
    }

}