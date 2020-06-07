import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class PageLocationMoto extends JFrame implements ActionListener{

    public JComboBox listeClients;
    public JComboBox listeMoto;
    private JPanel panelListes;
    private JPanel panelListeClient;
    private JPanel panelListeMoto;
    private JPanel panelPrincipal;
    private JPanel panelFicheBoutons;
    private JPanel panelBoutons;
    private JPanel panelFiche;
    private JPanel panelInfoClient;
    private JPanel panelInfoMoto;

    private JPanel panelRetour;
    private JPanel panelAjout;
    private JPanel panelConsult;

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


    private JButton retour;
    private JButton ajout;
    private JButton consult;

    private Client leGars;
    private Moto laMoto;

    private ArrayList<String> tabClients = new ArrayList<>();
    private ArrayList<String> tabMotos = new ArrayList<>();


    public PageLocationMoto(){

        BorderLayout borderPrincipal = new BorderLayout();
        BorderLayout borderFicheBoutons = new BorderLayout();
        GridLayout grilleListes = new GridLayout(2,1);
        GridLayout grilleFicheBoutons = new GridLayout(1,2);
        GridLayout grilleBoutons = new GridLayout(3,1);
        BorderLayout borderFiche = new BorderLayout();
        GridLayout grilleInfoClient = new GridLayout(6,1);
        GridLayout grilleInfoMoto = new GridLayout(7,1);

        retour = new JButton("Retour");
        ajout = new JButton("Ajouter Fiche");
        consult = new JButton("Consulter fiches");

        listeClients = new JComboBox();
        panelListeClient = new JPanel();
        listeMoto = new JComboBox();
        panelListes = new JPanel();
        panelListeMoto = new JPanel();
        panelPrincipal = new JPanel();
        panelFicheBoutons = new JPanel();
        panelFiche = new JPanel();
        panelBoutons = new JPanel();
        panelRetour = new JPanel();
        panelAjout = new JPanel();
        panelConsult = new JPanel();
        panelInfoClient = new JPanel();
        panelInfoMoto = new JPanel();

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


        ajoutListeClient();
        if(!tabClients.isEmpty()){
            comboBoxClientInit();
        }

        ajoutListeMoto();
        if(!tabMotos.isEmpty()){
            comboBoxMotoInit();
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

        if(listeMoto.getSelectedItem() != null) {
            laMoto = ficheInitMoto(listeMoto.getSelectedItem().toString());
            marque = new JLabel(laMoto.getMarque());
            modele = new JLabel(laMoto.getModele());
            vitesseMax = new JLabel(String.valueOf(laMoto.getVitesseMax()));
            km = new JLabel(String.valueOf(laMoto.getKm()));
            etat = new JLabel(laMoto.getEtat());
            puissance = new JLabel(String.valueOf(laMoto.getPuissance()));
            prix = new JLabel(String.valueOf(laMoto.getPrixLocation()));


            panelMarque.add(marque);
            panelModele.add(modele);
            panelVitesseMax.add(vitesseMax);
            panelKm.add(km);
            panelEtat.add(etat);
            panelPuissance.add(puissance);
            panelPrix.add(prix);

            panelInfoMoto.setLayout(grilleInfoMoto);
            panelInfoMoto.add(panelMarque);
            panelInfoMoto.add(panelModele);
            panelInfoMoto.add(panelVitesseMax);
            panelInfoMoto.add(panelKm);
            panelInfoMoto.add(panelEtat);
            panelInfoMoto.add(panelPuissance);
            panelInfoMoto.add(panelPrix);
        }

        panelListeClient.add(listeClients);
        panelListeMoto.add(listeMoto);
        panelFiche.setLayout(borderFiche);
        panelFiche.add(panelInfoClient,BorderLayout.WEST);
        panelFiche.add(panelInfoMoto,BorderLayout.EAST);

        panelFicheBoutons.setLayout(borderFicheBoutons);
        panelFicheBoutons.add(panelFiche);
        panelFicheBoutons.add(panelBoutons,BorderLayout.EAST);

        panelBoutons.setLayout(grilleBoutons);
        panelBoutons.add(panelAjout);
        panelBoutons.add(panelConsult);
        panelBoutons.add(panelRetour);

        panelAjout.add(ajout);
        panelConsult.add(consult);
        panelRetour.add(retour);

        panelListes.setLayout(grilleListes);
        panelListes.add(panelListeClient);
        panelListes.add(panelListeMoto);

        panelListes.setSize(new Dimension(900,50));
        listeClients.setPreferredSize(new Dimension(900,25));
        listeMoto.setPreferredSize(new Dimension(900,25));
        panelBoutons.setPreferredSize(new Dimension(300,300));
        panelFiche.setPreferredSize(new Dimension(600,400));
        panelInfoClient.setPreferredSize(new Dimension(300,400));
        panelInfoMoto.setPreferredSize(new Dimension(300,400));

        panelPrincipal.setLayout(borderPrincipal);
        this.setContentPane(panelPrincipal);
        panelPrincipal.add(panelListes);
        panelPrincipal.add(panelFicheBoutons,BorderLayout.SOUTH);

        panelFiche.setBorder(BorderFactory.createLineBorder(Color.black));
        panelInfoClient.setBorder(BorderFactory.createLineBorder(Color.black));
        panelInfoMoto.setBorder(BorderFactory.createLineBorder(Color.black));

        retour.addActionListener(this);
        ajout.addActionListener(this);
        consult.addActionListener(this);
        listeMoto.addActionListener(this);
        listeClients.addActionListener(this);



        this.setBounds(500, 100, 900, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Page Location Moto");
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

        }

        if (e.getSource() == consult){
            leGars = ficheInitClient(listeClients.getSelectedItem().toString());
            laMoto = ficheInitMoto(listeMoto.getSelectedItem().toString());
            PageConsultClient pageConsult = new PageConsultClient(leGars);
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

        if(e.getSource() == listeMoto){

            laMoto = ficheInitMoto(listeMoto.getSelectedItem().toString());
            marque.setText(laMoto.getMarque());
            modele.setText(laMoto.getModele());
            vitesseMax.setText(String.valueOf(laMoto.getVitesseMax()));
            km.setText(String.valueOf(laMoto.getKm()));
            etat.setText(laMoto.getEtat());
            puissance.setText(String.valueOf(laMoto.getPuissance()));
            prix.setText(String.valueOf(laMoto.getPrixLocation()));
            panelInfoMoto.repaint();

        }

    }

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



    public Moto ficheInitMoto(String moto) {

        Moto motorbike = null;
        try {
            FileInputStream fichier = new FileInputStream("./Motos/" + moto + ".xml");
            XMLDecoder decoder = new XMLDecoder(fichier);
            motorbike = (Moto) decoder.readObject();
            decoder.close();
            fichier.close();

        }

        catch(Exception e){
            System.out.println(e);
        }
        return motorbike;
    }

    // ============================================================

    public void ajoutListeMoto(){

        FilenameFilter filtre = new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                return s.endsWith(".xml");
            }
        };

        int i;
        new File("./Motos").mkdir();
        File dossier = new File("./Motos/");
        File[] fichiersMoto = dossier.listFiles(filtre);
        for (i = 0; i < fichiersMoto.length; i++) {

            String[] tab = fichiersMoto[i].toString().split("/");
            String[] nomFichier = tab[2].split(".xml");
            String[] nomFichierh = nomFichier[0].split(" ");
            String modele = nomFichierh[1];
            String marque = nomFichierh[0];
            String motorbike = marque + " " + modele;

            tabMotos.add(motorbike);
        }

    }

    // ============================================================
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


    private void comboBoxClientInit() {
        listeClients.removeAllItems();
        for (String c : tabClients) {

            listeClients.addItem(c);

        }
    }


    private void comboBoxMotoInit() {
        listeMoto.removeAllItems();
        for (String c : tabMotos) {

            listeMoto.addItem(c);
        }
    }


}
