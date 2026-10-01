package Vista;

import java.util.Scanner;

public class IU_Principal {
    private Scanner scanner;

    public IU_Principal() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenuPrincipal() {
        System.out.println("Bienvenido al Sistema del Hospital");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Autenticación");
        System.out.println("0. Salir");
        System.out.print("Ingrese su opción: ");
        return scanner.nextInt();
    }

    public int mostrarMenuAutenticacion() {
        System.out.println("\nMenú de Autenticación");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Iniciar Sesión");
        System.out.println("2. Registrarse");
        System.out.println("0. Volver al Menú Principal");
        System.out.print("Ingrese su opción: ");
        return scanner.nextInt();
    }

    public void mostrarMenuExpedienteClinico() {
        System.out.println("\nMenú de Expediente Clínico");
        // Opciones de menú para el expediente clínico
    }

    public void mostrarMenuConsulta() {
        System.out.println("\nMenú de Consulta");
        // Opciones de menú para las consultas
    }

    public void mostrarMenuPagos() {
        System.out.println("\nMenú de Pagos");
        // Opciones de menú para los pagos
    }

    public void mostrarMenuLaboratorio() {
        System.out.println("\nMenú de Laboratorio");
        
        // Opciones de menú para el laboratorio
    }

    public void mostrarMenuPersonalMedico() {
        System.out.println("\nMenú de Personal Médico");
        // Opciones de menú para el personal médico
    }
}
