package Modelo.ModuloLaboratorio;

// Clase que representa un estudio médico
public class Estudio_Medico {
    // Atributos
    private int ID_cita; // ID de la cita
    private String nombre; // Nombre del paciente
    private String nombrePrueba; // Tipo de prueba
    private String fecha; // Fecha del estudio
    private String hora; // Hora del estudio
    private String medicoSolicitante; // Médico que solicitó el estudio

    // Constructor para inicializar todos los atributos
    public Estudio_Medico(int ID_cita, String nombre, String nombrePrueba, String fecha, String hora, String medicoSolicitante) {
        this.ID_cita = ID_cita;
        this.nombre = nombre;
        this.nombrePrueba = nombrePrueba;
        this.fecha = fecha;
        this.hora = hora;
        this.medicoSolicitante = medicoSolicitante;
    }

    // Constructor para solicitar nombre paciente, fecha, hora y ID de cita
    public Estudio_Medico(String nombre, String fecha, String hora, int ID_cita) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.ID_cita = ID_cita;
    }

    // Constructor vacío
    public Estudio_Medico() {
        
    }

    // Métodos para obtener y establecer los valores de los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrePrueba() {
        return nombrePrueba;
    }

    public void setNombrePrueba(String nombrePrueba) {
        this.nombrePrueba = nombrePrueba;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getid_cita() {
        return ID_cita;
    }

    public void setid_cita(int ID_cita) {
        this.ID_cita = ID_cita;
    }

    public String getMedicoSolicitante() {
        return medicoSolicitante;
    }

    public void setMedicoSolicitante(String medicoSolicitante) {
        this.medicoSolicitante = medicoSolicitante;
    }
}

