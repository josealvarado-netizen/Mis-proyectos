package Proyecto.Modulo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Proyecto.ConexionBD;

public class Gestor_Usuario {

    // Método para registrar un usuario en la base de datos
    public boolean registrarUsuario(Usuario usuario) {
        String query = "INSERT INTO Usuario (nombre, apellido, correo, contraseña) VALUES (?, ?, ?, ?)";

        // Usar la clase ConexionBD para obtener la conexión
        try (Connection conn = ConexionBD.getConexion(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Establecer los parámetros para la consulta
            pstmt.setString(1, usuario.getNombreU());
            pstmt.setString(2, usuario.getApellidoU());
            pstmt.setString(3, usuario.getCorreoU());
            pstmt.setString(4, usuario.getContrasenaU());

            // Ejecutar la consulta
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
