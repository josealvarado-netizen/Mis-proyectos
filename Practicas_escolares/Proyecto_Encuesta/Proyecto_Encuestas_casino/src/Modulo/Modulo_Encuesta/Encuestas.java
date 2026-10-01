package Modulo.Modulo_Encuesta;

import java.util.List;

public interface Encuestas {

    List<Pregunta> obtenerPreguntas(List<String> juegos);

    void guardarRespuesta(String id,
                          String respuesta,
                          String fecha);


}