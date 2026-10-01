package Modelo.ModuloPersonalMedico;

import java.util.ArrayList;
import java.util.List;

import Modelo.ModuloAutentificacion.Usuario;
import Modelo.ModuloEnfermeria.Enfermero;
import Modelo.ModuloExpediente.Medico;
import Modelo.ModuloLaboratorio.Laboratorista;

public class Tabla_Personal_Medico {
    private List<Object> usuarioList;

    public Tabla_Personal_Medico() {
        usuarioList = new ArrayList<>();
        inicializaTablaUsuario(); // Inicializa la tabla de personal médico con algunos datos de ejemplo
    }

    private void inicializaTablaUsuario() {
        // Ejemplo para agregar un médico
        usuarioList.add(new Medico("DrSmith", "contrasena123", "12345678"));
        // Ejemplo para agregar un enfermero
        usuarioList.add(new Enfermero("EnfJohnson", "clave321", "87654321"));
        // Ejemplo para agregar un laboratorista
        usuarioList.add(new Laboratorista("LabDoe", "pass456", "98765432"));
    }

    public void agregarUsuario(Usuario usuario) {
        usuarioList.add(usuario);
    }

    public Usuario buscarUsuario(String nombreUsuario) {
        for (Object obj : usuarioList) {
            if (obj instanceof Usuario) {
                Usuario usuario = (Usuario) obj;
                if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                    return usuario;
                }
            }
        }
        return null;
    }

    public void eliminarUsuario(String nombreUsuario) {
        Usuario usuarioAEliminar = buscarUsuario(nombreUsuario);
        if (usuarioAEliminar != null) {
            usuarioList.remove(usuarioAEliminar);
            System.out.println("El personal médico " + nombreUsuario + " ha sido eliminado de la tabla.");
        } else {
            System.out.println("El personal médico " + nombreUsuario + " no se encuentra en la tabla.");
        }
    }

    public void mostrarInfoTablaUsuario() {
        for (Object obj : usuarioList) {
            if (obj instanceof Usuario) {
                Usuario usuario = (Usuario) obj;
                System.out.println("Nombre: " + usuario.getNombreUsuario());
                // Aquí puedes imprimir otros atributos específicos del personal médico, como el tipo (médico, enfermero, laboratorista), etc.
                System.out.println();
            }
        }
    }
}
