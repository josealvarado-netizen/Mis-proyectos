package Modulo.Modulo_Ayuda_ludopatia;

public class Informacion {

    // Nombre del centro de ayuda
    private String nombreCentro;

    // Dirección o ubicación del centro
    private String ubicacion;

    // Teléfono de contacto
    private String telefono;

    // Constructor que inicializa los datos del centro
    public Informacion(String nombreCentro, String ubicacion, String telefono){

        this.nombreCentro = nombreCentro;
        this.ubicacion = ubicacion;
        this.telefono = telefono;

    }

    // Métodos getter y setter para acceder y modificar los datos

    public String getNombreCentro() {
        return nombreCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}