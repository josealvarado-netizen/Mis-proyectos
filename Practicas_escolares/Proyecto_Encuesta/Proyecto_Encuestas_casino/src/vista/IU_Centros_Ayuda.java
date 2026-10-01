package vista;

import Controlador.Controlador_Centros_Ayuda;
import Modulo.Modulo_Ayuda_ludopatia.Informacion;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class IU_Centros_Ayuda extends Application {

    // Controlador que maneja la lógica de la vista
    private Controlador_Centros_Ayuda controlador;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        // Inicializa el controlador
        controlador = new Controlador_Centros_Ayuda(stage);

        // Contenedor principal de la interfaz
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);

        // Título de la ventana
        Label titulo = new Label("Centros de ayuda más cercanos");
        titulo.setFont(Font.font("Arial", 24));

        // Contenedor donde se mostrarán los centros
        VBox vboxCentros = new VBox(15);
        vboxCentros.setPadding(new Insets(10));
        vboxCentros.setAlignment(Pos.TOP_LEFT);

        // Recorre los centros obtenidos y los muestra
        for (Informacion centro : controlador.obtenerCentros()) {

            Label label = new Label(

                    "Centro: " + centro.getNombreCentro() + "\n" +
                            "Dirección: " + centro.getUbicacion() + "\n" +
                            "Teléfono: " + centro.getTelefono()

            );

            label.setFont(Font.font("Arial", 16));

            // Estilo visual del recuadro
            label.setStyle("-fx-border-color: gray; -fx-border-width: 1; -fx-padding: 10;");

            vboxCentros.getChildren().add(label);

        }

        // Scroll para poder ver todos los centros
        ScrollPane scrollPane = new ScrollPane(vboxCentros);
        scrollPane.setFitToWidth(true);

        // Botón para regresar a la pantalla anterior
        Button botonRegresar = new Button("Regresar");

        botonRegresar.setFont(Font.font(16));

        botonRegresar.setOnAction(e -> {

            controlador.regresar();

        });

        // Agrega los elementos a la ventana principal
        root.getChildren().addAll(titulo, scrollPane, botonRegresar);

        // Configuración de la ventana
        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("Centros de Ayuda Ludopatía");

        stage.setScene(scene);

        stage.show();

    }

}