package Controlador;

import Modulo.Modulo_Usuario.Gestor_Usuario;
import Modulo.Modulo_Usuario.Usuarios;
import javafx.stage.Stage;
import vista.IU_Principal;
import vista.IU_Seleccion_juegos;

public class Controlador_Nuevo_Usuario {

    // Objeto que gestiona el registro de usuarios
    private Usuarios gestorUsuario;

    // Referencia a la ventana principal
    private Stage stagePrincipal;

    // Constructor que inicializa el gestor de usuarios y el stage
    public  Controlador_Nuevo_Usuario(Stage stage){

        gestorUsuario = new Gestor_Usuario();
        this.stagePrincipal = stage;
    }

    // Método que registra un nuevo usuario con sus datos
    public void registrarUsuario(String nombre, String apellido, String fecha_Nac, int edad, String id_Ine, String correo, String contrasena) {

        // Guarda la información del nuevo usuario
        gestorUsuario.registrarUsuario(nombre, apellido, fecha_Nac, edad, id_Ine, correo, contrasena);

        try {

            // Redirige a la pantalla de selección de juegos después del registro
            IU_Seleccion_juegos juego = new IU_Seleccion_juegos();
            juego.start(stagePrincipal);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // Permite regresar a la pantalla principal
    public void regresar(){

        try {

            IU_Principal principal= new IU_Principal();
            principal.start(stagePrincipal);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}