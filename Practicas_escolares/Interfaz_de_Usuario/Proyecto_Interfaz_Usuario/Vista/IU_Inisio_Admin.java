package Proyecto.Vista;

import Proyecto.Controlador.Controlador_IS_Admin;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class IU_Inisio_Admin extends Application {

    public static void main(String[] args) {
        // Método launch() inicia la aplicación JavaFX
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Crear el controlador
        Controlador_IS_Admin controlador = new Controlador_IS_Admin();

        // Crear el GridPane y agregar los controles
        GridPane gridPane = createPane();
        agregarControles(gridPane, controlador, stage);

        // Crear la escena
        Scene scene = new Scene(gridPane, 800, 600);

        // Configurar el título y la escena del stage
        stage.setTitle("Inicio de sesión Admin");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane createPane() {
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(500, 300);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }

    private void agregarControles(GridPane gridPane, Controlador_IS_Admin controlador, Stage primaryStage) {
        // Etiquetas y campos de texto
        Text textusuario = new Text("Usuario:");
        textusuario.setFont(Font.font("Arial", FontWeight.BLACK, 20));
        TextField textFieldUsuario = new TextField();
        textFieldUsuario.setPrefWidth(300);
        textFieldUsuario.setPrefHeight(45);

        Text textContraseña = new Text("Contraseña:");
        textContraseña.setFont(Font.font("Arial", FontWeight.BLACK, 20));
        PasswordField passwordFieldCont = new PasswordField();
        passwordFieldCont.setPrefWidth(300);
        passwordFieldCont.setPrefHeight(45);

        // Botón de acceso
        Button buttonAcceder = new Button("Acceder");
        buttonAcceder.setPrefWidth(150);
        buttonAcceder.setPrefHeight(45);
        buttonAcceder.setStyle("-fx-background-color: orange");

        // Acción del botón
        buttonAcceder.setOnAction(e -> {
            String usuario = textFieldUsuario.getText();
            String contraseña = passwordFieldCont.getText();

            if (controlador.validarCredenciales(usuario, contraseña)) {
                System.out.println("Acceso concedido.");

                // Cerrar la ventana actual y abrir la IU_Informacion_Admin
                IU_Informacion_Admin iuInformacionAdmin = new IU_Informacion_Admin();
                try {
                    primaryStage.close(); // Cerrar la ventana de inicio de sesión
                    iuInformacionAdmin.start(new Stage()); // Abrir la nueva ventana
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Acceso denegado.");
            }
        });

        // Agregar controles al grid
        gridPane.add(textusuario, 0, 0);
        gridPane.add(textFieldUsuario, 1, 0);
        gridPane.add(textContraseña, 0, 1);
        gridPane.add(passwordFieldCont, 1, 1);
        gridPane.add(buttonAcceder, 1, 2);
    }
}
