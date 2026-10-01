package Proyecto.Controlador;

import java.util.List;

import Proyecto.Modulo.Gestor_Grafica;
import Proyecto.Modulo.Gestor_Info_Admin;
import Proyecto.Modulo.Informacion;
import Proyecto.Modulo.Usos;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class Controlador_Info_Admin {
 
    private Gestor_Info_Admin gestor;
    private Gestor_Grafica gestorGrafica;

    public Controlador_Info_Admin() {
        this.gestor = new Gestor_Info_Admin();
        this.gestorGrafica = new Gestor_Grafica();
    }

    // Método para actualizar la información en el Label
    public void actualizarInformacion(String idNom, Label label) {
        Informacion info = gestor.obtenerInformacion(idNom);
        if (info != null) {
            label.setText(info.getInfo());  // Asignar el texto directamente
            label.setWrapText(true);  // Hacer que el texto se ajuste automáticamente
        } else {
            label.setText("Información no disponible para: " + idNom);
        }
    }

    // Método para generar los datos del gráfico de barras, obteniendo los datos directamente de la base de datos
    public XYChart.Series<String, Number> generarGraficoDeBarras(String idNom) {
        List<Usos> usos = gestorGrafica.obtenerUsosPorEnergia(idNom);  // Obtener los datos de la base de datos

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName(idNom);

        // Llenar los datos de la serie con los usos obtenidos de la base de datos
        for (Usos uso : usos) {
            series.getData().add(new XYChart.Data<>(String.valueOf(uso.getAnio()), uso.getUso()));
        }

        return series;
    }

    // Método para guardar la información en la base de datos
    public boolean guardarInformacion(String idNom, String info) {
        return gestor.guardarInformacion(idNom, info);  // Llamamos al método del Gestor para guardar la información
    }
}
