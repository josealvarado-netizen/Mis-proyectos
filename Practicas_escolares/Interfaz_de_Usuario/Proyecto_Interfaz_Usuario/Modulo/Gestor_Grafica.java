package Proyecto.Modulo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Proyecto.ConexionBD;

public class Gestor_Grafica {

    // Método para obtener los usos de energía de la base de datos
    public List<Usos> obtenerUsosPorEnergia(String idNom) {
        List<Usos> usosList = new ArrayList<>();
        String sql = "SELECT anio, uso, lugar, ID_nom FROM Usos WHERE ID_nom = ?";  // Consulta SQL con el nombre correcto de la columna

        try (Connection conn = ConexionBD.getConexion(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idNom);  // Establecer el valor del parámetro 'ID_nom'
            ResultSet rs = stmt.executeQuery();  // Ejecutar la consulta

            while (rs.next()) {
                // Obtener los datos de la base de datos
                int anio = rs.getInt("anio");
                float uso = rs.getFloat("uso");
                String lugar = rs.getString("lugar");
                String idNomResultado = rs.getString("ID_nom");  // Cambiar 'id_nom' a 'ID_nom'

                // Crear un objeto Usos y agregarlo a la lista
                Usos usoObj = new Usos(anio, uso, lugar, idNomResultado);
                usosList.add(usoObj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usosList;  // Devolver la lista de Usos
    }
}
