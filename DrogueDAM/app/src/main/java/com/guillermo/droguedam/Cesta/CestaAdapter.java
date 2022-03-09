package com.guillermo.droguedam.Cesta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.guillermo.droguedam.Objetos.ClsProducto;
import com.guillermo.droguedam.R;
import java.util.ArrayList;

public class CestaAdapter extends RecyclerView.Adapter{
    private final ArrayList<ClsProducto> listaProductos;
    private final Context context;

    public CestaAdapter(ArrayList<ClsProducto> listaProductos, Context context) {
        this.listaProductos = listaProductos;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row=inflater.inflate(R.layout.row_cesta, parent, false);
        return new CestaAdapter.CestaVH(row);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ClsProducto producto = listaProductos.get(position);
        CestaAdapter.CestaVH vh = (CestaAdapter.CestaVH) holder;

        vh.imagen.setImageResource(producto.getImagen());
        vh.nombre.setText(producto.getNombre());
        vh.precio.setText(producto.getPrecio() + "€");
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public static class CestaVH extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView nombre, precio;

        public CestaVH(View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagenCesta);
            nombre = itemView.findViewById(R.id.nombreCesta);
            precio = itemView.findViewById(R.id.precioCesta);
        }

    }
}
