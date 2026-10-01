package Proyecto.Controlador;

import Proyecto.Modulo.Gestor_IS_Admin;

public class Controlador_IS_Admin {
    private Gestor_IS_Admin gestor;

    public Controlador_IS_Admin() {
        this.gestor = new Gestor_IS_Admin();
    }

    public boolean validarCredenciales(String correo, String contraseña) {
        return gestor.comprobarUsuario(correo, contraseña);
    }
}
