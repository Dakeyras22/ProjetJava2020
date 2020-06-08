package Classes;

import java.beans.XMLDecoder;
import java.io.FileInputStream;

public class Client {

    private String nom;
    private String prenom;
    private String dateNaissance;
    private String adresse;
    private String telephone;
    private String mail;

    /**
     * Constructeur de la classe Classes.Client avec en paramètres les infos de ceux-ci
     *
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param adresse
     * @param telephone
     * @param mail
     */


    public Client(String nom,String prenom,String dateNaissance,String adresse,String telephone,String mail){

        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.telephone = telephone;
        this.mail = mail;

    }

    public Client(){}

    /*===================================================================== Getters ================================*/

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMail() {
        return mail;
    }
    /* ============================================================ Setters ========================================*/

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}
