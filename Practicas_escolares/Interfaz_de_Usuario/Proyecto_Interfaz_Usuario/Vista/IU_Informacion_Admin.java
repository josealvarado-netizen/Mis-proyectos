package Proyecto.Vista;

import Proyecto.Controlador.Controlador_Info_Admin;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class IU_Informacion_Admin extends Application {

    @Override
    public void start(Stage stage) {
        // Crear el controlador
        Controlador_Info_Admin controladorInfo = new Controlador_Info_Admin();

        // Crear las pestañas
        Tab tabHidro = createTab("Energía Hidroeléctrica", "Hidroeléctrica", controladorInfo);
        Tab tabGeo = createTab("Energía Geotérmica", "Geotérmica", controladorInfo);
        Tab tabEolica = createTab("Energía Eólica", "Eólica", controladorInfo);
        Tab tabSolar = createTab("Energía Solar", "Solar", controladorInfo);
        Tab tabInicio = createTabSinGrafica("Inicio", "Recursos renovables", controladorInfo);

        // Crear TabPane y agregar las pestañas
        TabPane tabPane = new TabPane(tabHidro, tabGeo, tabEolica, tabSolar, tabInicio);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.getSelectionModel().select(tabInicio);

        // Crear la barra de botones
        Button modificar = new Button("Modificar");
        ButtonBar botonBar = new ButtonBar();
        botonBar.getButtons().add(modificar); // Solo agregamos el botón "Modificar"

        // Agregar la barra de botones al final de la interfaz
        VBox vBox = new VBox(tabPane, botonBar);

        // Acción del botón "Modificar"
        modificar.setOnAction(e -> openModifyWindow(controladorInfo));

        // Crear la escena y la interfaz
        Scene scene = new Scene(vBox, 1000, 750);
        stage.setTitle("Energías Renovables");
        stage.setScene(scene);
        stage.show();
    }

    // Crear pestaña con gráfico
    private Tab createTab(String title, String energyType, Controlador_Info_Admin controladorInfo) {
        // Crear el gráfico
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Uso de " + title);
        xAxis.setLabel("Año");
        yAxis.setLabel("Uso");
        barChart.getData().add(controladorInfo.generarGraficoDeBarras(energyType));

        // Crear el label
        Label label = new Label("Información de " + title);

        // Crear la pestaña
        Tab tab = new Tab(title);
        tab.setContent(new VBox(label, barChart));

        // Actualizar la información al seleccionar la pestaña
        tab.setOnSelectionChanged(e -> {
            if (tab.isSelected()) {
                controladorInfo.actualizarInformacion(energyType, label);
            }
        });

        return tab;
    }

    // Crear pestaña sin gráfico
    private Tab createTabSinGrafica(String title, String energyType, Controlador_Info_Admin controladorInfo) {
        Label label = new Label("Información general sobre los recursos renovables.");

        Tab tab = new Tab(title);
        tab.setContent(label);

        tab.setOnSelectionChanged(e -> {
            if (tab.isSelected()) {
                controladorInfo.actualizarInformacion(energyType, label);
            }
        });

        return tab;
    }

    // Método para abrir la ventana de modificación
    private void openModifyWindow(Controlador_Info_Admin controladorInfo) {
        Stage modifyStage = new Stage();
        modifyStage.setTitle("Modificar Información");

        // Crear el GridPane para la ventana de modificación
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        
        // Crear el ComboBox con las opciones
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Hidroeléctrica", "Geotérmica", "Eólica", "Solar");
        comboBox.setValue("Hidroeléctrica");  // Valor predeterminado

        // Crear el TextArea
        TextArea textAreaInfo = new TextArea();

        // Crear el botón "Guardar"
        Button btnGuardar = new Button("Guardar");

        // Acción del botón Guardar
        btnGuardar.setOnAction(e -> {
            String seleccion = comboBox.getValue();
            String texto = textAreaInfo.getText();
            System.out.println("Opción seleccionada: " + seleccion);
            System.out.println("Información guardada: " + texto);
            
            // Llamar al controlador para guardar la información en la BD
            boolean exito = controladorInfo.guardarInformacion(seleccion, texto);
            
            if (exito) {
                System.out.println("Información guardada correctamente en la base de datos.");
            } else {
                System.out.println("Error al guardar la información.");
            }
            
            modifyStage.close(); // Cerrar la ventana de modificación
        });

        // Agregar los controles al VBox
        vBox.getChildren().addAll(
            new Label("Selecciona una opción:"),
            comboBox,
            new Label("Información a modificar:"),
            textAreaInfo,
            btnGuardar
        );

        // Crear la escena y agregar el VBox
        Scene scene = new Scene(vBox, 400, 300);
        modifyStage.setScene(scene);
        modifyStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
