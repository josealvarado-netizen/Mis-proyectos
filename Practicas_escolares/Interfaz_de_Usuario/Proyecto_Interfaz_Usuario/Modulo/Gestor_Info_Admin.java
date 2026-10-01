package Proyecto.Modulo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Proyecto.ConexionBD;

public class Gestor_Info_Admin {

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

    public boolean guardarInformacion(String idNom, String info) {
        // Consulta para actualizar la información
        String query = "UPDATE informacion SET info = ? WHERE ID_nom = ?";
    
        try (PreparedStatement statement = ConexionBD.getConexion().prepareStatement(query)) {
            statement.setString(1, info);   // Establecer el valor de info
            statement.setString(2, idNom);  // Establecer el valor de ID_nom
    
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;  // Si se actualizó correctamente, retorna true
        } catch (SQLException e) {
            System.out.println("Error al guardar la información en la base de datos: " + e.getMessage());
        }
        return false;  // Si ocurrió algún error o no se actualizó ningún registro, retornamos false
    }
    
}
