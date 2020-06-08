package Classes;

public class Avion extends Vehicules{

    private int nbHeureVol;
    private int nbMoteur;

    /**
     * Constructeur de la classe avion, avec en paramètre les informations utiles pour l'utilisateur.
     */

    public Avion(){
        super();
        this.nbHeureVol = 0;
        this.nbMoteur = 0;
    }

    /* ======================================== Getters and Setters =========================================*/

    public int getNbHeureVol() {
        return nbHeureVol;
    }

    public void setNbHeureVol(int nbHeureVol) {
        this.nbHeureVol = nbHeureVol;
    }

    public int getNbMoteur() {
        return nbMoteur;
    }

    public void setNbMoteur(int nbMoteur) {
        this.nbMoteur = nbMoteur;
    }
}
