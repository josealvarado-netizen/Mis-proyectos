package Modulo.Modulo_Encuesta;

import BD.Conexion;

import java.sql.*;
import java.util.*;

public class Tabla_Preguntas {

    // Método que obtiene las preguntas generales y las específicas de los juegos seleccionados
    public List<Pregunta> obtenerPreguntas(
            List<String> juegos){

        // Lista donde se almacenarán las preguntas
        List<Pregunta> lista=
                new ArrayList<>();

        try{

            // Obtiene la conexión a la base de datos
            Connection con=
                    Conexion.getConnection();

            // Consulta para obtener preguntas generales
            String sqlGeneral=

                    "SELECT * FROM preguntas " +
                            "WHERE id_juego='GENERAL'";

            PreparedStatement psGeneral=
                    con.prepareStatement(sqlGeneral);

            ResultSet rsGeneral=
                    psGeneral.executeQuery();

            // Agrega las preguntas generales a la lista
            while(rsGeneral.next()){

                lista.add(

                        new Pregunta(

                                rsGeneral.getString("id_preg"),
                                rsGeneral.getString("pregunta"),
                                rsGeneral.getString("id_juego"),
                                rsGeneral.getString("tipo")

                        )

                );

            }

            // Consulta para obtener preguntas específicas por juego
            String sqlJuego=

                    "SELECT * FROM preguntas WHERE id_juego=?";

            // Recorre los juegos seleccionados
            for(String juego:juegos){

                PreparedStatement ps=
                        con.prepareStatement(sqlJuego);

                ps.setString(1,juego);

                ResultSet rs=
                        ps.executeQuery();

                // Agrega las preguntas de cada juego
                while(rs.next()){

                    lista.add(

                            new Pregunta(

                                    rs.getString("id_preg"),
                                    rs.getString("pregunta"),
                                    rs.getString("id_juego"),
                                    rs.getString("tipo")

                            )

                    );

                }

            }

            // Cierra la conexión
            con.close();

        }

        catch(Exception e){

            // Muestra error si falla la consulta
            e.printStackTrace();

        }

        // Retorna la lista de preguntas
        return lista;

    }

}