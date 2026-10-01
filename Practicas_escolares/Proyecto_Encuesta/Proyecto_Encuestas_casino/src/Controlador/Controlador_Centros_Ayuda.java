package Controlador;

import Modulo.Modulo_Ayuda_ludopatia.Gestor_centros_ayuda;
import Modulo.Modulo_Ayuda_ludopatia.Informacion;

import javafx.stage.Stage;
import vista.IU_Seleccion_juegos;

import java.util.List;

public class Controlador_Centros_Ayuda {

    // Objeto que gestiona la obtención de los centros de ayuda
    private Gestor_centros_ayuda gestor;

    // Referencia a la ventana principal de la aplicación
    private Stage stagePrincipal;

    // Constructor que inicializa el gestor y recibe el stage principal
    public Controlador_Centros_Ayuda(Stage stage) {

        gestor = new Gestor_centros_ayuda();

        this.stagePrincipal = stage;

    }

    // Método que obtiene la lista de centros de ayuda
    public List<Informacion> obtenerCentros(){

        return gestor.obtenerCentros();

    }

    // Método que permite regresar a la pantalla de selección de juegos
    public void regresar(){

        try{

            IU_Seleccion_juegos juegos = new IU_Seleccion_juegos();

            juegos.start(stagePrincipal);

        }catch(Exception e){

            // Muestra error si falla el cambio de ventana
            e.printStackTrace();

        }

    }

}