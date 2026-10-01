package Proyecto.Modulo;

public class Informacion {
    private String idNom;
    private String info;

    // Constructor vacío
    public Informacion() {
    }

    // Constructor con parámetros
    public Informacion(String idNom, String info) {
        this.idNom = idNom;
        this.info = info;
    }

    // Getters y Setters
    public String getIdNom() {
        return idNom;
    }

    public void setIdNom(String idNom) {
        this.idNom = idNom;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    

   
}