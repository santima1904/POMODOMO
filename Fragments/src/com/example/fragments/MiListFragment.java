package com.example.fragments;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MiListFragment extends Fragment{

	private String[] menu = {"Menu1","Menu2","Menu3","Menu4"};
	private int[] imagenes = {R.drawable.gato1,R.drawable.gato2,R.drawable.gato3,R.drawable.gato4};
	private ListView lv;
	
	//nuestro listener para cuando pulsamos un item del listado
	private MiListener listener;
	
	//Se lanza cuando se crea la vista
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container,
			Bundle savedInstanceState) {
		//'inflamos' el layout para este fragment
		return inflater.inflate(R.layout.milist_fragment, container, false);
	}
	
	//Se lanza cuando la activdad ha sido creada
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		//Recogemos la lista
		lv = (ListView) getView().findViewById(R.id.miList);
		ArrayList<Gato> aux = new ArrayList<Gato>();
		for(int i=0; i<menu.length;i++){
			aux.add(new Gato(menu[i], imagenes[i]));
		}
		
		//Creamos el adaptador y se lo asignamos a la lista
		ArrayAdapter<Gato> adaptador = new ArrayAdapter<Gato>(this.getActivity(), android.R.layout.simple_list_item_1, aux);
		lv.setAdapter(adaptador);
		
		//Asignamos un nuevo listener cuando hacemos click en un elemento de la lista
		lv.setOnItemClickListener(new OnItemClickListener(){
			//Redefinimos el metodo para que lance el metodo de nuestro listener
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if(listener!=null){
					listener.onSeleccionado((Gato) lv.getItemAtPosition(arg2));
				}

			}

		});

	}

	//Definimos nuestra interfaz de listener
	public interface MiListener{
		void onSeleccionado(Gato s);
	}

	//Setter del listener
	public void setMiListener(MiListener ml){
		this.listener = ml;
	}
	
	//Definimos la clase Gato
	public class Gato{
		private String nombre;
		private final int imagen;
		
		public Gato(String nom, int ima){
			nombre = nom;
			imagen = ima;
		}
		
		public String toString(){
			return nombre;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getImagen() {
			return imagen;
		}
		
		
		
	}

}
