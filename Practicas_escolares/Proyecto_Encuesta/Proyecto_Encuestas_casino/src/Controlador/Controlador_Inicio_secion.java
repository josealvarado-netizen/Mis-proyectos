package Controlador;

import Modulo.Modulo_Juegos.juego;
import Modulo.Modulo_Usuario.Gestor_Usuario;
import Modulo.Modulo_Usuario.Usuario;
import Modulo.Modulo_Usuario.Usuarios;
import javafx.stage.Stage;
import vista.IU_Encuestas_Admin;
import vista.IU_Principal;
import vista.IU_Seleccion_juegos;

public class Controlador_Inicio_secion {

    // Objeto que gestiona la autenticación de usuarios
    private Usuarios controladorIS;

    // Referencia a la ventana principal
    private Stage stagePrincipal;

    // Constructor que inicializa el gestor de usuarios y el stage
    public Controlador_Inicio_secion(Stage stage) {
        controladorIS = new Gestor_Usuario();
        this.stagePrincipal = stage;
    }

    // Método que valida las credenciales del usuario
    public void iniciarSesion(String correo, String contraseña) {

        // Intenta autenticar al usuario
        Usuario usuario = controladorIS.nuevoInicioSecion(correo, contraseña);

        // Verifica si el usuario existe
        if (usuario != null) {

            // Verifica si el usuario es administrador
            if ("ADMIN".equals(usuario.getRol())) {
                System.out.println("Entrando como ADMIN");

                try{
                    // Abre la interfaz de encuestas del administrador
                    IU_Encuestas_Admin encuestasAdmin = new IU_Encuestas_Admin();
                    encuestasAdmin.start(stagePrincipal);

                } catch (RuntimeException e) {
                    throw new RuntimeException(e);
                }

            } else {

                try {
                    // Abre la interfaz de selección de juegos para usuarios normales
                    IU_Seleccion_juegos juego = new IU_Seleccion_juegos();
                    juego.start(stagePrincipal);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        } else {
            // Mensaje si las credenciales son incorrectas
            System.out.println("Credenciales incorrectas");
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
