package Modulo.Modulo_Aviso_privacidad;

// Bibliotecas para trabajar con SQL
import java.security.PublicKey;
import java.sql.*;
import BD.Conexion; // conexión con la base de datos
import Modulo.Modulo_Usuario.Usuario;

public class Tabla_avisos {

    public Tabla_avisos() {
    }

    // Método que busca un aviso de privacidad en la base de datos por su ID
    public Aviso_privasidad buscarAviso(int ID_aviso) {

        Aviso_privasidad aviso_privasidad = null;

        try {

            // Obtiene la conexión a la base de datos
            Connection con = Conexion.getConnection();

            // Consulta SQL para obtener el aviso
            String sql = "SELECT id,contenido FROM aviso_privacidad WHERE id=?";

            // PreparedStatement para evitar inyección SQL
            PreparedStatement av = con.prepareStatement(sql);

            // Se asigna el ID a la consulta
            av.setInt(1, ID_aviso);

            // Ejecuta la consulta
            ResultSet rs = av.executeQuery();

            // Si encuentra el aviso crea el objeto con los datos
            if (rs.next()) {

                int id = rs.getInt("id");

                String contenido = rs.getString("contenido");

                aviso_privasidad = new Aviso_privasidad(id, contenido);

            }

            // Cierra los recursos de la base de datos
            rs.close();
            av.close();
            con.close();

        } catch (Exception e) {

            // Muestra error si falla la consulta
            e.printStackTrace();

        }

        // Retorna el aviso encontrado (o null si no existe)
        return aviso_privasidad;

    }

}