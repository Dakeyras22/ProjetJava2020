public class VehiculesTerrestre extends Vehicules {

    private int km;
    private int puissance;

    public VehiculesTerrestre(){
        super();
        this.km = 0;
        this.puissance = 0;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }
}
