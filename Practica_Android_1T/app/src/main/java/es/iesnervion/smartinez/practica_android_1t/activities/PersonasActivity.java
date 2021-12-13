package es.iesnervion.smartinez.practica_android_1t.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import es.iesnervion.smartinez.practica_android_1t.R;
import es.iesnervion.smartinez.practica_android_1t.clasesBasicas.EmpresaTecnologica;
import es.iesnervion.smartinez.practica_android_1t.clasesBasicas.Persona;

public class PersonasActivity extends AppCompatActivity {
    private Spinner spinner;
    ArrayList<Persona> listadoPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);
        Bundle bundle = getIntent().getExtras();
        listadoPersonas = bundle.getParcelableArrayList("personas");
        spinner = findViewById(R.id.spinner);
        IconicAdapter<Persona> adapter = new IconicAdapter<>(this, verduras);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    class IconicAdapter<T> extends BaseAdapter implements SpinnerAdapter {

        Context contextAdapter;

        //Constructor
        public IconicAdapter(Context context) {
            contextAdapter = context;
        }
        
        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {

            View row = convertView;
            TextView text;

            if (row == null){
                LayoutInflater inflater = getLayoutInflater();

                row = inflater.inflate(R.layout.spinner_lista, parent, false);

                text = (TextView) row.findViewById(R.id.texto);

                holder = new ViewHolder2(text);
                row.setTag(holder);
            }else{
                holder = (ViewHolder2) row.getTag();
            }

            holder.getText().setText(verduras[position].getNombre());

            return row;
        }



        @Override
        public int getCount() {
            return verduras.length;
        }

        @Override
        public Object getItem(int position) {
            return verduras[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View row = convertView;
            TextView text;
            ImageView image;

            if (row == null){
                LayoutInflater inflater = getLayoutInflater();

                row = inflater.inflate(R.layout.spinner_seleccionado, parent, false);

                text = (TextView) row.findViewById(R.id.texto_seleccionado);
                image = (ImageView) row.findViewById(R.id.img);


                holder = new ViewHolder(image, text);
                row.setTag(holder);
            }else{
                holder = (ViewHolder) row.getTag();
            }

            holder.getText().setText(verduras[position].getNombre());
            holder.getImage().setImageResource(verduras[position].getImage());

            return row;
        }

    }

}