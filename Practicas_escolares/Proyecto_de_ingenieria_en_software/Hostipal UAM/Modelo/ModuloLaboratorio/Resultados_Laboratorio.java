package Modelo.ModuloLaboratorio;

// Definición de la clase Resultados_Laboratorio que hereda de la clase Estudio_Medico
public class Resultados_Laboratorio extends Estudio_Medico {
    private String resultados; // Atributo para almacenar los resultados de la prueba

    // Constructor de la clase Resultados_Laboratorio que recibe un objeto Estudio_Medico y los resultados de la prueba
    public Resultados_Laboratorio(Estudio_Medico estudioMedico, String resultados) {
        // Se llama al constructor de la clase padre (Estudio_Medico) para inicializar los atributos heredados
        super(estudioMedico.getid_cita(), estudioMedico.getNombre(), estudioMedico.getNombrePrueba(), estudioMedico.getFecha(), estudioMedico.getHora(), estudioMedico.getMedicoSolicitante());
        
        // Se asigna el valor de los resultados de la prueba
        this.resultados = resultados;
    }
    
    // Constructor de la clase Resultados_Laboratorio que recibe un objeto Estudio_Medico
    public Resultados_Laboratorio(Estudio_Medico estudioMedico) {
        // Se llama al constructor de la clase padre (Estudio_Medico) para inicializar los atributos heredados
        super(estudioMedico.getid_cita(), estudioMedico.getNombre(), estudioMedico.getNombrePrueba(), estudioMedico.getFecha(), estudioMedico.getHora(), estudioMedico.getMedicoSolicitante());
    }
    
    // Método getter para obtener los resultados de la prueba
    public String getResultados() {
        return resultados;     
    }

    // Método setter para establecer los resultados de la prueba
    public void setResultados(String resultados) {
        this.resultados = resultados;
    }
}