package es.iesnervion.smartinez.pruebaevaluable2t.adapters;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import es.iesnervion.smartinez.pruebaevaluable2t.R;
import es.iesnervion.smartinez.pruebaevaluable2t.models.Producto;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {

    List<Producto> listadoProducto;
    List<Producto> listadoProductosOriginal;
    private static ClickListener clickListener;

    public ProductoAdapter(List<Producto> listadoProducto) {
        this.listadoProducto = listadoProducto;
        listadoProductosOriginal = new ArrayList<>(listadoProducto);

    }

    public void setOnItemClickListener(ClickListener clickListener) {
        ProductoAdapter.clickListener = clickListener;
    }


    class ProductoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imagen;
        TextView nombre;
        TextView precio;

        public ProductoViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            imagen = itemView.findViewById(R.id.producto_image);
            nombre = itemView.findViewById(R.id.producto_nombre);
            precio = itemView.findViewById(R.id.producto_precio);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
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

    public void filtrarProductos(String texto) {
        if(texto.length() == 0){
            listadoProducto = new ArrayList<>(listadoProductosOriginal);//listaProductosAux tiene todos los productos
        }else{
            listadoProducto.clear();
            for(Producto producto : listadoProductosOriginal){
                if(producto.getNombre().toLowerCase().contains(((CharSequence) texto).toString().toLowerCase()) //Dios esta contigo
                        || String.valueOf(producto.getPrecioUnitario()).contains(((CharSequence) texto).toString().toLowerCase())){
                    listadoProducto.add(producto);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return listadoProducto.size();
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }
}
