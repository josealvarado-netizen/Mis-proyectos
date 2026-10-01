package Modelo.ModuloLaboratorio;

import java.util.ArrayList;
import java.util.List;

// Definición de la clase Tabla_Estudios_Medicos
public class Tabla_Estudios_Medicos {
    private List<Resultados_Laboratorio> estudios; // Lista para almacenar los estudios médicos
    
    // Constructor de la clase
    public Tabla_Estudios_Medicos(){
        estudios = new ArrayList<>(); // Inicializa la lista de estudios médicos como un ArrayList
        inicializaTabla_Estudios_Medicos(); // Llama al método para inicializar la tabla con estudios iniciales
    }
    
    // Método para inicializar la tabla con estudios iniciales
    private void inicializaTabla_Estudios_Medicos(){
        // Agrega algunos estudios iniciales a la lista de estudios
        estudios.add(new Resultados_Laboratorio(new Estudio_Medico(12563,"eduardo vaginas", "Examen de sangre", "30 de abril", "12:35","Samuel Peréz"), "tipo de Sangre O+"));
        estudios.add(new Resultados_Laboratorio(new Estudio_Medico(125, "jorge paramo", "Examen de orina", "2024-06-29", "11:50 am", "Antonio Reyes"), "sin anomalia"));
    }

    // Método para agregar un nuevo estudio a la tabla
    public void agregarEstudio(Resultados_Laboratorio estudio) {
        estudios.add(estudio);
    }

    // Método para solicitar y agregar un nuevo estudio a la tabla
    public void solicitarDatos(int ID_cita, String nombre, String nombrePrueba, String fecha, String hora, String medicoSolicitante) {
        Resultados_Laboratorio nuevoEstudio = new Resultados_Laboratorio(new Estudio_Medico(ID_cita, nombre, nombrePrueba, fecha, hora, medicoSolicitante), "");
        estudios.add(nuevoEstudio);
    }

    // Método para buscar un estudio médico por su ID de cita
    public Resultados_Laboratorio buscarEstudio_Medico(int ID_cita) {
        for (Resultados_Laboratorio estudio : estudios) {
            if (estudio.getid_cita() == ID_cita) {
                return estudio; // Devuelve el estudio si se encuentra el ID de cita
            }
        }
        return null; // Devuelve null si no se encuentra el ID de cita
    }
    
    // Método para solicitar y asignar los resultados de un estudio por su ID de cita
    public void solicitarResultado(int ID_cita, String resultados) {
        Resultados_Laboratorio estudio = buscarEstudio_Medico(ID_cita);
        if (estudio != null) {
            estudio.setResultados(resultados);
        } else {
            System.out.println("No se encontró ningún estudio médico con el ID de cita " + ID_cita);
        }
    }

    // Método para eliminar un estudio por su ID de cita
    public void eliminarEstudio_Medico(int ID_cita){
        Resultados_Laboratorio eliminarEStudio = buscarEstudio_Medico(ID_cita);
        if(eliminarEStudio != null){
            estudios.remove(eliminarEStudio);
            System.out.println("La cita con la ID: " + ID_cita + " ha sido eliminada de la Tabla Estudios Medicos");
        }else{
            System.out.println("La cita con la ID: " + ID_cita + " no se encuentra en la Tabla Estudios Medicos");
        }
    }

    // Método para modificar un estudio por su ID de cita
    public void modificarEstudio_Medico(int ID_cita, String nuevoNombrePaciente, String nuevoTipoExamen, String nuevaFecha, String nuevaHora, int nuevoID_cita){
        Resultados_Laboratorio modificarEstudio = buscarEstudio_Medico(ID_cita);
        if(modificarEstudio != null){
            modificarEstudio.setNombre(nuevoNombrePaciente);
            modificarEstudio.setNombrePrueba(nuevoTipoExamen);
            modificarEstudio.setFecha(nuevaFecha);
            modificarEstudio.setHora(nuevaHora);
            modificarEstudio.setid_cita(nuevoID_cita);
            System.out.println("Los datos de la cita con ID " + ID_cita + " han sido modificados exitosamente.");
        }else{
            System.out.println("La cita con la ID: " + ID_cita + " no se encuentra en la Tabla Estudios Medicos");
        }
    }

    // Método para eliminar los resultados de un estudio por su ID de cita
    public void eliminarResultados(int ID_cita) {
        Resultados_Laboratorio estudio = buscarEstudio_Medico(ID_cita);
        if (estudio != null && estudio instanceof Resultados_Laboratorio) {
            Resultados_Laboratorio resultadosLaboratorio = (Resultados_Laboratorio) estudio;
            resultadosLaboratorio.setResultados(null);
            System.out.println("Los resultados de la cita con ID " + ID_cita + " han sido eliminados exitosamente.");
        } else {
            System.out.println("La cita con la ID: " + ID_cita + " no es una prueba de laboratorio en la Tabla Estudios Medicos o no se encuentra.");
        }
    }

    // Método para modificar los resultados de un estudio por su ID de cita
    public void modificarResultados(int ID_cita, String nuevosResultados) {
        Resultados_Laboratorio estudio = buscarEstudio_Medico(ID_cita);
        if (estudio != null && estudio instanceof Resultados_Laboratorio) {
            Resultados_Laboratorio resultadosLaboratorio = (Resultados_Laboratorio) estudio;
            resultadosLaboratorio.setResultados(nuevosResultados);
            System.out.println("Los resultados de la cita con ID " + ID_cita + " han sido modificados exitosamente.");
        } else {
            System.out.println("La cita con la ID: " + ID_cita + " no es una prueba de laboratorio en la Tabla Estudios Medicos o no se encuentra.");
        }
    }

    // Método para agregar un estudio al expediente médico
    public void agregarAExpediente(int ID_cita, String resultados) {
        Resultados_Laboratorio estudio = buscarEstudio_Medico(ID_cita);
        if (estudio != null) {
            if (!(estudio instanceof Resultados_Laboratorio)) {
                Resultados_Laboratorio nuevoEstudio = new Resultados_Laboratorio(estudio, resultados);
                estudios.add(nuevoEstudio);
                System.out.println("El estudio ha sido agregado al expediente médico.");
            } else {
                System.out.println("El estudio ya está presente en el expediente médico.");
            }
        } else {
            System.out.println("No se encontró ningún estudio con la ID de cita proporcionada.");
        }
    }

    // Método para buscar y mostrar los datos de un estudio por su ID de cita
    public void imprimirDatosEstudio(int ID_cita) {
        for (Resultados_Laboratorio estudio : estudios) {
            if (estudio.getid_cita() == ID_cita) {
                System.out.println("Datos del estudio médico con ID de cita " + ID_cita + ":");
                System.out.println("Nombre del paciente: " + estudio.getNombre());
                System.out.println("Tipo de examen: " + estudio.getNombrePrueba());
                System.out.println("Fecha del examen: " + estudio.getFecha());
                System.out.println("Hora del examen: " + estudio.getHora());
                System.out.println("Médico solicitante: " + estudio.getMedicoSolicitante());
                System.out.println("Resultados: " + estudio.getResultados());
                return;
            }
        }
        System.out.println("No se encontró ningún estudio médico con el ID de cita " + ID_cita);
    }
    
    // Método para buscar y mostrar los datos de un estudio por su ID de cita sin los resultados de laboratorio
    public void imprimirDatosCita(int ID_cita) {
        for (Resultados_Laboratorio estudio : estudios) {
            if (estudio.getid_cita() == ID_cita) {
                System.out.println("Datos del estudio médico con ID de cita " + ID_cita + ":");
                System.out.println("Nombre del paciente: " + estudio.getNombre());
                System.out.println("Tipo de examen: " + estudio.getNombrePrueba());
                System.out.println("Fecha del examen: " + estudio.getFecha());
                System.out.println("Hora del examen: " + estudio.getHora());
                System.out.println("Médico solicitante: " + estudio.getMedicoSolicitante());
                return;
            }
        }
        System.out.println("No se encontró ningún estudio médico con el ID de cita " + ID_cita);
    }
}