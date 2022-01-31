package com.example.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class DetalleActivity extends FragmentActivity{
	
	//Paquete donde se recoge el atributo pasado en el intent
	public static final String EXTRA_TEXTO =
			"com.example.fragments.EXTRA_TEXTO";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Se le asigna el layout detalle
		setContentView(R.layout.detalle);
		
		//Se recoge el Fragment de detalle
		DetalleFragment detalle =
				(DetalleFragment)getSupportFragmentManager()
				.findFragmentById(R.id.detalle);
		
		//Se llama al metodo mostrarDetalle del fragment detalle
		detalle.mostrarDetalle(
				getIntent().getIntExtra(EXTRA_TEXTO, R.drawable.ic_launcher));
		
	}

}
