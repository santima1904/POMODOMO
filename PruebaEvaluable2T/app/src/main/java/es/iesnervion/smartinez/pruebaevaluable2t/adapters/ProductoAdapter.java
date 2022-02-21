package es.iesnervion.smartinez.pruebaevaluable2t.adapters;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.iesnervion.smartinez.pruebaevaluable2t.R;
import es.iesnervion.smartinez.pruebaevaluable2t.models.Producto;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {

    List<Producto> listadoProducto;

    public ProductoAdapter(List<Producto> listadoProducto) {
        this.listadoProducto = listadoProducto;
    }


    class ProductoViewHolder extends RecyclerView.ViewHolder{
        Image imagen;
        TextView nombre;
        TextView precio;

        public ProductoViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombreLista);
            apellidos = itemView.findViewById(R.id.apellidosLista);
        }
    }

    @Override
    public ProductoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.personalayout, parent, false);

        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductoViewHolder holder, int position) {
        Producto persona = listadoPersona.get(position);

        holder.nombre.setText(persona.getNombre());
        holder.apellidos.setText(persona.getApellidos());
    }

    @Override
    public int getItemCount() {
        return listadoProducto.size();
    }
}
