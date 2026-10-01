package Controlador;

import Modulo.Modulo_Encuesta.Gestor_Encuesta_Admin;

import javafx.stage.Stage;
import vista.IU_Principal;

import java.util.List;

public class Controlador_Encuesta_Admin {

    // Objeto que gestiona la lógica de la encuesta para el administrador
    private Gestor_Encuesta_Admin gestor;

    // Referencia a la ventana principal
    private Stage stagePrincipal;

    // Constructor que inicializa el gestor y recibe el stage principal
    public Controlador_Encuesta_Admin(Stage stage){

        gestor = new Gestor_Encuesta_Admin();

        this.stagePrincipal = stage;

    }

    // Obtiene las fechas en las que existen respuestas registradas
    public List<String> getFechas(){

        return gestor.obtenerFechasDisponibles();

    }

    // Obtiene las preguntas y respuestas registradas en una fecha específica
    public List<String[]> getPreguntasYRespuestasPorFecha(String fecha){

        return gestor.obtenerPreguntasYRespuestasPorFecha(fecha);

    }

    // Permite regresar a la pantalla principal del sistema
    public void regresar(){

        try{

            IU_Principal principal = new IU_Principal();

            principal.start(stagePrincipal);

        }catch(Exception e){

            // Muestra el error si falla el cambio de ventana
            e.printStackTrace();

        }

    }

}