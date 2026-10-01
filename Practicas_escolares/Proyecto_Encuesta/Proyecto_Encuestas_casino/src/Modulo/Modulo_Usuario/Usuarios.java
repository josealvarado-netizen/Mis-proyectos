package Modulo.Modulo_Usuario;

public interface Usuarios {

    void registrarUsuario(String nombre, String apellido, String fecha_Nac,
                          int edad, String id_Ine, String correo, String contrasena);


    Usuario nuevoInicioSecion(String correo, String contraseña);
}
