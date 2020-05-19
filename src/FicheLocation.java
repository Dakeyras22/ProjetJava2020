public class FicheLocation {

    private Client aClient;
    private Vehicules aVehicule;
    private String dateDebut;
    private String dateFin;
    private int nbJours;
    private int kmPrevu;
    private int prixPrev;

    public FicheLocation(Client aClient, Vehicules aVehicule, String dateDebut, String dateFin,int nbJours, int kmPrevu){

        this.aClient = aClient;
        this.aVehicule = aVehicule;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbJours = nbJours;
        this.kmPrevu = kmPrevu;
        this.prixPrev = 0;


    }

    /* ======================================== Getters =========================================*/

    public Client getaClient() {
        return aClient;
    }

    public Vehicules getaVehicule() {
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

    public int getPrixPrev() {
        return prixPrev;
    }

    /*======================================== Setters ===================================*/

    public void setaClient(Client aClient) {
        this.aClient = aClient;
    }

    public void setaVehicule(Vehicules aVehicule) {
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

    public void setPrixPrev(int prixPrev) {
        this.prixPrev = prixPrev;
    }

    /* ========================================= Méthodes ===============================*/


}
