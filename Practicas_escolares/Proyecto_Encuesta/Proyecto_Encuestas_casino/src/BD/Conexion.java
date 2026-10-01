package BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    // Datos de conexión a la base de datos MySQL
    private static final String URL="jdbc:mysql://127.0.0.1:3306/DB_Encuesta?useSSL=false&serverTimezone=UTC";
    private static final String USER="aum";
    private static final String PASSWORD="uam1";

    // Método que establece y retorna la conexión a la BD
    public static Connection getConnection(){

        Connection con=null;

        try{
            // Intenta conectarse a la base de datos
            con=DriverManager.getConnection(URL,USER,PASSWORD);

        }catch(Exception e){

            // Muestra error si falla la conexión
            System.out.println("Error de conexion");

        }

        // Retorna la conexión obtenida
        return con;

    }

}