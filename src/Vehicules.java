public class Vehicules {
    private String etat;
    private String modele;
    private String marque;
    private int vitesseMax;
    private int prixLocation;

    public Vehicules(String etat, String modele, String marque, int vitesseMax, int prixLocation){
        this.etat = etat;
        this.modele = modele;
        this.marque = marque;
        this.vitesseMax = vitesseMax;
        this.prixLocation = prixLocation;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getVitesseMax() {
        return vitesseMax;
    }

    public void setVitesseMax(int vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    public int getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(int prixLocation) {
        this.prixLocation = prixLocation;
    }
}
