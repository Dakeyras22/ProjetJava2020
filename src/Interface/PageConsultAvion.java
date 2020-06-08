package Interface;

import Classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;


public class PageConsultAvion extends JFrame implements ActionListener{
    private JPanel panQuestion = new JPanel();
    private JPanel panSlogan = new JPanel();
    private JPanel panTxtMarque = new JPanel();
    private JPanel panTxtModele = new JPanel();
    private JPanel panTxtEtat = new JPanel();
    private JPanel panTxtNbHeureVol = new JPanel();
    private JPanel panTxtVitesseMax = new JPanel();
    private JPanel panTxtNbMoteur = new JPanel();
    private JPanel panTxtPrix = new JPanel();
    private JPanel panInfoMarque = new JPanel();
    private JPanel panInfoModele = new JPanel();
    private JPanel panInfoEtat = new JPanel();
    private JPanel panInfoNbHeureVol = new JPanel();
    private JPanel panInfoVitesseMax = new JPanel();
    private JPanel panInfoNbMoteur = new JPanel();
    private JPanel panInfoPrix = new JPanel();
    private JPanel panAjout = new JPanel();
    private JPanel panRetour = new JPanel();
    private JLabel slogan = new JLabel("Nous redoublons d'effort pour vous proposer un service de qualité.");
    private JLabel question = new JLabel("Voici les infos de l'avion que vous pouvez modifier");
    private JLabel txtMarque = new JLabel("Marque");
    private JLabel txtModele = new JLabel("Modèle");
    private JLabel txtEtat = new JLabel("Etat");
    private JLabel txtNbHeureVol = new JLabel("Nombre d'heures de vol au compteur");
    private JLabel txtVitesseMax = new JLabel("Vitesse maximale");
    private JLabel txtNbMoteur = new JLabel("Nombre de moteurs");
    private JLabel txtPrix = new JLabel("Prix location par jour");
    private JTextField marque = new JTextField("");
    private JTextField modele = new JTextField("");
    private JTextField etat = new JTextField("");
    private JTextField nbHeureVol = new JTextField("");
    private JTextField vitesseMax = new JTextField("");
    private JTextField nbMoteur = new JTextField("");
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
     * Constructeur de la classe Interface.PageConsultAvion générant l'affichage de la fenêtre
     *
     * @param anAvion
     */

    public PageConsultAvion(Avion anAvion){

        marque.setText(anAvion.getMarque());
        modele.setText(anAvion.getModele());
        etat.setText(anAvion.getEtat());
        nbHeureVol.setText(String.valueOf(anAvion.getNbHeureVol()));
        vitesseMax.setText(String.valueOf(anAvion.getVitesseMax()));
        nbMoteur.setText(String.valueOf(anAvion.getNbMoteur()));
        prix.setText(String.valueOf(anAvion.getPrixLocation()));
        if(anAvion.getDisponible()==true){
            dispo.setSelected(true);
        }else{
            indispo.setSelected(true);
        }
        
        slogan.setFont(new Font("TimesRoman", Font.ITALIC, 14));
        slogan.setForeground(Color.orange);
        question.setFont(new Font("Arial", Font.PLAIN, 16));

        marque.setPreferredSize(new Dimension(150,30));
        modele.setPreferredSize(new Dimension(150,30));
        etat.setPreferredSize(new Dimension(150,30));
        nbHeureVol.setPreferredSize(new Dimension(150,30));
        vitesseMax.setPreferredSize(new Dimension(150,30));
        nbMoteur.setPreferredSize(new Dimension(150,30));
        prix.setPreferredSize(new Dimension(150,30));

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
        panTxtNbHeureVol.add(txtNbHeureVol, BorderLayout.CENTER);
        panTxtNbHeureVol.setBackground(Color.white);
        panTxtVitesseMax.add(txtVitesseMax, BorderLayout.CENTER);
        panTxtVitesseMax.setBackground(Color.white);
        panTxtNbMoteur.add(txtNbMoteur, BorderLayout.CENTER);
        panTxtNbMoteur.setBackground(Color.white);
        panTxtPrix.add(txtPrix, BorderLayout.CENTER);
        panTxtPrix.setBackground(Color.white);
        panInfoMarque.add(marque, BorderLayout.CENTER);
        panInfoMarque.setBackground(Color.white);
        panInfoModele.add(modele, BorderLayout.CENTER);
        panInfoModele.setBackground(Color.white);
        panInfoEtat.add(etat, BorderLayout.CENTER);
        panInfoEtat.setBackground(Color.white);
        panInfoNbHeureVol.add(nbHeureVol, BorderLayout.CENTER);
        panInfoNbHeureVol.setBackground(Color.white);
        panInfoVitesseMax.add(vitesseMax, BorderLayout.CENTER);
        panInfoVitesseMax.setBackground(Color.white);
        panInfoNbMoteur.add(nbMoteur, BorderLayout.CENTER);
        panInfoNbMoteur.setBackground(Color.white);
        panInfoPrix.add(prix, BorderLayout.CENTER);
        panInfoPrix.setBackground(Color.white);
        panAjout.add(ajout, BorderLayout.CENTER);
        panAjout.setBackground(Color.white);
        panRetour.add(retour, BorderLayout.CENTER);
        panRetour.setBackground(Color.white);
        panTxtDispo.add(txtDispo, BorderLayout.CENTER);
        panTxtDispo.setBackground(Color.white);

        this.setTitle("Page de consultation d'un avion");
        this.setResizable(false);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel b1 = new JPanel();
        b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
        b1.add(panQuestion);

        JPanel b2 = new JPanel();
        b2.setLayout(new GridLayout(9,2));
        b2.add(panTxtMarque);
        b2.add(panInfoMarque);
        b2.add(panTxtModele);
        b2.add(panInfoModele);
        b2.add(panTxtEtat);
        b2.add(panInfoEtat);
        b2.add(panTxtNbHeureVol);
        b2.add(panInfoNbHeureVol);
        b2.add(panTxtVitesseMax);
        b2.add(panInfoVitesseMax);
        b2.add(panTxtNbMoteur);
        b2.add(panInfoNbMoteur);
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

        this.getContentPane().add(b4);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ajout) {
            if (marque.getText().equals("") || modele.getText().equals("") || etat.getText().equals("")
                    || nbHeureVol.getText().equals("") || vitesseMax.getText().equals("") || nbMoteur.getText().equals("")
                    || prix.getText().equals("")) {
                BlankPopUp blankPopUp = new BlankPopUp();
            } else {
                ModifAvion();
                PageAvion pageAvion = new PageAvion();
                this.dispose();
            }
        } else if (e.getSource() == retour) {
            new PageAvion();
            this.dispose();
        }
        if(dispo.isSelected()==true){
            disponible=true;
        }else if(indispo.isSelected()==true){
            disponible=false;
        }
    }

    /**
     * Méthode modifiant un objet Classes.Avion
     */

    public void ModifAvion(){
        Avion anAvion = new Avion();
        anAvion.setMarque(marque.getText());
        anAvion.setModele(modele.getText());
        anAvion.setEtat(etat.getText());
        anAvion.setNbHeureVol(Integer.parseInt(nbHeureVol.getText()));
        anAvion.setVitesseMax(Integer.parseInt(vitesseMax.getText()));
        anAvion.setNbMoteur(Integer.parseInt(nbMoteur.getText()));
        anAvion.setPrixLocation(Integer.parseInt(prix.getText()));
        anAvion.setDisponible(disponible);
        ecrireAvion(anAvion);

    }

    /**
     * Méthode créant
     *
     * @param anAvion
     */

    public void ecrireAvion(Avion anAvion) {

        try {
            FileOutputStream car = new FileOutputStream("./Avions/"+anAvion.getMarque()+" "+anAvion.getModele()+".xml");
            XMLEncoder encoder = new XMLEncoder(car);
            encoder.writeObject(anAvion);
            encoder.close();
            car.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
