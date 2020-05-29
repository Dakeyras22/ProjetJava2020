import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageAjoutMoto extends JFrame{
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
    private JLabel slogan = new JLabel("Nous redoublons d'effort pour vous proposer un service de qualité.");
    private JLabel question = new JLabel("Veuillez rentrer les caractéristiques de la nouvelle moto");
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
    private JButton ajout = new JButton("Ajouter");

    public PageAjoutMoto(){

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

        this.setTitle("Page d'ajout d'une moto");
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
        bTxt.add(panTxtPrix);

        JPanel bInfo = new JPanel();
        bInfo.setLayout(new BoxLayout(bInfo, BoxLayout.PAGE_AXIS));
        bInfo.add(panInfoMarque);
        bInfo.add(panInfoModele);
        bInfo.add(panInfoEtat);
        bInfo.add(panInfoKm);
        bInfo.add(panInfoVitesseMax);
        bInfo.add(panInfoPuissance);
        bInfo.add(panInfoPrix);

        JPanel b2 = new JPanel();
        b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
        b2.add(bTxt);
        b2.add(bInfo);

        JPanel b3 = new JPanel();
        b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
        b3.add(panAjout);

        JPanel b4 = new JPanel();
        b4.setLayout(new BoxLayout(b4, BoxLayout.LINE_AXIS));
        b4.add(panSlogan);

        JPanel b5 = new JPanel();
        b5.setLayout(new BoxLayout(b5, BoxLayout.PAGE_AXIS));
        b5.add(b1);
        b5.add(b2);
        b5.add(b3);
        b5.add(b4);

        ajout.addActionListener(new AjoutListener());

        this.getContentPane().add(b5);
        this.setVisible(true);

    }

    class AjoutListener implements ActionListener {
        public void actionPerformed(ActionEvent e){

        }
    }

}
