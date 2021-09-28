package modelo;

/**
 * Clase para crear objetos equipo y guardar informacion de ellos
 */
public class Equipo {

    //Atributos

    private String nombreEquipo;
    private int partidosJugados;
    private int golesMarcados;
    private int golesRecibidos;
    private int puntos;

    //Constructores
    // Constructor con parámetros

    public Equipo(String nombreEquipo, int partidosJugados, int golesMarcados, int golesRecibidos, int puntos) {
        this.nombreEquipo = nombreEquipo;
        this.partidosJugados = partidosJugados;
        this.golesMarcados = golesMarcados;
        this.golesRecibidos = golesRecibidos;
        this.puntos = puntos;
    }

    //Constructor por defecto

    public Equipo() {
        this.nombreEquipo = "";
        this.partidosJugados = 0;
        this.golesMarcados = 0;
        this.golesRecibidos = 0;
        this.puntos = 0;
    }

    //Getters and setters

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getGolesMarcados() {
        return golesMarcados;
    }

    public void setGolesMarcados(int golesMarcados) {
        this.golesMarcados = golesMarcados;
    }

    public int getGolesRecibidos() {
        return golesRecibidos;
    }

    public void setGolesRecibidos(int golesRecibidos) {
        this.golesRecibidos = golesRecibidos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    //Métodos de la clase object
    //toString

    @Override
    public String toString() {
        return
               partidosJugados +
                "   " + golesMarcados +
                "   " + golesRecibidos +
                "   " + puntos;
    }
}
