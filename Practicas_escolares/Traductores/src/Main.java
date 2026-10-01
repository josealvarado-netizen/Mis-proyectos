import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage stage) {
        // Crea el GridPane utilizando el método corregido
        GridPane gridPane = creaPane();

        // Agrega los controles al GridPane
        agregarControles(gridPane);

        // Crea la escena con el GridPane y un tamaño definido
        Scene scene = new Scene(gridPane, 1200, 700);

        // Configura el título de la ventana
        stage.setTitle("Compilador Ru");

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

    //Metodo para crear y configurar los controles
    private void agregarControles(GridPane gridPane) {
        Controlador controlador = new Controlador();
        //Creamos el recuadro donde estara el codigo introducido por el usuario
        TextArea CodigoBruto = new TextArea();
        CodigoBruto.setPrefHeight(800);
        CodigoBruto.setPrefWidth(800);

        //Creamos los botenes que nos ayudaran a ejecutar el codigo
        Button abrirarchivo = new Button("Abrir archivo");
        abrirarchivo.setPrefHeight(200);
        abrirarchivo.setPrefWidth(100);
        abrirarchivo.setOnAction(e -> controlador.Abrir_archivo((Stage) gridPane.getScene().getWindow(), CodigoBruto));


        Button guardar = new Button("Guardar");
        Button ejecutar = new Button("Ejecutar");
        guardar.setPrefHeight(200);
        guardar.setPrefWidth(100);

        ejecutar.setPrefHeight(200);
        ejecutar.setPrefWidth(100);

        ButtonBar botonAccion = new ButtonBar();
        botonAccion.getButtons().addAll(guardar, ejecutar);
        gridPane.add(botonAccion, 1, 2); // columna 1, fila 2 (parte baja derecha)
        GridPane.setMargin(botonAccion, new Insets(10, 0, 0, 0)); // margen superior
        GridPane.setHalignment(botonAccion, javafx.geometry.HPos.RIGHT);

        guardar.setOnAction(e -> controlador.Guardar_archivo((Stage) gridPane.getScene().getWindow(), CodigoBruto));
        ejecutar.setOnAction(e -> controlador.Ejecutar_codigo(CodigoBruto.getText()));


        gridPane.add(abrirarchivo, 0, 0);
        gridPane.add(CodigoBruto, 0, 1, 2, 1);

    }

    public static void main(String[] args) {
        launch(args);
    }
}

