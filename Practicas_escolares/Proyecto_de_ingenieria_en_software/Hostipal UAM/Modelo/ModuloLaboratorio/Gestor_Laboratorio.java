package Modelo.ModuloLaboratorio;

// Clase que gestiona las operaciones del laboratorio
public class Gestor_Laboratorio {
    // Instancia de la clase Prueba_Laboratorio para realizar las operaciones
    private Prueba_Laboratorio prueba_Laboratorio = new Prueba_Laboratorio();
    
    // Método para solicitar datos de una cita
    public void Solicar_Datos_Cita(int ID_cita, String nombre, String nombrePrueba, String fecha, String hora, String medicoSolicitante) {
        prueba_Laboratorio.Solicar_Datos_Cita(ID_cita, nombre, nombrePrueba, fecha, hora, medicoSolicitante);
    }
    
    // Método para consultar información de una cita por su ID
    public void ConsultarCita(int ID_cita) {
        prueba_Laboratorio.Ver_informacion_cita(ID_cita);
    }
    
    // Método para eliminar una cita por su ID
    public void EliminarCita(int ID_cita) {
        prueba_Laboratorio.Eliminar_Cita_Estudio(ID_cita);
    }

    // Método para modificar los datos de una cita
    public void Modificar_Datos_Cita(int ID_cita, String nombre, String nombrePrueba, String fecha, String hora, int nuevoID_cita) {
        prueba_Laboratorio.Modificar_Cita(ID_cita, nombre, nombrePrueba, fecha, hora, nuevoID_cita);
    }

    // Método para ver los resultados de una cita por su ID
    public void Ver_Resultados(int ID_cita) {
        prueba_Laboratorio.Ver_Resultados(ID_cita);
    }
    
    // Método para ingresar resultados de una cita
    public void Ingreso_Resultados(int ID_cita, String resultados) {
        prueba_Laboratorio.Ingreso_De_Resultados(ID_cita, resultados);
    }
    
    // Método para eliminar los resultados de una cita por su ID
    public void Eliminar_Resultados(int ID_cita) {
        prueba_Laboratorio.Eliminar_Resultado(ID_cita);
    }

    // Método para modificar los resultados de una cita
    public void Modifcar_Resultados(int ID_cita, String resultado) {
        prueba_Laboratorio.Modificar_Resultado(ID_cita, resultado);
    }
    
    // Método para añadir una cita al expediente
    public void Subir_A_Expedeinte(int ID_cita, String nombre) {
        prueba_Laboratorio.Añadir_A_Expediente(ID_cita, nombre);
    }

    // Método para buscar resultados en el expediente por el ID de la cita
    public void Buscar_Resultado_Lab(int Id_cita) {
        prueba_Laboratorio.Ver_Resultados(Id_cita);
    }

    // Método para añadir una cita al expediente
    public void Mandar_A_Expediente(int ID_cita, String nombre) {
        prueba_Laboratorio.Añadir_A_Expediente(ID_cita, nombre);
    }  
}
