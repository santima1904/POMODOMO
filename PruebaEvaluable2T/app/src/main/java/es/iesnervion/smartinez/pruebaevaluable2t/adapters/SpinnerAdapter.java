package es.iesnervion.smartinez.pruebaevaluable2t.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class SpinnerAdapter extends BaseAdapter implements android.widget.SpinnerAdapter {

    //Constantes
    public final String FILTRADO_CATEGORIA = "Categoria";
    public final String FILTRADO_NOMBRE_ASC = "Nombre asc";
    public final String FILTRADO_NOMBRE_DESC = "Nombre desc";
    public final String FILTRADO_PRECIO_ASC = "Precio asc";
    public final String FILTRADO_PRECIO_DESC = "Precio desc";

    //Propiedades
    Context contextAdapter;
    String[] parametrosFiltrado = {FILTRADO_CATEGORIA, FILTRADO_NOMBRE_ASC, FILTRADO_NOMBRE_DESC, FILTRADO_PRECIO_ASC, FILTRADO_PRECIO_DESC};


    //Constructor
    public SpinnerAdapter(Context context) {
        contextAdapter = context;
    }

    @Override
    public int getCount() {
        return parametrosFiltrado.length;
    }

    @Override
    public Object getItem(int position) {
        return parametrosFiltrado[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder holder;
        View row = convertView;


        if (row == null){
            LayoutInflater inflater = (LayoutInflater) contextAdapter.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);
            holder = new ViewHolder((TextView) row.findViewById(android.R.id.text1));
            row.setTag(holder);
        }else{
            holder = (ViewHolder) row.getTag();
        }
        holder.getFiltrado().setText(parametrosFiltrado[position]);

        return row;
    }

}

class ViewHolder{
    TextView filtrado;

    public ViewHolder(TextView filtrado) {
        this.filtrado = filtrado;
    }

    public TextView getFiltrado() {
        return filtrado;
    }

    public void setFiltrado(TextView filtrado) {
        this.filtrado = filtrado;
    }
}
