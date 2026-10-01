package Modelo.ModuloAutentificacion;

import java.util.ArrayList;
import java.util.List;

public class TablaUsuarios {
    
    private List<Usuario> usuarios;

    public TablaUsuarios() {
        usuarios = new ArrayList<>();
        inicializaTablaUsuarios(); // Llamada al método para inicializar la tabla de usuarios
    }

    // Método para inicializar la tabla de usuarios con algunos datos de ejemplo
    private void inicializaTablaUsuarios() {
        // Administradores
        usuarios.add(new Usuario("Admin3", "admin3@example.com", "admin3password"));
        usuarios.add(new Usuario("Admin4", "admin4@example.com", "admin4password"));
        // Pacientes
        usuarios.add(new Usuario("Maria", "maria2002@gmail.com", "firenze2002"));
        usuarios.add(new Usuario("Juan", "juan2000@gmail.com", "venezia2000"));
        usuarios.add(new Usuario("Sofia", "sofia2001@gmail.com", "napoli2001"));

        //Laboratorista
        usuarios.add(new Usuario("Lab1", "lab1@example.com", "lab1"));
    }

    // Método para agregar un nuevo usuario a la tabla
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Método para buscar un usuario por su nombre de usuario
    public Usuario buscarUsuario(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null; // Devuelve null si no se encuentra el usuario
    }

    public void eliminarUsuario(String nombreUsuario) {
        Usuario usuarioAEliminar = buscarUsuario(nombreUsuario);
        if (usuarioAEliminar != null) {
            usuarios.remove(usuarioAEliminar);
            System.out.println("El usuario " + nombreUsuario + " ha sido eliminado de la tabla de usuarios.");
        } else {
            System.out.println("El usuario " + nombreUsuario + " no se encuentra en la tabla de usuarios.");
        }
    }

    // Método para mostrar la información de la tabla de usuarios
    public void mostrarInfoTablaUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println("Nombre: " + usuario.getNombreUsuario());
            System.out.println("Correo: " + usuario.getCorreo());
            //System.out.println("Fecha de registro: " + usuario.getFechaRegistro());
            //System.out.println("Rol de usuario: " + usuario.getRol());
            System.out.println();
        }
    }
}
