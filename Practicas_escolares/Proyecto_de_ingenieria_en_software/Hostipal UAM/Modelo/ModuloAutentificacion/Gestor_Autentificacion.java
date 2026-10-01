package Modelo.ModuloAutentificacion;

import Modelo.ModuloAvisos.Administrador;
import Modelo.ModuloEnfermeria.Enfermero;
import Modelo.ModuloExpediente.Medico;
import Modelo.ModuloLaboratorio.Laboratorista;
//import Modelo.ModuloPersonalMedico.Tabla_Personal_Medico;

public class Gestor_Autentificacion {
    
    private String claveAdministrador = "HOSPITAL";
    Autenticacion nuevaSesion = new Autenticacion();
    //private Tabla_Personal_Medico tablaPersonalMedico = new Tabla_Personal_Medico();
    
    public String getClaveAdministrador() {
        return claveAdministrador;
    }

    public void setClaveAdministrador(String claveAdministrador) {
        this.claveAdministrador = claveAdministrador;
    }

    public boolean inicioSesion(String nombreUsuario, String contraseña){
        return nuevaSesion.validaDatosInicioSesion(nombreUsuario, contraseña);
    }

    public void registrarUsuario(String nombreUsuario, String correoElectronico, String contraseña){
        Usuario nuevoUsuario = new Usuario(nombreUsuario, correoElectronico, contraseña);
        nuevaSesion.registroNuevoUsuario(nuevoUsuario);
    }

    // Métodos para inicio de sesión y registro de cada tipo de usuario
    public boolean inicioSesionAdministrador(String nombreUsuario, String contraseña) {
        // Lógica para iniciar sesión como administrador
        return nuevaSesion.validaDatosInicioSesion(nombreUsuario, contraseña);
    }

    public void registrarAdministrador(String nombreUsuario, String correoElectronico, String contraseña) {
        // Lógica para registrar un nuevo administrador
        Administrador nuevoAdministrador = new Administrador(nombreUsuario, contraseña);
        nuevaSesion.registroNuevoUsuario(nuevoAdministrador);
    }

    public boolean inicioSesionPersonalMedico(String nombreUsuario, String contraseña) {
        return nuevaSesion.validaDatosInicioSesionPersonal(nombreUsuario, contraseña);
    }

    public void registrarMedico(String nombreUsuario, String contraseña, String cedulaProfesional) {
        Medico nuevoMedico = new Medico(nombreUsuario, contraseña, cedulaProfesional);
        nuevaSesion.registrarMedico(nuevoMedico);
    }

    public void registrarEnfermero(String nombreUsuario, String contraseña, String cedulaProfesional) {
        Enfermero nuevoEnfermero = new Enfermero(nombreUsuario, contraseña, cedulaProfesional);
        nuevaSesion.registrarEnfermero(nuevoEnfermero);
    }

    public void registrarLaboratorista(String nombreUsuario, String contraseña, String cedulaProfesional) {
        Laboratorista nuevoLaboratorista = new Laboratorista(nombreUsuario, contraseña, cedulaProfesional);
        nuevaSesion.registrarLaboratorista(nuevoLaboratorista);
    }



}
