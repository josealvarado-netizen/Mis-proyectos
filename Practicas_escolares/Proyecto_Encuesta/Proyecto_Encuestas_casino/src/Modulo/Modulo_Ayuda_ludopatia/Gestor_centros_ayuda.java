package Modulo.Modulo_Ayuda_ludopatia;

import java.util.List;

public class Gestor_centros_ayuda implements Centro_ayuda{

    // Objeto que permite acceder a los datos de los centros de ayuda
    private Tabla_Centros tabla;

    // Constructor que inicializa la tabla de centros
    public Gestor_centros_ayuda(){

        tabla = new Tabla_Centros();

    }

    // Método que obtiene la lista de centros de ayuda
    @Override
    public List<Informacion> obtenerCentros(){

        return tabla.obtenerCentros();

    }

}