package iesnervion.smartinez.pracitcaviewholderlayoutsdiferentes;

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

    Utensilio piedra = new Utensilio("piedra", R.drawable.piedra);
    Utensilio papel = new Utensilio("papel", R.drawable.papel);
    Utensilio tijeras = new Utensilio("tijeras", R.drawable.tijeras);
    Oso osoRuso = new Oso("oso pardo", R.drawable.oso_ruso, "Rusia");
    Oso osoChino = new Oso("oso panda", R.drawable.oso_chino, "China");
    private Object[] content = {piedra, papel, osoChino, papel, osoRuso, tijeras, piedra, tijeras, osoChino, osoRuso, piedra};
    private ListView lista;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.miLista);
        text = findViewById(R.id.selection);

        lista.setAdapter(new IconicAdapter<Object>(this, content));

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
            int tipoLayout = 0;

            if (getItem(positicion) instanceof Oso){
                tipoLayout = 1;
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
            ViewHolder1 holder_utensilio;
            ViewHolder2 holder_oso;
            TextView nombre;
            TextView pais;
            ImageView image;

            if (row == null){
                LayoutInflater inflater = getLayoutInflater();

                if (getItemViewType(position) == 0){
                    row = inflater.inflate(R.layout.layout_utensilio, parent, false);

                    nombre = (TextView) row.findViewById(R.id.text_nombre_utensilio);
                    image = (ImageView) row.findViewById(R.id.image_utensilio);

                    holder_utensilio = new ViewHolder1(nombre, image);
                    row.setTag(holder_utensilio) ;

                    holder_utensilio.getText().setText(((Utensilio)content[position]).getNombre());
                    holder_utensilio.getImage().setImageResource(((Utensilio)content[position]).getImagen());
                }else{
                    row = inflater.inflate(R.layout.layout_oso, parent, false);

                    nombre = (TextView) row.findViewById(R.id.text_nombre_oso);
                    image = (ImageView) row.findViewById(R.id.image_oso);
                    pais = (TextView) row.findViewById(R.id.text_pais_oso);

                    holder_oso = new ViewHolder2(nombre, image, pais);
                    row.setTag(holder_oso);

                    holder_oso.getNombre().setText(((Oso)content[position]).getNombre());
                    holder_oso.getImage().setImageResource(((Oso)content[position]).getImage());
                    holder_oso.getPais().setText(((Oso)content[position]).getPais());
                }
            }else{
                if (getItemViewType(position) == 0){
                    holder_utensilio = (ViewHolder1) row.getTag();

                    holder_utensilio.getText().setText(((Utensilio)content[position]).getNombre());
                    holder_utensilio.getImage().setImageResource(((Utensilio)content[position]).getImagen());
                }else{
                    holder_oso = (ViewHolder2) row.getTag();

                    holder_oso.getNombre().setText(((Oso)content[position]).getNombre());
                    holder_oso.getImage().setImageResource(((Oso)content[position]).getImage());
                    holder_oso.getPais().setText(((Oso)content[position]).getPais());
                }
            }

            return row;
        }
    }


    class ViewHolder1{
        TextView text;
        ImageView image;

        public ViewHolder1(TextView text, ImageView image) {
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
        TextView nombre;
        ImageView image;
        TextView pais;

        public ViewHolder2(TextView text, ImageView image, TextView pais) {
            this.nombre = text;
            this.image = image;
            this.pais = pais;
        }

        public ImageView getImage() {
            return image;
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getPais() {
            return pais;
        }
    }


}