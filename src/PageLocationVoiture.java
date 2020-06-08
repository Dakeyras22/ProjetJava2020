import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class PageLocationVoiture extends JFrame implements ActionListener{

    public JComboBox listeClients;
    public JComboBox listeVoiture;
    public JComboBox listeFiches;
    private JPanel panelListes;
    private JPanel panelListeClient;
    private JPanel panelListeVoiture;
    private JPanel panelListeFiches;
    private JPanel panelPrincipal;
    private JPanel panelFicheBoutons;
    private JPanel panelBoutons;
    private JPanel panelFiche;
    private JPanel panelInfoClient;
    private JPanel panelInfoVoiture;

    private JPanel panelRetour;
    private JPanel panelAjout;
    private JPanel panelConsult;
    private JPanel panelRendu;

    private JPanel panelNom;
    private JPanel panelPrenom;
    private JPanel panelDateDeNaissance;
    private JPanel panelAdresse;
    private JPanel panelTelephone;
    private JPanel panelMail;


    private JPanel panelMarque;
    private JPanel panelModele;
    private JPanel panelVitesseMax;
    private JPanel panelKm;
    private JPanel panelEtat;
    private JPanel panelPuissance;
    private JPanel panelPrix;
    private JPanel panelNbPlaces;

    private JLabel nom;
    private JLabel prenom;
    private JLabel dateDeNaissance;
    private JLabel adresse;
    private JLabel telephone;
    private JLabel mail;

    private JLabel marque;
    private JLabel modele;
    private JLabel vitesseMax;
    private JLabel km;
    private JLabel etat;
    private JLabel puissance;
    private JLabel prix;
    private JLabel nbPlace;

    private JButton retour;
    private JButton ajout;
    private JButton consult;
    private JButton rendu;

    private Client leGars;
    private Voiture laVoiture = new Voiture();
    private FicheLocation laFiche;

    private ArrayList<String> tabClients = new ArrayList<>();
    private ArrayList<String> tabVoitures = new ArrayList<>();
    private ArrayList<String> tabLocations = new ArrayList<>();


    /**
     * Constructeur de la classe PageLocationVoiture générant l'affichage de la fenêtre
     */

    public PageLocationVoiture(){

        BorderLayout borderPrincipal = new BorderLayout();
        BorderLayout borderFicheBoutons = new BorderLayout();
        GridLayout grilleListes = new GridLayout(3,1);
        GridLayout grilleFicheBoutons = new GridLayout(1,2);
        GridLayout grilleBoutons = new GridLayout(4,1);
        BorderLayout borderFiche = new BorderLayout();
        GridLayout grilleInfoClient = new GridLayout(6,1);
        GridLayout grilleInfoVoiture = new GridLayout(8,1);

        retour = new JButton("Retour");
        ajout = new JButton("Ajouter Fiche");
        consult = new JButton("Consulter fiches");
        rendu = new JButton("Fiche de Rendu");

        listeClients = new JComboBox();
        listeFiches = new JComboBox();
        panelListeClient = new JPanel();
        listeVoiture = new JComboBox();
        panelListes = new JPanel();
        panelListeVoiture = new JPanel();
        panelListeFiches = new JPanel();
        panelPrincipal = new JPanel();
        panelFicheBoutons = new JPanel();
        panelFiche = new JPanel();
        panelBoutons = new JPanel();
        panelRetour = new JPanel();
        panelRendu = new JPanel();
        panelAjout = new JPanel();
        panelConsult = new JPanel();
        panelInfoClient = new JPanel();
        panelInfoVoiture = new JPanel();

        panelNom = new JPanel();
        panelPrenom = new JPanel();
        panelDateDeNaissance = new JPanel();
        panelAdresse = new JPanel();
        panelTelephone = new JPanel();
        panelMail = new JPanel();

        panelMarque = new JPanel();
        panelModele = new JPanel();
        panelVitesseMax = new JPanel();
        panelKm = new JPanel();
        panelEtat = new JPanel();
        panelPuissance = new JPanel();
        panelPrix = new JPanel();
        panelNbPlaces = new JPanel();

        ajoutListeClient();
        if(!tabClients.isEmpty()){
            comboBoxClientInit();
        }

        ajoutListeVoiture();
        if(!tabVoitures.isEmpty()){
            comboBoxVoitureInit();
        }

        ajoutListeLocation();
        if(!tabLocations.isEmpty()){
            comboBoxLocationInit();
        }

        if(listeClients.getSelectedItem() != null) {
            leGars = ficheInitClient(listeClients.getSelectedItem().toString());
            nom = new JLabel(leGars.getNom());
            prenom = new JLabel(leGars.getPrenom());
            dateDeNaissance = new JLabel(leGars.getDateNaissance());
            adresse = new JLabel(leGars.getAdresse());
            telephone = new JLabel(leGars.getTelephone());
            mail = new JLabel(leGars.getMail());

            panelNom.add(nom);
            panelPrenom.add(prenom);
            panelAdresse.add(adresse);
            panelDateDeNaissance.add(dateDeNaissance);
            panelTelephone.add(telephone);
            panelMail.add(mail);

            panelInfoClient.setLayout(grilleInfoClient);
            panelInfoClient.add(panelNom);
            panelInfoClient.add(panelPrenom);
            panelInfoClient.add(panelDateDeNaissance);
            panelInfoClient.add(panelAdresse);
            panelInfoClient.add(panelTelephone);
            panelInfoClient.add(panelMail);

        }

        if(listeVoiture.getSelectedItem() != null) {
            laVoiture = ficheInitVoiture(listeVoiture.getSelectedItem().toString());
            marque = new JLabel(laVoiture.getMarque());
            modele = new JLabel(laVoiture.getModele());
            vitesseMax = new JLabel(String.valueOf(laVoiture.getVitesseMax()));
            km = new JLabel(String.valueOf(laVoiture.getKm()));
            etat = new JLabel(laVoiture.getEtat());
            puissance = new JLabel(String.valueOf(laVoiture.getPuissance()));
            prix = new JLabel(String.valueOf(laVoiture.getPrixLocation()));
            nbPlace = new JLabel(String.valueOf(laVoiture.getNbPlaces()));

            panelMarque.add(marque);
            panelModele.add(modele);
            panelVitesseMax.add(vitesseMax);
            panelKm.add(km);
            panelEtat.add(etat);
            panelPuissance.add(puissance);
            panelPrix.add(prix);
            panelNbPlaces.add(nbPlace);

            panelInfoVoiture.setLayout(grilleInfoVoiture);
            panelInfoVoiture.add(panelMarque);
            panelInfoVoiture.add(panelModele);
            panelInfoVoiture.add(panelVitesseMax);
            panelInfoVoiture.add(panelKm);
            panelInfoVoiture.add(panelEtat);
            panelInfoVoiture.add(panelPuissance);
            panelInfoVoiture.add(panelPrix);
            panelInfoVoiture.add(panelNbPlaces);

        }

        panelListeClient.add(listeClients);
        panelListeVoiture.add(listeVoiture);
        panelListeFiches.add(listeFiches);
        panelFiche.setLayout(borderFiche);
        panelFiche.add(panelInfoClient,BorderLayout.WEST);
        panelFiche.add(panelInfoVoiture,BorderLayout.EAST);

        panelFicheBoutons.setLayout(borderFicheBoutons);
        panelFicheBoutons.add(panelFiche);
        panelFicheBoutons.add(panelBoutons,BorderLayout.EAST);

        panelBoutons.setLayout(grilleBoutons);
        panelBoutons.add(panelAjout);
        panelBoutons.add(panelConsult);
        panelBoutons.add(panelRendu);
        panelBoutons.add(panelRetour);

        panelAjout.add(ajout);
        panelConsult.add(consult);
        panelRetour.add(retour);
        panelRendu.add(rendu);

        panelListes.setLayout(grilleListes);
        panelListes.add(panelListeClient);
        panelListes.add(panelListeVoiture);
        panelListes.add(panelListeFiches);

        panelListes.setSize(new Dimension(900,125));
        listeClients.setPreferredSize(new Dimension(900,25));
        listeVoiture.setPreferredSize(new Dimension(900,25));
        listeFiches.setPreferredSize(new Dimension(900,25));
        panelBoutons.setPreferredSize(new Dimension(300,300));
        panelFiche.setPreferredSize(new Dimension(600,375));
        panelInfoClient.setPreferredSize(new Dimension(300,375));
        panelInfoVoiture.setPreferredSize(new Dimension(300,375));

        panelPrincipal.setLayout(borderPrincipal);
        this.setContentPane(panelPrincipal);
        panelPrincipal.add(panelListes);
        panelPrincipal.add(panelFicheBoutons,BorderLayout.SOUTH);

        panelFiche.setBorder(BorderFactory.createLineBorder(Color.black));
        panelInfoClient.setBorder(BorderFactory.createLineBorder(Color.black));
        panelInfoVoiture.setBorder(BorderFactory.createLineBorder(Color.black));

        retour.addActionListener(this);
        ajout.addActionListener(this);
        consult.addActionListener(this);
        rendu.addActionListener(this);
        listeVoiture.addActionListener(this);
        listeClients.addActionListener(this);



        this.setBounds(500, 100, 900, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Page Location Voiture");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == retour){
            PageAccueil pageAccueil = new PageAccueil();
            this.setVisible(false);
        }

        if(e.getSource() == ajout){
            leGars = ficheInitClient(listeClients.getSelectedItem().toString());
            laVoiture = ficheInitVoiture(listeVoiture.getSelectedItem().toString());
            PageAjoutFiche pageAjoutFiche = new PageAjoutFiche(leGars,laVoiture);
            this.dispose();
        }

        if(e.getSource()== rendu){
            leGars = ficheInitClient(listeClients.getSelectedItem().toString());
            laVoiture = ficheInitVoiture(listeVoiture.getSelectedItem().toString());
            laFiche = ficheInitLocation(listeFiches.getSelectedItem().toString());
            PageRenduFiche pageRenduFiche = new PageRenduFiche(listeClients.getSelectedItem().toString(),listeVoiture.getSelectedItem().toString(),laFiche,leGars,laVoiture);
            this.dispose();
        }

        if (e.getSource() == consult){
            leGars = ficheInitClient(listeClients.getSelectedItem().toString());
            laVoiture = ficheInitVoiture(listeVoiture.getSelectedItem().toString());
            laFiche = ficheInitLocation(listeFiches.getSelectedItem().toString());
            PageConsultFiche pageConsult = new PageConsultFiche(listeClients.getSelectedItem().toString(),listeVoiture.getSelectedItem().toString(),laFiche,leGars,laVoiture);
            this.setVisible(false);
        }

        if(e.getSource() == listeClients){
            leGars = ficheInitClient(listeClients.getSelectedItem().toString());
            nom.setText(leGars.getNom());
            prenom.setText(leGars.getPrenom());
            dateDeNaissance.setText(leGars.getDateNaissance());
            adresse.setText(leGars.getAdresse());
            telephone.setText(leGars.getTelephone());
            mail.setText(leGars.getMail());
            panelInfoClient.repaint();
        }

        if(e.getSource() == listeVoiture){

            laVoiture = ficheInitVoiture(listeVoiture.getSelectedItem().toString());
            marque.setText(laVoiture.getMarque());
            modele.setText(laVoiture.getModele());
            vitesseMax.setText(String.valueOf(laVoiture.getVitesseMax()));
            km.setText(String.valueOf(laVoiture.getKm()));
            etat.setText(laVoiture.getEtat());
            puissance.setText(String.valueOf(laVoiture.getPuissance()));
            prix.setText(String.valueOf(laVoiture.getPrixLocation()));
            nbPlace.setText(String.valueOf(laVoiture.getNbPlaces()));
            panelInfoVoiture.repaint();

        }

    }

    /**
     * Méthode générant un objet Client à partir d'un fichier .xml
     *
     * @param client
     * @return
     */

    public Client ficheInitClient(String client) {

        Client mec = null;
        try {
            FileInputStream fichier = new FileInputStream("./Client/" + client + ".xml");
            XMLDecoder decoder = new XMLDecoder(fichier);
            mec = (Client) decoder.readObject();
            decoder.close();
            fichier.close();

        }

        catch(Exception e){
            System.out.println(e);
        }
        return mec;
    }

    /**
     * Méthode générant un objet FicheLocation à partir d'un fichier .xml
     *
     * @param location
     * @return
     */

    public FicheLocation ficheInitLocation(String location) {

        FicheLocation fiche = null;
        try {
            FileInputStream fichier = new FileInputStream("./Location/" + location + ".xml");
            XMLDecoder decoder = new XMLDecoder(fichier);
            fiche = (FicheLocation) decoder.readObject();
            decoder.close();
            fichier.close();

        }

        catch(Exception e){
            System.out.println(e);
        }
        return fiche;
    }

    /**
     * Méthode générant un objet Voiture à partir d'un fichier .xml
     *
     * @param voiture
     * @return
     */

    public Voiture ficheInitVoiture(String voiture) {

        Voiture car = null;
        try {
            FileInputStream fichier = new FileInputStream("./Voitures/" + voiture + ".xml");
            XMLDecoder decoder = new XMLDecoder(fichier);
            car = (Voiture) decoder.readObject();
            decoder.close();
            fichier.close();

        }

        catch(Exception e){
            System.out.println(e);
        }
        return car;
    }

    /**
     * Méthode ajoutant à une liste les fiches de Voiture
     */

    public void ajoutListeVoiture(){

        FilenameFilter filtre = new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                return s.endsWith(".xml");
            }
        };

        int i;
        new File("./Voitures").mkdir();
        File dossier = new File("./Voitures/");
        File[] fichiersVoitures = dossier.listFiles(filtre);
        for (i = 0; i < fichiersVoitures.length; i++) {

            String[] tab = fichiersVoitures[i].toString().split("/");
            String[] nomFichier = tab[2].split(".xml");
            String[] nomFichierh = nomFichier[0].split(" ");
            String modele = nomFichierh[1];
            String marque = nomFichierh[0];
            String car = marque + " " + modele;

            tabVoitures.add(car);
        }

    }

    /**
     * Méthode ajoutant à une liste les fiches de Client
     */

    public void ajoutListeClient(){

        FilenameFilter filtre = new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                return s.endsWith(".xml");
            }
        };

        int i;
        new File("./Client").mkdir();
        File dossier = new File("./Client/");
        File[] fichiersVoitures = dossier.listFiles(filtre);
        for (i = 0; i < fichiersVoitures.length; i++) {

            String[] tab = fichiersVoitures[i].toString().split("/");
            String[] nomFichier = tab[2].split(".xml");
            String[] nomFichierh = nomFichier[0].split(" ");
            String prenom = nomFichierh[1];
            String nom = nomFichierh[0];
            String mec = nom + " " + prenom;

            tabClients.add(mec);
        }

    }

    /**
     * Méthode ajoutant à une liste les fiches de location
     */

    public void ajoutListeLocation(){

        FilenameFilter filtre = new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                return s.endsWith(".xml");
            }
        };

        int i;
        new File("./Location").mkdir();

        File dossier = new File("./Location/");
        File[] fichiersVoitures = dossier.listFiles(filtre);
        for (i = 0; i < fichiersVoitures.length; i++) {

            String[] tab = fichiersVoitures[i].toString().split("/");
            String[] nomFichier = tab[2].split(".xml");
            String[] nomFichierh = nomFichier[0].split(" ");
            String modele = nomFichierh[3];
            String marque = nomFichierh[2];
            String prenom = nomFichierh[1];
            String nom = nomFichierh[0];
            String location = nom + " " + prenom + " " + marque + " " + modele;
            String aClient = ficheInitLocation(location).getaClient();
            String aVehicule = ficheInitLocation(location).getaVehicule();

            if((nom + " "+ prenom).equals(listeClients.getSelectedItem().toString()) && (marque+" "+modele).equals(listeVoiture.getSelectedItem().toString())) {

                tabLocations.add(location);
            }
        }

    }

    /**
     * Méthode remplissant la ComboBox avec la liste des Clients
     */

    private void comboBoxClientInit() {
        listeClients.removeAllItems();
        for (String c : tabClients) {

            listeClients.addItem(c);

        }
    }

    /**
     * Méthode remplissant la ComboBox avec la liste des Voitures
     */

    private void comboBoxVoitureInit() {
        listeVoiture.removeAllItems();
        for (String c : tabVoitures) {

            listeVoiture.addItem(c);
        }
    }

    /**
     * Méthode remplissant la ComboBox avec la liste des Locations
     */

    private void comboBoxLocationInit() {
        listeFiches.removeAllItems();
        for (String c : tabLocations) {

            listeFiches.addItem(c);
        }
    }


}
