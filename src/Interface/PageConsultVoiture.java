package Interface;

import Classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;

public class PageConsultVoiture extends JFrame implements ActionListener{
    private JPanel panQuestion = new JPanel();
    private JPanel panSlogan = new JPanel();
    private JPanel panTxtMarque = new JPanel();
    private JPanel panTxtModele = new JPanel();
    private JPanel panTxtEtat = new JPanel();
    private JPanel panTxtKm = new JPanel();
    private JPanel panTxtVitesseMax = new JPanel();
    private JPanel panTxtPuissance = new JPanel();
    private JPanel panTxtNbPlaces = new JPanel();
    private JPanel panTxtPrix = new JPanel();
    private JPanel panInfoMarque = new JPanel();
    private JPanel panInfoModele = new JPanel();
    private JPanel panInfoEtat = new JPanel();
    private JPanel panInfoKm = new JPanel();
    private JPanel panInfoVitesseMax = new JPanel();
    private JPanel panInfoPuissance = new JPanel();
    private JPanel panInfoNbPlaces = new JPanel();
    private JPanel panInfoPrix = new JPanel();
    private JPanel panAjout = new JPanel();
    private JPanel panRetour = new JPanel();
    private JLabel slogan = new JLabel("Nous redoublons d'effort pour vous proposer un service de qualité.");
    private JLabel question = new JLabel("Voici les infos de la voiture que vous pouvez modifier");
    private JLabel txtMarque = new JLabel("Marque");
    private JLabel txtModele = new JLabel("Modèle");
    private JLabel txtEtat = new JLabel("Etat");
    private JLabel txtKm = new JLabel("Kilométrage au compteur");
    private JLabel txtVitesseMax = new JLabel("Vitesse maximale");
    private JLabel txtPuissance = new JLabel("Puissance");
    private JLabel txtNbPlaces = new JLabel("Nombre de places");
    private JLabel txtPrix = new JLabel("Prix location par jour (50km compris)");
    private JTextField marque = new JTextField("");
    private JTextField modele = new JTextField("");
    private JTextField etat = new JTextField("");
    private JTextField km = new JTextField("");
    private JTextField vitesseMax = new JTextField("");
    private JTextField puissance = new JTextField("");
    private JTextField nbPlaces = new JTextField("");
    private JTextField prix = new JTextField("");
    private JButton ajout = new JButton("Terminer les modifications");
    private JButton retour = new JButton("Retour");
    private JPanel panTxtDispo = new JPanel();
    private JPanel panInfoDispo = new JPanel();
    private JLabel txtDispo = new JLabel("Disponible");
    private JRadioButton dispo = new JRadioButton("oui");
    private JRadioButton indispo = new JRadioButton("non");
    private ButtonGroup buttonGroup = new ButtonGroup();
    private boolean disponible;

    /**
     * Constructeur de la classe Interface.PageConsultVoiture générant l'affichage de la fenêtre
     *
     * @param aVoiture
     */

    public PageConsultVoiture(Voiture aVoiture){

        marque.setText(aVoiture.getMarque());
        modele.setText(aVoiture.getModele());
        etat.setText(aVoiture.getEtat());
        km.setText(String.valueOf(aVoiture.getKm()));
        vitesseMax.setText(String.valueOf(aVoiture.getVitesseMax()));
        puissance.setText(String.valueOf(aVoiture.getPuissance()));
        nbPlaces.setText(String.valueOf(aVoiture.getNbPlaces()));
        prix.setText(String.valueOf(aVoiture.getPrixLocation()));
        if(aVoiture.getDisponible()==true){
            dispo.setSelected(true);
        }else{
            indispo.setSelected(true);
        }


        slogan.setFont(new Font("TimesRoman", Font.ITALIC, 14));
        slogan.setForeground(Color.orange);
        question.setFont(new Font("Arial", Font.PLAIN, 16));

        marque.setPreferredSize(new Dimension(150,20));
        modele.setPreferredSize(new Dimension(150,20));
        etat.setPreferredSize(new Dimension(150,20));
        km.setPreferredSize(new Dimension(150,20));
        vitesseMax.setPreferredSize(new Dimension(150,20));
        puissance.setPreferredSize(new Dimension(150,20));
        nbPlaces.setPreferredSize(new Dimension(150,20));
        prix.setPreferredSize(new Dimension(150,20));

        buttonGroup.add(dispo);
        buttonGroup.add(indispo);
        panInfoDispo.setLayout(new BoxLayout(panInfoDispo, BoxLayout.LINE_AXIS));
        panInfoDispo.add(dispo);
        panInfoDispo.add(indispo);
        panInfoDispo.setBackground(Color.white);

        panQuestion.add(question, BorderLayout.CENTER);
        panQuestion.setBackground(Color.white);
        panSlogan.add(slogan, BorderLayout.CENTER);
        panSlogan.setBackground(Color.white);
        panTxtMarque.add(txtMarque, BorderLayout.CENTER);
        panTxtMarque.setBackground(Color.white);
        panTxtModele.add(txtModele, BorderLayout.CENTER);
        panTxtModele.setBackground(Color.white);
        panTxtEtat.add(txtEtat, BorderLayout.CENTER);
        panTxtEtat.setBackground(Color.white);
        panTxtKm.add(txtKm, BorderLayout.CENTER);
        panTxtKm.setBackground(Color.white);
        panTxtVitesseMax.add(txtVitesseMax, BorderLayout.CENTER);
        panTxtVitesseMax.setBackground(Color.white);
        panTxtPuissance.add(txtPuissance, BorderLayout.CENTER);
        panTxtPuissance.setBackground(Color.white);
        panTxtNbPlaces.add(txtNbPlaces, BorderLayout.CENTER);
        panTxtNbPlaces.setBackground(Color.white);
        panTxtPrix.add(txtPrix, BorderLayout.CENTER);
        panTxtPrix.setBackground(Color.white);
        panInfoMarque.add(marque, BorderLayout.CENTER);
        panInfoMarque.setBackground(Color.white);
        panInfoModele.add(modele, BorderLayout.CENTER);
        panInfoModele.setBackground(Color.white);
        panInfoEtat.add(etat, BorderLayout.CENTER);
        panInfoEtat.setBackground(Color.white);
        panInfoKm.add(km, BorderLayout.CENTER);
        panInfoKm.setBackground(Color.white);
        panInfoVitesseMax.add(vitesseMax, BorderLayout.CENTER);
        panInfoVitesseMax.setBackground(Color.white);
        panInfoPuissance.add(puissance, BorderLayout.CENTER);
        panInfoPuissance.setBackground(Color.white);
        panInfoNbPlaces.add(nbPlaces, BorderLayout.CENTER);
        panInfoNbPlaces.setBackground(Color.white);
        panInfoPrix.add(prix, BorderLayout.CENTER);
        panInfoPrix.setBackground(Color.white);
        panAjout.add(ajout, BorderLayout.CENTER);
        panAjout.setBackground(Color.white);
        panRetour.add(retour, BorderLayout.CENTER);
        panRetour.setBackground(Color.white);
        panTxtDispo.add(txtDispo, BorderLayout.CENTER);
        panTxtDispo.setBackground(Color.white);


        this.setTitle("Page de consultation d'une voiture");
        this.setResizable(false);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel b1 = new JPanel();
        b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
        b1.add(panQuestion);

        JPanel b2 = new JPanel();
        b2.setLayout(new GridLayout(10,2));
        b2.add(panTxtMarque);
        b2.add(panInfoMarque);
        b2.add(panTxtModele);
        b2.add(panInfoModele);
        b2.add(panTxtEtat);
        b2.add(panInfoEtat);
        b2.add(panTxtKm);
        b2.add(panInfoKm);
        b2.add(panTxtVitesseMax);
        b2.add(panInfoVitesseMax);
        b2.add(panTxtPuissance);
        b2.add(panInfoPuissance);
        b2.add(panTxtNbPlaces);
        b2.add(panInfoNbPlaces);
        b2.add(panTxtPrix);
        b2.add(panInfoPrix);
        b2.add(panTxtDispo);
        b2.add(panInfoDispo);
        b2.add(panAjout);
        b2.add(panRetour);

        JPanel b3 = new JPanel();
        b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
        b3.add(panSlogan);

        JPanel b4 = new JPanel();
        b4.setLayout(new BoxLayout(b4, BoxLayout.PAGE_AXIS));
        b4.add(b1);
        b4.add(b2);
        b4.add(b3);

        ajout.addActionListener(this);
        retour.addActionListener(this);
        dispo.addActionListener(this);
        indispo.addActionListener(this);

        this.getContentPane().add(b4);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ajout) {
            if (marque.getText().equals("") || modele.getText().equals("") || etat.getText().equals("")
                    || km.getText().equals("") || vitesseMax.getText().equals("") || puissance.getText().equals("")
                    || nbPlaces.getText().equals("") || prix.getText().equals("")
                    || (dispo.isSelected()==false && indispo.isSelected()==false)) {
                BlankPopUp blankPopUp = new BlankPopUp();
            } else {
                ModifVoiture();
                PageVoiture pageVoiture = new PageVoiture();
                this.dispose();
            }
        } else if (e.getSource() == retour) {
            PageVoiture pageVoiture = new PageVoiture();
            this.dispose();
        }
        if(dispo.isSelected()==true){
            disponible=true;
        }else if(indispo.isSelected()==true){
            disponible=false;
        }
    }

    /**
     * Méthode créant une Classes.Voiture avec les informations modifiées
     */

    public void ModifVoiture(){
        Voiture aVoiture = new Voiture();
        aVoiture.setMarque(marque.getText());
        aVoiture.setModele(modele.getText());
        aVoiture.setEtat(etat.getText());
        aVoiture.setKm(Integer.parseInt(km.getText()));
        aVoiture.setVitesseMax(Integer.parseInt(vitesseMax.getText()));
        aVoiture.setPuissance(Integer.parseInt(puissance.getText()));
        aVoiture.setNbPlaces(Integer.parseInt(nbPlaces.getText()));
        aVoiture.setPrixLocation(Integer.parseInt(prix.getText()));
        aVoiture.setDisponible(disponible);
        ecrireVoiture(aVoiture);
    }

    /**
     * Méthode transformant un objet Classes.Voiture en fichier .xml
     *
     * @param aVoiture
     */

    public void ecrireVoiture(Voiture aVoiture) {

        try {

            FileOutputStream car = new FileOutputStream("./Voitures/"+aVoiture.getMarque()+" "+aVoiture.getModele()+".xml");
            XMLEncoder encoder = new XMLEncoder(car);
            encoder.writeObject(aVoiture);
            encoder.close();
            car.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}