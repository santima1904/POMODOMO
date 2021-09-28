package vista;

import modelo.Equipo;

import java.util.Scanner;

/**
 * Esta clase se encargara de las interacciones con  el ususario.
 * Tanto de recoger datos por teclado como de mostrar mensajes
 */
public class Menu {

    //Teclados
    public static  Scanner tecladoString = new Scanner(System.in);
    public static  Scanner tecladoInt = new Scanner(System.in);


    //Constantes
    public static final String MENSAJE_INICIAL = "Bienvenido a nuestra liga";
    public static final String MENU_INICIAL = "Que desea hacer?"+'\n'+
            "1. Introducir resultado"+'\n'+
            "2. Ver clasificacion"+'\n'+
            "3. Salir";
    public static final String EQUIPO_LOCAL = "Equipo local: ";
    public static final String GOLES_LOCAL = "Goles local: ";
    public static final String EQUIPO_VISITANTE = "Equipo visitante: ";
    public static final String GOLES_VISITANTE = "Goles visitante: ";


    //Métodos para mostrar mensajes

    /**
     * Cabecera: public static void menuInicial()
     * Descripción: método para mostrar el menú incial
     */
    public static void menuInicial(){
        System.out.println(MENSAJE_INICIAL);
        System.out.println(MENU_INICIAL);
    }



    //Métodos para recoger datos

    /**
     * Cabecera: public static int pedirOpcion()
     * Descripción: método para pedir la opción del menú principal
     */
    public static int pedirOpcion(){
        int opcion = 0;

        while(opcion!=1 && opcion != 2 && opcion != 3){
            opcion = tecladoInt.nextInt();
        }

        return opcion;
    }

    /**
     * Cabecera: public static Equipo pedirEquipoLocal()
     * Descripción: método para pedir el equipo local en una jornada
     */
    public static String pedirEquipoLocal(){

        System.out.println(EQUIPO_LOCAL);

        return tecladoString.nextLine();
    }

    /**
     * Cabecera: public static Equipo pedirEquipoVisitante()
     * Descripción: método para pedir el equipo visitante en una jornada
     */
    public static String pedirEquipoVisitante(){
        System.out.println(EQUIPO_VISITANTE);
        return tecladoString.nextLine();
    }

    /**
     * Cabecera: public static int pedirGolesLocal()
     * Descripción: método para pedir los goles del equipo local en una jornada
     */
    public static int pedirGolesLocal(){
        System.out.println(GOLES_LOCAL);
        return tecladoInt.nextInt();
    }

    /**
     * Cabecera: public static int pedirGolesVisistante()
     * Descripción: método para pedir los goles del equipo visitante en una jornada
     */
    public static int pedirGolesVisistante(){
        System.out.println(GOLES_VISITANTE);
        return tecladoInt.nextInt();
    }

    /**
     * Cabecera: public static void mostrarClasificacion(Equipo[] tabla)
     * Descripcion: Este metodo permite mostrar la clasificacion de forma ordenada
     * @param tabla
     */
    public static void mostrarClasificacion(Equipo[] tabla){

        System.out.println("           PJ  GM  GR  P");

        //Hago una condicion por equipo por temas de estetica, ya que al tener diferente numero de caracteres no queda de forma simetrica
        for (Equipo equipo : tabla) {
            if (equipo.getNombreEquipo().equals("PSG")){
                System.out.println(equipo.getNombreEquipo()+"        "+equipo.toString());

            }else if (equipo.getNombreEquipo().equals("Liverpool")){
                System.out.println(equipo.getNombreEquipo()+"  "+equipo.toString());

            }else{
                System.out.println(equipo.getNombreEquipo()+"   "+equipo.toString());
            }

        }

    }
}
