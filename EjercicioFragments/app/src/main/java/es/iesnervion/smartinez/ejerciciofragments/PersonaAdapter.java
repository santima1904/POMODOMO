package es.iesnervion.smartinez.ejerciciofragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import es.iesnervion.smartinez.ejerciciofragments.modelo.Persona;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder> {

    List<Persona> listadoPersona;

    public PersonaAdapter(List<Persona> listadoPersona) {
        this.listadoPersona = listadoPersona;
    }

    class PersonaViewHolder extends RecyclerView.ViewHolder{
        View view;
        TextView nombre;
        TextView apellidos;

        public PersonaViewHolder(View itemView) {
            super(itemView);
            nombre = view.findViewById(R.id.nombreLista);
            apellidos = view.findViewById(R.id.apellidosLista);
        }
    }

    @Override
    public PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        return new PersonaViewHolder(inflater.inflate(R.layout.personalayout, parent, false));
    }

    @Override
    public void onBindViewHolder(PersonaViewHolder holder, int position) {
        Persona persona = listadoPersona.get(position);

        holder.nombre.setText(listadoPersona.get(position).getNombre());
        holder.apellidos.setText(listadoPersona.get(position).getApellidos());
    }

    @Override
    public int getItemCount() {
        return listadoPersona.size();
    }
}
