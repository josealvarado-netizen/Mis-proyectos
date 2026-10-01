package Modelo.ModuloAvisos;
import Modelo.ModuloAutentificacion.Usuario;

// Subclase Administrador
public class Administrador extends Usuario {
    private String claveAdministrador = "HOSPITAL";

    public Administrador(String nombreUsuario, String contraseña) {
        super(nombreUsuario, contraseña);
    }

    // Getter para claveAdministrador
    public String getClaveAdministrador() {
        return claveAdministrador;
    }
}
