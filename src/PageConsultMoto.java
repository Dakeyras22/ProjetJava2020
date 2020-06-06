import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageConsultMoto extends JFrame implements ActionListener {
    private JPanel panQuestion = new JPanel();
    private JPanel panSlogan = new JPanel();
    private JPanel panTxtMarque = new JPanel();
    private JPanel panTxtModele = new JPanel();
    private JPanel panTxtEtat = new JPanel();
    private JPanel panTxtKm = new JPanel();
    private JPanel panTxtVitesseMax = new JPanel();
    private JPanel panTxtPuissance = new JPanel();
    private JPanel panTxtPrix = new JPanel();
    private JPanel panInfoMarque = new JPanel();
    private JPanel panInfoModele = new JPanel();
    private JPanel panInfoEtat = new JPanel();
    private JPanel panInfoKm = new JPanel();
    private JPanel panInfoVitesseMax = new JPanel();
    private JPanel panInfoPuissance = new JPanel();
    private JPanel panInfoPrix = new JPanel();
    private JPanel panAjout = new JPanel();
    private JPanel panRetour = new JPanel();
    private JLabel slogan = new JLabel("Nous redoublons d'effort pour vous proposer un service de qualité.");
    private JLabel question = new JLabel("Voici les infos de l'avion que vous pouvez modifier");
    private JLabel txtMarque = new JLabel("Marque");
    private JLabel txtModele = new JLabel("Modèle");
    private JLabel txtEtat = new JLabel("Etat");
    private JLabel txtKm = new JLabel("Kilométrage au compteur");
    private JLabel txtVitesseMax = new JLabel("Vitesse maximale");
    private JLabel txtPuissance = new JLabel("Puissance");
    private JLabel txtPrix = new JLabel("Prix location par jour (50km compris)");
    private JTextField marque = new JTextField("");
    private JTextField modele = new JTextField("");
    private JTextField etat = new JTextField("");
    private JTextField km = new JTextField("");
    private JTextField vitesseMax = new JTextField("");
    private JTextField puissance = new JTextField("");
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

    public PageConsultMoto(Moto aMoto){

        marque.setText(aMoto.getMarque());
        modele.setText(aMoto.getModele());
        etat.setText(aMoto.getEtat());
        km.setText(String.valueOf(aMoto.getKm()));
        vitesseMax.setText(String.valueOf(aMoto.getVitesseMax()));
        puissance.setText(String.valueOf(aMoto.getPuissance()));
        prix.setText(String.valueOf(aMoto.getPrixLocation()));
        if(aMoto.getDisponible()==true){
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
        km.setPreferredSize(new Dimension(150,30));
        vitesseMax.setPreferredSize(new Dimension(150,30));
        puissance.setPreferredSize(new Dimension(150,30));
        prix.setPreferredSize(new Dimension(150,30));

        panQuestion.add(question, BorderLayout.CENTER);
        panQuestion.setBackground(Color.white);
        panSlogan.add(slogan, BorderLayout.CENTER);
        panSlogan.setBackground(Color.white);
        panRetour.add(retour, BorderLayout.CENTER);
        panRetour.setBackground(Color.white);
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
        panInfoPrix.add(prix, BorderLayout.CENTER);
        panInfoPrix.setBackground(Color.white);
        panAjout.add(ajout, BorderLayout.CENTER);
        panAjout.setBackground(Color.white);
        panTxtDispo.add(txtDispo, BorderLayout.CENTER);
        panTxtDispo.setBackground(Color.white);

        this.setTitle("Page de consultation d'une moto");
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
        b2.add(panTxtKm);
        b2.add(panInfoKm);
        b2.add(panTxtVitesseMax);
        b2.add(panInfoVitesseMax);
        b2.add(panTxtPuissance);
        b2.add(panInfoPuissance);
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
                    || prix.getText().equals("")) {
                BlankPopUp blankPopUp = new BlankPopUp();
            } else {
                ModifMoto();
                PageAccueil pageAccueil = new PageAccueil();
                this.dispose();
            }
        } else if (e.getSource() == retour) {
            PageMoto pageMoto = new PageMoto();
            this.dispose();
        }
        if(dispo.isSelected()==true){
            disponible=true;
        }else if(indispo.isSelected()==true){
            disponible=false;
        }
    }

    public void ModifMoto(){
        Moto aMoto = new Moto();
        aMoto.setMarque(marque.getText());
        aMoto.setModele(modele.getText());
        aMoto.setEtat(etat.getText());
        aMoto.setKm(Integer.parseInt(km.getText()));
        aMoto.setVitesseMax(Integer.parseInt(vitesseMax.getText()));
        aMoto.setPuissance(Integer.parseInt(puissance.getText()));
        aMoto.setPrixLocation(Integer.parseInt(prix.getText()));
        aMoto.setDisponible(disponible);
    }
}
