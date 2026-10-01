package vista;

import Controlador.Controlador_Encuesta_Admin;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.List;

public class IU_Encuestas_Admin extends Application {

    // Controlador que maneja la lógica de consultas de encuestas
    private Controlador_Encuesta_Admin controlador;

    public static void main(String[] args){

        launch();

    }

    @Override
    public void start(Stage stage){

        // Inicializa el controlador
        controlador = new Controlador_Encuesta_Admin(stage);

        // Contenedor principal
        VBox root = new VBox(20);

        root.setPadding(new Insets(20));

        root.setAlignment(Pos.TOP_CENTER);

        // Título de la ventana
        Label titulo = new Label("Encuestas por fecha");

        titulo.setFont(Font.font("Arial",24));

        // ComboBox para seleccionar fecha de encuesta
        ComboBox<String> comboFechas = new ComboBox<>();

        comboFechas.getItems().addAll(controlador.getFechas());

        comboFechas.setPromptText("Seleccione una fecha");

        // Contenedor donde se mostrarán preguntas y respuestas
        VBox vboxRespuestas = new VBox(15);

        vboxRespuestas.setPadding(new Insets(10));

        vboxRespuestas.setAlignment(Pos.TOP_LEFT);

        // Scroll para visualizar muchos resultados
        ScrollPane scrollPane = new ScrollPane(vboxRespuestas);

        scrollPane.setFitToWidth(true);

        // Botón para cerrar sesión
        Button botonSalir = new Button("Cerrar sesión");

        botonSalir.setOnAction(e->{

            controlador.regresar();

        });

        // Evento cuando se selecciona una fecha
        comboFechas.setOnAction(e->{

            // Limpia resultados anteriores
            vboxRespuestas.getChildren().clear();

            String fecha = comboFechas.getValue();

            if(fecha!=null){

                // Obtiene preguntas y respuestas de esa fecha
                List<String[]> datos =
                        controlador.getPreguntasYRespuestasPorFecha(fecha);

                // Muestra cada pregunta con su respuesta
                for(String[] pr : datos){

                    Label label = new Label(

                            "Pregunta: "+pr[0]+"\n"+
                                    "Respuesta: "+pr[1]

                    );

                    label.setFont(Font.font("Arial",16));

                    // Estilo visual del recuadro
                    label.setStyle(
                            "-fx-border-color: gray;"+
                                    "-fx-border-width:1;"+
                                    "-fx-padding:10;"
                    );

                    vboxRespuestas.getChildren().add(label);

                }

            }

        });

        // Agrega todos los elementos a la ventana
        root.getChildren().addAll(

                titulo,
                comboFechas,
                scrollPane,
                botonSalir

        );

        // Configuración de la ventana
        Scene scene = new Scene(root,800,600);

        stage.setTitle("Administrador de Encuestas");

        stage.setScene(scene);

        stage.show();

    }

}