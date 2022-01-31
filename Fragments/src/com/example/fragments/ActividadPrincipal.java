package com.example.fragments;

import com.example.fragments.MiListFragment.Gato;
import com.example.fragments.MiListFragment.MiListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

//Actividad compuesta de fragments
public class ActividadPrincipal extends FragmentActivity implements MiListener {

	//Se lanza cuando la actividad es creada
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Le asignamos el layout principal
		setContentView(R.layout.principal);

		//Recogemos el fragmento de listado
		MiListFragment mlf = (MiListFragment) this.getSupportFragmentManager().findFragmentById(R.id.miListFragment);
		//Asociamos nuestro listener con el fragmento de listado
		mlf.setMiListener(this);

	}


	//Definimos el método de la interfaz implementada
	@Override
	public void onSeleccionado(Gato s) {
		//Comprobamos si en nuestra actividad existe el fragmento de detalle
		boolean hayFragment = (getSupportFragmentManager().findFragmentById(R.id.detalleFragment) != null);
		if(hayFragment){
			//Recogemos el fragment detalle y llamamos a su método mostrarDetalle
			((DetalleFragment)getSupportFragmentManager().findFragmentById(R.id.detalleFragment)).mostrarDetalle(s.getImagen());
		}else{
			//Como no existe el fragment detalle se lanza un Intent de la actividad detalle
			//con el parámetro que nos interesa
			Intent i = new Intent(this, DetalleActivity.class);
			i.putExtra(DetalleActivity.EXTRA_TEXTO, s.getImagen());
			startActivity(i);
		}
		
	}

}
