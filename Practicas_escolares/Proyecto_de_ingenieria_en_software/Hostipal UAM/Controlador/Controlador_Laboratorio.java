package Controlador;

import Modelo.ModuloLaboratorio.Gestor_Laboratorio;
import Vista.IU_Laboratorio;

// Definición de la clase Controlador_Laboratorio
public class Controlador_Laboratorio {
    private IU_Laboratorio vistaLab; // Referencia a la vista de laboratorio
    private Gestor_Laboratorio gestorLaboratorio; // Referencia al gestor de laboratorio
    
    // Constructor de la clase que acepta un objeto IU_Laboratorio y un objeto Gestor_Laboratorio
    public Controlador_Laboratorio(IU_Laboratorio vistaLab, Gestor_Laboratorio gestorLaboratorio) {
        this.vistaLab = vistaLab;
        this.gestorLaboratorio = gestorLaboratorio;
    }
    
    // Método para generar una cita médica
    public void Generar_cita(int ID_cita, String nombre, String nombrePrueba, String fecha, String hora, String medicoSolicitante){
        vistaLab.mostrarMensaje("Suiendo datos"); // Mostrar mensaje en la vista
        gestorLaboratorio.Solicar_Datos_Cita(ID_cita, nombre, nombrePrueba, fecha, hora, medicoSolicitante); // Llamar al método en el gestor
        vistaLab.mostrarMensaje("Preparando... Por favor espere..."); // Mostrar mensaje en la vista
    }
    
    // Método para consultar una cita médica
    public void Cita(int ID_cita){
        vistaLab.mostrarMensaje("Seleccion Consulta de cita"); // Mostrar mensaje en la vista
        gestorLaboratorio.ConsultarCita(ID_cita); // Llamar al método en el gestor
        vistaLab.mostrarMensaje("Redirigiendo...."); // Mostrar mensaje en la vista
    }

    // Método para cancelar una cita médica
    public void Cancelar_cita(int ID_cita){
        vistaLab.mostrarMensaje("Seleccion Cancelar cita"); // Mostrar mensaje en la vista
        gestorLaboratorio.EliminarCita(ID_cita); // Llamar al método en el gestor
        vistaLab.mostrarMensaje("Actualizando...."); // Mostrar mensaje en la vista
        
    }

    // Método para actualizar una cita médica
    public void Actualizar_cita(int ID_cita, String nombre, String nombrePrueba, String fecha, String hora, int nuevoID_cita){
        vistaLab.mostrarMensaje("Seleccion modificacion de cita"); // Mostrar mensaje en la vista
        vistaLab.mostrarMensaje("Redirigiendo...."); // Mostrar mensaje en la vista
        gestorLaboratorio.Modificar_Datos_Cita(ID_cita, nombre, nombrePrueba, fecha, hora, nuevoID_cita); // Llamar al método en el gestor
    }

    // Método para introducir resultados de una prueba
    public void introduccion_De_resultados(int ID_cita, String resultados){
        vistaLab.mostrarMensaje("Seleccion Agregar resultados"); // Mostrar mensaje en la vista
        vistaLab.mostrarMensaje("Redirigiendo...."); // Mostrar mensaje en la vista
        gestorLaboratorio.Ingreso_Resultados(ID_cita, resultados); // Llamar al método en el gestor
    }

    // Método para ver resultados de una prueba
    public void Ver_Resultados(int ID_cita){
        vistaLab.mostrarMensaje("Seleccion visualizar Resultados"); // Mostrar mensaje en la vista
        vistaLab.mostrarMensaje("Preparando...."); // Mostrar mensaje en la vista
        gestorLaboratorio.Buscar_Resultado_Lab(ID_cita); // Llamar al método en el gestor
    }

    // Método para actualizar resultados de una prueba
    public void Actualizar_Resultados(int ID_cita, String resultados){
        vistaLab.mostrarMensaje("Seleccion Actualizar informacion de resultados"); // Mostrar mensaje en la vista
        vistaLab.mostrarMensaje("Redirigiendo...."); // Mostrar mensaje en la vista
        gestorLaboratorio.Modifcar_Resultados(ID_cita, resultados); // Llamar al método en el gestor
    }

    // Método para borrar resultados de una prueba
    public void Borrar_Resultados(int ID_cita){
        vistaLab.mostrarMensaje("Selección eliminar Resultados de Examen clinico"); // Mostrar mensaje en la vista
        gestorLaboratorio.Eliminar_Resultados(ID_cita); // Llamar al método en el gestor
        vistaLab.mostrarMensaje("Actualizando...."); // Mostrar mensaje en la vista
    }

    // Método para actualizar expediente médico
    public void Actualizar_Expediente(int ID_cita, String nombre){
        vistaLab.mostrarMensaje("Selección subir al expediente"); // Mostrar mensaje en la vista
        gestorLaboratorio.Subir_A_Expedeinte(ID_cita, nombre); // Llamar al método en el gestor
        vistaLab.mostrarMensaje("Actualizando Expediente..."); // Mostrar mensaje en la vista
    }
}
 

    
