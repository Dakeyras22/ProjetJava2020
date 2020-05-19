public class VehiculesTerrestre {

    private int km;
    private int puissance;

    VehiculesTerrestre(int km, int puissance){
        this.km = km;
        this.puissance = puissance;
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
