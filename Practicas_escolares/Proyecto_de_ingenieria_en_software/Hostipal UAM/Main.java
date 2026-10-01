import java.util.Scanner;

import Modelo.ModuloAutentificacion.Gestor_Autentificacion;
import Vista.IU_Autenticacion;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IU_Autenticacion vista = new IU_Autenticacion();
        Gestor_Autentificacion gestor = new Gestor_Autentificacion();

        // Menú de inicio
        int opcionInicio = vista.mostrarMenuInicio();
        scanner.nextLine(); // Limpiar el búfer después de leer un entero
        switch (opcionInicio) {
            case 1:
                // Iniciar sesión
                int opcionInicioSesion = vista.mostrarMenuInicioSesion();
                scanner.nextLine(); // Limpiar el búfer después de leer un entero
                switch (opcionInicioSesion) {
                    case 1:
                            // Iniciar sesión como administrador
                            System.out.println("Ingrese la clave del administrador:");
                            String claveAdministrador = scanner.nextLine();
                            if (claveAdministrador.equals(gestor.getClaveAdministrador())) {
                                vista.mostrarFormularioInicioSesion();
                            } else {
                                System.out.println("Clave incorrecta. No tiene permisos de administrador.");
                            }
                        break;
                    case 2:
                        // Iniciar sesión como personal médico
                        int tipoPersonalMedico = vista.mostrarMenuPersonalMedico();
                        scanner.nextLine(); // Limpiar el búfer después de leer un entero
                        switch (tipoPersonalMedico) {
                            case 1:
                                vista.mostrarFormularioInicioSesionMedico();
                                break;
                            case 2:
                                vista.mostrarFormularioInicioSesionEnfermero();
                                break;
                            case 3:
                                vista.mostrarFormularioInicioSesionLaboratorista();
                                break;
                            default:
                                System.out.println("Opción inválida.");
                                break;
                        }
                        break;
                    case 3:
                        // Iniciar sesión como paciente
                        vista.mostrarFormularioInicioSesion();
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
                break;
            case 2:
                // Registro de nuevo usuario
                int tipoUsuario = vista.mostrarMenuRegistroUsuario();
                scanner.nextLine(); // Limpiar el búfer después de leer un entero
                switch (tipoUsuario) {
                    case 1:
                        // Registro de personal médico
                        int tipoPersonalMedicoRegistro = vista.mostrarMenuPersonalMedico();
                        scanner.nextLine(); // Limpiar el búfer después de leer un entero
                        switch (tipoPersonalMedicoRegistro) {
                            case 1:
                                vista.mostrarFormularioRegistroMedico();
                                break;
                            case 2:
                                vista.mostrarFormularioRegistroEnfermero();
                                break;
                            case 3:
                                vista.mostrarFormularioRegistroLaboratorista();
                                break;
                            default:
                                System.out.println("Opción inválida.");
                                break;
                        }
                        break;
                    case 2:
                        // Registro de paciente
                        vista.mostrarFormularioRegistro();
                        break;
                    case 3:
                        // Registro de administrador
                        System.out.println("Ingrese la clave del administrador:");
                        String claveAdministrador = scanner.nextLine();
                        if (claveAdministrador.equals(gestor.getClaveAdministrador())) {
                            vista.mostrarFormularioRegistro();
                        } else {
                            System.out.println("Clave incorrecta. No tiene permisos de administrador.");
                        }

                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
                break;
            default:
                System.out.println("Opción inválida.");
                break;
        }
    }
}
