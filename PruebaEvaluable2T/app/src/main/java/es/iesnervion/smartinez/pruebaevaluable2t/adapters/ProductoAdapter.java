package es.iesnervion.smartinez.pruebaevaluable2t.adapters;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        ImageView imagen;
        TextView nombre;
        TextView precio;

        public ProductoViewHolder(View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.producto_image);
            nombre = itemView.findViewById(R.id.producto_nombre);
            precio = itemView.findViewById(R.id.producto_precio);
        }
    }

    @Override
    public ProductoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.producto_layout, parent, false);

        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductoViewHolder holder, int position) {
        Producto producto = listadoProducto.get(position);

        holder.imagen.setImageResource(producto.getImage());
        holder.nombre.setText(producto.getNombre());
        holder.precio.setText(""+producto.getPrecioUnitario()+"€");
    }

    @Override
    public int getItemCount() {
        return listadoProducto.size();
    }
}
