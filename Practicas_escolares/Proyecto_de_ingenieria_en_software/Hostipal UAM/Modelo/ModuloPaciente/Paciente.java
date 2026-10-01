package Modelo.ModuloPaciente;

import Modelo.ModuloAutentificacion.Usuario;

// Subclase Paciente
public class Paciente extends Usuario {
    // No se necesitan campos adicionales específicos para Paciente
    public Paciente(String nombreUsuario, String contraseña) {
        super(nombreUsuario, contraseña);
    }
}