package Modulo.Modulo_Encuesta;

import java.util.List;

public interface Encuestas_Admin {

    List<String> obtenerFechasDisponibles();

    List<String[]> obtenerPreguntasYRespuestasPorFecha(String fecha);

}