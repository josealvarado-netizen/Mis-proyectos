package Proyecto.Modulo;

public class Administrador {
    private String correoA;
    private String contraseñaA;

    public Administrador(String correoA, String contraseñaA){
        this.correoA = correoA;
        this.contraseñaA = contraseñaA;
    }

    public Administrador(){

    }

    public String getCorreoA(){
        return correoA;
    }

    public void setCorreoA(String correoA){
        this.correoA = correoA;
    }

    public String getContrasañaA(){
        return contraseñaA;
    }

    public void setContraseñaA(String contraseñaA){
        this.contraseñaA = contraseñaA;
    }

}
