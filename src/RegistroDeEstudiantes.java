import java.util.Scanner;
public class RegistroDeEstudiantes {
    static Scanner sc = new Scanner(System.in);
    static String nombreEstudiante = "N/A";
    static double nota1 = -1, nota2 = -1, nota3 = -1;
    static String sobrescribirDatos;
    public static void main(String[] args) {
        boolean estaActivo = true;
        do {

            mostrarMenu();
            System.out.print("Ingrese su opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            System.out.println("");
            switch (opcion) {
                case 1:
                    registrarEstudiante();                    
                    break;
                case 2:
                    mostrarInformacion();
                    break;
                case 3:
                    mostrarPromedio();
                    break;
                case 4:
                    mostrarResumenCompleto();
                    break;
                case 5:
                    limpiarDatos();
                    break;
                case 0:
                    estaActivo = !estaActivo;
                    System.out.println("====== Cerrando el sistema ======");
                    break;
                default:
                    if (opcion < 0 || opcion > 5) {
                        System.out.println("La opcion no es valida, intente de nuevo");
                    }
                    break;
            }
        } while (estaActivo == true);
        sc.close();
    }
    //1.Metodo para mostrar el menu
    static void mostrarMenu(){
        System.out.println("===== Sistema de Registro de Estudiantes =====\n");
        System.out.println("1. Registrar Datos de el Estudiante");
        System.out.println("2. Mostrar Datos del Estudiante actual");
        System.out.println("3. Calcular Promedio de Notas");
        System.out.println("4. Mostrar resumen completo del Estudiante");
        System.out.println("5. Limpiar Datos del Estudiante actual");
        System.out.println("0. Salir\n");        
    }
    //2. Metodos de la funcionalidad Registrar informacion de el estudiante 
    static void registrarEstudiante(){
        if (nombreEstudiante.equalsIgnoreCase("N/A")) {
            menuRegistroEstudiantes();
        }else{
            validarEstudiante();
        }       
    }
    static void menuRegistroEstudiantes(){
        System.out.print("Ingrese Nombre de el Estudiante: ");
        nombreEstudiante = sc.nextLine();
        System.out.print("Ingrese Nota 1: ");
        nota1 = validarNotas();
        System.out.print("Ingrese Nota 2: ");
        nota2 = validarNotas();
        System.out.print("Ingrese Nota 3: ");
        nota3 = validarNotas();
        System.out.println("\n");
    }
    static void validarEstudiante(){     
        do {            
            sobrescribirDatos(); 
            if (sobrescribirDatos.equalsIgnoreCase("s")) {
                menuRegistroEstudiantes();
                return;
            }else if (sobrescribirDatos.equalsIgnoreCase("n")) {
                System.out.println("Registro cancelado\n");
                return;
            }else{
                System.out.println("Opcion no valida vuelva a intentarlo\n");
            }
        } while (!sobrescribirDatos.equalsIgnoreCase("s")||!sobrescribirDatos.equalsIgnoreCase("n"));

    }
    static void sobrescribirDatos(){
        System.out.println("Desea sobrescribir los datos actuales (S/N): ");
        sobrescribirDatos = sc.nextLine();
    }
    static double validarNotas(){
        double nota;        
        do {
            nota = sc.nextDouble();
            if (nota >= 0 && nota <= 100) {
                return nota;
            }else{
                System.out.println("La nota no cumple con los limites establecidos, vuelva a intentarlo\n");
                System.out.print("Intente de nuevo: ");
            }
        } while (true);
    }
    //3.Metodos para mostrar informacion del estudiante actual
    static void mostrarInformacion(){
        if (nombreEstudiante.equalsIgnoreCase("N/A")) {
            System.out.println("No hay datos de estudiante registrados actualmente.");
        }else{
            infoEstudiante();
        }
    }
    static void infoEstudiante(){
        System.out.println("Nombre de el estudiante: "+nombreEstudiante);
        System.out.printf("Nota 1: %.1f  || Nota 2: %.1f  || Nota 3: %.1f%n%n",nota1,nota2,nota3);
    }
    //4.Metodos par calcular promedio de el estudiante actual
    static void mostrarPromedio(){
        if (nota1 == -1) {
            System.out.println("No hay datos registrados\n");
        }else{
            System.out.println("Nombre de el estudiante: "+nombreEstudiante);
            System.out.printf("Promedio de Notas: %.2f%n%n",calcularPromedio());
        }
    }
    static double calcularPromedio(){
        double promedio = (nota1 + nota2 + nota3)/3;
        return promedio;
    }
    //5.Metodos para mostrar resumen completo de el estudiante
    static void mostrarResumenCompleto(){
        if (nombreEstudiante.equalsIgnoreCase("N/A")) {
            System.out.println("No hay informacio guardada, registre un estudiante\n");
        }else{
            System.out.println("====== Resumen del Estudiante ======\n");
            System.out.printf("Nombre: %s%nNota 1: %.2f%nNota 2: %.2f%nNota 3: %.2f%nPromedio: %.2f%nEstado: %s%n%n",nombreEstudiante,nota1,nota2,nota3,calcularPromedio(),calcularEstado());
        }
        
    }
    static String calcularEstado(){
        String estado = (calcularPromedio() >= 60)?"Aprobado":"Reprobado";
        return estado;
    }
    //6.Metodos para limpiar los datos de el estudiante actual
    static void limpiarDatos(){
        nombreEstudiante = "N/A";
        nota1 = -1; 
        nota2 = -1;
        nota3 = -1;
        System.out.println("Los datos del estudiante actual han sido borrados exitosamente.\n");
    }
}