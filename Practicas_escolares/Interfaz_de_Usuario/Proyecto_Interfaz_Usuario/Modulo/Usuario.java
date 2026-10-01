package Proyecto.Modulo;

public class Usuario {
    
    private String nombreU;
    private String apellidoU;
    private String correoU;
    private String contrasenaU;

    public Usuario(String nombreU, String apellidoU, String correoU, String contrasenaU){
        this.nombreU = nombreU;
        this.apellidoU = apellidoU;
        this.correoU = correoU;
        this.contrasenaU = contrasenaU;
    }

    public Usuario(){

    }

    public String getNombreU(){
        return nombreU;
    }

    public void setNombre(String nombreU){
        this.nombreU = nombreU;
    }

    public String getApellidoU(){
        return apellidoU;
    }

    public void setApellido(String apellidoU){
        this.apellidoU = apellidoU;
    }

    public String getCorreoU(){
        return correoU;
    }

    public void setCorreoU(String correoU){
        this.correoU = correoU;
    }
    
    public String getContrasenaU(){
        return contrasenaU;
    }

    public void setContrasenaU(String contrasenaU){
        this.contrasenaU = contrasenaU;
    }
    
}
