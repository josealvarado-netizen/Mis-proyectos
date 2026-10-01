package vista;

import Controlador.Controlador_Inicio_secion;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IU_InicioS extends Application {

    // Controlador que maneja la lógica del login
    private Controlador_Inicio_secion controlador_IS;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        // Inicializa el controlador
        controlador_IS = new Controlador_Inicio_secion(stage);

        // Crea el layout principal
        GridPane gridPane = createPane();

        // Agrega los controles (campos y botones)
        agregarControles(gridPane);

        // Configuración de la ventana
        Scene scene = new Scene(gridPane, 800, 600);

        stage.setTitle("Inicio de sesión");

        stage.setScene(scene);

        stage.show();

    }

    // Método que configura el GridPane
    private GridPane createPane() {

        GridPane gridPane = new GridPane();

        gridPane.setMinSize(500, 300);

        gridPane.setPadding(new Insets(20, 20, 20, 20));

        gridPane.setVgap(10);

        gridPane.setHgap(10);

        gridPane.setAlignment(Pos.CENTER);

        return gridPane;

    }

    // Método que agrega los campos y botones
    private void agregarControles(GridPane gridPane) {

        // Campo de correo
        Text textusuario = new Text("Correo:");

        textusuario.setFont(Font.font("Arial", FontWeight.BLACK, 20));

        TextField textFieldCorreo = new TextField();

        textFieldCorreo.setPrefWidth(300);

        textFieldCorreo.setPrefHeight(45);

        // Campo de contraseña
        Text textContraseña = new Text("Contraseña:");

        textContraseña.setFont(Font.font("Arial", FontWeight.BLACK, 20));

        PasswordField passwordFieldCont = new PasswordField();

        passwordFieldCont.setPrefWidth(300);

        passwordFieldCont.setPrefHeight(45);

        // Botón para iniciar sesión
        Button buttonAcceso = new Button("Acceder");

        buttonAcceso.setPrefWidth(150);

        buttonAcceso.setPrefHeight(45);

        buttonAcceso.setStyle("-fx-background-color: orange");

        // Botón para regresar
        Button buttonRegresar = new Button("salir");

        buttonRegresar.setPrefWidth(150);

        buttonRegresar.setPrefHeight(45);

        buttonRegresar.setStyle("-fx-background-color: orange");

        // Acción del botón regresar
        buttonRegresar.setOnAction(e -> {

            controlador_IS.regresar();

        });

        // Acción del botón acceder (login)
        buttonAcceso.setOnAction(e ->{

            String correo = textFieldCorreo.getText();

            String contrasena = passwordFieldCont.getText();

            controlador_IS.iniciarSesion(correo, contrasena);

        });

        // Agrega los elementos al GridPane
        gridPane.add(textusuario, 0, 0);

        gridPane.add(textFieldCorreo, 1, 0);

        gridPane.add(textContraseña, 0, 1);

        gridPane.add(passwordFieldCont, 1, 1);

        gridPane.add(buttonAcceso, 1, 2);

        gridPane.add(buttonRegresar,1,3);

    }

}