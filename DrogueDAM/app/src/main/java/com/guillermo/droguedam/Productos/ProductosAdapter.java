package com.guillermo.droguedam.Productos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.guillermo.droguedam.Objetos.ClsProducto;
import com.guillermo.droguedam.R;
import java.util.ArrayList;

public class ProductosAdapter extends RecyclerView.Adapter {

    private static ClickListener clickListener;
    private final ArrayList<ClsProducto> listaProductos;
    private final Context context;

    public ProductosAdapter(ArrayList<ClsProducto> listaProductos, Context context) {
        this.listaProductos = listaProductos;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row=inflater.inflate(R.layout.custom_row_demo, parent, false);
        return new ProductoVH(row);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ClsProducto producto = listaProductos.get(position);
        ProductoVH vh = (ProductoVH) holder;

        vh.imagen.setImageResource(producto.getImagen());
        vh.nombre.setText(producto.getNombre());
        vh.precio.setText(producto.getPrecio() + "€");
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public static class ProductoVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imagen;
        TextView nombre, precio;
        Button anadir;

        public ProductoVH(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imagen = itemView.findViewById(R.id.imageViewThumbnail);
            nombre = itemView.findViewById(R.id.nombreProducto);
            precio = itemView.findViewById(R.id.precioProducto);
            anadir = itemView.findViewById(R.id.addToCart);
            anadir.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        ProductosAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }
}
