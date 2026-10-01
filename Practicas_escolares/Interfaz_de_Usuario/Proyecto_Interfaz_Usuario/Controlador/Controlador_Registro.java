package Proyecto.Controlador;

import Proyecto.Modulo.Gestor_Usuario;
import Proyecto.Modulo.Usuario;

public class Controlador_Registro {

    private Gestor_Usuario gestor;

    public Controlador_Registro() {
        // Crear el gestor para registrar el usuario en la base de datos
        this.gestor = new Gestor_Usuario();
    }

    public boolean registrarUsuario(String nombre, String apellido, String correo, String contrasena) {
        // Verificar si los campos no están vacíos
        if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
            System.out.println("Todos los campos deben ser llenados.");
            return false;
        }

        // Crear un objeto Usuario con los datos ingresados
        Usuario nuevoUsuario = new Usuario(nombre, apellido, correo, contrasena);

        // Llamar al gestor para registrar el usuario
        boolean registrado = gestor.registrarUsuario(nuevoUsuario);

        // Imprimir el resultado del registro
        if (registrado) {
            System.out.println("Usuario registrado correctamente.");
        } else {
            System.out.println("Error al registrar el usuario.");
        }

        return registrado;
    }
}
