package Vista;

import java.util.Scanner;
import Controlador.ControladorAutenticacion;
import Modelo.ModuloAutentificacion.Gestor_Autentificacion;

public class IU_Autenticacion {
    private Scanner scanner;
    private Gestor_Autentificacion gestor;
    private ControladorAutenticacion controlador;

    public IU_Autenticacion() {
        scanner = new Scanner(System.in);
        gestor = new Gestor_Autentificacion();
        controlador = new ControladorAutenticacion(this, gestor);
    }

    public int mostrarMenuInicio() {
        System.out.println("Bienvenido");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Iniciar Sesión");
        System.out.println("2. Registrarse");
        System.out.print("Ingrese su opción: ");
        return scanner.nextInt();
    }

    public int mostrarMenuInicioSesion() {
        System.out.println("Inicio de Sesión");
        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1. Administrador");
        System.out.println("2. Personal Médico");
        System.out.println("3. Paciente");
        System.out.print("Ingrese su opción: ");
        return scanner.nextInt();
    }

    public int mostrarMenuRegistroUsuario() {
        System.out.println("Registro de Nuevo Usuario");
        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1. Personal Médico");
        System.out.println("2. Paciente");
        System.out.println("3. Administrador");
        System.out.print("Ingrese su opción: ");
        return scanner.nextInt();
    }

    public int mostrarMenuPersonalMedico() {
        System.out.println("Seleccione el tipo de personal médico:");
        System.out.println("1. Médico");
        System.out.println("2. Enfermero");
        System.out.println("3. Laboratorista");
        System.out.print("Ingrese su opción: ");
        return scanner.nextInt();
    }

    public void mostrarFormularioInicioSesion() {
        scanner.nextLine(); // Limpiar el búfer después de leer un entero
        System.out.println("Inicio de Sesión");
        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contraseña = scanner.nextLine();
        // Llamar al método del controlador para iniciar sesión
        controlador.iniciarSesion(nombreUsuario, contraseña);
    }

    // Método para mostrar el formulario de inicio de sesión para médicos
    public void mostrarFormularioInicioSesionMedico() {
        scanner.nextLine();
        System.out.println("Inicio de Sesión como Médico");
        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contraseña = scanner.nextLine();
        controlador.iniciarSesionMedico(nombreUsuario, contraseña);
    }

    // Método para mostrar el formulario de inicio de sesión para enfermeros
    public void mostrarFormularioInicioSesionEnfermero() {
        scanner.nextLine();
        System.out.println("Inicio de Sesión como Enfermero");
        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contraseña = scanner.nextLine();
        controlador.iniciarSesionEnfermero(nombreUsuario, contraseña);
    }

    // Método para mostrar el formulario de inicio de sesión para laboratoristas
    public void mostrarFormularioInicioSesionLaboratorista() {
        scanner.nextLine();
        System.out.println("Inicio de Sesión como Laboratorista");
        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contraseña = scanner.nextLine();
        controlador.iniciarSesionLaboratorista(nombreUsuario, contraseña);
    }
    
    
    public void mostrarFormularioRegistro() {
        scanner.nextLine(); // Limpiar el buffer
        System.out.println("Registro de Nuevo Usuario");
        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese su correo electrónico:");
        String correoElectronico = scanner.nextLine();
        System.out.println("Ingrese una contraseña:");
        String contraseña = scanner.nextLine();
        // Llamar al método del controlador para registrar usuario
        controlador.registrarUsuario(nombreUsuario, correoElectronico, contraseña);
    }

    public void mostrarFormularioRegistroMedico() {
        scanner.nextLine(); // Limpiar el buffer
        System.out.println("Registro de Nuevo Médico");
        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese una contraseña:");
        String contraseña = scanner.nextLine();
        System.out.println("Ingrese la cédula profesional:");
        String cedulaProfesional = scanner.nextLine();
        
        // Llamar al método del controlador para registrar un médico
        controlador.registrarMedico(nombreUsuario,contraseña, cedulaProfesional);
    }
    
    public void mostrarFormularioRegistroEnfermero() {
        scanner.nextLine(); // Limpiar el buffer
        System.out.println("Registro de Nuevo Enfermero");
        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese una contraseña:");
        String contraseña = scanner.nextLine();
        System.out.println("Ingrese la cédula profesional:");
        String cedulaProfesional = scanner.nextLine();
        
        // Llamar al método del controlador para registrar un enfermero
        controlador.registrarEnfermero(nombreUsuario, contraseña, cedulaProfesional);
    }
    
    public void mostrarFormularioRegistroLaboratorista() {
        scanner.nextLine(); // Limpiar el buffer
        System.out.println("Registro de Nuevo Laboratorista");
        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese una contraseña:");
        String contraseña = scanner.nextLine();
        System.out.println("Ingrese la cédula profesional:");
        String cedulaProfesional = scanner.nextLine();
        
        // Llamar al método del controlador para registrar un laboratorista
        controlador.registrarLaboratorista(nombreUsuario,contraseña, cedulaProfesional);
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    

}

