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
public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

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
    CheckBox checkCoches, checkMotos;
    RadioGroup radioCars, radioMotos;
    ListView listVehicles;
    int layoutCoches = 0;
    int layoutMotos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Crear los objetos vistas
        checkCoches = findViewById(R.id.check_car);
        checkMotos = findViewById(R.id.check_moto);
        radioCars = findViewById(R.id.radiogroup_cars);
        radioMotos = findViewById(R.id.radiogroup_motos);
        listVehicles = findViewById(R.id.list_vehicles);

        //Listeners
        checkCoches.setOnCheckedChangeListener(this);
        checkMotos.setOnCheckedChangeListener(this);
        radioCars.setOnCheckedChangeListener(this);
        radioMotos.setOnCheckedChangeListener(this);
    }

    private void rellenarListadoCoches(){
        vehicles.add(car1);
        vehicles.add(car2);
        vehicles.add(car3);
        vehicles.add(car4);
        vehicles.add(car5);
        vehicles.add(car6);
        vehicles.add(car7);
    }

    private void rellenarListadoMotos(){
        vehicles.add(bike1);
        vehicles.add(bike2);
        vehicles.add(bike3);
        vehicles.add(bike4);
    }

    private void rellenarListadoVehiculos(){
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
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        vehicles.clear();
        if (checkCoches.isChecked()&&checkMotos.isChecked()){
            rellenarListadoVehiculos();
        }else if (checkCoches.isChecked()){
            rellenarListadoCoches();
        }else if (checkMotos.isChecked()){
            rellenarListadoMotos();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
    if (group.getId() == R.id.radiogroup_cars){
        switch (checkedId){
            case R.id.radio_car_right:
                layoutCoches = R.layout.car_row_right;
        }
    }
    }


    class IconicAdapter extends BaseAdapter {

        Context context;
        List<Car> lista;

        public IconicAdapter(Context context, List<Car> lista) {
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
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;

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