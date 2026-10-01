package Modulo.Modulo_Usuario;

public class Usuario {

    // Atributos que representan la información del usuario
    private String rol;
    private String nombre;
    private String apellido;
    private String fecha_Nac;
    private int edad;
    private String id_Ine;
    private String correo;
    private String contraseña;

    // Constructor completo para registrar usuarios
    public Usuario(String rol,String nombre,String apellido,
                   String fecha_Nac,int edad,
                   String id_Ine,String correo,String contraseña){

        this.rol=rol;
        this.nombre=nombre;
        this.apellido=apellido;
        this.fecha_Nac=fecha_Nac;
        this.edad=edad;
        this.id_Ine=id_Ine;
        this.correo=correo;
        this.contraseña=contraseña;

    }

    // Constructor simplificado para login
    public Usuario(String rol,String correo,String contraseña){

        this.rol=rol;
        this.correo=correo;
        this.contraseña=contraseña;

    }

    // Getters y setters para acceder y modificar los datos

    public String getRol(){
        return rol;
    }

    public void setRol(String rol){
        this.rol=rol;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido=apellido;
    }

    public String getFecha_Nac(){
        return fecha_Nac;
    }

    public void setFecha_Nac(String fecha_Nac){
        this.fecha_Nac=fecha_Nac;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad=edad;
    }

    public String getId_Ine(){
        return id_Ine;
    }

    public void setId_Ine(String id_Ine){
        this.id_Ine=id_Ine;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo=correo;
    }

    public String getContraseña(){
        return contraseña;
    }

    public void setContraseña(String contraseña){
        this.contraseña=contraseña;
    }

}