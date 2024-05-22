import java.util.Scanner;

/**
 * @author Patricia Aguayo Escudero
 */

public class PrincipalDigimon {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        String nombreDomador;
        Domador domador = null;

        try {

            String opcion = "";
            int n = 30;

            do {
                MenuPrincipal();
                System.out.print("\n Opcion seleccionada: ");
                opcion = leer.nextLine();

                try {

                    n = Integer.parseInt(opcion);

                    switch (n) {

                        case 1:

                            while (true) {
                                System.out.print("\n Introduce el nombre del Domador: ");
                                nombreDomador = leer.nextLine();

                                if (nombreDomador.matches("[a-zA-Z]+")) {
                                    domador = new Domador(nombreDomador);
                                    domador.VerEquipo(domador);
                                    break;

                                } else {
                                    System.out.println("\n El nombre no debe contener numeros");
                                }
                            }

                            break;

                        case 2:

                            gestionJuego(leer, domador);
                            break;

                        case 3:

                            System.out.println("\n Gracias por usar nuestros servicios.");
                            break;

                        default:
                            System.out.println("\n Opcion no valida.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("\n Introduce un numero y no letras");
                }


            } while (n != 3);

        } finally {

            leer.close();

        }
    }

    /**
     * Menus visibles para el usuario
     */

    private static void MenuPrincipal() {

        System.out.println("\n -- Menu Principal: --");
        System.out.println("\n 1. Crear Jugador");
        System.out.println(" 2. Jugar");
        System.out.println(" 3. Salir");
    }

    private static void MenuJuegos() {

        System.out.println("\n -- Menu del Juego: --");
        System.out.println("\n 1. Iniciar batalla");
        System.out.println(" 2. Salir");
        System.out.println(" 3. Volver para atras");
    }

    /**
     *
     * @param leer Scanner para cadenas
     * @param domador Onjeto de la clase Domador
     */

    private static void gestionJuego(Scanner leer, Domador domador) {

        if (domador == null) {
            System.out.println("\n Debes crear un domador antes de jugar.");
            return;
        }

        int opcionJuego = 0;

        do {

            MenuJuegos();
            System.out.print("\n Opcion seleccionada: ");
            opcionJuego = Integer.parseInt(leer.nextLine());

            switch (opcionJuego) {

                case 1:

                    batallaDigital batalla = new batallaDigital(domador);
                    Digimon elegido = batalla.elige(domador);
                    batalla.pelea(elegido, domador);

                    if (domador.getNombreDomador() == null) {
                        return;
                    }

                    break;

                case 2:

                    System.out.println("\n Gracias por usar nuestros servicios.");
                    System.exit(0);
                    break;

                case 3:

                    System.out.println("\n Volviendo al menu principal.");
                    break;

                default:
                    System.out.println("\n Opcion no valida.");
            }
        } while (opcionJuego != 3);
    }

}