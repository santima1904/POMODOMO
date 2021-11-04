package es.iesnervion.smartinez.examenpdmo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.iesnervion.smartinez.examenpdmo1.clasesBasicas.Bike;
import es.iesnervion.smartinez.examenpdmo1.clasesBasicas.Car;

/*
    La lista no me funciona, no he sabido implementar las funciones de cambiar de lista al controlar el click en los radio buttons
    Tengo hecho el layout y los elementos de la vista.
    Le dejo lo que tengo hecho, aunque no este acabado. Si ejecuta verá la parte primera del ejercicio.
    He comentado el setAdapter para que pueda ejecutar sin que salga una excepcion.
 */
public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    Car car1 = new Car("Audi A8", R.drawable.audi_a8);
    Car car2 = new Car("BMW M3", R.drawable.bmw_m3);
    Car car3 = new Car("Citroen C3", R.drawable.citroen_c3);
    Car car4 = new Car("Opel Astra", R.drawable.opel_astra);
    Car car5 = new Car("Renault Captur", R.drawable.renault_captur);
    Car car6 = new Car("Seat Ibiza", R.drawable.seat_ibiza);
    Car car7 = new Car("Volkswagen Golf", R.drawable.vw_golf);

    Bike bike1 = new Bike("H-D SuperLow", R.drawable.harley_davidson_superlow);
    Bike bike2 = new Bike("Honda CBR600 RR", R.drawable.honda_cbr600_rr);
    Bike bike3 = new Bike("Suzuki GSX R600", R.drawable.suzuki_gsx_r600);
    Bike bike4 = new Bike("Yamaha R6", R.drawable.yamaha_r6);

    List<Object> vehicles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciar las vistas
        CheckBox checkCoches, checkMotos;
        RadioGroup radioCars, radioMotos;
        RadioButton radioCocheIzq, radioCocheDer, radioCocheDouble, radioMotoIzq, radioMotoDer, radioMotoDouble;
        ListView listVehicles;

        //Anhadir los objetos creados a la lista
        vehicles.add (bike1);
        vehicles.add (car1);
        vehicles.add (car2);
        vehicles.add (car3);
        vehicles.add (car4);
        vehicles.add (bike2);
        vehicles.add (car5);
        vehicles.add (bike3);
        vehicles.add (car6);
        vehicles.add (car7);
        vehicles.add (bike4);

        //Crear los objetos vistas
        checkCoches = findViewById(R.id.check_car);
        checkMotos = findViewById(R.id.check_moto);
        radioCars = findViewById(R.id.radiogroup_cars);
        radioMotos = findViewById(R.id.radiogroup_motos);
        radioCocheDer = findViewById(R.id.radio_car_right);
        radioCocheIzq = findViewById(R.id.radio_car_left);
        radioCocheDouble = findViewById(R.id.radio_car_double);
        radioMotoDer = findViewById(R.id.radio_moto_right);
        radioMotoIzq = findViewById(R.id.radio_moto_left);
        radioMotoDouble = findViewById(R.id.radio_moto_double);
        listVehicles = findViewById(R.id.list_vehicles);

        //Listeners
        checkCoches.setOnCheckedChangeListener(this);
        checkMotos.setOnCheckedChangeListener(this);
        radioCocheIzq.setOnCheckedChangeListener(this);
        radioCocheDer.setOnCheckedChangeListener(this);
        radioCocheDouble.setOnCheckedChangeListener(this);
        radioMotoIzq.setOnCheckedChangeListener(this);
        radioMotoDer.setOnCheckedChangeListener(this);
        radioMotoDouble.setOnCheckedChangeListener(this);

        //Adapter
        //listVehicles.setAdapter(new IconicAdapter<Object>(this, vehicles));

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    /**
     * Clase para crear un adaptador personalizado
     * @param <Object>
     */
    class IconicAdapter<Object> extends BaseAdapter {

        Context context;
        List<Object> lista;


        public IconicAdapter(Context context, List<Object> lista) {
            this.context = context;
            this.lista = lista;

        }

        @Override
        public int getCount() {
            return lista.size();
        }

        @Override
        public Object getItem(int position) {
            return lista.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

//         Metodo de prueba mientras intentaba solucionar el problema
//        /**
//         * Descripcion: Metodo para obtener el layout adecuado a la seleccion del usuario
//         *
//         * @return int
//         */
//        private int getLayoutSeleccion(){
//            int layout = 0;
//
//            switch (radioSeleccionado){
//                case R.id.radio_car_right:
//                    layout = R.layout.car_row_right;
//                    break;
//
//                case R.id.radio_car_left:
//                    layout = R.layout.car_row_left;
//                    break;
//
//                case R.id.radio_car_double:
//                    layout = R.layout.car_row_double;
//                    break;
//
//                case R.id.radio_moto_right:
//                    layout = R.layout.bike_row_right;
//                    break;
//
//                case R.id.radio_moto_left:
//                    layout = R.layout.bike_row_left;
//                    break;
//
//                case R.id.radio_moto_double:
//                    layout = R.layout.bike_row_double;
//                    break;
//            }
//            return layout;
//        }


        /*
        Este método cambiaría en algunas condiciones y en el primer parámetro del inflate, está puesto de prueba
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ImageView image;
            TextView text;
            ViewHolderImageText holder;

            if (row == null){
                LayoutInflater inflater = getLayoutInflater();

                row = inflater.inflate(R.layout.car_row_double, parent, false);
                image = findViewById(R.id.image);
                text = findViewById(R.id.name);

                holder = new ViewHolderImageText(image, text);
                row.setTag(holder);
            }else{
                holder = (ViewHolderImageText) row.getTag();
            }

            if (lista.get(position) instanceof Car) {
                holder.getImage().setImageResource(((Car) lista.get(position)).getCarImage());
                holder.getText().setText(((Car) lista.get(position)).getCarName());
            }
            return row;
        }
    }

    /**
     * View holder para los layouts con texto e imagen
     */
    class ViewHolderImageText{

        ImageView image;
        TextView text;

        public ViewHolderImageText(ImageView image, TextView text) {
            this.image = image;
            this.text = text;
        }

        public ImageView getImage() {
            return image;
        }

        public TextView getText() {
            return text;
        }

    }

    /**
     * View holder para los layouts con texto y dos imágenes
     */
    class ViewHolderImageTextImage{

        ImageView image1;
        TextView text;
        ImageView image2;

        public ViewHolderImageTextImage(ImageView image1, TextView text, ImageView image2) {
            this.image1 = image1;
            this.text = text;
            this.image2 = image2;
        }

        public ImageView getImage1() {
            return image1;
        }

        public TextView getText() {
            return text;
        }

        public ImageView getImage2() {
            return image2;
        }
    }
}