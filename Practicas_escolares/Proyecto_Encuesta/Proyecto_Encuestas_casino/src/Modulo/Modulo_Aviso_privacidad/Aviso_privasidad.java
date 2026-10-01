package Modulo.Modulo_Aviso_privacidad;

public class Aviso_privasidad {

    // Identificador del aviso de privacidad
    private int ID_aviso;

    // Contenido del aviso de privacidad
    private String aviso;

    // Constructor que inicializa los atributos
    public Aviso_privasidad(int ID_aviso, String aviso){
        this.ID_aviso = ID_aviso;
        this.aviso = aviso;
    }

    // Método para obtener el ID del aviso
    public  int getID_aviso(){

        return  ID_aviso;
    }

    // Método para modificar el ID del aviso
    public  void setID_aviso(int ID_aviso){

        this.ID_aviso = ID_aviso;
    }

    // Método para obtener el contenido del aviso
    public String getAviso() {

        return aviso;
    }

    // Método para modificar el contenido del aviso
    public void setAviso(String aviso) {

        this.aviso = aviso;
    }
}