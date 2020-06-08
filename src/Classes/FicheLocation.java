package Classes;

public class FicheLocation {

    private String aClient;
    private String aVehicule;
    private String dateDebut;
    private String dateFin;
    private int nbJours;
    private int kmPrevu;
    private double prixPrevu;
    private int kmFinal;
    private double prixFinal;

    /**
     * Constructeur de la classe Classes.FicheLocation que les paramètres suivants définissent
     *
     * @param client
     * @param vehicule
     * @param dateDebut
     * @param dateFin
     * @param nbJours
     * @param kmPrevu
     * @param prixPrevu
     */

    public FicheLocation(String client, String vehicule, String dateDebut, String dateFin,int nbJours, int kmPrevu, double prixPrevu){

        this.aClient = client;
        this.aVehicule = vehicule;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbJours = nbJours;
        this.kmPrevu = kmPrevu;
        this.prixPrevu = prixPrevu;
        this.kmFinal = 0;
        this.prixFinal = 0;


    }

    public FicheLocation(){}

    /* ======================================== Getters =========================================*/

    public String getaClient() {
        return aClient;
    }

    public String getaVehicule() {
        return aVehicule;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public int getNbJours() {
        return nbJours;
    }

    public int getKmPrevu() {
        return kmPrevu;
    }

    public double getPrixPrevu() { return prixPrevu; }

    public int getKmFinal() { return kmFinal; }

    public double getPrixFinal() { return prixFinal; }

    /*======================================== Setters ===================================*/

    public void setAClient(String aClient) {
        this.aClient = aClient;
    }

    public void setAVehicule(String aVehicule) {
        this.aVehicule = aVehicule;

    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public void setNbJours(int nbJours) {
        this.nbJours = nbJours;
    }

    public void setKmPrevu(int kmPrevu) {
        this.kmPrevu = kmPrevu;
    }

    public void setPrixPrevu(double prixPrevu) {
        this.prixPrevu = prixPrevu;
    }

    public void setKmFinal(int kmFinal) { this.kmFinal = kmFinal; }

    public void setPrixFinal(double prixFinal) { this.prixFinal = prixFinal; }

    /* ========================================= Méthodes ===============================*/


}
