import java.util.Scanner;

public class PokemonBatalla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Ingrese el tipo del Pokémon atacante (Agua, Fuego, Planta, Eléctrico): ");
        String tipoAtacante = scanner.nextLine().trim().toLowerCase();


        System.out.print("Ingrese el tipo del Pokémon defensor (Agua, Fuego, Planta, Eléctrico): ");
        String tipoDefensor = scanner.nextLine().trim().toLowerCase();


        if (!(tipoAtacante.equals("agua") || tipoAtacante.equals("fuego") || tipoAtacante.equals("planta") || tipoAtacante.equals("eléctrico")) ||
                !(tipoDefensor.equals("agua") || tipoDefensor.equals("fuego") || tipoDefensor.equals("planta") || tipoDefensor.equals("eléctrico"))) {
            System.out.println("Error: Tipo de Pokémon no válido.");
            return;
        }


        System.out.print("Ingrese el ataque (entre 1 y 100): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Error: El ataque debe ser un número.");
            return;
        }
        int ataque = scanner.nextInt();


        System.out.print("Ingrese la defensa (entre 1 y 100): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Error: La defensa debe ser un número.");
            return;
        }
        int defensa = scanner.nextInt();
        scanner.nextLine();


        if (ataque < 1 || ataque > 100 || defensa < 1 || defensa > 100) {
            System.out.println("Error: El ataque y la defensa deben estar entre 1 y 100.");
            return;
        }

        // utilice el .equals para mejorar la comparacion entre dos textos
        double efectividad;

        if ((tipoAtacante.equals("agua") && tipoDefensor.equals("fuego")) ||
                (tipoAtacante.equals("fuego") && tipoDefensor.equals("planta")) ||
                (tipoAtacante.equals("planta") && tipoDefensor.equals("agua")) ||
                (tipoAtacante.equals("eléctrico") && tipoDefensor.equals("agua"))) {
            efectividad = 2.0; // Ventaja
        } else if ((tipoAtacante.equals("agua") && tipoDefensor.equals("planta")) ||
                (tipoAtacante.equals("fuego") && tipoDefensor.equals("agua")) ||
                (tipoAtacante.equals("planta") && tipoDefensor.equals("fuego")) ||
                (tipoAtacante.equals("eléctrico") && tipoDefensor.equals("planta"))) {
            efectividad = 0.5;
        } else {
            efectividad = 1.0;
        }

        double daño = 50 * ((double) ataque / defensa) * efectividad;


        System.out.printf("El daño del ataque es: %.2f%n", daño);

        scanner.close();
    }
}
