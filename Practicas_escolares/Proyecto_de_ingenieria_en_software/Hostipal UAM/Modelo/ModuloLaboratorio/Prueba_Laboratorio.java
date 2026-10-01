package Modelo.ModuloLaboratorio;

// Importaciones necesarias

// Definición de la clase Prueba_Laboratorio
public class Prueba_Laboratorio {
    
    // Se instancia un objeto de la clase Tabla_Estudios_Medicos para acceder a sus métodos
    private Tabla_Estudios_Medicos tablaEstudios = new Tabla_Estudios_Medicos();

    // Constructor de la clase Prueba_Laboratorio
    public Prueba_Laboratorio() {
        // Se inicializa el objeto tablaEstudios
        tablaEstudios = new Tabla_Estudios_Medicos();
    }

    public void Solicar_Datos_Cita(int ID_cita, String nombre, String nombrePrueba, String fecha, String hora, String medicoSolicitante){
        tablaEstudios.solicitarDatos(ID_cita, nombre, nombrePrueba, fecha, hora, medicoSolicitante);
    }

    // Método para consultar un estudio médico por su ID de cita
    public void Consultar_Cita(int ID_cita) {
       tablaEstudios.imprimirDatosCita(ID_cita); // Llama al método buscarEstudio_Medico de Tabla_Estudios_Medicos
    }

    // Método para eliminar un estudio médico por su ID de cita
    public void Eliminar_Cita_Estudio(int ID_cita) {
        tablaEstudios.eliminarEstudio_Medico(ID_cita); // Llama al método eliminarEstudio_Medico de Tabla_Estudios_Medicos
    }

    // Método para modificar un estudio médico por su ID de cita
    public void Modificar_Cita(int ID_cita, String nombre, String nombrePrueba, String fecha, String hora, int nuevoID_cita) {
        // Llama al método modificarEstudio_Medico de Tabla_Estudios_Medicos para modificar los datos del estudio
        tablaEstudios.modificarEstudio_Medico(ID_cita, nombre, nombrePrueba, fecha, hora, nuevoID_cita);
    }
    public void Ingreso_De_Resultados(int ID_cita, String resultados){
        tablaEstudios.solicitarResultado(ID_cita, resultados);
    }
    // Método para eliminar los resultados de un estudio médico por su ID de cita
    public void Eliminar_Resultado(int ID_cita) {
        // Llama al método eliminarResultados de Tabla_Estudios_Medicos para eliminar los resultados del estudio
        tablaEstudios.eliminarResultados(ID_cita);
    }

    // Método para modificar los resultados de un estudio médico por su ID de cita
    public void Modificar_Resultado(int ID_cita, String resultado) {
        // Llama al método modificarResultados de Tabla_Estudios_Medicos para modificar los resultados del estudio
        tablaEstudios.modificarResultados(ID_cita, resultado);
    }

    // Método para añadir un estudio al expediente médico
    public void Añadir_A_Expediente(int ID_cita, String expediente) {
        // Llama al método agregarAExpediente de Tabla_Estudios_Medicos para añadir el estudio al expediente médico
        tablaEstudios.agregarAExpediente(ID_cita, expediente);
    }

    /// Método para ver la información de todos los estudios médicos en la tabla
public void Ver_Resultados(int ID_cita) {
    // Llama al método mostrarInfoTablaEstudios de Tabla_Estudios_Medicos para mostrar la información de los estudios
    tablaEstudios.imprimirDatosEstudio(ID_cita);
}

public void Ver_informacion_cita(int ID_cita){
    tablaEstudios.imprimirDatosCita(ID_cita);
}
}