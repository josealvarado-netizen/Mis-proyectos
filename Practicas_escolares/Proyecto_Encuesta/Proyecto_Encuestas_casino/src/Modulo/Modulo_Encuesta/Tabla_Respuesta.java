package Modulo.Modulo_Encuesta;

import BD.Conexion;

import java.sql.*;

public class Tabla_Respuesta {

    // Método que guarda una respuesta de la encuesta en la base de datos
    public void guardarRespuesta(String id_preg,String respuesta,String fecha){

        try{

            // Obtiene la conexión a la base de datos
            Connection con=Conexion.getConnection();

            // Consulta SQL para insertar la respuesta
            String sql="INSERT INTO respuestas(id_preg,respuesta,fecha) VALUES(?,?,?)";

            // PreparedStatement para insertar datos de forma segura
            PreparedStatement ps=con.prepareStatement(sql);

            // Asigna los valores a la consulta
            ps.setString(1,id_preg);
            ps.setString(2,respuesta);
            ps.setString(3,fecha);

            // Ejecuta la inserción
            ps.executeUpdate();

            // Cierra la conexión
            con.close();

        }

        catch(Exception e){

            // Muestra error si falla el guardado
            e.printStackTrace();

        }

    }

}