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

public class PageMoto extends JFrame implements ActionListener {

    public JComboBox listeMoto;
    private JPanel panelListeMoto;
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

    private JPanel panelMarque;
    private JPanel panelModele;
    private JPanel panelVitesseMax;
    private JPanel panelKm;
    private JPanel panelEtat;
    private JPanel panelPuissance;
    private JPanel panelPrix;

    private JLabel marque = new JLabel();
    private JLabel modele = new JLabel();
    private JLabel vitesseMax = new JLabel();
    private JLabel km = new JLabel();
    private JLabel etat = new JLabel();
    private JLabel puissance = new JLabel();
    private JLabel prix = new JLabel();


    private JButton retour;
    private JButton suppr;
    private JButton ajout;
    private JButton modif;

    private Moto laMoto;

    private ArrayList<String> tabMoto = new ArrayList<>();


    public PageMoto(){

        BorderLayout borderPrincipal = new BorderLayout();
        BorderLayout borderFicheBoutons = new BorderLayout();
        GridLayout grilleFicheBoutons = new GridLayout(1,2);
        GridLayout grilleBoutons = new GridLayout(4,1);
        BorderLayout borderFiche = new BorderLayout();
        GridLayout grilleInfoF = new GridLayout(7,1);
        GridLayout grilleInfo = new GridLayout(7,1);

        JLabel marqueF = new JLabel("Marque :");
        JLabel modeleF = new JLabel("Modèle :");
        JLabel puissanceF = new JLabel("Puissance :");
        JLabel etatF = new JLabel("Etat :");
        JLabel kmF = new JLabel("Km :");
        JLabel prixF = new JLabel("prix");
        JLabel vitesseMaxF = new JLabel("Vitesse Max :");

        retour = new JButton("Retour");
        suppr = new JButton("Supprimer moto");
        ajout = new JButton("Ajouter moto");
        modif = new JButton("Consulter moto");

        listeMoto = new JComboBox();
        panelListeMoto = new JPanel();
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



        panelMarque = new JPanel();
        panelModele = new JPanel();
        panelVitesseMax = new JPanel();
        panelKm = new JPanel();
        panelEtat = new JPanel();
        panelPuissance = new JPanel();
        panelPrix = new JPanel();
        ajoutListeMoto();
        if(!tabMoto.isEmpty()){
            comboBoxInit();
        }


        if(listeMoto.getSelectedItem() != null) {
            laMoto = ficheInit(listeMoto.getSelectedItem().toString());
            marque.setText(laMoto.getMarque());
            modele.setText(laMoto.getModele());
            vitesseMax.setText(String.valueOf(laMoto.getVitesseMax()));
            km.setText(String.valueOf(laMoto.getKm()));
            etat.setText(laMoto.getEtat());
            puissance.setText(String.valueOf(laMoto.getPuissance()));
            prix.setText(String.valueOf(laMoto.getPrixLocation()));


            panelMarque.add(marque);
            panelModele.add(modele);
            panelVitesseMax.add(vitesseMax);
            panelKm.add(km);
            panelEtat.add(etat);
            panelPuissance.add(puissance);
            panelPrix.add(prix);

            panelInfo.setLayout(grilleInfo);
            panelInfo.add(panelMarque);
            panelInfo.add(panelModele);
            panelInfo.add(panelVitesseMax);
            panelInfo.add(panelKm);
            panelInfo.add(panelEtat);
            panelInfo.add(panelPuissance);
            panelInfo.add(panelPrix);

        }

        panelMarqueF.add(marqueF);
        panelModeleF.add(modeleF);
        panelVitesseMaxF.add(vitesseMaxF);
        panelKmF.add(kmF);
        panelEtatF.add(etatF);
        panelPuissanceF.add(puissanceF);
        panelPrixF.add(prixF);


        panelInfoF.setLayout(grilleInfoF);
        panelInfoF.add(panelMarqueF);
        panelInfoF.add(panelModeleF);
        panelInfoF.add(panelVitesseMaxF);
        panelInfoF.add(panelKmF);
        panelInfoF.add(panelEtatF);
        panelInfoF.add(panelPuissanceF);
        panelInfoF.add(panelPrixF);

        panelListeMoto.add(listeMoto);
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

        panelListeMoto.setSize(new Dimension(900,50));
        listeMoto.setPreferredSize(new Dimension(900,50));
        panelBoutons.setPreferredSize(new Dimension(300,300));
        panelFiche.setPreferredSize(new Dimension(600,400));
        panelInfoF.setPreferredSize(new Dimension(300,400));
        panelInfo.setPreferredSize(new Dimension(300,400));

        panelPrincipal.setLayout(borderPrincipal);
        this.setContentPane(panelPrincipal);
        panelPrincipal.add(panelListeMoto);
        panelPrincipal.add(panelFicheBoutons,BorderLayout.SOUTH);

        panelBoutons.setBorder(BorderFactory.createLineBorder(Color.black));
        panelFiche.setBorder(BorderFactory.createLineBorder(Color.red));
        panelInfoF.setBorder(BorderFactory.createLineBorder(Color.blue));
        panelInfo.setBorder(BorderFactory.createLineBorder(Color.green));

        retour.addActionListener(this);
        ajout.addActionListener(this);
        modif.addActionListener(this);
        suppr.addActionListener(this);
        listeMoto.addActionListener(this);




        this.setBounds(500, 100, 900, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Page Moto");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);


    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == retour){
            PageAccueil pageAccueil = new PageAccueil();
            this.setVisible(false);
        }

        if(e.getSource() == ajout){
            PageAjoutMoto pageAjoutMoto = new PageAjoutMoto();
            this.setVisible(false);
        }

        if(e.getSource() == listeMoto){
            laMoto = ficheInit(listeMoto.getSelectedItem().toString());
            marque.setText(laMoto.getMarque());
            modele.setText(laMoto.getModele());
            vitesseMax.setText(String.valueOf(laMoto.getVitesseMax()));
            km.setText(String.valueOf(laMoto.getKm()));
            etat.setText(laMoto.getEtat());
            puissance.setText(String.valueOf(laMoto.getPuissance()));
            prix.setText(String.valueOf(laMoto.getPrixLocation()));
            panelInfo.repaint();
        }
    }

    public Moto ficheInit(String moto) {

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
        File dossier = new File("./Motos/");
        File[] fichiersMoto = dossier.listFiles(filtre);
        for (i = 0; i < fichiersMoto.length; i++) {

            String[] tab = fichiersMoto[i].toString().split("/");
            String[] nomFichier = tab[2].split(".xml");
            String[] nomFichierh = nomFichier[0].split(" ");
            String modele = nomFichierh[1];
            String marque = nomFichierh[0];
            String motorbike = marque + " " + modele;

            tabMoto.add(motorbike);
        }

    }

    /**
     * Cette fonction permet de remplir la ComboBox des voitures
     */

    private void comboBoxInit() {
        listeMoto.removeAllItems();
        for (String c : tabMoto) {

            listeMoto.addItem(c);

        }


    }


}

