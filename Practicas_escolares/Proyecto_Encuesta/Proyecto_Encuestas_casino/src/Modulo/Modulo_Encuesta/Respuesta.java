package Modulo.Modulo_Encuesta;

import java.time.LocalDate;

public class Respuesta {

    // ID de la pregunta a la que pertenece la respuesta
    private String id_preg;

    // Respuesta proporcionada por el usuario
    private String valor;

    // Fecha en que se registró la respuesta
    private String fecha;

    // Constructor que guarda la respuesta y asigna automáticamente la fecha actual
    public Respuesta(String id, String valor) {
        this.id_preg = id;
        this.valor = valor;
        this.fecha = LocalDate.now().toString(); // Fecha del día actual
    }

    // Métodos getter para obtener los datos de la respuesta
    public String getId_preg() {
        return id_preg;
    }

    public String getValor() {
        return valor;
    }

    public String getFecha() {
        return fecha;
    }
}