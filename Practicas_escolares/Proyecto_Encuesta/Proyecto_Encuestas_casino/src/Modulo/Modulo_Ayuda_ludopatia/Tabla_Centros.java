package Modulo.Modulo_Ayuda_ludopatia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import BD.Conexion;

public class Tabla_Centros {

    public Tabla_Centros(){}

    // Método que obtiene todos los centros de ayuda desde la base de datos
    public List<Informacion> obtenerCentros(){

        // Lista donde se almacenarán los centros obtenidos
        List<Informacion> centros = new ArrayList<>();

        try{

            // Obtiene la conexión a la base de datos
            Connection con = Conexion.getConnection();

            // Consulta SQL para obtener los datos de los centros
            String sql = "SELECT nombre,direccion,telefono FROM Centros_Ayuda";

            PreparedStatement ps = con.prepareStatement(sql);

            // Ejecuta la consulta
            ResultSet rs = ps.executeQuery();

            // Recorre los resultados y crea objetos Informacion
            while(rs.next()){

                Informacion info = new Informacion(

                        rs.getString("nombre"),
                        rs.getString("direccion"),
                        rs.getString("telefono")

                );

                // Agrega cada centro a la lista
                centros.add(info);

            }

            // Cierra los recursos de la base de datos
            rs.close();
            ps.close();
            con.close();

        }catch(Exception e){

            // Muestra error si falla la consulta
            e.printStackTrace();

        }

        // Retorna la lista de centros
        return centros;

    }

}