package Modulo.Modulo_Encuesta;

import java.util.List;

public class Gestor_Encuesta_Admin implements Encuestas_Admin{

    // Objeto que permite acceder a las respuestas de la encuesta para el administrador
    private Tabla_Respuestas_Admin tabla;

    // Constructor que inicializa la tabla de respuestas
    public Gestor_Encuesta_Admin(){

        tabla = new Tabla_Respuestas_Admin();

    }

    // Obtiene las fechas en las que existen respuestas registradas
    @Override
    public List<String> obtenerFechasDisponibles(){

        return tabla.obtenerFechas();

    }

    // Obtiene las preguntas y respuestas correspondientes a una fecha específica
    @Override
    public List<String[]> obtenerPreguntasYRespuestasPorFecha(String fecha){

        return tabla.obtenerPreguntasRespuestas(fecha);

    }

}