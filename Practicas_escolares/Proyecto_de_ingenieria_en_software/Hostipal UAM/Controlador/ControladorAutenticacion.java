package Controlador;

import Modelo.ModuloAutentificacion.Gestor_Autentificacion;
import Vista.IU_Autenticacion;

public class ControladorAutenticacion {
    private IU_Autenticacion vista;
    private Gestor_Autentificacion gestorAutentificacion;

    public ControladorAutenticacion(IU_Autenticacion vista, Gestor_Autentificacion gestorAutentificacion) {
        this.vista = vista;
        this.gestorAutentificacion = gestorAutentificacion;
    }

    public void iniciarSesion(String nombreUsuario, String contraseña) {
        boolean inicioSesionExitoso = gestorAutentificacion.inicioSesion(nombreUsuario, contraseña);

        if (inicioSesionExitoso) {
            vista.mostrarMensaje("Inicio de sesión exitoso.");
            // Puedes redirigir a otra vista, mostrar un mensaje de éxito, etc.
        } else {
            vista.mostrarMensaje("Inicio de sesión fallido. Verifique sus credenciales.");
            // Puedes mostrar un mensaje de error en la interfaz de usuario, por ejemplo.
        }
    }

    public void registrarUsuario(String nombreUsuario, String correoElectronico, String contraseña) {
        gestorAutentificacion.registrarUsuario(nombreUsuario, correoElectronico, contraseña);
        vista.mostrarMensaje("Usuario registrado exitosamente.");
        // Puedes realizar acciones adicionales, como mostrar un mensaje de éxito o redirigir a otra vista.
    }

    // Método para iniciar sesión como médico
    public void iniciarSesionMedico(String nombreUsuario, String contraseña) {
        boolean inicioSesionExitoso = gestorAutentificacion.inicioSesionPersonalMedico(nombreUsuario, contraseña);

        if (inicioSesionExitoso) {
            vista.mostrarMensaje("Inicio de sesión como médico exitoso.");
            // Puedes redirigir a otra vista, mostrar un mensaje de éxito, etc.
        } else {
            vista.mostrarMensaje("Inicio de sesión como médico fallido. Verifique sus credenciales.");
            // Puedes mostrar un mensaje de error en la interfaz de usuario, por ejemplo.
        }
    }

    // Método para iniciar sesión como enfermero
    public void iniciarSesionEnfermero(String nombreUsuario, String contraseña) {
        boolean inicioSesionExitoso = gestorAutentificacion.inicioSesionPersonalMedico(nombreUsuario, contraseña);

        if (inicioSesionExitoso) {
            vista.mostrarMensaje("Inicio de sesión como enfermero exitoso.");
            // Puedes redirigir a otra vista, mostrar un mensaje de éxito, etc.
        } else {
            vista.mostrarMensaje("Inicio de sesión como enfermero fallido. Verifique sus credenciales.");
            // Puedes mostrar un mensaje de error en la interfaz de usuario, por ejemplo.
        }
    }

    // Método para iniciar sesión como laboratorista
    public void iniciarSesionLaboratorista(String nombreUsuario, String contraseña) {
        boolean inicioSesionExitoso = gestorAutentificacion.inicioSesionPersonalMedico(nombreUsuario, contraseña);

        if (inicioSesionExitoso) {
            vista.mostrarMensaje("Inicio de sesión como laboratorista exitoso.");
            // Puedes redirigir a otra vista, mostrar un mensaje de éxito, etc.
        } else {
            vista.mostrarMensaje("Inicio de sesión como laboratorista fallido. Verifique sus credenciales.");
            // Puedes mostrar un mensaje de error en la interfaz de usuario, por ejemplo.
        }
    }

    // Método para registrar un médico
    public void registrarMedico(String nombreUsuario, String contraseña, String cedulaProfesional) {
        // Crear instancia de Medico y registrar en el gestor de autenticación
        gestorAutentificacion.registrarMedico(nombreUsuario, contraseña, cedulaProfesional);
        vista.mostrarMensaje("Médico registrado exitosamente.");
    }

    // Método para registrar un enfermero
    public void registrarEnfermero(String nombreUsuario, String contraseña, String cedulaProfesional) {
        gestorAutentificacion.registrarEnfermero(nombreUsuario, contraseña, cedulaProfesional);
        vista.mostrarMensaje("Enfermero registrado exitosamente.");
    }

    // Método para registrar un laboratorista
    public void registrarLaboratorista(String nombreUsuario, String contraseña, String cedulaProfesional) {
        gestorAutentificacion.registrarLaboratorista(nombreUsuario, contraseña, cedulaProfesional);
        vista.mostrarMensaje("Laboratorista registrado exitosamente.");
    }

    public IU_Autenticacion getVista() {
        return vista;
    }
}
