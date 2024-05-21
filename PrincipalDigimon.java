import java.util.Scanner;

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

                            System.out.print("\n Introduce el nombre del Domador: ");
                            nombreDomador = leer.nextLine();
                            domador = new Domador(nombreDomador);
                            domador.VerEquipo(domador);
                            break;

                        case 2:

                            batallaDigital batalla = new batallaDigital(domador);
                            Digimon elegido = batalla.elige(domador);
                            batalla.pelea(elegido, domador);
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

    private static void MenuPrincipal() {

        System.out.println("\n -- Menu Principal: --");
        System.out.println("\n 1. Crear Jugador");
        System.out.println(" 2. Iniciar batalla");
        System.out.println(" 3. Salir");

    }

}
