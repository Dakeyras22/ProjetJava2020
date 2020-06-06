import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PageVoiture extends JFrame implements ActionListener {

    public JComboBox listeVoiture;
    private JPanel panelListeVoiture;
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
    private JPanel panelKmF;
    private JPanel panelEtatF;
    private JPanel panelPuissanceF;
    private JPanel panelPrixF;
    private JPanel panelNbPlacesF;

    private JPanel panelMarque;
    private JPanel panelModele;
    private JPanel panelVitesseMax;
    private JPanel panelKm;
    private JPanel panelEtat;
    private JPanel panelPuissance;
    private JPanel panelPrix;
    private JPanel panelNbPlaces;

    private JButton retour;
    private JButton suppr;
    private JButton ajout;
    private JButton modif;

    JLabel marque = new JLabel();
    JLabel modele = new JLabel();
    JLabel vitesseMax = new JLabel();
    JLabel km = new JLabel();
    JLabel etat = new JLabel();
    JLabel puissance = new JLabel();
    JLabel prix = new JLabel();
    JLabel nbPlace = new JLabel();

    private Voiture laVoiture;

    private ArrayList<String> tabVoiture = new ArrayList<String>();





    public PageVoiture(){

        BorderLayout borderPrincipal = new BorderLayout();
        BorderLayout borderFicheBoutons = new BorderLayout();
        GridLayout grilleFicheBoutons = new GridLayout(1,2);
        GridLayout grilleBoutons = new GridLayout(4,1);
        BorderLayout borderFiche = new BorderLayout();
        GridLayout grilleInfoF = new GridLayout(8,1);
        GridLayout grilleInfo = new GridLayout(8,1);

        JLabel marqueF = new JLabel("Marque :");
        JLabel modeleF = new JLabel("Modèle :");
        JLabel puissanceF = new JLabel("Puissance :");
        JLabel etatF = new JLabel("Etat :");
        JLabel kmF = new JLabel("Km :");
        JLabel prixF = new JLabel("prix");
        JLabel nbPlacesF = new JLabel("Nombre de places :");
        JLabel vitesseMaxF = new JLabel("Vitesse Max :");

        retour = new JButton("Retour");
        suppr = new JButton("Supprimer voiture");
        ajout = new JButton("Ajouter voiture");
        modif = new JButton("Modifier voiture");

        listeVoiture = new JComboBox();
        panelListeVoiture = new JPanel();
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
        panelKmF = new JPanel();
        panelEtatF = new JPanel();
        panelPuissanceF = new JPanel();
        panelPrixF = new JPanel();
        panelNbPlacesF = new JPanel();


        panelMarque = new JPanel();
        panelModele = new JPanel();
        panelVitesseMax = new JPanel();
        panelKm = new JPanel();
        panelEtat = new JPanel();
        panelPuissance = new JPanel();
        panelPrix = new JPanel();
        panelNbPlaces = new JPanel();
        ajoutListeVoiture();
        if(!tabVoiture.isEmpty()){
            comboBoxInit();
        }


        if(listeVoiture.getSelectedItem() != null) {
            laVoiture = ficheInit(listeVoiture.getSelectedItem().toString());
            marque.setText(laVoiture.getMarque());
            modele.setText(laVoiture.getModele());
            vitesseMax.setText(String.valueOf(laVoiture.getVitesseMax()));
            km.setText(String.valueOf(laVoiture.getKm()));
            etat.setText(laVoiture.getEtat());
            puissance.setText(String.valueOf(laVoiture.getPuissance()));
            prix.setText(String.valueOf(laVoiture.getPrixLocation()));
            nbPlace.setText(String.valueOf(laVoiture.getNbPlaces()));

            panelMarque.add(marque);
            panelModele.add(modele);
            panelVitesseMax.add(vitesseMax);
            panelKm.add(km);
            panelEtat.add(etat);
            panelPuissance.add(puissance);
            panelPrix.add(prix);
            panelNbPlaces.add(nbPlace);

            panelInfo.setLayout(grilleInfo);
            panelInfo.add(panelMarque);
            panelInfo.add(panelModele);
            panelInfo.add(panelVitesseMax);
            panelInfo.add(panelKm);
            panelInfo.add(panelEtat);
            panelInfo.add(panelPuissance);
            panelInfo.add(panelPrix);
            panelInfo.add(panelNbPlaces);


        }

        panelMarqueF.add(marqueF);
        panelModeleF.add(modeleF);
        panelVitesseMaxF.add(vitesseMaxF);
        panelKmF.add(kmF);
        panelEtatF.add(etatF);
        panelPuissanceF.add(puissanceF);
        panelPrixF.add(prixF);
        panelNbPlacesF.add(nbPlacesF);


        panelInfoF.setLayout(grilleInfoF);
        panelInfoF.add(panelMarqueF);
        panelInfoF.add(panelModeleF);
        panelInfoF.add(panelVitesseMaxF);
        panelInfoF.add(panelKmF);
        panelInfoF.add(panelEtatF);
        panelInfoF.add(panelPuissanceF);
        panelInfoF.add(panelPrixF);
        panelInfoF.add(panelNbPlacesF);



        panelListeVoiture.add(listeVoiture);
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

        panelListeVoiture.setSize(new Dimension(900,50));
        listeVoiture.setPreferredSize(new Dimension(900,50));
        panelBoutons.setPreferredSize(new Dimension(300,300));
        panelFiche.setPreferredSize(new Dimension(600,400));
        panelInfo.setPreferredSize(new Dimension(300,400));
        panelInfoF.setPreferredSize(new Dimension(300,400));

        panelPrincipal.setLayout(borderPrincipal);
        this.setContentPane(panelPrincipal);
        panelPrincipal.add(panelListeVoiture);
        panelPrincipal.add(panelFicheBoutons,BorderLayout.SOUTH);


        panelFiche.setBorder(BorderFactory.createLineBorder(Color.black));
        panelInfoF.setBorder(BorderFactory.createLineBorder(Color.black));
        panelInfo.setBorder(BorderFactory.createLineBorder(Color.black));

        retour.addActionListener(this);
        ajout.addActionListener(this);
        modif.addActionListener(this);
        suppr.addActionListener(this);
        listeVoiture.addActionListener(this);

        this.setBounds(500, 100, 900, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Page Voiture");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);


    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == retour){
            PageAccueil pageAccueil = new PageAccueil();
            this.setVisible(false);
        }

        if(e.getSource() == ajout){
            PageAjoutVoiture pageAjoutVoiture = new PageAjoutVoiture();
            this.setVisible(false);
        }

        if(e.getSource() == listeVoiture){

            laVoiture = ficheInit(listeVoiture.getSelectedItem().toString());
            marque.setText(laVoiture.getMarque());
            modele.setText(laVoiture.getModele());
            vitesseMax.setText(String.valueOf(laVoiture.getVitesseMax()));
            km.setText(String.valueOf(laVoiture.getKm()));
            etat.setText(laVoiture.getEtat());
            puissance.setText(String.valueOf(laVoiture.getPuissance()));
            prix.setText(String.valueOf(laVoiture.getPrixLocation()));
            nbPlace.setText(String.valueOf(laVoiture.getNbPlaces()));
            panelInfo.repaint();

        }

    }

    public Voiture ficheInit(String voiture) {

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


// ============================================================
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

            tabVoiture.add(car);
        }

    }

    // ==========================================================================

    /**
     * Cette fonction permet de remplir la ComboBox des voitures
     */

    private void comboBoxInit() {
        listeVoiture.removeAllItems();
        for (String c : tabVoiture) {

            listeVoiture.addItem(c);

        }


    }

}

