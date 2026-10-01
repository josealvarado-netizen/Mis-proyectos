package Modulo.Modulo_Aviso_privacidad;

public class Gestor_avisoP implements AvisoPrivacidad {

    // Objeto que permite acceder a la tabla de avisos en la base de datos
    private Tabla_avisos BD_Aviso;

    private  Gestor_avisoP gestorAvisoP;

    // Constructor que inicializa el acceso a la tabla de avisos
    public Gestor_avisoP(){
        BD_Aviso = new Tabla_avisos();
    }

    // Método que busca un aviso de privacidad por su ID
    @Override
    public Aviso_privasidad buscaraviso(int ID_aviso) {

        return BD_Aviso.buscarAviso(ID_aviso);

    }
}