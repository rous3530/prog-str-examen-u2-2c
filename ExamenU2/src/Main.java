import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalRegistros = 0;
        int totalPermitidos = 0;
        int totalDenegados = 0;

        while (true) {
            String id = ingresarId(sc,"ID (o FIN): ");

            if (id.equalsIgnoreCase("FIN")) break;

            int hora = horasTrabajadas(sc,"Hora (0..23): ");


            // Si hora fuera 0..23 -> terminar main
            if (hora < 0 || hora > 23) {
                System.out.println("Hora inválida. Fin del programa.");
                return;
            }

            if (!U2Service.esIdValido(id)) {
                System.out.println("ID inválido");
                continue;
            }

            totalRegistros++;

            if (U2Service.esHorarioPermitido(hora)) {
                totalPermitidos++;
                System.out.println("ACCESO PERMITIDO");
            } else {
                totalDenegados++;
                System.out.println("ACCESO DENEGADO");
            }
        }

        double porcentajePermitifdo=porcentaje(totalRegistros,totalPermitidos,totalDenegados);

        System.out.println("=== RESUMEN ===");
        System.out.println("Total registros: " + totalRegistros );
        System.out.println("Permitidos: " + totalPermitidos );
        System.out.println("Denegados: " + totalDenegados);
        System.out.println("Porcentaje permitidos:%"+porcentajePermitifdo );
    }


    public static String ingresarId(Scanner sc,String msg){
        System.out.println(msg);
        return sc.next();
    }

    public static int horasTrabajadas(Scanner sc,String msg){
        System.out.println(msg);
        return sc.nextInt();
    }

    public static double porcentaje(int totalRegistrados,int totalPermitidos,int totalDenegados){
        double porcentaje = 100;

        double calculo = (porcentaje/totalRegistrados)*totalPermitidos;

        return calculo;
    }
}
