package Proyecto.Controlador;

import Proyecto.Vista.IU_Informacion_Admin;
import Proyecto.Vista.IU_Inisio_Admin;
import Proyecto.Vista.IU_Inisio_Sesion;
import Proyecto.Vista.IU_Registro;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Controlador_Principal {
    private Stage stagePrincipal;

    public Controlador_Principal(Stage stage) {
        this.stagePrincipal = stage;
    }

    // Método para manejar la acción "Iniciar sesión"
    public void manejarInicioSesion() {
        try{
            stagePrincipal.close();
            IU_Inisio_Sesion sesion = new IU_Inisio_Sesion();

            sesion.start(new Stage());
        }catch(Exception e){
            // Manejar cualquier excepción que pueda ocurrir
            System.err.println("Error al abrir la ventana de registro: " + e.getMessage());
            e.printStackTrace();
        }
        
    }

    // Método para manejar la acción "Registrarse"
    public void manejarRegistro() {
        try {
            // Cierra la ventana principal antes de abrir la de registro
            stagePrincipal.close();

            // Crear una nueva instancia de IU_Registro y mostrarla
            IU_Registro registro = new IU_Registro();
            // Se pasa el nuevo Stage a IU_Registro y se puede manejar cualquier lógica adicional
            registro.start(new Stage()); // Llama al método start con un nuevo Stage

        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir
            System.err.println("Error al abrir la ventana de registro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para manejar la acción "Administrador"
    public void manejarAdministrador() {
        try{
            stagePrincipal.close();
            IU_Inisio_Admin sesionAdmin = new IU_Inisio_Admin();

            sesionAdmin.start(new Stage());
        }catch(Exception e){
            // Manejar cualquier excepción que pueda ocurrir
            System.err.println("Error al abrir la ventana de registro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
