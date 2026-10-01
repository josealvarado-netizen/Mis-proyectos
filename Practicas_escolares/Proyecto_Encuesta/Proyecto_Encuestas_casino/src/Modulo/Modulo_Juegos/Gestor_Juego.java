package Modulo.Modulo_Juegos;

import java.util.List;

public class Gestor_Juego {

    // Objeto que permite acceder a los datos de los juegos
    private Tabla_Juego tabla;

    // Constructor que inicializa la tabla de juegos
    public Gestor_Juego(){
        tabla = new Tabla_Juego();
    }

    // Método que obtiene la lista de juegos disponibles
    public List<juego> obtenerJuegos(){

        // Llama al método de la tabla para obtener los juegos
        return tabla.getJuegos();

    }

}