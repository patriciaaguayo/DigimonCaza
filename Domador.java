public class Domador {

    // Atributos

    private int Contador = 0;
    private Digimon[] Equipo = new Digimon[3];
    private String NombreDomador;

    // Constructor

    public Domador(String nombre){

        this.NombreDomador = nombre;
        this.Equipo[Contador++] = new Digimon("Aleatorio");
    }

    // SETTERS Y GETTERS

    public void setNombreDomador(String nombreDomador) {
        NombreDomador = nombreDomador;
    }

    public String getNombreDomador() {
        return NombreDomador;
    }

    // MÉTODOS

    public void captura(Digimon digimon) {
        if (digimon.getSalud() <= digimon.getNivel() * 10 - 20) {
            if (Contador < 3) {
                Equipo[Contador++] = digimon;
                System.out.println("\n "+ digimon.getNombreDigimon() + " se ha unido a tu equipo.");
            } else {
                System.out.println("\n Equipo esta lleno. No puedes capturar mas Digimons.");
            }
        } else {
            System.out.println("\n "+ digimon.getNombreDigimon() + " no se puede unir. Su salud sigue siendo muy alta.");
        }
    }

    public void VerEquipo(Digimon[]equipo){

        String miEquipo = "";

        for(int i = 0; i<3; i++){
            miEquipo += "\n " + equipo[i].getNombreDigimon();

        }
        System.out.println(miEquipo);
    }
}
