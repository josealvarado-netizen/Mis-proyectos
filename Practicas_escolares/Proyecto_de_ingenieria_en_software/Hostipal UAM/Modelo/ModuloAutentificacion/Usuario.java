package Modelo.ModuloAutentificacion;

public class Usuario {
    private String nombreUsuario;
    private String contraseña;
    private String correoElectronico;

    
    // Constructor que acepta nombreUsuario y contraseña
    public Usuario(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        // Inicializa otros campos si es necesario
    }

    // Otro constructor que acepta nombreUsuario, contraseña y correoElectronico
    public Usuario(String nombreUsuario, String correoElectronico, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.correoElectronico = correoElectronico;
        // Inicializa otros campos si es necesario
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correoElectronico;
    }

    public void setCorreo(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }


}
