import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class batallaDigital {

    // Atributos

    Digimon Enemigo;
    Domador DomadorEnemigo;
    Domador Domador;

    // Constructor

    public batallaDigital(Domador domador) {

        this.Domador = domador;
        this.DomadorEnemigo = new Domador("Braulio");
        this.Enemigo = Digimon.CrearDigimonAleatorio();

    }

    // MÉTODOS

    public Digimon elige(Domador domador) {
        Scanner leer2 = new Scanner(System.in);
        int eleccion = -1;

        while (true) {
            try {
                System.out.println("\n Elige el Digimon de tu equipo:");
                for (int i = 0; i < domador.getEquipo().size(); i++) {
                    System.out.println((i + 1) + ": " + domador.getEquipo().get(i).getNombreDigimon());
                }

                eleccion = leer2.nextInt();

                if (eleccion >= 1 && eleccion <= domador.getEquipo().size()) {
                    return domador.getEquipo().get(eleccion - 1);
                } else {
                    System.out.println("\n Eleccion incorrecta. Elige un numero valido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n Debes introducir numeros, no letras.");
                leer2.next(); // Limpiar el scanner de la entrada inválida
            }
        }
    }

    public void pelea(Digimon elegido, Domador domador) {

        Scanner scanner = new Scanner(System.in);

        while (Enemigo.getSalud() > 0 && elegido.getSalud() > 0) {
            System.out.println("\n Elige un ataque: \n\n 1. Ataque1 \n 2. Ataque2 \n 3. Capturar");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    elegido.Ataque1(Enemigo);
                    break;
                case 2:
                    elegido.Ataque2(Enemigo);
                    break;
                case 3:
                    this.Domador.captura(Enemigo, domador);  // Usa la instancia `Domador` de la clase
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
            domador.getEquipo().remove(elegido);
        }

        if (!domador.tieneDigimonsDisponibles(domador)) {
            System.out.println("\n Todos tus Digimons han sido derrotados. Fin de la partida.");
            domador.reset();
        }
    }

}