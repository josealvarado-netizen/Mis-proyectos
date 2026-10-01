package Vista;

import java.util.Scanner;
import Controlador.Controlador_Laboratorio;
import Modelo.ModuloLaboratorio.Gestor_Laboratorio;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IU_Laboratorio vista = new IU_Laboratorio();
        Gestor_Laboratorio gestor_Laboratorio = new Gestor_Laboratorio();

        boolean continuar = true;

        while (continuar) {
            int opcionMenu = vista.Menu_Selección_Usuario();

            switch (opcionMenu) {
                case 1:
                    while (true) {
                        int seleccionAdmin = vista.MostrarMenuAdmin();
                        switch (seleccionAdmin) {
                            case 1:
                                System.out.println("Ingrese el ID de la cita a modificar: ");
                                int ID_cita = Integer.parseInt(scanner.nextLine());
                                System.out.println("Ingrese el nuevo nombre del paciente: ");
                                String nombre = scanner.nextLine();
                                System.out.println("Ingrese el nuevo tipo de estudio: ");
                                String nombrePrueba = scanner.nextLine();
                                System.out.println("Ingrese la nueva fecha (YYYY-MM-DD): ");
                                String fecha = scanner.nextLine();
                                System.out.println("Ingrese la nueva hora (HH:MM AM/PM): ");
                                String hora = scanner.nextLine();
                                System.out.println("Ingrese el nuevo ID de cita: ");
                                int nuevoID_cita = Integer.parseInt(scanner.nextLine());
                                gestor_Laboratorio.Modificar_Datos_Cita(ID_cita, nombre, nombrePrueba, fecha, hora, nuevoID_cita);
                                break;
                            case 2:
                                System.out.println("Seleccionaste Eliminar Cita");
                                System.out.println("Ingresa la ID de la cita a eliminar: ");
                                ID_cita = Integer.parseInt(scanner.nextLine());
                                gestor_Laboratorio.EliminarCita(ID_cita);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opción inválida.");
                                break;
                        }
                        if (seleccionAdmin == 0) {
                            break;
                        }
                    }
                    break;

                case 2:
                    while (true) {
                        int seleccionMedico = vista.MostrarMenuMedico();
                        switch (seleccionMedico) {
                            case 1:
                                System.out.println("Introduce la ID de los estudios a consultar: ");
                                int ID_cita = Integer.parseInt(scanner.nextLine());
                                gestor_Laboratorio.Ver_Resultados(ID_cita);
                                break;
                            default:
                                System.out.println("Opción inválida.");
                                break;
                        }
                        if (seleccionMedico == 0) {
                            break;
                        }
                    }
                    break;

                case 3:
                    while (true) {
                        int seleccionMenuPaciente = vista.MostrarMenuPaciente();
                        switch (seleccionMenuPaciente) {
                            case 1:
                                System.out.println("Ingreso de datos para generar nueva cita");
                                System.out.println("Ingrese el ID de la cita a modificar: ");
                                int ID_cita = Integer.parseInt(scanner.nextLine());
                                System.out.println("Ingrese el nuevo nombre del paciente: ");
                                String nombre = scanner.nextLine();
                                System.out.println("Ingrese el nuevo tipo de estudio: ");
                                String nombrePrueba = scanner.nextLine();
                                System.out.println("Ingrese la nueva fecha (YYYY-MM-DD): ");
                                String fecha = scanner.nextLine();
                                System.out.println("Ingrese la nueva hora (HH:MM AM/PM): ");
                                String hora = scanner.nextLine();
                                System.out.println("Ingrese el nombre del médico solicitante del estudio: ");
                                String medicoSolicitante = scanner.nextLine();
                                System.out.println("Ingrese el nuevo ID de cita: ");
                                int nuevoID_cita = Integer.parseInt(scanner.nextLine());
                                gestor_Laboratorio.Solicar_Datos_Cita(nuevoID_cita, nombre, nombrePrueba, fecha, hora, medicoSolicitante);
                                break;
                            case 2:
                                System.out.println("Ingreso de datos para modificar día de cita");
                                System.out.println("Ingrese el ID de la cita a modificar: ");
                                ID_cita = Integer.parseInt(scanner.nextLine());
                                System.out.println("Ingrese el nuevo nombre del paciente: ");
                                nombre = scanner.nextLine();
                                System.out.println("Ingrese el nuevo tipo de estudio: ");
                                nombrePrueba = scanner.nextLine();
                                System.out.println("Ingrese la nueva fecha (YYYY-MM-DD): ");
                                fecha = scanner.nextLine();
                                System.out.println("Ingrese la nueva hora (HH:MM AM/PM): ");
                                hora = scanner.nextLine();
                                System.out.println("Ingrese el nuevo ID de cita: ");
                                nuevoID_cita = Integer.parseInt(scanner.nextLine());
                                gestor_Laboratorio.Modificar_Datos_Cita(ID_cita, nombre, nombrePrueba, fecha, hora, nuevoID_cita);
                                break;
                            case 3:
                                System.out.println("Seleccionaste Eliminar Cita");
                                System.out.println("Ingresa la ID de la cita a eliminar: ");
                                ID_cita = Integer.parseInt(scanner.nextLine());
                                gestor_Laboratorio.EliminarCita(ID_cita);
                                break;
                            case 4:
                                System.out.println("Seleccion Ver Resultados de laboratorio");
                                System.out.println("Ingresa el ID de la cita para ver los resultados");
                                ID_cita = Integer.parseInt(scanner.nextLine());
                                gestor_Laboratorio.Ver_Resultados(ID_cita);
                                break;
                            case 5:
                                System.out.println("Seleccion Ver Datos de la cita");
                                System.out.println("Ingresa el ID de tu cita: ");
                                ID_cita = Integer.parseInt(scanner.nextLine());
                                gestor_Laboratorio.ConsultarCita(ID_cita);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opción inválida.");
                                break;
                        }
                        if (seleccionMenuPaciente == 0) {
                            break;
                        }
                    }
                    break;

                case 4:
                    while (true) {
                        int seleccionLaboratorista = vista.MostrarMenuLaboratorista();
                        switch (seleccionLaboratorista) {
                            case 1:
                                System.out.println("Seleccion Generar Resultados de laboratorio");
                                System.out.println("Ingrese el ID de la cita para colocar sus Resultados");
                                int ID_cita = Integer.parseInt(scanner.nextLine());
                                System.out.println("Ingrese el resultado de los análisis: ");
                                String resultados = scanner.nextLine();
                                gestor_Laboratorio.Ingreso_Resultados(ID_cita, resultados);
                                break;
                            case 2:
                                System.out.println("Selección Actualizar Expediente");
                                System.out.println("Ingresa el ID de la cita a buscar: ");
                                ID_cita = Integer.parseInt(scanner.nextLine());
                                System.out.println("Ingresa el nombre del paciente: ");
                                String nombre = scanner.nextLine();
                                gestor_Laboratorio.Subir_A_Expedeinte(ID_cita, nombre);
                                break;
                            case 3:
                                System.out.println("Selección Modificar resultados");
                                System.out.println("Ingrese la ID de la cita para modificar los resultados: ");
                                ID_cita = Integer.parseInt(scanner.nextLine());
                                System.out.println("Ingrese los nuevos resultados: ");
                                resultados = scanner.nextLine();
                                gestor_Laboratorio.Modifcar_Resultados(ID_cita, resultados);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opción inválida.");
                                break;
                        }
                        if (seleccionLaboratorista == 0) {
                            break;
                        }
                    }
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }

            System.out.println("¿Desea realizar otra operación? (S/N): ");
            String continuarStr = scanner.nextLine();
            if (!continuarStr.equalsIgnoreCase("S")) {
                continuar = false;
            }
        }
        scanner.close();
    }
}
