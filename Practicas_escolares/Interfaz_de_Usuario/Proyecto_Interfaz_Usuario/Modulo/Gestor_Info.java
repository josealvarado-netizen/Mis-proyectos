package Proyecto.Modulo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Proyecto.ConexionBD;

public class Gestor_Info {

    // Método para obtener la información según el ID
    public Informacion obtenerInformacion(String idNom) {
        String query = "SELECT * FROM informacion WHERE ID_nom = ?";  // Consulta ajustada para filtrar por ID_nom

        try (PreparedStatement statement = ConexionBD.getConexion().prepareStatement(query)) {  // Cambiar a getConexion()
            statement.setString(1, idNom);  // Establecer el valor de ID_nom

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String id = resultSet.getString("ID_nom");  // Obtener ID_nom
                    String info = resultSet.getString("info");  // Obtener la información

                    return new Informacion(id, info);  // Retornar un objeto Informacion con los datos
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la información de la base de datos: " + e.getMessage());
        }
        return null;  // Si no se encuentra la información, retornamos null
    }
}
