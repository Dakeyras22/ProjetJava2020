package Classes;

public class Voiture extends VehiculesTerrestre{
    private int nbPlaces;

    /**
     * Constructeur de la classe Classes.Voiture définissant une voiture
     */

    public Voiture(){
        super();
        this.nbPlaces = 0;
    }

    /* ======================================== Getters and Setters =========================================*/

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }


}
