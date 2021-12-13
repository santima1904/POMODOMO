package iesnervion.smartinez.pruebaspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Verdura [] verduras = {new Verdura("Berenjena", R.drawable.berenjena), new Verdura("Cebolla", R.drawable.cebolla),
            new Verdura("Puerro", R.drawable.puerro), new Verdura("Patata", R.drawable.patata)};
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        IconicAdapter<Verdura> adapter = new IconicAdapter<>(this, verduras);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        TextView text = findViewById(R.id.name);
        text.setText(verduras[position].getNombre());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    class IconicAdapter<T> extends BaseAdapter implements SpinnerAdapter {

        Context contextAdapter;
        T[] lista;

        //Constructor
        public IconicAdapter(Context context, T[] listaDatos) {
            contextAdapter = context;
            lista = listaDatos;
        }


        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {

            ViewHolder2 holder;
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

            ViewHolder holder;
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

    class ViewHolder{
        TextView text;
        ImageView image;

        public ViewHolder(ImageView image, TextView text) {
            this.text = text;
            this.image = image;
        }

        public TextView getText() {
            return text;
        }

        public ImageView getImage() {
            return image;
        }
    }

    class ViewHolder2{
        TextView text;

        public ViewHolder2(TextView text) {
            this.text = text;
        }

        public TextView getText() {
            return text;
        }

    }

}