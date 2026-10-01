package vista;

import Controlador.Controlador_Principal;
import Modulo.Modulo_Aviso_privacidad.Aviso_privasidad;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class IU_Principal extends Application {

    public static void main(String[] args) {

        launch(args);

    }

    // Controlador principal de la aplicación
    private Controlador_Principal controlador;

    @Override
    public void start(Stage stage) {

        // Inicializa el controlador
        controlador = new Controlador_Principal(stage);

        // Layout principal
        BorderPane root = new BorderPane();

        root.setPadding(new Insets(20));

        // Título de la ventana
        Label titulo = new Label("Bienvenido al casino UAMI");

        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 28));

        BorderPane.setAlignment(titulo, Pos.CENTER);

        root.setTop(titulo);

        // Área donde se muestra el aviso de privacidad
        TextArea terminos = new TextArea();

        terminos.setWrapText(true);

        terminos.setEditable(false);

        terminos.setPrefWidth(400);

        terminos.setPrefHeight(400);

        // Obtiene el aviso de privacidad
        Aviso_privasidad aviso = controlador.buscarAviso(1);

        // Muestra el aviso si existe
        if (aviso != null) {

            terminos.setText(aviso.getAviso());

        }

        root.setLeft(terminos);

        // Panel de botones (login y registro)
        VBox panelBotones = new VBox(15);

        panelBotones.setAlignment(Pos.CENTER);

        // Botón para ir a inicio de sesión
        Button botonInicio = new Button("Inicio de sesión");

        botonInicio.setPrefWidth(180);

        botonInicio.setOnAction(e -> controlador.IU_Inicio_sec());

        // Botón para ir a registro
        Button botonRegistro = new Button("Registro");

        botonRegistro.setPrefWidth(180);

        botonRegistro.setOnAction(e -> controlador.IU_Reg());

        panelBotones.getChildren().addAll(botonInicio, botonRegistro);

        root.setRight(panelBotones);

        // Configuración de la ventana
        Scene scene = new Scene(root, 900, 600);

        stage.setTitle("Inicio");

        stage.setScene(scene);

        stage.show();

    }

}