package vista;

import Controlador.Controlador_Encuesta;
import Modulo.Modulo_Encuesta.Pregunta;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.*;

public class IU_Encuesta extends Application {

    // Controlador que maneja la lógica de la encuesta
    private Controlador_Encuesta controlador;

    // Lista de juegos seleccionados por el usuario
    private List<String> juegosSeleccionados;

    // Constructor que recibe los juegos seleccionados
    public IU_Encuesta(List<String> juegos){

        this.juegosSeleccionados=juegos;

    }

    public void start(Stage stage){

        // Inicializa el controlador
        controlador = new Controlador_Encuesta(stage);

        // Contenedor principal
        BorderPane root = new BorderPane();

        root.setPadding(new Insets(20));

        // Título de la encuesta
        Label titulo =
                new Label("Casino UAM C: Encuesta de satisfaccion");

        titulo.setFont(
                Font.font("Arial",
                        FontWeight.BOLD,26));

        root.setTop(titulo);

        // Contenedor de preguntas
        VBox contenedor = new VBox(20);

        // Obtiene las preguntas según los juegos seleccionados
        List<Pregunta> preguntas =
                controlador.getPreguntas(
                        juegosSeleccionados);

        // Fecha actual para guardar respuestas
        String fechaActual =
                LocalDate.now().toString();

        // Recorre todas las preguntas
        for(Pregunta p:preguntas){

            VBox bloque =
                    new VBox(10);

            // Texto de la pregunta
            Label texto =
                    new Label(p.getPregunta());

            bloque.getChildren()
                    .add(texto);

            // Si la pregunta es tipo SI/NO
            if(p.getTipo()
                    .equals("RADIO")){

                RadioButton si =
                        new RadioButton("Sí");

                RadioButton no =
                        new RadioButton("No");

                // Grupo para permitir solo una opción
                ToggleGroup group =
                        new ToggleGroup();

                si.setToggleGroup(group);
                no.setToggleGroup(group);

                HBox box =
                        new HBox(20,
                                si,no);

                bloque.getChildren()
                        .add(box);

                // Guarda respuesta "Si"
                si.setOnAction(e->

                        controlador
                                .guardarRespuesta(
                                        p.getId_preg(),
                                        "Si",
                                        fechaActual
                                )
                );

                // Guarda respuesta "No"
                no.setOnAction(e->

                        controlador
                                .guardarRespuesta(
                                        p.getId_preg(),
                                        "No",
                                        fechaActual
                                )
                );

            }
            else{

                // Campo de texto para respuestas abiertas
                TextField txt =
                        new TextField();

                bloque.getChildren()
                        .add(txt);

                // Guarda respuesta cuando el usuario deja el campo
                txt.focusedProperty()
                        .addListener(

                                (a,b,c)->{

                                    if(!c){

                                        controlador
                                                .guardarRespuesta(
                                                        p.getId_preg(),
                                                        txt.getText(),
                                                        fechaActual
                                                );

                                    }

                                }

                        );

            }

            contenedor.getChildren()
                    .add(bloque);

        }

        // Scroll para visualizar todas las preguntas
        ScrollPane scroll =
                new ScrollPane();

        scroll.setContent(contenedor);

        root.setCenter(scroll);

        // Botón para finalizar encuesta
        Button finalizar =
                new Button("Finalizar");

        finalizar.setOnAction(e->{

            // Mensaje de confirmación
            Alert a =
                    new Alert(
                            Alert.AlertType.INFORMATION);

            a.setContentText(
                    "Encuesta guardada");

            a.showAndWait();

            // Regresa a la pantalla anterior
            controlador
                    .volverseleccion();

        });

        root.setBottom(finalizar);

        // Configuración de ventana
        Scene scene =
                new Scene(root,800,600);

        stage.setScene(scene);

        stage.show();

    }

}