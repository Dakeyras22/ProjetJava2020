package Classes;

public class Vehicules {
    private String etat;
    private String modele;
    private String marque;
    private int vitesseMax;
    private int prixLocation;
    private boolean disponible;

    /**
     * Constructeur de la classe Classes.Vehicules définissant un véhicule
     */

    public Vehicules(){
        this.etat = "neuf";
        this.modele = "non renseigné";
        this.marque = "non renseignée";
        this.vitesseMax = 0;
        this.prixLocation = 0;
        this.disponible = true;
    }

    /* ======================================== Getters and Setters =========================================*/

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

    public boolean getDisponible(){ return disponible; }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
