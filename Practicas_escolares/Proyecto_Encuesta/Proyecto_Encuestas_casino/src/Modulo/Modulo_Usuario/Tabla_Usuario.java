package Modulo.Modulo_Usuario;

import java.sql.*;
import BD.Conexion;

public class Tabla_Usuario {

    public Tabla_Usuario(){}

    // Método para guardar un usuario en la base de datos
    public void agregarUsuario(Usuario usuario){

        try{

            // Obtiene conexión a la base de datos
            Connection con=Conexion.getConnection();

            // Consulta SQL para insertar el usuario
            String sql="INSERT INTO usuarios(rol,nombre,apellido,fecha_Nac,edad,id_Ine,correo,contraseña) VALUES(?,?,?,?,?,?,?,?)";

            // PreparedStatement para enviar los datos de forma segura
            PreparedStatement ps=con.prepareStatement(sql);

            // Asigna los datos del objeto Usuario a la consulta
            ps.setString(1,usuario.getRol());
            ps.setString(2,usuario.getNombre());
            ps.setString(3,usuario.getApellido());
            ps.setString(4,usuario.getFecha_Nac());
            ps.setInt(5,usuario.getEdad());
            ps.setString(6,usuario.getId_Ine());
            ps.setString(7,usuario.getCorreo());
            ps.setString(8,usuario.getContraseña());

            // Ejecuta la inserción
            ps.executeUpdate();

            // Cierra conexión
            con.close();

        }catch(Exception e){

            // Muestra error si falla el registro
            e.printStackTrace();

        }

    }

    // Método para buscar un usuario (login)
    public Usuario buscarUsuario(String correo,String contraseña){

        Usuario usuario=null;

        try{

            // Conexión a la base de datos
            Connection con=Conexion.getConnection();

            // Consulta para validar correo y contraseña
            String sql="SELECT * FROM usuarios WHERE correo=? AND contraseña=?";

            PreparedStatement ps=con.prepareStatement(sql);

            ps.setString(1,correo);
            ps.setString(2,contraseña);

            ResultSet rs=ps.executeQuery();

            // Si existe el usuario, crea el objeto Usuario
            if(rs.next()){

                usuario=new Usuario(

                        rs.getString("rol"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("fecha_Nac"),
                        rs.getInt("edad"),
                        rs.getString("id_Ine"),
                        rs.getString("correo"),
                        rs.getString("contraseña")

                );

            }

            // Cierra conexión
            con.close();

        }catch(Exception e){

            // Muestra error si falla la búsqueda
            e.printStackTrace();

        }

        // Retorna el usuario encontrado o null si no existe
        return usuario;

    }

}