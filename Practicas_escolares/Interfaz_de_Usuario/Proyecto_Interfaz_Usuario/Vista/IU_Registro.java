package Proyecto.Vista;

import Proyecto.Controlador.Controlador_Registro;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IU_Registro extends Application {

    private Controlador_Registro controlador;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        controlador = new Controlador_Registro();

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(500, 300);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        Label labelText = new Label("Crea un nuevo usuario");
        labelText.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        labelText.setStyle("-fx-text-fill: red;");

        Text textNomU = new Text("Nombre");
        textNomU.setFont(Font.font("Arial", FontWeight.BLACK, 20));
        textNomU.setStyle("-fx-text-fill: red");
        TextField textFieldNom = new TextField();
        textFieldNom.setPrefHeight(45);
        textFieldNom.setPrefWidth(300);

        Text textApe = new Text("Apellido");
        textApe.setFont(Font.font("Arial", FontWeight.BLACK, 20));
        TextField textFieldApe = new TextField();
        textFieldApe.setPrefWidth(300);
        textFieldApe.setPrefHeight(45);

        Text textCorreo = new Text("Correo");
        textCorreo.setFont(Font.font("Arial", FontWeight.BLACK, 20));
        TextField textFieldCorreo = new TextField();
        textFieldCorreo.setPrefWidth(300);
        textFieldCorreo.setPrefHeight(45);

        Text textContra = new Text("Contraseña");
        textContra.setFont(Font.font("Arial", FontWeight.BLACK, 20));
        TextField textFieldContra = new TextField();
        textFieldContra.setPrefWidth(300);
        textFieldContra.setPrefHeight(45);

        Button buttonRegistro = new Button("Registrar");
        buttonRegistro.setPrefWidth(150);
        buttonRegistro.setPrefHeight(45);
        buttonRegistro.setStyle("-fx-background-color: orange;");

        // Evento del botón de registro
        buttonRegistro.setOnAction(e -> {
            String nombre = textFieldNom.getText();
            String apellido = textFieldApe.getText();
            String correo = textFieldCorreo.getText();
            String contrasena = textFieldContra.getText();

            // Verificar si los campos están vacíos
            if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
                mostrarMensaje("Llenar campos", "Todos los campos deben ser llenados.");
                return;
            }

            // Llamar al controlador para registrar el usuario
            boolean registrado = controlador.registrarUsuario(nombre, apellido, correo, contrasena);

            // Si no se registra el usuario, mostrar el mensaje de correo ya registrado
            if (!registrado) {
                mostrarMensaje("Correo ya registrado", "El correo ya está registrado.");
            } else {
                // Si el registro es exitoso, abrir una nueva ventana
                IU_Informacion iuInformacion = new IU_Informacion();
                try {
                    iuInformacion.start(new Stage());
                    stage.close(); // Cerrar la ventana actual
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        gridPane.add(labelText, 0, 0);
        gridPane.add(textNomU, 0, 1);
        gridPane.add(textFieldNom, 1, 1);
        gridPane.add(textApe, 0, 2);
        gridPane.add(textFieldApe, 1, 2);
        gridPane.add(textCorreo, 0, 3);
        gridPane.add(textFieldCorreo, 1, 3);
        gridPane.add(textContra, 0, 4);
        gridPane.add(textFieldContra, 1, 4);
        gridPane.add(buttonRegistro, 1, 5);

        Scene scene = new Scene(gridPane, 800, 600);
        stage.setTitle("Nuevo Registro");
        stage.setScene(scene);
        stage.show();
    }

    private void mostrarMensaje(String titulo, String mensaje) {
        // Crear una ventana de mensaje
        Stage mensajeStage = new Stage();
        mensajeStage.setTitle(titulo);

        // Crear el contenido de la ventana de mensaje
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().add(new Label(mensaje));

        // Crear el botón para cerrar el mensaje
        Button btnCerrar = new Button("Cerrar");
        btnCerrar.setOnAction(e -> mensajeStage.close());
        vbox.getChildren().add(btnCerrar);

        Scene scene = new Scene(vbox, 300, 150);
        mensajeStage.setScene(scene);
        mensajeStage.show();
    }
}

