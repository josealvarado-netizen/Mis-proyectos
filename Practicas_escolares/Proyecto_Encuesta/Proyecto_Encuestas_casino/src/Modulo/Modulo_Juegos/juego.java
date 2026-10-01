package Modulo.Modulo_Juegos;

public class juego {

    // Atributos del juego (id y nombre)
    private String id_Juego;
    private String nombreJuego;

    // Constructor para crear un objeto juego
    public juego( String id_Juego, String nombreJuego){

        this.id_Juego  = id_Juego;
        this.nombreJuego = nombreJuego;

    }

    // Método para obtener el id del juego
    public String getId_Juego() {

        return id_Juego;

    }

    // Método para modificar el id del juego
    public void setId_Juego(String id_Juego) {

        this.id_Juego = id_Juego;

    }

    // Método para obtener el nombre del juego
    public String getNombreJuego() {

        return nombreJuego;

    }

    // Método para modificar el nombre del juego
    public void setNombreJuego(String nombreJuego) {

        this.nombreJuego = nombreJuego;

    }
}