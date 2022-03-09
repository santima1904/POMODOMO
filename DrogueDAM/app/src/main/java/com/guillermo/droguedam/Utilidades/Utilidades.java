package com.guillermo.droguedam.Utilidades;

import static android.content.Context.MODE_PRIVATE;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.guillermo.droguedam.Objetos.ClsProducto;
import com.guillermo.droguedam.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

public class Utilidades {

    /**
     * Metemos a mano los datos para la lista, pero se deberian coger de base de datos.
     * @return lista de productos.
     */
    public static ArrayList<ClsProducto> generarListaProductos(){
        ArrayList<ClsProducto> lista = new ArrayList<>();

        lista.add(new ClsProducto(R.drawable.higiene1, "Desorodante", 100, 1.50, "0001", "Higiene"));
        lista.add(new ClsProducto(R.drawable.higiene2,"Compresas", 100, 3.50, "0002", "Higiene"));
        lista.add(new ClsProducto(R.drawable.higiene3,"Tricovel Energy", 100, 4.00, "0003", "Higiene"));
        lista.add(new ClsProducto(R.drawable.higiene4,"Colgate pasta", 100, 0.50, "0004", "Higiene"));
        lista.add(new ClsProducto(R.drawable.higiene5,"Listerine", 100, 1.5, "0005", "Higiene"));
        lista.add(new ClsProducto(R.drawable.limpieza1,"Kiko limpiador", 100, 0.25, "0006", "Limpieza"));
        lista.add(new ClsProducto(R.drawable.limpieza2,"Clorox chupito", 100, 7.5, "0007", "Limpieza"));
        lista.add(new ClsProducto(R.drawable.limpieza4,"KH7 Limpiador", 100, 17.5, "0008", "Limpieza"));
        lista.add(new ClsProducto(R.drawable.limpieza5,"Limpia manos", 100, 12.5, "0009", "Limpieza"));
        lista.add(new ClsProducto(R.drawable.perfume1,"Colonia CK", 100, 11.30, "00010", "Perfume"));
        lista.add(new ClsProducto(R.drawable.perfume2,"Colonia 1 Million", 100, 1.5, "00011", "Perfume"));
        lista.add(new ClsProducto(R.drawable.perfume3,"Channel N5", 100, 1.5, "00012", "Perfume"));
        lista.add(new ClsProducto(R.drawable.perfume4,"Colonia rosa", 100, 6.5, "00013", "Perfume"));
        lista.add(new ClsProducto(R.drawable.perfume5,"Colonia negra", 100, 6.0, "00014", "Perfume"));

        return lista;
    }

    /**
     * Contenido de la lista para ordenar.
     * @return Lista con las etiquetas apra ordenar
     */
    public static ArrayList<String> generarListaOrdenar(){
        ArrayList<String> lista = new ArrayList<>();

        lista.add("Ordenar por");
        lista.add("Precio mayor a menor");
        lista.add("Precio menor a mayor");
        lista.add("Alfabetico a-Z");
        lista.add("Alfabetico z-A");

        return lista;
    }

    /**
     * Contenido apra las categorias
     * @return Lista con las etiquetas para filtrar.
     */
    public static ArrayList<String> generarListaCategorias(){
        ArrayList<String> lista = new ArrayList<>();

        lista.add("Filtrar por");
        lista.add("Higiene");
        lista.add("Hogar");
        lista.add("Perfumeria");

        return lista;
    }

    /**
     * Obtenemos la lista de productos que tuvieramos almacenados en el dispositivo
     */
    public static ArrayList<ClsProducto> obtenerListaProductosAlmacenada(Context context){
        ArrayList<ClsProducto> listaProductosSeleccionados;
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constantes.SP_PRODUCTOS_SELECCIONADOS, MODE_PRIVATE);
        String json = sharedPreferences.getString(Constantes.PRODUCTOS, null);
        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<ClsProducto>>() {}.getType();
        listaProductosSeleccionados = gson.fromJson(json, type);

        if(listaProductosSeleccionados == null){
            listaProductosSeleccionados = new ArrayList<>();
        }

        return listaProductosSeleccionados;
    }

    /**
     * Almacena la lista de productos seleccionados
     * @param context Contexto.
     * @param lista Lista para almacenar
     */
    public static void almacenarDatos(Context context, ArrayList<ClsProducto> lista){
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constantes.SP_PRODUCTOS_SELECCIONADOS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //Metemos los productos seleccionados
        String json = gson.toJson(lista);
        editor.putString(Constantes.PRODUCTOS, json);
        editor.apply();
    }

    /**
     * Comprueba si un producto ya se encuentra añadido a la cesta
     * @param lista Lista de pedidos
     * @param ref num referencia del producto
     * @return True en caso de existir, false en caso contrario.
     */
    public static boolean comprobarProductoExistente(ArrayList<ClsProducto> lista, String ref){
        boolean existe = false;

        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getNumReferencia().equals(ref)){
                existe = true;
                break;
            }
        }

        return existe;
    }

    /**
     * Actualiza el nombre de usuario
     */
    public static void actualizarNombreUsuario(Context context, String nombre){
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constantes.DATOS_USUARIO, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //Actualizamos el nombre de usuario
        editor.putString(Constantes.NOMBRE, nombre);
        editor.apply();
    }

    /**
     * Ordena la lista segun el precio de mayor a menor
     * @param lista lista a ordenar
     */
    public static void ordenarPrecioMayorMenor(ArrayList<ClsProducto> lista){
        //Ordenamos por fecha, asi la mas reciente sale primero
        Collections.sort(lista, (o1, o2) -> {
            int resultado = 0;

            if(o1.getPrecio() > o2.getPrecio()){
                resultado = -1;
            }else if(o1.getPrecio() < o2.getPrecio()){
                resultado = 1;
            }

            return resultado;
        });
    }

    /**
     * Ordena la lista segun el precio de menor a mayor
     * @param lista lista a ordenar.
     */
    public static void ordenarPrecioMenorMayor(ArrayList<ClsProducto> lista){
        //Ordenamos por fecha, asi la mas reciente sale primero
        Collections.sort(lista, (o1, o2) -> {
            int resultado = 0;

            if(o1.getPrecio() > o2.getPrecio()){
                resultado = 1;
            }else if(o1.getPrecio() < o2.getPrecio()){
                resultado = -1;
            }

            return resultado;
        });
    }

    /**
     * la lista alfabeticamente de la a-Z
     * @param lista lista a ordenar.
     */
    public static void ordenarAlfabeticamenteAZ(ArrayList<ClsProducto> lista){
        //Ordenamos por fecha, asi la mas reciente sale primero
        Collections.sort(lista, (o1, o2) -> o1.getNombre().compareTo(o2.getNombre()));
    }

    /**
     * Ordena la lista alfabeticamente de la z-A
     * @param lista lista a ordenar.
     */
    public static void ordenarAlfabeticamenteZA(ArrayList<ClsProducto> lista){
        //Ordenamos por fecha, asi la mas reciente sale primero
        Collections.sort(lista, (o1, o2) -> o2.getNombre().compareTo(o1.getNombre()));
    }

    /**
     * Genera una lista con los objetos ClsProduco que cumplan con el tipo de producto
     * @param lista Lista a filtrar.
     * @param filtro Tipo de producto.
     * @return Lista filtrada.
     */
    public static ArrayList<ClsProducto> realizarFiltrado(ArrayList<ClsProducto> lista, String filtro){
        ArrayList<ClsProducto> listaProductos = new ArrayList<>();

        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getTipoProducto().equals(filtro)){
                listaProductos.add(lista.get(i));
            }
        }

        return listaProductos;
    }

}
