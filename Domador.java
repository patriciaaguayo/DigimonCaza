import java.util.ArrayList;

public class Domador {

    // Atributos

    private int Contador = 0;
    ArrayList <Digimon> Equipo = new ArrayList<Digimon>(3);
    private String NombreDomador;

    // Constructor

    public Domador(String nombre){

        this.NombreDomador = nombre;
        Digimon Primero = CrearDigimonAleatorio();
        Equipo.add(Primero);
    }

    // SETTERS Y GETTERS

    public void setNombreDomador(String nombreDomador) {
        NombreDomador = nombreDomador;
    }

    public String getNombreDomador() {
        return NombreDomador;
    }

    public ArrayList<Digimon> getEquipo() {

        return this.Equipo;
    }


    // MÉTODOS

    /**
     *
     * @param digimon objeto de la clase Digimon
     * @param domador objeto de la clase Domador
     * Con este método se comprueba si el domanor tiene espacio y si no, se revisa
     * el equipo que tiene para comprobar si ha logrado el objetivo
     */

    public void captura(Digimon digimon, Domador domador) {
        if (digimon.getSalud() <= digimon.getNivel() * 10 - 20) {
            if (Equipo.size() < 3) {
                Equipo.add(digimon);
                System.out.println("\n " + digimon.getNombreDigimon() + " se ha unido a tu equipo.");
            } else {
                System.out.println("\n Equipo esta lleno. No puedes capturar mas Digimons.");
                domador.EquipoObjetivo(domador);
            }
        } else {
            System.out.println("\n " + digimon.getNombreDigimon() + " no se puede unir. " +
                    "Su salud sigue siendo muy alta. Debido a tu impaciencia " +
                    digimon.getNombreDigimon() + " ha huido");
        }
    }

    /**
     *
     * @return devuelve el nombre del digimon aleatorio
     */

    public Digimon CrearDigimonAleatorio() {
        String[] nombres = {"Agumon", "Gabumon", "Patamon", "Gatomon", "Etemon",
                "Palmon", "Veemon", "Koromon", "Devimon", "Gomamon"};

        int indice = (int) (Math.random() * nombres.length);

        Digimon Nuevo = new Digimon(nombres[indice]);

        return Nuevo;
    }

    /**
     *
     * @param domador objeto de tipo Domador que muestra el equipo que tiene
     */

    public void VerEquipo(Domador domador){

        String miEquipo = "";

        for(Digimon lista : domador.getEquipo()){

            miEquipo += "\n\n - " + lista.getNombreDigimon();

        }
        System.out.println("\n Tu equipo consta de: " + miEquipo);
    }

    /**
     *
     * @param domador objeto de tipo Domador comprueba si ha llegado al equipo objetivo
     */

    public void EquipoObjetivo(Domador domador) {

        boolean tieneAgumon = false;
        boolean tieneGabumon = false;
        boolean tienePatamon = false;

        for (Digimon digimon : domador.getEquipo()) {
            if (digimon != null) {
                if (digimon.getNombreDigimon().equals("Agumon")) {
                    tieneAgumon = true;
                } else if (digimon.getNombreDigimon().equals("Gabumon")) {
                    tieneGabumon = true;
                } else if (digimon.getNombreDigimon().equals("Patamon")) {
                    tienePatamon = true;
                }
            }
        }

        if (tieneAgumon && tieneGabumon && tienePatamon) {
            System.out.println("\n Enhorabuena, has conseguido en tu equipo a Agumon, Gabumon y Patamon.");
        } else {
            System.out.println("\n Lastima, no has logrado conseguir en tu equipo a Agumon, Gabumon y Patamon.");
        }
    }

    /**
     *
     * @param domador objeto de la clase Domador
     * @return Retorna si tiene Digimons disponibles en su equipo
     */

    public boolean tieneDigimonsDisponibles(Domador domador) {
        for (Digimon digimon : domador.getEquipo()) {
            if (digimon.getSalud() > 0) {
                return true;
            }
        }
        return false;
    }

    public void reset() {
        this.Equipo.clear();
        this.NombreDomador = null;
    }
}