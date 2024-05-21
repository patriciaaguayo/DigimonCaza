import java.util.Scanner;

public class PrincipalDigimon {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        Scanner leer2 = new Scanner(System.in);

        System.out.print("\n Ingrese el nombre del Domador: ");
        String nombreDomador = leer.nextLine();
        Domador domador = new Domador(nombreDomador);

        System.out.println("\n 1. Iniciar batalla");
        System.out.println("\n 2. Salir");
        int opcion = leer2.nextInt();

        if (opcion == 1) {
            batallaDigital batalla = new batallaDigital(domador);
            Digimon elegido = batalla.elige();
            batalla.pelea(elegido);

        } else {
            System.out.println("\n Saliendo del juego.");
        }
    }
}
