package Proyecto;

// Importa la clase IU_Principal, que contiene la interfaz gráfica de usuario (GUI) principal
import Proyecto.Vista.IU_Principal;

// Importa la clase Connection, que probablemente será utilizada para manejar conexiones a bases de datos
import java.sql.Connection;

/**
 * Clase principal del proyecto
 */
public class MAIN {

    /**
     * Método principal del programa.
     * Este método actúa como punto de entrada para la ejecución del programa.
     *
     * @param args Argumentos de línea de comandos pasados al ejecutar el programa.
     */
    public static void main(String[] args) {
        // Llamar al método estático `launch` de la clase IU_Principal.
        // `IU_Principal` es la interfaz gráfica principal del programa. 
        // `launch` es un método típico de aplicaciones JavaFX que inicializa y ejecuta la interfaz.
        IU_Principal.launch(IU_Principal.class, args);
    }
}
