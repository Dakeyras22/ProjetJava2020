import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.lang.reflect.Array;
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

    private JButton retour;
    private JButton suppr;
    private JButton ajout;
    private JButton modif;

    private Avion avion;

    private ArrayList<String> tabAvion;


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



        if(listeAvion.getSelectedItem() != null) {
            avion = ficheInit(listeAvion.getSelectedItem().toString());
            JLabel marque = new JLabel(avion.getMarque());
            JLabel modele = new JLabel(avion.getModele());
            JLabel vitesseMax = new JLabel(String.valueOf(avion.getVitesseMax()));
            JLabel nbHeuresVol = new JLabel(String.valueOf(avion.getNbHeureVol()));
            JLabel etat = new JLabel(avion.getEtat());
            JLabel nbMoteur = new JLabel(String.valueOf(avion.getNbMoteur()));
            JLabel prix = new JLabel(String.valueOf(avion.getPrixLocation()));


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

        panelPrincipal.setLayout(borderPrincipal);
        this.setContentPane(panelPrincipal);
        panelPrincipal.add(panelListeAvion);
        panelPrincipal.add(panelFicheBoutons,BorderLayout.SOUTH);

        panelBoutons.setBorder(BorderFactory.createLineBorder(Color.black));
        panelFiche.setBorder(BorderFactory.createLineBorder(Color.red));
        panelInfoF.setBorder(BorderFactory.createLineBorder(Color.blue));
        //panelInfo.setBorder(BorderFactory.createLineBorder(Color.green));

        retour.addActionListener(this);
        ajout.addActionListener(this);
        modif.addActionListener(this);
        suppr.addActionListener(this);





        this.setBounds(500, 100, 900, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Page Avion");
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

    }

    public Avion ficheInit(String avion) {

        Avion plane = null;
        try {
            FileInputStream fichier = new FileInputStream("./Client/" + avion + ".xml");
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



}

