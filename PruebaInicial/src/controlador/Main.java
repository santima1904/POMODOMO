package controlador;

import modelo.Equipo;
import vista.Menu;

public class Main {
    public static void main(String[] args) {

        //Creo los equipos
        Equipo Liverpool = new Equipo("Liverpool", 0, 0, 0, 0);
        Equipo PSG = new Equipo("PSG", 0, 0, 0, 0);
        Equipo Dortmund = new Equipo("Dortmund", 0, 0, 0, 0);
        Equipo Juventus = new Equipo("Juventus", 0, 0, 0, 0);

        //Array con los equipos
        Equipo [] clasificacion = new Equipo[4];

        //Lleno la array
        clasificacion [0] = Liverpool;
        clasificacion [1] = PSG;
        clasificacion [2] = Dortmund;
        clasificacion [3] = Juventus;

        //Variables
        int opcionMenu = 1;

        //Comienzo de programa

        while(opcionMenu == 1 || opcionMenu == 2){
            Menu.menuInicial();
            opcionMenu = Menu.pedirOpcion();

            switch (opcionMenu){

                case 1:
                    Gestora.almacenarResultado(clasificacion);
                    break;

                case 2:
                    Menu.mostrarClasificacion(Gestora.ordenarTabla(clasificacion));
                    break;
            }

            System.out.println(" ");
            System.out.println("----------------------------------------");
            //Estas lineas son para dejar un espacio y dar mas sensacion de limpieza
        }



    }
}
