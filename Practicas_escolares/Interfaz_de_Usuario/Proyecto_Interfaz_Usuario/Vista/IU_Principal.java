package Proyecto.Vista;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import Proyecto.Controlador.Controlador_Principal;

public class IU_Principal extends Application {

    private Controlador_Principal controlador;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Crear el controlador y pasarle el escenario principal
        controlador = new Controlador_Principal(stage);

        // Crea el GridPane utilizando el método corregido
        GridPane gridPane = creaPane();

        // Agrega los controles al GridPane
        agregarControles(gridPane);

        // Crea la escena con el GridPane y un tamaño definido
        Scene scene = new Scene(gridPane, 800, 600);

        // Configura el título de la ventana
        stage.setTitle("Inicio");

        // Establece la escena en el escenario principal
        stage.setScene(scene);

        // Muestra la ventana al usuario
        stage.show();
    }

    // Método para crear y configurar un GridPane
    private GridPane creaPane() {
        GridPane gridPane = new GridPane();

        // Establece un tamaño mínimo para el GridPane
        gridPane.setMinSize(300, 200);

        // Establece márgenes internos para los elementos del GridPane
        gridPane.setPadding(new Insets(20, 20, 20, 20));

        // Establece el espacio vertical entre las filas
        gridPane.setVgap(10);

        // Establece el espacio horizontal entre las columnas
        gridPane.setHgap(10);

        // Establece la alineación central para los elementos en el GridPane
        gridPane.setAlignment(Pos.CENTER);

        return gridPane;
    }

    // Método para agregar controles al GridPane
    private void agregarControles(GridPane gridPane) {
        // Ruta de la imagen
        String imagePath = "file:///C:/Users/allen/OneDrive/Imágenes/proyecto/Inicio.jpg";

        // Crear la imagen y el ImageView
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);

        // Establece un tamaño adecuado para la imagen si es necesario
        imageView.setFitWidth(300);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);  // Mantiene las proporciones de la imagen

        // Crear el StackPane para centrar la imagen
        StackPane imagePane = new StackPane();
        imagePane.getChildren().add(imageView); // Añade la imagen al StackPane
        imagePane.setAlignment(Pos.CENTER); // Alineación centrada

        // Texto "Imagen" como un Label
        Label labelImagen = new Label("Para conocer más sobre los Energias Renovables 'Inicia sesion' o 'Registrate'");
        labelImagen.setFont(Font.font("Arial", FontWeight.BOLD, 16)); // Fuente: Arial, negrita, tamaño 16

        // Botón para "Iniciar sesión"
        Button button1 = new Button("Iniciar sesión");
        button1.setOnAction(event -> controlador.manejarInicioSesion());

        // Botón para "Registrarse"
        Button button2 = new Button("Registrarse");
        button2.setOnAction(event -> controlador.manejarRegistro());

        // Botón para "Administrador"
        Button button3 = new Button("Administrador");
        button3.setOnAction(event -> controlador.manejarAdministrador());

        // Agrega el StackPane con la imagen al GridPane en la fila 0
        gridPane.add(imagePane, 0, 0, 2, 1);  // Centra la imagen en las primeras dos columnas

        // Agrega el Label "Imagen" en la posición (columna 0, fila 1)
        gridPane.add(labelImagen, 0, 1);

        // Agrega los botones al GridPane en posiciones específicas
        gridPane.add(button1, 0, 2); // Columna 0, Fila 2
        gridPane.add(button2, 1, 2); // Columna 1, Fila 2
        gridPane.add(button3, 0, 3); // Coloca el botón en una posición diferente
    }
}
