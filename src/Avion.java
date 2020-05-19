public class Avion extends Vehicules{

    private int nbHeureVol;
    private int nbMoteur;

    public Avion(){
        super();
        this.nbHeureVol = 0;
        this.nbMoteur = 0;
    }

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
