package Controlador;

import Modulo.Modulo_Encuesta.*;

import javafx.stage.Stage;

import vista.IU_Seleccion_juegos;

import java.util.*;

public class Controlador_Encuesta {

    // Objeto que gestiona la lógica de la encuesta
    private Gestor_Encuesta gestor;

    // Referencia a la ventana principal
    private Stage stage;

    // Constructor que inicializa el gestor y recibe el stage
    public Controlador_Encuesta(Stage stage){

        gestor=new Gestor_Encuesta();

        this.stage=stage;

    }

    // Obtiene las preguntas dependiendo de los juegos seleccionados
    public List<Pregunta> getPreguntas(
            List<String> juegos){

        return gestor.obtenerPreguntas(juegos);

    }

    // Guarda la respuesta del usuario junto con la fecha
    public void guardarRespuesta(
            String id,
            String respuesta,
            String fecha){

        gestor.guardarRespuesta(
                id,
                respuesta,
                fecha);

    }

    // Permite regresar a la pantalla de selección de juegos
    public void volverseleccion(){

        try{

            IU_Seleccion_juegos sel=
                    new IU_Seleccion_juegos();

            sel.start(stage);

        }

        catch(Exception e){

            // Muestra el error si falla el cambio de ventana
            e.printStackTrace();

        }

    }

}