import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class PageAjoutVoiture extends JFrame implements ActionListener{
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
    private JLabel question = new JLabel("Veuillez rentrer les caractéristiques de la nouvelle voiture");
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
    private JButton ajout = new JButton("Ajouter");
    private JButton retour = new JButton("Retour");



    public PageAjoutVoiture(){

        slogan.setFont(new Font("TimesRoman", Font.ITALIC, 14));
        slogan.setForeground(Color.orange);
        question.setFont(new Font("Arial", Font.PLAIN, 16));

        marque.setPreferredSize(new Dimension(150,30));
        modele.setPreferredSize(new Dimension(150,30));
        etat.setPreferredSize(new Dimension(150,30));
        km.setPreferredSize(new Dimension(150,30));
        vitesseMax.setPreferredSize(new Dimension(150,30));
        puissance.setPreferredSize(new Dimension(150,30));
        nbPlaces.setPreferredSize(new Dimension(150,30));
        prix.setPreferredSize(new Dimension(150,30));

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

        this.setTitle("Page d'ajout d'une voiture");
        this.setResizable(false);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel b1 = new JPanel();
        b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
        b1.add(panQuestion);

        JPanel bTxt = new JPanel();
        bTxt.setLayout(new BoxLayout(bTxt, BoxLayout.PAGE_AXIS));
        bTxt.add(panTxtMarque);
        bTxt.add(panTxtModele);
        bTxt.add(panTxtEtat);
        bTxt.add(panTxtKm);
        bTxt.add(panTxtVitesseMax);
        bTxt.add(panTxtPuissance);
        bTxt.add(panTxtNbPlaces);
        bTxt.add(panTxtPrix);

        JPanel bInfo = new JPanel();
        bInfo.setLayout(new BoxLayout(bInfo, BoxLayout.PAGE_AXIS));
        bInfo.add(panInfoMarque);
        bInfo.add(panInfoModele);
        bInfo.add(panInfoEtat);
        bInfo.add(panInfoKm);
        bInfo.add(panInfoVitesseMax);
        bInfo.add(panInfoPuissance);
        bInfo.add(panInfoNbPlaces);
        bInfo.add(panInfoPrix);

        JPanel b2 = new JPanel();
        b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
        b2.add(bTxt);
        b2.add(bInfo);

        JPanel b3 = new JPanel();
        b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
        b3.add(panAjout);
        b3.add(panRetour);

        JPanel b4 = new JPanel();
        b4.setLayout(new BoxLayout(b4, BoxLayout.LINE_AXIS));
        b4.add(panSlogan);

        JPanel b5 = new JPanel();
        b5.setLayout(new BoxLayout(b5, BoxLayout.PAGE_AXIS));
        b5.add(b1);
        b5.add(b2);
        b5.add(b3);
        b5.add(b4);

        ajout.addActionListener(this);
        retour.addActionListener(this);

        this.getContentPane().add(b5);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ajout) {
            if (marque.getText().equals("") || modele.getText().equals("") || etat.getText().equals("")
                    || km.getText().equals("") || vitesseMax.getText().equals("") || puissance.getText().equals("")
                    || nbPlaces.getText().equals("") || prix.getText().equals("")) {
                BlankPopUp blankPopUp = new BlankPopUp();
            } else {
                ajoutVoiture();
                PageVoiture pageVoiture = new PageVoiture();
                this.dispose();
            }
        } else if (e.getSource() == retour) {
            //PageVoiture pageVoiture = new PageVoiture();
            this.dispose();

        }
    }

    public void ajoutVoiture(){
        Voiture aVoiture = new Voiture();
        aVoiture.setMarque(marque.getText());
        aVoiture.setModele(modele.getText());
        aVoiture.setEtat(etat.getText());
        aVoiture.setKm(Integer.parseInt(km.getText()));
        aVoiture.setVitesseMax(Integer.parseInt(vitesseMax.getText()));
        aVoiture.setPuissance(Integer.parseInt(puissance.getText()));
        aVoiture.setNbPlaces(Integer.parseInt(nbPlaces.getText()));
        aVoiture.setPrixLocation(Integer.parseInt(prix.getText()));

        ecrireVoiture(aVoiture);
    }

    public void ecrireVoiture(Voiture aVoiture) {

        try {
            new File("./Voitures").mkdir();
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
    /* =================================================*/



}
