package Modulo.Modulo_Encuesta;

import java.util.*;

public class Gestor_Encuesta implements Encuestas{

    // Objeto que gestiona la obtención de preguntas desde la base de datos
    private Tabla_Preguntas tablaPreguntas;

    // Objeto que gestiona el guardado de respuestas
    private Tabla_Respuesta tablaRespuesta;

    // Constructor que inicializa las tablas de preguntas y respuestas
    public Gestor_Encuesta(){

        tablaPreguntas=new Tabla_Preguntas();

        tablaRespuesta=new Tabla_Respuesta();

    }

    // Obtiene las preguntas según los juegos seleccionados
    public List<Pregunta> obtenerPreguntas(
            List<String> juegos){

        return tablaPreguntas
                .obtenerPreguntas(juegos);

    }

    // Guarda la respuesta de una pregunta junto con la fecha
    public void guardarRespuesta(
            String id,
            String respuesta,
            String fecha){

        tablaRespuesta
                .guardarRespuesta(
                        id,
                        respuesta,
                        fecha);

    }

}