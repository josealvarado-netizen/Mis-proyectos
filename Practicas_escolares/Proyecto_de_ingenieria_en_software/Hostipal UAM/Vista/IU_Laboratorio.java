package Vista;

import java.util.Scanner;
import Controlador.Controlador_Laboratorio;
import Modelo.ModuloLaboratorio.Gestor_Laboratorio;

// Definición de la clase IU_Laboratorio
public class IU_Laboratorio {
    
    private Scanner scanner; // Objeto Scanner para entrada de datos
    private Gestor_Laboratorio gestor; // Objeto Gestor_Laboratorio para interactuar con la lógica de negocio
    private Controlador_Laboratorio controlador; // Objeto Controlador_Laboratorio para gestionar las acciones del usuario

    // Constructor de la clase IU_Laboratorio
    public IU_Laboratorio (){
        scanner = new Scanner(System.in); // Inicializa el objeto Scanner
        gestor = new Gestor_Laboratorio(); // Inicializa el objeto Gestor_Laboratorio
        controlador = new Controlador_Laboratorio(this, gestor); // Inicializa el objeto Controlador_Laboratorio pasando esta instancia de IU_Laboratorio y el Gestor_Laboratorio
    }

    // Método para mostrar el menú de selección de usuario
    public int Menu_Selección_Usuario(){
        // Mostrar opciones del menú
        System.out.println("Menu de Usuario");
        System.out.println("Seleccione una opcion");
        System.out.println("1. Menu Administrador ");
        System.out.println("2. Menu Medico ");
        System.out.println("3. Menu Paciente ");
        System.out.println("4. Menu Laboratorista");
        return scanner.nextInt(); // Leer la opción seleccionada por el usuario
    }
    
    // Método para mostrar el menú de administrador
    public int MostrarMenuAdmin(){
        // Mostrar opciones del menú
        System.out.println("Menu Administrador");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Reprogramar cita laboratorio ");
        System.out.println("2. Cancelar cita laboratorio");
        System.out.println("0. Regresar al menu");
        System.out.print("Ingrese su opción: ");
        return scanner.nextInt(); // Leer la opción seleccionada por el usuario
    }

    // Método para mostrar el menú de médico
    public int MostrarMenuMedico(){
        // Mostrar opciones del menú
        System.out.println("Menu Medico");
        System.out.println("Seleccione su opción:");
        System.out.println("1. Visualizar resultados de laboratorio");
        System.out.println("0. Salir");
        return scanner.nextInt(); // Leer la opción seleccionada por el usuario
    }

    // Método para mostrar el menú de paciente
    public int MostrarMenuPaciente(){
        // Mostrar opciones del menú
        System.out.println("Menu Pacientes");
        System.out.println("Seleccione su opción: ");
        System.out.println("1. Solicitar estudio medico");
        System.out.println("2. Reagendar estudio medico");
        System.out.println("3. Cancelar estudio medico");
        System.out.println("4. Vizualizar resultados de laboratorio");
        System.out.println("5. Consultar Cita");
        return scanner.nextInt(); // Leer la opción seleccionada por el usuario
    }

    // Método para mostrar el menú de laboratorista
    public int MostrarMenuLaboratorista(){
        // Mostrar opciones del menú
        System.out.println("Menu Laboratorista");
        System.out.println("Seleccione su opción");
        System.out.println("1. Generar resultados de laboratorio");
        System.out.println("2. Agregar al expediente clinico");
        System.out.println("3. Modificar estudios medicos: ");
        return scanner.nextInt(); // Leer la opción seleccionada por el usuario
    }
    
    // Método para mostrar un mensaje en la interfaz
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Método para mostrar el formulario de generar cita
    public void Formulario_Generar_Cita(){
        // Solicitar datos para generar la cita
        System.out.println("Agendar Cita");
        System.out.println("Ingrese el ID de la cita: ");
        int ID_cita = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.println("Ingresa el nombre del paciente: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese nombre de estudio solicitado: ");
        String nombrePrueba = scanner.nextLine();
        System.out.println("Ingresa la fecha de estudio: ");
        String fecha = scanner.nextLine();
        System.out.println("Ingresa la hora del estudio: ");
        String hora = scanner.nextLine();
        System.out.println("Ingrese nombre del médico solicitante del estudio: ");
        String medicoSolicitante = scanner.nextLine();
        controlador.Generar_cita(ID_cita, nombre, nombrePrueba, fecha, hora, medicoSolicitante); // Llamar al controlador para generar la cita
    }

    // Método para mostrar el formulario de búsqueda de cita
    public void Formulario_Busqueda_Cita(){
        scanner.nextLine(); // Consumir la nueva línea
        System.out.println("Consultar cita");
        System.out.println("Ingrese el ID de su cita: ");
        int ID_cita = scanner.nextInt();
        controlador.Cita(ID_cita); // Llamar al controlador para buscar la cita
    }
    
    // Método para mostrar el formulario de eliminación de cita
    public void Formulario_Eliminar_Cita(){
        scanner.nextLine(); // Consumir la nueva línea
        System.out.println("Eliminar cita");
        System.out.println("Ingrese el ID de la cita a eliminar: ");
        int ID_cita =  scanner.nextInt();
        controlador.Cancelar_cita(ID_cita); // Llamar al controlador para eliminar la cita
    }

    // Método para mostrar el formulario de reagendamiento de cita
    public void Formulario_Reagendar_Cita(){
        // Solicitar datos para reagendar la cita
        System.out.println("Reagendar Cita de Laboratorio");
        System.out.println("Ingrese ID de la cita  a modificar: ");
        int ID_cita = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.println("Ingrese nuevo nombre del paciente: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese nuevo Estudio solicitado: ");
        String nombrePrueba = scanner.nextLine();
        System.out.println("Ingrese nueva fecha de la cita: ");
        String fecha = scanner.nextLine();
        System.out.println("Ingrese nueva hora de cita: ");
        String hora = scanner.nextLine();
        System.out.println("Ingrese nuevo ID de cita: ");
        int nuevoID_cita = scanner.nextInt();
        controlador.Actualizar_cita(ID_cita, nombre, nombrePrueba, fecha, hora, nuevoID_cita); // Llamar al controlador para reagendar la cita
    }

    // Método para mostrar el formulario de visualización de resultados
    public void Vizualizar_Resultados(){
        // Solicitar ID de la cita para visualizar resultados
        System.out.println("Resultados de laboratorio");
        System.out.println("Ingresa el ID de la cita de laboratorio");
        int ID_cita = scanner.nextInt();
        controlador.Ver_Resultados(ID_cita); // Llamar al controlador para visualizar resultados
    }

    // Método para mostrar el formulario de ingreso de resultados
    public void Ingreso_De_Resultados(){
        // Solicitar datos para ingresar resultados
        System.out.println("Agregar el Analisis del estudio");
        System.out.println("Introduce la ID de la cita: ");
        int ID_cita = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.println("Introduce el analisis correspondiente: ");
        String resultados = scanner.nextLine();
        controlador.introduccion_De_resultados(ID_cita, resultados); // Llamar al controlador para ingresar resultados
    }

    // Método para mostrar el formulario de modificación de resultados
    public void Modificar_Resultado(){
        // Solicitar ID de la cita y nuevo resultado para modificar resultados
        System.out.println("Modificar Resultados de Laboratorio");
        System.out.println("Ingrese el ID de la cita a modificar: ");
        int ID_cita = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.println("Ingrese el nuevo resultado del estudio: ");
        String resultados = scanner.nextLine();
        controlador.Actualizar_Resultados(ID_cita, resultados); // Llamar al controlador para modificar resultados
    }

    // Método para mostrar el formulario de eliminación de resultados
    public void Eliminar_Resultado(){
        // Solicitar ID de la cita para eliminar resultados
        System.out.println("Eliminar resultados: ");
        System.out.println("Ingrese el ID del estudio a eliminar: ");
        int ID_cita = scanner.nextInt();
        controlador.Borrar_Resultados(ID_cita); // Llamar al controlador para eliminar resultados
    }

    // Método para mostrar el formulario de visualización de resultados
    public void Visualizar_Resultados(){
        // Solicitar ID de la cita para visualizar resultados
        System.out.println("Ver Resultados");
        System.out.println("Ingrese el ID de los resultados a visualizar: ");
        int ID_cita = scanner.nextInt();
        controlador.Ver_Resultados(ID_cita); // Llamar al controlador para visualizar resultados
    }

    // Método para mostrar el formulario de subida a expediente
    public void Subir_A_Expedeinte(){
        // Solicitar ID de la cita y nuevo resultado para subir a expediente
        System.out.println("Ver Resultados");
        System.out.println("Ingrese el ID de los resultados a visualizar: ");
        int ID_cita = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.println("Ingrese el nuevo resultado del estudio: ");
        String resultados = scanner.nextLine();
        controlador.Actualizar_Resultados(ID_cita, resultados); // Llamar al controlador para subir a expediente
    }

}
