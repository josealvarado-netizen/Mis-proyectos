package Proyecto.Vista;

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
import Proyecto.Controlador.Controlador_IS;
import Proyecto.Modulo.Gestor_IS;

public class IU_Inisio_Sesion extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        // Crear el gestor y el controlador
        Gestor_IS gestor = new Gestor_IS();
        Controlador_IS controlador = new Controlador_IS(gestor);

        // Crear GridPane
        GridPane gridPane = createPane();
        agregarControles(gridPane, controlador, stage);

        // Configurar la escena
        Scene scene = new Scene(gridPane, 800, 600);
        stage.setTitle("Inicio de sesión");
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

    private void agregarControles(GridPane gridPane, Controlador_IS controlador, Stage primaryStage) {
        // Etiquetas y campos de texto
        Text textusuario = new Text("Correo:");
        textusuario.setFont(Font.font("Arial", FontWeight.BLACK, 20));
        TextField textFieldCorreo = new TextField();
        textFieldCorreo.setPrefWidth(300);
        textFieldCorreo.setPrefHeight(45);

        Text textContraseña = new Text("Contraseña:");
        textContraseña.setFont(Font.font("Arial", FontWeight.BLACK, 20));
        PasswordField passwordFieldCont = new PasswordField();
        passwordFieldCont.setPrefWidth(300);
        passwordFieldCont.setPrefHeight(45);

        // Botón de acceso
        Button buttonAcceso = new Button("Acceder");
        buttonAcceso.setPrefWidth(150);
        buttonAcceso.setPrefHeight(45);
        buttonAcceso.setStyle("-fx-background-color: orange");

        // Acción del botón
        buttonAcceso.setOnAction(e -> {
            String correo = textFieldCorreo.getText();
            String contrasena = passwordFieldCont.getText();

            if (controlador.verificarUsuario(correo, contrasena)) {
                System.out.println("Acceso permitido. Usuario encontrado.");

                // Cerrar la ventana actual y abrir IU_Informacion
                IU_Informacion iuInformacion = new IU_Informacion();
                try {
                    primaryStage.close(); // Cerrar la ventana de inicio de sesión
                    iuInformacion.start(new Stage()); // Abrir la nueva interfaz
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Acceso denegado. Usuario no encontrado.");
            }
        });

        // Agregar controles al grid
        gridPane.add(textusuario, 0, 0);
        gridPane.add(textFieldCorreo, 1, 0);
        gridPane.add(textContraseña, 0, 1);
        gridPane.add(passwordFieldCont, 1, 1);
        gridPane.add(buttonAcceso, 1, 2);
    }
}
