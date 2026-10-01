package Modulo.Modulo_Usuario;

public class Gestor_Usuario implements Usuarios{

    // Objeto que permite acceder a la tabla de usuarios
    private Tabla_Usuario tabla_BD;

    // Constructor que inicializa la tabla de usuarios
    public Gestor_Usuario(){

        tabla_BD=new Tabla_Usuario();

    }

    // Método para registrar un nuevo usuario
    public void registrarUsuario(String nombre,String apellido,String fecha_Nac,
                                 int edad,String id_Ine,String correo,String contrasena){

        // Crea un nuevo usuario con rol USER por defecto
        Usuario nuevo=new Usuario(

                "USER",
                nombre,
                apellido,
                fecha_Nac,
                edad,
                id_Ine,
                correo,
                contrasena

        );

        // Guarda el usuario en la tabla
        tabla_BD.agregarUsuario(nuevo);

    }

    // Método para iniciar sesión (login)
    public Usuario nuevoInicioSecion(String correo,String contraseña){

        // Busca el usuario en la base de datos
        return tabla_BD.buscarUsuario(correo,contraseña);

    }

}