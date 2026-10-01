package Modulo.Modulo_Encuesta;

public class Pregunta {

    // Identificador de la pregunta
    private String id_preg;

    // Texto de la pregunta
    private String pregunta;

    // Identificador del juego al que pertenece la pregunta
    private String id_juego;

    // Tipo de pregunta (RADIO = Sí/No, TEXTO = respuesta abierta)
    private String tipo;

    // Constructor que inicializa los datos de la pregunta
    public Pregunta(String id_preg, String pregunta, String id_juego, String tipo) {
        this.id_preg = id_preg;
        this.pregunta = pregunta;
        this.id_juego = id_juego;
        this.tipo = tipo;
    }

    // Métodos getter para obtener los datos
    public String getId_preg() { return id_preg; }
    public String getPregunta() { return pregunta; }
    public String getId_juego() { return id_juego; }
    public String getTipo() { return tipo; }

    // Métodos setter para modificar los datos
    public void setId_preg(String id_preg) { this.id_preg = id_preg; }
    public void setPregunta(String pregunta) { this.pregunta = pregunta; }
    public void setId_juego(String id_juego) { this.id_juego = id_juego; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}