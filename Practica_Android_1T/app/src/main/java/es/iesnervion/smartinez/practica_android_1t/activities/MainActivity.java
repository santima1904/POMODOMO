package es.iesnervion.smartinez.practica_android_1t.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import es.iesnervion.smartinez.practica_android_1t.R;
import es.iesnervion.smartinez.practica_android_1t.clasesBasicas.Empresa;
import es.iesnervion.smartinez.practica_android_1t.clasesBasicas.EmpresaNoTecnologica;
import es.iesnervion.smartinez.practica_android_1t.clasesBasicas.EmpresaTecnologica;
import es.iesnervion.smartinez.practica_android_1t.viewModel.MiViewModel;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    MiViewModel miViewModel;
    ListView listView;
    AutoCompleteTextView autocompletex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miViewModel = new ViewModelProvider(this).get(MiViewModel.class);
        listView = findViewById(R.id.listEmpresas);
        IconicAdapter <Empresa> adapter = new IconicAdapter <Empresa>(this, miViewModel.getListadoEmpresas());
        IconicAdapterFiltrar <Empresa> adapterFiltrar = new IconicAdapterFiltrar<>(this, miViewModel.getListadoEmpresas());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        autocompletex = findViewById(R.id.editFiltro);
        autocompletex.setOnItemClickListener(this);
        autocompletex.setAdapter(adapterFiltrar);
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

    class IconicAdapter <T> extends BaseAdapter{

        Context contextAdapter;
        List<Empresa> listadoEmpresas;

        public IconicAdapter(Context contextAdapter, List<Empresa> listadoEmpresas) {
            this.contextAdapter = contextAdapter;
            this.listadoEmpresas = listadoEmpresas;
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
            return listadoEmpresas.size();
        }

        @Override
        public Object getItem(int position) {
            return listadoEmpresas.get(position);
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
            notifyDataSetChanged();

            return row;
        }
    }

    class IconicAdapterFiltrar <T> extends BaseAdapter implements Filterable{

        Context contextAdapter;
        List<Empresa> listadoEmpresas,empresaList, suggestions;

        public IconicAdapterFiltrar(Context contextAdapter, List<Empresa> listadoEmpresas) {
            this.contextAdapter = contextAdapter;
            this.listadoEmpresas = listadoEmpresas;
            this.empresaList = new ArrayList<>(listadoEmpresas);
            this.suggestions = new ArrayList<>();
        }

        @Override
        public int getCount() {
            return listadoEmpresas.size();
        }

        @Override
        public Object getItem(int i) {
            return listadoEmpresas.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            TextView nombre;
            ViewHolderNombreFiltro viewHolderNombreFiltro;

            if (row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.layout_filtro, parent, false);

                nombre = (TextView) row.findViewById(R.id.nombre_filtro);

                viewHolderNombreFiltro = new ViewHolderNombreFiltro(nombre);
                row.setTag(viewHolderNombreFiltro);

                viewHolderNombreFiltro.getNombre().setText(((Empresa)getItem(position)).getNombre());
            } else {

                viewHolderNombreFiltro = (ViewHolderNombreFiltro) row.getTag();
                viewHolderNombreFiltro.getNombre().setText(((Empresa) (getItem(position))).getNombre());
            }

            return row;
        }

        @Override
        public Filter getFilter() {
            return empresasFilter;
        }

        Filter empresasFilter = new Filter() {

            @Override
            public CharSequence convertResultToString(Object result){
                return ((Empresa)result).getNombre();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();

                if (constraint != null){
                    suggestions.clear();
                    for (Empresa e:empresaList) {
                        if (e.getNombre().toLowerCase().contains(constraint.toString().toLowerCase())){
                            suggestions.add(e);
                        }
                    }
                    filterResults.values = suggestions;
                    filterResults.count = suggestions.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                List<Empresa> listaFiltrada = (ArrayList<Empresa>)filterResults.values;

                if (filterResults != null && filterResults.count > 0){
                    listadoEmpresas.clear();
                    listadoEmpresas.addAll(listaFiltrada);
                    notifyDataSetChanged();
                }
            }
        };
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

    class ViewHolderNombreFiltro {
        //Atributos
        private TextView nombre;

        //Constructor
        public ViewHolderNombreFiltro(TextView nombre) {
            this.nombre = nombre;
        }

        //Getters and setters
        public TextView getNombre() {
            return nombre;
        }

        public void setNombre(TextView nombre) {
            this.nombre = nombre;
        }

    }
}