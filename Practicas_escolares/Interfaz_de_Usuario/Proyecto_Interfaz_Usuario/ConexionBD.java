package Proyecto;

// Importa las clases necesarias para manejar conexiones a bases de datos y excepciones relacionadas
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para gestionar la conexión a la base de datos.
 * Encapsula la lógica para establecer y obtener una conexión con la base de datos SQL Server.
 */
public class ConexionBD {

    // Variable estática para almacenar la conexión a la base de datos.
    private static Connection conn;

    // URL de conexión a la base de datos SQL Server.
    // Se especifica el host (localhost), puerto (1433), nombre de la base de datos (Proyecto),
    // y otras opciones como deshabilitar el cifrado y permitir el uso de certificados de servidor.
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Proyecto;encrypt=false;trustServerCertificate=true;integratedSecurity=true;";

    /**
     * Método estático para obtener la conexión a la base de datos.
     * Implementa el patrón Singleton para asegurarse de que solo exista una conexión activa a la vez.
     *
     * @return Un objeto de tipo `Connection` que representa la conexión a la base de datos.
     */
    public static Connection getConexion() {
        try {
            // Verifica si la conexión es nula o está cerrada.
            // Si es así, crea una nueva conexión utilizando la URL especificada.
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL);
                System.out.println("Conexión exitosa a la base de datos.");
            }
        } catch (SQLException e) {
            // Captura y maneja cualquier excepción que ocurra al intentar conectarse a la base de datos.
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace(); // Imprime la traza de la excepción para ayudar en la depuración.
        }
        // Retorna la conexión a la base de datos.
        return conn;
    }
}
