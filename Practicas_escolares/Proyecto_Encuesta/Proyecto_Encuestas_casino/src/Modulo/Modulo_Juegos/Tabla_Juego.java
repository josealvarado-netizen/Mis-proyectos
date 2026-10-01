package Modulo.Modulo_Juegos;

import java.util.ArrayList;
import java.util.List;

public class Tabla_Juego {

    // Lista donde se almacenan los juegos disponibles
    private List<juego> juegos;

    // Constructor que inicializa la lista y carga los juegos
    public Tabla_Juego(){

        juegos = new ArrayList<>();

        inicializartablajuego();

    }

    // Método que agrega los juegos iniciales a la lista
    private void  inicializartablajuego(){

        juegos.add(new juego("0001", "Poker"));

        juegos.add((new juego("0002", "Ruleta")));

        juegos.add((new juego("0003", "BlackJ")));

    }

    // Método que devuelve la lista de juegos
    public List<juego> getJuegos(){

        return juegos;

    }

}