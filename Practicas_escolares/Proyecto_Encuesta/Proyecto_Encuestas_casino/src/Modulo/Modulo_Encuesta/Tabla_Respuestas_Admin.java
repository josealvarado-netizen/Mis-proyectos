package Modulo.Modulo_Encuesta;

import BD.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Tabla_Respuestas_Admin {

    public Tabla_Respuestas_Admin(){}

    // Método que obtiene las fechas en las que existen respuestas registradas
    public List<String> obtenerFechas(){

        // Lista donde se almacenan las fechas
        List<String> fechas = new ArrayList<>();

        try{

            // Obtiene la conexión a la base de datos
            Connection con = Conexion.getConnection();

            // Consulta para obtener fechas únicas ordenadas de más reciente a más antigua
            String sql =
                    "SELECT DISTINCT fecha FROM respuestas ORDER BY fecha DESC";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            // Agrega las fechas encontradas a la lista
            while(rs.next()){

                fechas.add(rs.getString("fecha"));

            }

            // Cierra los recursos
            rs.close();
            ps.close();
            con.close();

        }catch(Exception e){

            // Muestra error si falla la consulta
            e.printStackTrace();

        }

        // Retorna las fechas disponibles
        return fechas;

    }

    // Método que obtiene preguntas y respuestas según una fecha
    public List<String[]> obtenerPreguntasRespuestas(String fecha){

        // Lista donde se guardan las preguntas y respuestas
        List<String[]> datos = new ArrayList<>();

        try{

            // Obtiene la conexión a la base de datos
            Connection con = Conexion.getConnection();

            // Consulta que une preguntas y respuestas mediante el id de la pregunta
            String sql =
                    "SELECT p.pregunta , r.respuesta " +
                            "FROM respuestas r " +
                            "JOIN preguntas p ON r.id_preg = p.id_preg " +
                            "WHERE r.fecha = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            // Asigna la fecha a la consulta
            ps.setString(1,fecha);

            ResultSet rs = ps.executeQuery();

            // Guarda cada pregunta con su respuesta
            while(rs.next()){

                String pregunta = rs.getString("pregunta");

                String respuesta = rs.getString("respuesta");

                datos.add(new String[]{pregunta,respuesta});

            }

            // Cierra los recursos
            rs.close();
            ps.close();
            con.close();

        }catch(Exception e){

            // Muestra error si falla la consulta
            e.printStackTrace();

        }

        // Retorna las preguntas y respuestas encontradas
        return datos;

    }

}