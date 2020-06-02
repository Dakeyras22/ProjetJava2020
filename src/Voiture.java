public class Voiture extends VehiculesTerrestre{
    private int nbPlaces;

    public Voiture(){
        super();
        this.nbPlaces = 0;

    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }


}
