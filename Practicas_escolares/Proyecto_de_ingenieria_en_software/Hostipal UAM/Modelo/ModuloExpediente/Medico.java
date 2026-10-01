package Modelo.ModuloExpediente;

import Modelo.ModuloAutentificacion.Usuario;

// Subclase Medico
public class Medico extends Usuario {
    private String cedulaProfesional;

    public Medico(String nombreUsuario, String contraseña, String cedulaProfesional) {
        super(nombreUsuario, contraseña);
        this.cedulaProfesional = cedulaProfesional;
    }

    // Constructor que toma solo nombre de usuario y contraseña
    public Medico(String nombreUsuario, String contraseña) {
        super(nombreUsuario, contraseña);
        // Puedes inicializar la cédula profesional con un valor predeterminado o dejarla en blanco
        // Por ejemplo:
        // this.cedulaProfesional = ""; // Inicialización con cadena vacía
        // O puedes establecerla como null
        // this.cedulaProfesional = null; // Inicialización con null
    }

    // Getter para cedulaProfesional
    public String getCedulaProfesional() {
        return cedulaProfesional;
    }
}