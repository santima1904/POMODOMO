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
        TextView nombre;
        TextView apellidos;

        public PersonaViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombreLista);
            apellidos = itemView.findViewById(R.id.apellidosLista);
        }
    }

    @Override
    public PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.personalayout, parent, false);

        return new PersonaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonaViewHolder holder, int position) {
        Persona persona = listadoPersona.get(position);

        holder.nombre.setText(persona.getNombre());
        holder.apellidos.setText(persona.getApellidos());
    }

    @Override
    public int getItemCount() {
        return listadoPersona.size();
    }
}
