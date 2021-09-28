package controlador;

import modelo.Equipo;
import vista.Menu;


/**
 * Clase para realizar las funciones generales del programa
 * Esta clase usa metodos de diferentes clases
 */

public class Gestora{

    /**
     * Cabecera: public static Equipo[] ordenarTabla(Equipo[] tabla)
     * Descripcion: Metodo para ordenar la array con los equipos segun los puntos de cada uno
     * Precondiciones: Array de equipos no nula
     * Postcondiciones: Array ordenada
     *
     * Entradas: Equipo[] tabla
     * Salidas: tabla
     * @param tabla
     * @return
     */
    public static Equipo[] ordenarTabla(Equipo[] tabla){

        Equipo auxiliar;
        int puntoReferencia = 0;

        puntoReferencia = tabla[0].getPuntos();//Cojo como referencia los puntos del primer equipo en la tabla

        for (int i = 0; i < tabla.length; i++) {//Recorro la tabla equipo por equipo, si el el equipo tiene mas puntos que la referencia,
                                                //lo adelanto un puesto en la clasificacion,
                                                //esto se hara hasta que no pueda subir mas, ya que el siguiente tendra mas puntos, o simplemente ya es el primero
            if (tabla[i].getPuntos() >= puntoReferencia && i!=0){
                  auxiliar = tabla[i-1];
                  tabla[i-1] = tabla[i];
                  tabla[i] = auxiliar;
            }

        }

        return tabla;
    }


    /**
     * Cabecera: public static void almacenarResultado(Equipo[] tabla)
     * Descripcion: Metodo para almacenar los resultados introducidos por el usuario previamente
     * Precondiciones: Array de equipos no nula
     * Postcondiciones: Clasificacion actualizada
     *
     * Entradas: Equipo[] tabla
     * Salidas: ninguna
     * @param tabla
     */
    public static void almacenarResultado(Equipo[] tabla){

        String nombreEquipoLocal, nombreEquipoVisitante;
        int golesLocal, golesVisi;

        //Aqui recojon todos los datos del usuario con metodos de la clase menu
        nombreEquipoLocal =  Menu.pedirEquipoLocal();
        nombreEquipoVisitante =  Menu.pedirEquipoVisitante();
        golesLocal = Menu.pedirGolesLocal();
        golesVisi = Menu.pedirGolesVisistante();

        //Hago la actualizacion en las diferentes situaciones que se pueden dar
        if (golesLocal == golesVisi){
           actualizarClasificacionEmpate(nombreEquipoLocal, nombreEquipoVisitante, golesLocal, golesVisi, tabla);

        }else if (golesLocal > golesVisi){
            actualizarClasificacionVictoria(nombreEquipoLocal, nombreEquipoVisitante, golesLocal, golesVisi, tabla);

        }else {
            actualizarClasificacionDerrota(nombreEquipoLocal, nombreEquipoVisitante, golesLocal, golesVisi, tabla);

        }

    }


    /**
     * Cabecera: private static int buscarEquipoNombre(String nombre, Equipo[] tabla)
     * Descripcion: Metodo para buscar un equipo en la tabla segun su nombre
     * Precondiciones: Array de equipos no nula
     * Postcondiciones: encontrado el equipo
     *
     * Entradas: Equipo[] tabla, String nombre
     * Salidas: int indice
     *
     * @param tabla, nombre
     * @return indice
     */
    private static int buscarEquipoNombre(String nombre, Equipo[] tabla){
        int indice = 0;

        for (int i = 0; i < tabla.length; i++){
            if (tabla[i].getNombreEquipo().equals(nombre)){
                indice = i;
                i = 5;//le doy un valor que le permita salir del bucle
            }
        }

        return indice;
    }


    /**
     * Cabecera: private static void actualizarClasificacionEmpate(String nombreLocal, String nombreVisi, int golesLocal, int golesVisi, Equipo[] tabla)
     * Descripcion: Metodo para actualizar la clasificacion segun el resultado introducido, en este caso es si hay empate
     * Precondiciones: Array de equipos no nula
     * Postcondiciones: Clasificacion actualizada
     *
     * Entradas: String nombreLocal, String nombreVisi, int golesLocal, int golesVisi, Equipo[] tabla
     * Salidas: ninguna
     * @param  nombreLocal, nombreVisi, golesLocal, golesVisi, tabla
     */
    private static void actualizarClasificacionEmpate(String nombreLocal, String nombreVisi, int golesLocal, int golesVisi, Equipo[] tabla){

            tabla[buscarEquipoNombre(nombreLocal, tabla)].setPuntos(tabla[buscarEquipoNombre(nombreLocal, tabla)].getPuntos()+1);
            tabla[buscarEquipoNombre(nombreVisi, tabla)].setPuntos(tabla[buscarEquipoNombre(nombreVisi, tabla)].getPuntos()+1);
            actualizarComun(nombreLocal, nombreVisi, golesLocal, golesVisi, tabla);

    }

    /**
     * Cabecera: private static void actualizarClasificacionVictoria(String nombreLocal, int golesLocal, int golesVisi, Equipo[] tabla)
     * Descripcion: Metodo para actualizar la clasificacion segun el resultado introducido, en este caso es si hay victoria local
     * Precondiciones: Array de equipos no nula
     * Postcondiciones: Clasificacion actualizada
     *
     * Entradas: String nombreLocal, String nombreVisi, int golesLocal, int golesVisi, Equipo[] tabla
     * Salidas: ninguna
     * @param  nombreLocal, nombreVisi, golesLocal, golesVisi, tabla
     */
    private static void actualizarClasificacionVictoria(String nombreLocal, String nombreVisi, int golesLocal, int golesVisi, Equipo[] tabla){

        tabla[buscarEquipoNombre(nombreLocal, tabla)].setPuntos(tabla[buscarEquipoNombre(nombreLocal, tabla)].getPuntos()+3);
        actualizarComun(nombreLocal, nombreVisi, golesLocal, golesVisi, tabla);

    }

    /**
     * Cabecera: private static void actualizarClasificacionDerrota(String nombreVisi, int golesLocal, int golesVisi, Equipo[] tabla)
     * Descripcion: Metodo para actualizar la clasificacion segun el resultado introducido, en este caso es si hay derrota local
     * Precondiciones: Array de equipos no nula
     * Postcondiciones: Clasificacion actualizada
     *
     * Entradas: String nombreLocal, String nombreVisi, int golesLocal, int golesVisi, Equipo[] tabla
     * Salidas: ninguna
     * @param  nombreLocal, nombreVisi, golesLocal, golesVisi, tabla
     */
    private static void actualizarClasificacionDerrota(String nombreLocal, String nombreVisi, int golesLocal, int golesVisi, Equipo[] tabla){

        tabla[buscarEquipoNombre(nombreVisi, tabla)].setPuntos(tabla[buscarEquipoNombre(nombreVisi, tabla)].getPuntos()+3);
        actualizarComun(nombreLocal, nombreVisi, golesLocal, golesVisi, tabla);

    }


    /**
     * Cabecera: private static void actualizarComun(String nombreLocal, String nombreVisi, int golesLocal, int golesVisi, Equipo[] tabla)
     * Descripcion: Metodo para modularizar el codigo de metodos anteriores y evitar la duplicidad
     * Precondiciones: Array de equipos no nula
     * Postcondiciones: Clasificacion actualizada
     *
     * Entradas: String nombreLocal, String nombreVisi, int golesLocal, int golesVisi, Equipo[] tabla
     * Salidas: ninguna
     * @param  nombreLocal, nombreVisi, golesLocal, golesVisi, tabla
     */
    private static void actualizarComun(String nombreLocal, String nombreVisi, int golesLocal, int golesVisi, Equipo[] tabla){
        tabla[buscarEquipoNombre(nombreVisi, tabla)].setGolesMarcados(tabla[buscarEquipoNombre(nombreVisi, tabla)].getGolesMarcados()+golesVisi);
        tabla[buscarEquipoNombre(nombreVisi, tabla)].setGolesRecibidos(tabla[buscarEquipoNombre(nombreVisi, tabla)].getGolesRecibidos()+golesLocal);
        tabla[buscarEquipoNombre(nombreLocal, tabla)].setGolesMarcados(tabla[buscarEquipoNombre(nombreLocal, tabla)].getGolesMarcados()+golesLocal);
        tabla[buscarEquipoNombre(nombreLocal, tabla)].setGolesRecibidos(tabla[buscarEquipoNombre(nombreLocal, tabla)].getGolesRecibidos()+golesVisi);
        tabla[buscarEquipoNombre(nombreLocal, tabla)].setPartidosJugados(tabla[buscarEquipoNombre(nombreLocal, tabla)].getPartidosJugados()+1);
        tabla[buscarEquipoNombre(nombreVisi, tabla)].setPartidosJugados(tabla[buscarEquipoNombre(nombreVisi, tabla)].getPartidosJugados()+1);
    }


}

