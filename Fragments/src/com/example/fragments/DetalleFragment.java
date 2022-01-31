package com.example.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class DetalleFragment extends Fragment implements View.OnClickListener{
	
	private Button boton; //Boton que crea un Fragment dinámico
	
	//Se lanza cuando la vista es creada
	@Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
		//Devolvemos la vista devuelta al 'inflar' el layout detalle_fragment
        return inflater.inflate(R.layout.detalle_fragment, container, false);
        
    }
	
	//Se lanza cuando la actividad es creada
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		//Recogemos el boton
		boton = (Button) this.getActivity().findViewById(R.id.botonFragment);
		//Le asignamos el listener de click a esta clase
        boton.setOnClickListener(this);
	}
	
	//Método que modifica el texto que aparece en el layout de este fragmento
	public void mostrarDetalle(int imagen){
		ImageView image = (ImageView) getActivity().findViewById(R.id.imagen);
		image.setImageResource(imagen);
	}
	
	//Definimos el método onClick para el boton
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.botonFragment:
			// Creamos un nuevo fragment
			Fragment newFragment = new TopFragment();
			//Creamos la transaction para modificar los fragment contenidos
			FragmentTransaction transaction = this.getActivity().getSupportFragmentManager().beginTransaction();

			//Reemplazamos 
			transaction.replace(R.id.detalleFragment2, newFragment);
			transaction.addToBackStack(null);

			//Llevamos a cabo la transaction
			transaction.commit();
			break;

		default:
			break;
		}
		
	}
	
	

}
