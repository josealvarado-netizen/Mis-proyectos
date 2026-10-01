package Controlador;

import Modulo.Modulo_Aviso_privacidad.Aviso_privasidad;
import Modulo.Modulo_Aviso_privacidad.Gestor_avisoP;
import javafx.stage.Stage;
import vista.IU_InicioS;
import vista.IU_Registro;

public class Controlador_Principal {

    // Referencia a la ventana principal de la aplicación
    private Stage stagePrincipal;

    // Objeto que gestiona el aviso de privacidad
    private Gestor_avisoP gestorAviso;

    // Constructor que inicializa el stage y el gestor del aviso
    public Controlador_Principal(Stage stage){
        this.stagePrincipal = stage;
        this.gestorAviso = new Gestor_avisoP();
    }

    // Abre la interfaz de inicio de sesión
    public void IU_Inicio_sec() {
        try {

            IU_InicioS sesion = new IU_InicioS();
            sesion.start(stagePrincipal);

        } catch (Exception e) {

            // Muestra error si falla el cambio de ventana
            e.printStackTrace();

        }
    }

    // Abre la interfaz de registro de usuario
    public void IU_Reg() {
        try {

            IU_Registro registro = new IU_Registro();
            registro.start(stagePrincipal);

        } catch (Exception e) {

            // Muestra error si falla el cambio de ventana
            e.printStackTrace();

        }
    }

    // Obtiene el aviso de privacidad por su ID
    public Aviso_privasidad buscarAviso(int ID_Aviso){

        return gestorAviso.buscaraviso(ID_Aviso);

    }

}