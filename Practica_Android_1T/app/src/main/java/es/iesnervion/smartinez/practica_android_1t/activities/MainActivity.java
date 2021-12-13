package es.iesnervion.smartinez.practica_android_1t.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;

import es.iesnervion.smartinez.practica_android_1t.R;
import es.iesnervion.smartinez.practica_android_1t.clasesBasicas.EmpresaNoTecnologica;
import es.iesnervion.smartinez.practica_android_1t.clasesBasicas.EmpresaTecnologica;
import es.iesnervion.smartinez.practica_android_1t.viewModel.MiViewModel;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    MiViewModel miViewModel;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miViewModel = new ViewModelProvider(this).get(MiViewModel.class);
        listView = findViewById(R.id.listEmpresas);
        listView.setAdapter(new IconicAdapter(this));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getItemAtPosition(position) instanceof EmpresaTecnologica) {
            miViewModel.setEmpresaSeleccionada((EmpresaTecnologica) parent.getItemAtPosition(position));
            Intent intent = new Intent(view.getContext(), EmpresaActivity.class);
            intent.putExtra("empresa", miViewModel.getEmpresaSeleccionada());
            startActivity(intent);
        }
    }

    class IconicAdapter extends BaseAdapter{

        Context contextAdapter;

        public IconicAdapter(Context contextAdapter) {
            this.contextAdapter = contextAdapter;
        }

        @Override
        public int getItemViewType(int positicion){
            int tipoLayout = 0;

            if (getItem(positicion) instanceof EmpresaTecnologica){
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
            return miViewModel.getListadoEmpresas().size();
        }

        @Override
        public Object getItem(int position) {
            return miViewModel.getListadoEmpresas().get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            TextView nombre, web, mail, localizacion, cnae;
            ImageView logo;
            ViewHolderTecnologica viewHolderTecnologica;
            ViewHolderNoTecnologicas viewHolderNoTecnologicas;

            if (row == null){
                LayoutInflater inflater = getLayoutInflater();
                if (getItemViewType(position) == 0){
                    row = inflater.inflate(R.layout.layout_empresas_no_tecnologicas, parent, false);

                    nombre = (TextView) row.findViewById(R.id.txtNombreNo);
                    cnae = (TextView) row.findViewById(R.id.txtCnae);

                    viewHolderNoTecnologicas = new ViewHolderNoTecnologicas(nombre, cnae);
                    row.setTag(viewHolderNoTecnologicas);

                    viewHolderNoTecnologicas.getNombre().setText(((EmpresaNoTecnologica)(getItem(position))).getNombre());
                    viewHolderNoTecnologicas.getCnae().setText(((EmpresaNoTecnologica)(getItem(position))).getCnae());
                }else{
                    row = inflater.inflate(R.layout.layout_empresas_tecnologicas, parent, false);

                    nombre = (TextView)row.findViewById(R.id.txtNombre);
                    web = (TextView)row.findViewById(R.id.txtWeb);
                    mail = (TextView)row.findViewById(R.id.txtMail);
                    localizacion = (TextView)row.findViewById(R.id.txtLocalizacion);
                    logo = (ImageView)row.findViewById(R.id.imgLogo);

                    viewHolderTecnologica = new ViewHolderTecnologica(nombre, web, mail, localizacion, logo);
                    row.setTag(viewHolderTecnologica);

                    viewHolderTecnologica.getNombre().setText(((EmpresaTecnologica)(getItem(position))).getNombre());
                    viewHolderTecnologica.getWeb().setText(((EmpresaTecnologica)(getItem(position))).getWeb());
                    viewHolderTecnologica.getMail().setText(((EmpresaTecnologica)(getItem(position))).getMailContacto());
                    viewHolderTecnologica.getLocalizacion().setText(((EmpresaTecnologica)(getItem(position))).getLocalizacion());
                    viewHolderTecnologica.getLogo().setImageResource(((EmpresaTecnologica)(getItem(position))).getLogo());
                }
            }else{
                if (getItemViewType(position) == 0){
                    viewHolderNoTecnologicas = (ViewHolderNoTecnologicas) row.getTag();

                    viewHolderNoTecnologicas.getNombre().setText(((EmpresaNoTecnologica)(getItem(position))).getNombre());
                    viewHolderNoTecnologicas.getCnae().setText(((EmpresaNoTecnologica)(getItem(position))).getCnae());
                }else{
                    viewHolderTecnologica = (ViewHolderTecnologica) row.getTag();

                    viewHolderTecnologica.getNombre().setText(((EmpresaTecnologica)(getItem(position))).getNombre());
                    viewHolderTecnologica.getWeb().setText(((EmpresaTecnologica)(getItem(position))).getWeb());
                    viewHolderTecnologica.getMail().setText(((EmpresaTecnologica)(getItem(position))).getMailContacto());
                    viewHolderTecnologica.getLocalizacion().setText(((EmpresaTecnologica)(getItem(position))).getLocalizacion());
                    viewHolderTecnologica.getLogo().setImageResource(((EmpresaTecnologica)(getItem(position))).getLogo());
                }
            }

            return row;
        }
    }

    class ViewHolderTecnologica{

        //Atributos
        private TextView nombre;
        private TextView web;
        private TextView mail;
        private TextView localizacion;
        private ImageView logo;

        //Constructor
        public ViewHolderTecnologica(TextView nombre, TextView web, TextView mail, TextView localizacion, ImageView logo) {
            this.nombre = nombre;
            this.web = web;
            this.mail = mail;
            this.localizacion = localizacion;
            this.logo = logo;
        }

        //Getters and setters
        public TextView getNombre() {
            return nombre;
        }

        public void setNombre(TextView nombre) {
            this.nombre = nombre;
        }

        public TextView getWeb() {
            return web;
        }

        public void setWeb(TextView web) {
            this.web = web;
        }

        public TextView getMail() {
            return mail;
        }

        public void setMail(TextView mail) {
            this.mail = mail;
        }

        public TextView getLocalizacion() {
            return localizacion;
        }

        public void setLocalizacion(TextView localizacion) {
            this.localizacion = localizacion;
        }

        public ImageView getLogo() {
            return logo;
        }

        public void setLogo(ImageView logo) {
            this.logo = logo;
        }
    }

    class ViewHolderNoTecnologicas{
        //Atributos
        private TextView nombre;
        private TextView cnae;

        //Constructor
        public ViewHolderNoTecnologicas(TextView nombre, TextView cnae) {
            this.nombre = nombre;
            this.cnae = cnae;
        }

        //Getters and setters
        public TextView getNombre() {
            return nombre;
        }

        public void setNombre(TextView nombre) {
            this.nombre = nombre;
        }

        public TextView getCnae() {
            return cnae;
        }

        public void setCnae(TextView cnae) {
            this.cnae = cnae;
        }
    }
}