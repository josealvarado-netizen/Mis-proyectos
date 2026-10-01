package Proyecto.Modulo;

import Proyecto.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Gestor_IS_Admin {

    public boolean comprobarUsuario(String correo, String contraseña) {
        String sql = "SELECT correo FROM Administrador WHERE correo = ? AND contraseña = ?";

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, correo);
            stmt.setString(2, contraseña);
            ResultSet rs = stmt.executeQuery();

            // Si se encuentra un resultado, el usuario es válido
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Si ocurre un error o no hay coincidencia, devuelve false
    }
}
