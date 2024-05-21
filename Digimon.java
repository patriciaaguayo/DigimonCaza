public class Digimon {

    private String NombreDigimon;
    private int PuntosAtaque;
    private String Salud;
    private int CantidadAtaques;
    private int DP1; // Ataque 1
    private int DP2; // Ataque 2

    // Constructor

    public Digimon(){

    }

    public void setNombreDigimon(String nombreDigimon) {
        NombreDigimon = nombreDigimon;
    }

    public String getNombreDigimon() {
        return NombreDigimon;
    }

    public void setPuntosAtaque(int puntosAtaque) {
        PuntosAtaque = puntosAtaque;
    }

    public int getPuntosAtaque() {
        return PuntosAtaque;
    }

    public void setSalud(String salud) {
        Salud = salud;
    }

    public String getSalud() {
        return Salud;
    }

    public void setCantidadAtaques(int cantidadAtaques) {
        CantidadAtaques = cantidadAtaques;
    }

    public int getCantidadAtaques() {
        return CantidadAtaques;
    }

    public void setDP1(int DP1) {
        this.DP1 = DP1;
    }

    public int getDP1() {
        return DP1;
    }

    public void setDP2(int DP2) {
        this.DP2 = DP2;
    }

    public int getDP2() {
        return DP2;
    }

}
