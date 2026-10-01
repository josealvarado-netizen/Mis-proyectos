package Proyecto.Controlador;

import Proyecto.Modulo.Gestor_IS;

public class Controlador_IS {
    private Gestor_IS gestor;

    public Controlador_IS(Gestor_IS gestor) {
        this.gestor = gestor;
    }

    public boolean verificarUsuario(String correo, String contrasena) {
        return gestor.verificarUsuarioEnBD(correo, contrasena);
    }
}
