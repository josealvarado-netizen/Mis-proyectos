import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static final String URL="jdbc:mysql://127.0.0.1:3306/DB_Encuesta?useSSL=false&serverTimezone=UTC";
    private static final String USER="aum";
    private static final String PASSWORD="uam1";

    public static Connection getConnection(){

        Connection con=null;

        try{

            con=DriverManager.getConnection(URL,USER,PASSWORD);

            System.out.println("Conexion exitosa");

        }catch(Exception e){

            System.out.println("Error de conexion");
            e.printStackTrace();

        }

        return con;

    }

}