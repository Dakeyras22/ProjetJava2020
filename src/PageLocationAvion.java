import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;


public class PageLocationAvion extends JFrame implements ActionListener{

    public JComboBox listeClients;
    public JComboBox listeAvion;
    public JComboBox listeFiches;
    private JPanel panelListes;
    private JPanel panelListeClient;
    private JPanel panelListeAvion;
    private JPanel panelListeFiches;
    private JPanel panelPrincipal;
    private JPanel panelFicheBoutons;
    private JPanel panelBoutons;
    private JPanel panelFiche;
    private JPanel panelInfoClient;
    private JPanel panelInfoAvion;

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
    private JPanel panelHeuresVol;
    private JPanel panelEtat;
    private JPanel panelNbMoteur;
    private JPanel panelPrix;


    private JLabel nom;
    private JLabel prenom;
    private JLabel dateDeNaissance;
    private JLabel adresse;
    private JLabel telephone;
    private JLabel mail;

    private JLabel marque;
    private JLabel modele;
    private JLabel vitesseMax;
    private JLabel heuresVol;
    private JLabel etat;
    private JLabel nbMoteurs;
    private JLabel prix;


    private JButton retour;
    private JButton ajout;
    private JButton consult;
    private JButton rendu;

    private Client leGars;
    private Avion lAvion;
    private FicheLocation laFiche;

    private ArrayList<String> tabClients = new ArrayList<>();
    private ArrayList<String> tabAvions = new ArrayList<>();
    private ArrayList<String> tabLocations = new ArrayList<>();

    /**
     * Constructeur de la classe PageLocationAvion générant l'affichage de la fenêtre
     */

    public PageLocationAvion(){

        BorderLayout borderPrincipal = new BorderLayout();
        BorderLayout borderFicheBoutons = new BorderLayout();
        GridLayout grilleListes = new GridLayout(3,1);
        GridLayout grilleFicheBoutons = new GridLayout(1,2);
        GridLayout grilleBoutons = new GridLayout(3,1);
        BorderLayout borderFiche = new BorderLayout();
        GridLayout grilleInfoClient = new GridLayout(6,1);
        GridLayout grilleInfoAvion = new GridLayout(7,1);

        retour = new JButton("Retour");
        ajout = new JButton("Ajouter Fiche");
        consult = new JButton("Consulter fiches du client");
        rendu = new JButton("Fiche de Rendu");

        listeClients = new JComboBox();
        panelListeClient = new JPanel();
        listeAvion = new JComboBox();
        listeFiches = new JComboBox();
        panelListes = new JPanel();
        panelListeAvion = new JPanel();
        panelListeFiches = new JPanel();
        panelPrincipal = new JPanel();
        panelFicheBoutons = new JPanel();
        panelFiche = new JPanel();
        panelBoutons = new JPanel();
        panelRetour = new JPanel();
        panelAjout = new JPanel();
        panelConsult = new JPanel();
        panelRendu = new JPanel();
        panelInfoClient = new JPanel();
        panelInfoAvion = new JPanel();

        panelNom = new JPanel();
        panelPrenom = new JPanel();
        panelDateDeNaissance = new JPanel();
        panelAdresse = new JPanel();
        panelTelephone = new JPanel();
        panelMail = new JPanel();

        panelMarque = new JPanel();
        panelModele = new JPanel();
        panelVitesseMax = new JPanel();
        panelHeuresVol = new JPanel();
        panelEtat = new JPanel();
        panelNbMoteur = new JPanel();
        panelPrix = new JPanel();


        ajoutListeClient();
        if(!tabClients.isEmpty()){
            comboBoxClientInit();
        }

        ajoutListeAvion();
        if(!tabAvions.isEmpty()){
            comboBoxAvionInit();
        }

        ajoutListeLocation();
        if(!tabClients.isEmpty()){
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

        if(listeAvion.getSelectedItem() != null) {
            lAvion = ficheInitAvion(listeAvion.getSelectedItem().toString());
            marque = new JLabel(lAvion.getMarque());
            modele = new JLabel(lAvion.getModele());
            vitesseMax = new JLabel(String.valueOf(lAvion.getVitesseMax()));
            heuresVol = new JLabel(String.valueOf(lAvion.getNbHeureVol()));
            etat = new JLabel(lAvion.getEtat());
            nbMoteurs = new JLabel(String.valueOf(lAvion.getNbMoteur()));
            prix = new JLabel(String.valueOf(lAvion.getPrixLocation()));


            panelMarque.add(marque);
            panelModele.add(modele);
            panelVitesseMax.add(vitesseMax);
            panelHeuresVol.add(heuresVol);
            panelEtat.add(etat);
            panelNbMoteur.add(nbMoteurs);
            panelPrix.add(prix);

            panelInfoAvion.setLayout(grilleInfoAvion);
            panelInfoAvion.add(panelMarque);
            panelInfoAvion.add(panelModele);
            panelInfoAvion.add(panelVitesseMax);
            panelInfoAvion.add(panelHeuresVol);
            panelInfoAvion.add(panelEtat);
            panelInfoAvion.add(panelNbMoteur);
            panelInfoAvion.add(panelPrix);
        }

        panelListeClient.add(listeClients);
        panelListeAvion.add(listeAvion);
        panelListeFiches.add(listeFiches);
        panelFiche.setLayout(borderFiche);
        panelFiche.add(panelInfoClient,BorderLayout.WEST);
        panelFiche.add(panelInfoAvion,BorderLayout.EAST);

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
        panelListes.add(panelListeAvion);
        panelListes.add(panelListeFiches);

        panelListes.setSize(new Dimension(900,125));
        listeClients.setPreferredSize(new Dimension(900,25));
        listeAvion.setPreferredSize(new Dimension(900,25));
        listeFiches.setPreferredSize(new Dimension(900,25));
        panelBoutons.setPreferredSize(new Dimension(300,300));
        panelFiche.setPreferredSize(new Dimension(600,375));
        panelInfoClient.setPreferredSize(new Dimension(300,375));
        panelInfoAvion.setPreferredSize(new Dimension(300,375));

        panelPrincipal.setLayout(borderPrincipal);
        this.setContentPane(panelPrincipal);
        panelPrincipal.add(panelListes);
        panelPrincipal.add(panelFicheBoutons,BorderLayout.SOUTH);

        panelFiche.setBorder(BorderFactory.createLineBorder(Color.black));
        panelInfoClient.setBorder(BorderFactory.createLineBorder(Color.black));
        panelInfoAvion.setBorder(BorderFactory.createLineBorder(Color.black));

        retour.addActionListener(this);
        ajout.addActionListener(this);
        consult.addActionListener(this);
        rendu.addActionListener(this);
        listeAvion.addActionListener(this);
        listeClients.addActionListener(this);



        this.setBounds(500, 100, 900, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Page Location Avion");
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
            lAvion = ficheInitAvion(listeAvion.getSelectedItem().toString());
            PageAjoutFiche pageAjoutFiche = new PageAjoutFiche(leGars,lAvion);
            this.dispose();
        }

        if (e.getSource() == consult){
            leGars = ficheInitClient(listeClients.getSelectedItem().toString());
            lAvion = ficheInitAvion(listeAvion.getSelectedItem().toString());
            laFiche = ficheInitLocation(listeFiches.getSelectedItem().toString());
            PageConsultFiche pageConsult = new PageConsultFiche(listeClients.getSelectedItem().toString(),listeAvion.getSelectedItem().toString(),laFiche,leGars,lAvion);
            this.setVisible(false);
        }

        if(e.getSource()== rendu){
            leGars = ficheInitClient(listeClients.getSelectedItem().toString());
            lAvion = ficheInitAvion(listeAvion.getSelectedItem().toString());
            laFiche = ficheInitLocation(listeFiches.getSelectedItem().toString());
            PageRenduFiche pageRenduFiche = new PageRenduFiche(listeClients.getSelectedItem().toString(),listeAvion.getSelectedItem().toString(),laFiche,leGars,lAvion);
            this.dispose();
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

        if(e.getSource() == listeAvion){

            lAvion = ficheInitAvion(listeAvion.getSelectedItem().toString());
            marque.setText(lAvion.getMarque());
            modele.setText(lAvion.getModele());
            vitesseMax.setText(String.valueOf(lAvion.getVitesseMax()));
            heuresVol.setText(String.valueOf(lAvion.getNbHeureVol()));
            etat.setText(lAvion.getEtat());
            nbMoteurs.setText(String.valueOf(lAvion.getNbMoteur()));
            prix.setText(String.valueOf(lAvion.getPrixLocation()));
            panelInfoAvion.repaint();

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
     * Méthode générant un objet Avion à partir d'un fichier .xml
     *
     * @param avion
     * @return
     */

    public Avion ficheInitAvion(String avion) {

        Avion plane = null;
        try {
            FileInputStream fichier = new FileInputStream("./Avions/" + avion + ".xml");
            XMLDecoder decoder = new XMLDecoder(fichier);
            plane = (Avion) decoder.readObject();
            decoder.close();
            fichier.close();

        }

        catch(Exception e){
            System.out.println(e);
        }
        return plane;
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
     * Méthode ajoutant à une liste les différents clients
     */

    public void ajoutListeAvion(){

        FilenameFilter filtre = new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                return s.endsWith(".xml");
            }
        };
        new File("./Avions").mkdir();

        int i;
        File dossier = new File("./Avions/");
        File[] fichiersAvion = dossier.listFiles(filtre);
        for (i = 0; i < fichiersAvion.length; i++) {

            String[] tab = fichiersAvion[i].toString().split("/");
            String[] nomFichier = tab[2].split(".xml");
            String[] nomFichierh = nomFichier[0].split(" ");
            String modele = nomFichierh[1];
            String marque = nomFichierh[0];
            String plane = marque + " " + modele;


            tabAvions.add(plane);
        }

    }

    /**
     * Méthode ajoutant à une liste les locations pour un client et un avion
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
            System.out.println(location);


            if((nom + " "+ prenom).equals(listeClients.getSelectedItem().toString()) && (marque+" "+modele).equals(listeAvion.getSelectedItem().toString())) {

                tabLocations.add(location);
            }
        }

    }

    /**
     * Méthode ajoutant à une liste les différents clients
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

            //if ficheInitAvion()

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
     * Méthode remplissant la ComboBox avec la liste des Clients
     */

    private void comboBoxClientInit() {
        listeClients.removeAllItems();
        for (String c : tabClients) {

            listeClients.addItem(c);

        }
    }

    /**
     * Méthode remplissant la ComboBox avec la liste des Avions
     */

    private void comboBoxAvionInit() {
        listeAvion.removeAllItems();
        for (String c : tabAvions) {

            listeAvion.addItem(c);
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
