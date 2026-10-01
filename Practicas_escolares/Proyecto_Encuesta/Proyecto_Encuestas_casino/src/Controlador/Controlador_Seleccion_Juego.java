package Controlador;

import javafx.stage.Stage;
import vista.IU_Centros_Ayuda;
import vista.IU_Encuesta;
import vista.IU_Principal;

import java.util.List;

public class Controlador_Seleccion_Juego {

    // Referencia a la ventana principal
    private Stage stagePrincipal;

    // Constructor que recibe el stage principal
    public Controlador_Seleccion_Juego(Stage stage){

        this.stagePrincipal=stage;

    }

    // Abre la interfaz de encuesta pasando la lista de juegos seleccionados
    public void IU_Encuesta(List<String> juegos){

        try{

            IU_Encuesta encuesta=
                    new IU_Encuesta(juegos);

            encuesta.start(stagePrincipal);

        }

        catch(Exception e){

            // Muestra error si falla el cambio de ventana
            e.printStackTrace();

        }

    }

    // Abre la interfaz de centros de ayuda
    public void IU_Centros_Ayuda(){

        try{

            IU_Centros_Ayuda ayuda=
                    new IU_Centros_Ayuda();

            ayuda.start(stagePrincipal);

        }

        catch(Exception e){

            // Muestra error si falla el cambio de ventana
            e.printStackTrace();

        }

    }

    // Permite regresar a la pantalla principal
    public void regresar(){

        try{

            IU_Principal p=
                    new IU_Principal();

            p.start(stagePrincipal);

        }

        catch(Exception e){

            e.printStackTrace();

        }

    }

}