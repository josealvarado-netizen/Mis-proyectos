package vista;

import Controlador.Controlador_Nuevo_Usuario;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IU_Registro extends Application {

    // Controlador que maneja la lógica del registro
    private Controlador_Nuevo_Usuario controlador_nuevo_usuario;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        // Se inicializa el controlador y se le pasa el stage
        controlador_nuevo_usuario = new Controlador_Nuevo_Usuario(stage);

        // Layout principal
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(500, 300);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        // Título de la ventana
        Label labelText = new Label("Crea un nuevo usuario");
        labelText.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        labelText.setStyle("-fx-text-fill: red;");

        // Campos del formulario
        Text textNomU = new Text("Nombre");
        TextField textFieldNom = new TextField();

        Text textApe = new Text("Apellido");
        TextField textFieldApe = new TextField();

        Text textfechaN = new Text("Fecha de Nacimiento");
        TextField textFieldfechaN = new TextField();

        Text textEdad = new Text("Edad");
        TextField textFieldEdad = new TextField();

        Text textIDine = new Text("Numero de INE");
        TextField textFieldIDine = new TextField();

        Text textCorreo = new Text("Correo");
        TextField textFieldCorreo = new TextField();

        Text textContra = new Text("Contraseña");
        TextField textFieldContra = new TextField();

        // Botón para registrar usuario
        Button buttonRegistro = new Button("Registrar");

        buttonRegistro.setOnAction(e -> {

            // Obtener datos del formulario
            String nombre = textFieldNom.getText();
            String apellido = textFieldApe.getText();
            String fecha_Nac = textFieldfechaN.getText();
            int edad = Integer.parseInt(textFieldEdad.getText());
            String id_Ine = textFieldIDine.getText();
            String correo = textFieldCorreo.getText();
            String contraseña = textFieldContra.getText();

            // Enviar datos al controlador
            controlador_nuevo_usuario.registrarUsuario(
                    nombre, apellido, fecha_Nac,
                    edad, id_Ine, correo, contraseña
            );
        });

        // Botón para regresar a la pantalla anterior
        Button buttonRegresar = new Button("salir");

        buttonRegresar.setOnAction(e -> {

            // Llama al método del controlador para regresar
            controlador_nuevo_usuario.regresar();

        });

        // Agregar componentes al GridPane
        gridPane.add(labelText, 0, 0);
        gridPane.add(textNomU, 0, 1);
        gridPane.add(textFieldNom, 1, 1);
        gridPane.add(textApe, 0, 2);
        gridPane.add(textFieldApe, 1, 2);
        gridPane.add(textfechaN, 0,3);
        gridPane.add(textFieldfechaN, 1, 3);
        gridPane.add(textEdad, 0,4);
        gridPane.add(textFieldEdad,1,4);
        gridPane.add(textIDine, 0,5);
        gridPane.add(textFieldIDine,1,5);
        gridPane.add(textCorreo, 0, 6);
        gridPane.add(textFieldCorreo, 1,6 );
        gridPane.add(textContra, 0, 7);
        gridPane.add(textFieldContra, 1, 7);
        gridPane.add(buttonRegistro, 1, 8);
        gridPane.add(buttonRegresar,1,9);

        // Crear escena
        Scene scene = new Scene(gridPane, 800, 600);
        stage.setTitle("Nuevo Registro");
        stage.setScene(scene);
        stage.show();
    }
}