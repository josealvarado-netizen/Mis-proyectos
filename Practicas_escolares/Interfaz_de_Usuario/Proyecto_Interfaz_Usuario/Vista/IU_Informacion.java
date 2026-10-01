package Proyecto.Vista;

import Proyecto.Controlador.Controlador_Info;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class IU_Informacion extends Application {

    @Override
    public void start(Stage stage) {
        // Crear el controlador
        Controlador_Info controladorInfo = new Controlador_Info();

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

        // Crear la escena y la interfaz
        Scene scene = new Scene(tabPane, 1000, 750);
        stage.setTitle("Energías Renovables");
        stage.setScene(scene);
        stage.show();
    }

    // Crear pestaña con gráfico
    private Tab createTab(String title, String energyType, Controlador_Info controladorInfo) {
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
        tab.setContent(new javafx.scene.layout.VBox(label, barChart));

        // Actualizar la información al seleccionar la pestaña
        tab.setOnSelectionChanged(e -> {
            if (tab.isSelected()) {
                controladorInfo.actualizarInformacion(energyType, label);
            }
        });

        return tab;
    }

    // Crear pestaña sin gráfico
    private Tab createTabSinGrafica(String title, String energyType, Controlador_Info controladorInfo) {
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

    public static void main(String[] args) {
        launch();
    }
}
