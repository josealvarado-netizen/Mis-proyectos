package Modelo.ModuloAutentificacion;

import Modelo.ModuloEnfermeria.Enfermero;
import Modelo.ModuloExpediente.Medico;
import Modelo.ModuloLaboratorio.Laboratorista;
import Modelo.ModuloPersonalMedico.Tabla_Personal_Medico;


public class Autenticacion {
    // Declaración de atributos
    // Nota: los atributos son instancias de clases definidas en el módulo de autenticación
    //private Usuario usuario;
    private TablaUsuarios tablaUsuarios;
    private Tabla_Personal_Medico tablaPersonalMedico;

    // Constructor para inicializar la tabla de usuarios
    public Autenticacion() {
        tablaUsuarios = new TablaUsuarios();
        tablaPersonalMedico = new Tabla_Personal_Medico();
    }

    // Método para registrar un nuevo usuario en la tabla de usuarios
    public void registroNuevoUsuario(Usuario nuevousuario) {
        tablaUsuarios.agregarUsuario(nuevousuario);
        System.out.println("Su usuario "+ nuevousuario.getNombreUsuario() +"se ha agregado correctamente.");
    }
    
    // Método para validar los datos de inicio de sesión
    public boolean validaDatosInicioSesion(String nombreUsuario, String contraseña) {
        // Implementación de la validación
        Usuario usuarioValidado = tablaUsuarios.buscarUsuario(nombreUsuario);
        if (usuarioValidado != null) {
            return usuarioValidado.getContraseña().equals(contraseña);
        }
        return false;
    }

    public void eliminarUsuario(String nombreUsuario) {
        tablaUsuarios.eliminarUsuario(nombreUsuario);
    }

    public boolean validaDatosInicioSesionPersonal(String nombreUsuario, String contraseña) {
        Usuario usuarioValidado = tablaPersonalMedico.buscarUsuario(nombreUsuario);
        if (usuarioValidado instanceof Medico || usuarioValidado instanceof Enfermero || usuarioValidado instanceof Laboratorista) {
                return usuarioValidado.getContraseña().equals(contraseña);
            }
        return false;
        }

    // Funciones para médicos
    public void registrarMedico(Medico nuevoMedico) {
        tablaPersonalMedico.agregarUsuario(nuevoMedico);
        System.out.println("Médico " + nuevoMedico.getNombreUsuario() + " registrado correctamente.");
    }

    // public boolean inicioSesionMedico(String nombreUsuario, String contraseña) {
    //     return tablaPersonalMedico.validaDatosInicioSesionPersonal(nombreUsuario, contraseña);
    // }

    // Funciones para enfermeros
    public void registrarEnfermero(Enfermero nuevoEnfermero) {
        tablaPersonalMedico.agregarUsuario(nuevoEnfermero);
        System.out.println("Enfermero " + nuevoEnfermero.getNombreUsuario() + " registrado correctamente.");
    }

    // public boolean inicioSesionEnfermero(String nombreUsuario, String contraseña) {
    //     return tablaPersonalMedico.validaDatosInicioSesionPersonal(nombreUsuario, contraseña);
    // }

    // Funciones para laboratoristas
    public void registrarLaboratorista(Laboratorista nuevoLaboratorista) {
        tablaPersonalMedico.agregarUsuario(nuevoLaboratorista);
        System.out.println("Laboratorista " + nuevoLaboratorista.getNombreUsuario() + " registrado correctamente.");
    }

    // public boolean inicioSesionLaboratorista(String nombreUsuario, String contraseña) {
    //     return tablaPersonalMedico.validaDatosInicioSesionPersonal(nombreUsuario, contraseña);
    // }

    
    // public boolean validaDatosInicioSesionPersonal(String nombreUsuario, String contraseña) {
    //     return tablaPersonalMedico.validaDatosInicioSesionPersonal(nombreUsuario, contraseña);
    // }

    // Método para mostrar la información de la tabla de usuarios
    public void mostrarInfoTablaUsuarios() {
        tablaUsuarios.mostrarInfoTablaUsuarios();
    }
}


