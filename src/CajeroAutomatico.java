
public class CajeroAutomatico {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        double saldo = 50000;
        int opcion;

        do {
            System.out.println("\nCajero Automático");
            System.out.println("1. Consultar saldo actual");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> System.out.println("Su saldo actual es: $" + saldo);

                case 2 -> {
                System.out.print("Ingrese la cantidad a depositar: $");
                double deposito = scanner.nextDouble();
                if (deposito > 0) {
                    saldo += deposito;
                    System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
                } else {
                    System.out.println("Monto inválido.");
                }
            }

                case 3 -> {
                System.out.print("Ingrese la cantidad a retirar: $");
                double retiro = scanner.nextDouble();
                if (retiro > 0 && retiro <= saldo) {
                    saldo -= retiro;
                    System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
                } else {
                    System.out.println("Fondos insuficientes o monto inválido.");
                }
            }

                case 4 -> System.out.println("Gracias por usar el cajero. ¡Hasta pronto!");

                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}