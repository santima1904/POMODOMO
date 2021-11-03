package iesnervion.smartinez.listaheterogenea;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Objeto piedra = new Objeto("piedra", R.drawable.piedra);
    Objeto papel = new Objeto("papel", R.drawable.papel);
    Objeto tijeras = new Objeto("tijeras", R.drawable.tijeras);
    private Objeto[] content = {piedra, papel, tijeras, papel, papel, tijeras, piedra, tijeras, tijeras, papel, piedra};
    private ListView lista;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.miLista);
        text = findViewById(R.id.selection);

        lista.setAdapter(new IconicAdapter<Objeto>(this, content));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                text.setText(parent.getItemAtPosition(position).toString());
            }
        });
    }

    class IconicAdapter<T> extends BaseAdapter {

        Context contextAdapter;
        T[] lista;
        //Constructor
        public IconicAdapter(Context context, T[] listaDatos) {
            contextAdapter = context;
            lista = listaDatos;
        }

        @Override
        public int getItemViewType(int positicion){
            int tipoLayout = 1;

            if (positicion%2 == 0){
                tipoLayout = 2;
            }

            return tipoLayout;
        }

        @Override
        public int getViewTypeCount (){

            return 2;
        }

        @Override
        public int getCount() {
            return content.length;
        }

        @Override
        public Object getItem(int position) {
            return content[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            View row = convertView;
            ViewHolder holder;
            TextView text;
            ImageView image;

            if (row == null){
                LayoutInflater inflater = getLayoutInflater();

                if (getItemViewType(position) == 1){
                    row = inflater.inflate(R.layout.fila_impar, parent, false);

                    text = (TextView) row.findViewById(R.id.text_impar_row);
                    image = (ImageView) row.findViewById(R.id.image_impar_row);
                }else{
                    row = inflater.inflate(R.layout.fila_par, parent, false);

                    text = (TextView) row.findViewById(R.id.text_par_row);
                    image = (ImageView) row.findViewById(R.id.image_par_row);
                }

                holder = new ViewHolder(text, image);
                row.setTag(holder);
            }else{
                holder = (ViewHolder) row.getTag();
            }

            holder.getText().setText(content[position].getNombre());
            holder.getImage().setImageResource(content[position].getImagen());

            return row;
        }

    }

    class ViewHolder{
        TextView text;
        ImageView image;

        public ViewHolder(TextView text, ImageView image) {
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

}