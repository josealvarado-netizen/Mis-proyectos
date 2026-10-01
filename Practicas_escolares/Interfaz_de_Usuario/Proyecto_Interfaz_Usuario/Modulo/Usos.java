package Proyecto.Modulo;


public class Usos {
    private int anio;
    private float uso;
    private String lugar;
    private String idNom; // Clave foránea que referencia a Informacion

    // Constructor vacío
    public Usos() {
    }

    // Constructor con parámetros
    public Usos(int anio, float uso, String lugar, String idNom) {
        this.anio = anio;
        this.uso = uso;
        this.lugar = lugar;
        this.idNom = idNom;
    }

    // Getters y Setters
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public float getUso() {
        return uso;
    }

    public void setUso(float uso) {
        this.uso = uso;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getIdNom() {
        return idNom;
    }

    public void setIdNom(String idNom) {
        this.idNom = idNom;
    }
}
