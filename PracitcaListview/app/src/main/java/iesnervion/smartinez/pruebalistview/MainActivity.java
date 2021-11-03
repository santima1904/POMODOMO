package iesnervion.smartinez.pruebalistview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private TextView selection;
    /*
    private final String [] content = {"lorem", "piedra", "dolor",
            "sit", "amet",
            "consectetuer", "adipiscing", "papel", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "tijeras", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "daniel", "purus"};

     */
    Objeto piedra = new Objeto("piedra", R.drawable.piedra);
    Objeto papel = new Objeto("papel", R.drawable.papel);
    Objeto tijeras = new Objeto("tijeras", R.drawable.tijeras);
    private Objeto[] content = {piedra, papel, tijeras};
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selection = findViewById(R.id.selection);
        lista = findViewById(R.id.miLista);

        //creo un nuevo Adapter
        lista.setAdapter(new IconicAdapter<Objeto>(this,
                R.layout.list_layout, R.id.text_row,
                content));

        //configuro el evento de click en cualquiera de los elementos de la lista
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Esta forma no sirve en un futuro, ya que usaremos conexiones en la base de datos
                //selection.setText(content[position]);

                //Esta forma usa directamente la vista
                selection.setText(parent.getItemAtPosition(position).toString());
            }
        });

    }

    class IconicAdapter<T> extends ArrayAdapter<T> {

        //Constructor
        public IconicAdapter(Context context, int resource, int textViewResourceId, T[] objects) {
            super(context, resource, textViewResourceId, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            View row = convertView;
            ViewHolder holder;
            TextView text;
            ImageView image;

            //Forma con ViewHolder
            if (row == null){
                LayoutInflater inflater = getLayoutInflater();
                row=inflater.inflate(R.layout.list_layout, parent, false);

                text = (TextView) row.findViewById(R.id.text_row);
                image = (ImageView) row.findViewById(R.id.image_row);
                holder = new ViewHolder(text, image);
                row.setTag(holder);
            }else{
                holder = (ViewHolder) row.getTag();
            }

            holder.getText().setText(content[position].getNombre());
            holder.getImage().setImageResource(content[position].getImagen());

            //Forma con inflate
            /*
            View row = convertView;

            if (row == null){
                LayoutInflater inflater = getLayoutInflater();
                row=inflater.inflate(R.layout.list_layout, parent, false);
            }

             */

            //Forma para hacerlo con ArrayAdapter
            //View row = super.getView(position, convertView, parent);
            //ImageView icon = (ImageView) row.findViewById(R.id.image_row);

            //Forma con un array de objetos
            //icon.setImageResource(content[position].getImagen());

            /*
            //Forma con una array de String
            switch (content[position]){
                case "piedra":
                    icon.setImageResource(R.drawable.piedra);
                    break;

                case "papel":
                    icon.setImageResource(R.drawable.papel);
                    break;

                case "tijeras":
                    icon.setImageResource(R.drawable.tijeras);
                    break;

                default:
                    icon.setImageResource(R.drawable.ic_baseline_close_24);
                    break;

            }
             */

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
