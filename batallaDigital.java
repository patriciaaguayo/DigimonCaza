import java.util.Random;
import java.util.Scanner;

public class batallaDigital {

    // Atributos

    Digimon Enemigo;
    Domador Domador;

    // Constructor

    public batallaDigital(Domador domador) {
        this.Domador = domador;
        String[] nombres = {"Agumon", "Gabumon", "Patamon", "Gatomon", "Etemon",
                "Palmon", "Veemon", "Koromon", "Devimon", "Gomamon"};
        Random rand = new Random();
        Enemigo = new Digimon(nombres[rand.nextInt(nombres.length)]);
    }

    // MÉTODOS

    public Digimon elige() {
        Scanner leer2 = new Scanner(System.in);
        System.out.println("Elija el Digimon de su equipo (0, 1, 2): ");
        int eleccion = leer2.nextInt();

        return Domador.Equipo[eleccion];
    }

    public void pelea(Digimon elegido) {
        Scanner scanner = new Scanner(System.in);
        while (Enemigo.getSalud() > 0 && elegido.getSalud() > 0) {
            System.out.println("Elija un ataque: \n\n 1. Ataque1 \n 2. Ataque2 \n 3. Capturar");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    elegido.Ataque1(Enemigo);
                    break;
                case 2:
                    elegido.Ataque2(Enemigo);
                    break;
                case 3:
                    Domador.captura(Enemigo);
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
            if (Enemigo.getSalud() > 0) {
                Enemigo.Ataque1(elegido);
            }
        }
        if (Enemigo.getSalud() <= 0) {
            System.out.println("\n " + Enemigo.getNombreDigimon() + " ha sido derrotado.");
        }
        if (elegido.getSalud() <= 0) {
            System.out.println("\n " + elegido.getNombreDigimon() + " ha sido derrotado.");
        }
    }
}
