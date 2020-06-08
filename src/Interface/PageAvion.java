package Interface;

import Classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class PageAvion extends JFrame implements ActionListener {

    public JComboBox listeAvion;
    private JPanel panelListeAvion;
    private JPanel panelPrincipal;
    private JPanel panelFicheBoutons;
    private JPanel panelBoutons;
    private JPanel panelFiche;
    private JPanel panelInfoF;
    private JPanel panelInfo;

    private JPanel panelRetour;
    private JPanel panelAjout;
    private JPanel panelSuppr;
    private JPanel panelModif;

    private JPanel panelMarqueF;
    private JPanel panelModeleF;
    private JPanel panelVitesseMaxF;
    private JPanel panelHeureVolF;
    private JPanel panelEtatF;
    private JPanel panelNbMoteurF;
    private JPanel panelPrixF;

    private JPanel panelMarque;
    private JPanel panelModele;
    private JPanel panelVitesseMax;
    private JPanel panelHeureVol;
    private JPanel panelEtat;
    private JPanel panelNbMoteur;
    private JPanel panelPrix;

    private JLabel marque;
    private JLabel modele;
    private JLabel vitesseMax;
    private JLabel nbHeuresVol;
    private JLabel etat;
    private JLabel nbMoteur;
    private JLabel prix;

    private JButton retour;
    private JButton suppr;
    private JButton ajout;
    private JButton modif;

    private Avion avion;

    private ArrayList<String> tabAvion = new ArrayList<>();

    /**
     * Constructeur de la classe Interface.PageAvion générant l'affichage de la fenêtre
     */

    public PageAvion(){

        BorderLayout borderPrincipal = new BorderLayout();
        BorderLayout borderFicheBoutons = new BorderLayout();
        GridLayout grilleFicheBoutons = new GridLayout(1,2);
        GridLayout grilleBoutons = new GridLayout(4,1);
        BorderLayout borderFiche = new BorderLayout();
        GridLayout grilleInfoF = new GridLayout(7,1);
        GridLayout grilleInfo = new GridLayout(7,1);

        JLabel marqueF = new JLabel("Marque :");
        JLabel modeleF = new JLabel("Modèle :");
        JLabel nbMoteursF = new JLabel("Nombre de moteurs :");
        JLabel etatF = new JLabel("Etat :");
        JLabel nbHeuresVolF = new JLabel("Heures de Vol :");
        JLabel prixF = new JLabel("prix");
        JLabel vitesseMaxF = new JLabel("Vitesse Max :");

        retour = new JButton("Retour");
        suppr = new JButton("Supprimer avion");
        ajout = new JButton("Ajouter avion");
        modif = new JButton("Consulter avion");

        listeAvion = new JComboBox();
        panelListeAvion = new JPanel();
        panelPrincipal = new JPanel();
        panelFicheBoutons = new JPanel();
        panelFiche = new JPanel();
        panelBoutons = new JPanel();
        panelRetour = new JPanel();
        panelAjout = new JPanel();
        panelModif = new JPanel();
        panelSuppr = new JPanel();
        panelInfoF = new JPanel();
        panelInfo = new JPanel();

        panelMarqueF = new JPanel();
        panelModeleF = new JPanel();
        panelVitesseMaxF = new JPanel();
        panelHeureVolF = new JPanel();
        panelEtatF = new JPanel();
        panelNbMoteurF = new JPanel();
        panelPrixF = new JPanel();



        panelMarque = new JPanel();
        panelModele = new JPanel();
        panelVitesseMax = new JPanel();
        panelHeureVol = new JPanel();
        panelEtat = new JPanel();
        panelNbMoteur = new JPanel();
        panelPrix = new JPanel();
        ajoutListeAvion();
        if(!tabAvion.isEmpty()){
            comboBoxInit();
        }

        if(listeAvion.getSelectedItem() != null) {
            avion = ficheInit(listeAvion.getSelectedItem().toString());
            marque = new JLabel(avion.getMarque());
            modele = new JLabel(avion.getModele());
            vitesseMax = new JLabel(String.valueOf(avion.getVitesseMax()));
            nbHeuresVol = new JLabel(String.valueOf(avion.getNbHeureVol()));
            etat = new JLabel(avion.getEtat());
            nbMoteur = new JLabel(String.valueOf(avion.getNbMoteur()));
            prix = new JLabel(String.valueOf(avion.getPrixLocation()));


            panelMarque.add(marque);
            panelModele.add(modele);
            panelVitesseMax.add(vitesseMax);
            panelHeureVol.add(nbHeuresVol);
            panelEtat.add(etat);
            panelNbMoteur.add(nbMoteur);
            panelPrix.add(prix);

            panelInfo.setLayout(grilleInfo);
            panelInfo.add(panelMarque);
            panelInfo.add(panelModele);
            panelInfo.add(panelVitesseMax);
            panelInfo.add(panelHeureVol);
            panelInfo.add(panelEtat);
            panelInfo.add(panelNbMoteur);
            panelInfo.add(panelPrix);

        }

        panelMarqueF.add(marqueF);
        panelModeleF.add(modeleF);
        panelVitesseMaxF.add(vitesseMaxF);
        panelHeureVolF.add(nbHeuresVolF);
        panelEtatF.add(etatF);
        panelNbMoteurF.add(nbMoteursF);
        panelPrixF.add(prixF);


        panelInfoF.setLayout(grilleInfoF);
        panelInfoF.add(panelMarqueF);
        panelInfoF.add(panelModeleF);
        panelInfoF.add(panelVitesseMaxF);
        panelInfoF.add(panelHeureVolF);
        panelInfoF.add(panelEtatF);
        panelInfoF.add(panelNbMoteurF);
        panelInfoF.add(panelPrixF);

        panelListeAvion.add(listeAvion);
        panelFiche.setLayout(borderFiche);
        panelFiche.add(panelInfoF,BorderLayout.WEST);
        panelFiche.add(panelInfo,BorderLayout.EAST);



        panelFicheBoutons.setLayout(borderFicheBoutons);
        panelFicheBoutons.add(panelFiche);
        panelFicheBoutons.add(panelBoutons,BorderLayout.EAST);

        panelBoutons.setLayout(grilleBoutons);
        panelBoutons.add(panelAjout);
        panelBoutons.add(panelModif);
        panelBoutons.add(panelSuppr);
        panelBoutons.add(panelRetour);

        panelAjout.add(ajout);
        panelModif.add(modif);
        panelSuppr.add(suppr);
        panelRetour.add(retour);

        panelListeAvion.setSize(new Dimension(900,50));
        listeAvion.setPreferredSize(new Dimension(900,50));
        panelBoutons.setPreferredSize(new Dimension(300,300));
        panelFiche.setPreferredSize(new Dimension(600,400));
        panelInfoF.setPreferredSize(new Dimension(300,400));
        panelInfo.setPreferredSize(new Dimension(300,400));

        panelPrincipal.setLayout(borderPrincipal);
        this.setContentPane(panelPrincipal);
        panelPrincipal.add(panelListeAvion);
        panelPrincipal.add(panelFicheBoutons,BorderLayout.SOUTH);


        panelFiche.setBorder(BorderFactory.createLineBorder(Color.black));
        panelInfoF.setBorder(BorderFactory.createLineBorder(Color.black));
        panelInfo.setBorder(BorderFactory.createLineBorder(Color.black));

        retour.addActionListener(this);
        ajout.addActionListener(this);
        modif.addActionListener(this);
        suppr.addActionListener(this);
        listeAvion.addActionListener(this);




        this.setBounds(500, 100, 900, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Page Classes.Avion");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);


    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == retour){
            PageAccueil pageAccueil = new PageAccueil();
            this.setVisible(false);
        }

        if(e.getSource() == ajout){
            PageAjoutAvion pageAjoutAvion = new PageAjoutAvion();
            this.setVisible(false);
        }

        if(e.getSource()==modif){

            avion = ficheInit(listeAvion.getSelectedItem().toString());
            PageConsultAvion pageConsult = new PageConsultAvion(avion);
            this.setVisible(false);
        }

        if(e.getSource() == suppr){
            File file = new File("./Motos/"+ (listeAvion.getSelectedItem().toString()) +".xml");
            file.delete();
            this.dispose();
            PageAvion pageAvion = new PageAvion();
        }

        if (e.getSource() == listeAvion){
            avion = ficheInit(listeAvion.getSelectedItem().toString());
            marque.setText(avion.getMarque());
            modele.setText(avion.getModele());
            vitesseMax.setText(String.valueOf(avion.getVitesseMax()));
            nbHeuresVol.setText(String.valueOf(avion.getNbHeureVol()));
            etat.setText(avion.getEtat());
            nbMoteur.setText(String.valueOf(avion.getNbMoteur()));
            prix.setText(String.valueOf(avion.getPrixLocation()));
        }

    }

    /**
     * Méthode recueillant les informations d'un fichier .xml afin de générer un objet de la classe Classes.Avion
     *
     * @param avion
     * @return
     */

    public Avion ficheInit(String avion) {

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
     * Méthode créant la liste des Avions en fonction des fichiers .xml
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

            tabAvion.add(plane);
        }

    }

    // ==========================================================================

    /**
     * Cette fonction permet de remplir la ComboBox des avions
     */

    private void comboBoxInit() {
        listeAvion.removeAllItems();
        for (String c : tabAvion) {

            listeAvion.addItem(c);

        }


    }


}

