public class Digimon {

    private String NombreDigimon;
    private int Nivel;
    private int PuntosAtaque;
    private int Salud;
    private int DP1; // Ataque 1 Común Gasta 1 cada vez que se usa
    private int DP2; // Ataque 2 Especial Gasta 2 cada vez que se usa

    // Constructor

    public Digimon(String nombre){

        this.NombreDigimon = nombre;
        this.Nivel = (int)(Math.random()*5)+1;
        this.PuntosAtaque = this.Nivel*5;
        this.Salud = this.Nivel*10;
        this.DP1 = 10;
        this.DP2 = 10;
    }

    // SETTERS Y GETTERS

    public void setNombreDigimon(String nombreDigimon) {
        NombreDigimon = nombreDigimon;
    }

    public String getNombreDigimon() {
        return NombreDigimon;
    }

    public int getNivel(){
        return Nivel;
    }

    public int getPuntosAtaque() {
        return PuntosAtaque;
    }

    public int getSalud() {
        return Salud;
    }

    public int getDP1() {
        return DP1;
    }

    public int getDP2() {
        return DP2;
    }

    // MÉTODOS

    public void Ataque1(Digimon enemigo) {
        enemigo.Salud -= this.PuntosAtaque;
        this.DP1--;

        System.out.println("\n " + this.NombreDigimon + " ha usado Ataque1 contra "
        + enemigo.NombreDigimon + " y le ha quitado " + this.Salud +
        " puntos de salud");
    }

    public void Ataque2(Digimon enemigo) {
        enemigo.Salud -= this.PuntosAtaque*2;
        this.DP2 -= 2;

        System.out.println("\n " + this.NombreDigimon + " ha usado Ataque2 contra "
                + enemigo.NombreDigimon + " y le ha quitado " + this.Salud +
                " puntos de salud");
    }

}
