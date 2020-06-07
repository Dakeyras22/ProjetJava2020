import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;

public class PageRenduFiche extends JFrame implements ActionListener {
    private JPanel panQuestion = new JPanel();
    private JPanel panSlogan = new JPanel();
    private JPanel panAjout = new JPanel();
    private JPanel panRetour = new JPanel();
    private JPanel panTxtDateDebut = new JPanel();
    private JPanel panTxtDateFin = new JPanel();
    private JPanel panTxtNbJours = new JPanel();
    private JPanel panTxtNbKmPrevu = new JPanel();
    private JPanel panTxtPrixPrevu = new JPanel();
    private JPanel panTxtNbKmFinal = new JPanel();
    private JPanel panInfoDateDebut = new JPanel();
    private JPanel panInfoDateFin = new JPanel();
    private JPanel panInfoNbJours = new JPanel();
    private JPanel panInfoNbKmPrevu = new JPanel();
    private JPanel panInfoPrixPrevu = new JPanel();
    private JPanel panInfoNbKmFinal = new JPanel();
    private JLabel question = new JLabel("Veuillez compléter et ajuster les informations de la fiche de fin de location.");
    private JLabel slogan = new JLabel("Nous redoublons d'effort pour vous proposer un service de qualité.");
    private JLabel txtDateDebut = new JLabel("Date de début : ");
    private JLabel txtDateFin = new JLabel("Date de fin : ");
    private JLabel txtNbJours = new JLabel("Nombre de jours : ");
    private JLabel txtNbKmPrevu = new JLabel("Nombre de Km prévus : ");
    private JLabel txtPrixPrevu = new JLabel("Prix prévu : ");
    private JLabel txtNbKmFinal = new JLabel("Nombre de km final : ");
    private JLabel dateDebut = new JLabel();
    private JTextField dateFin = new JTextField();
    private JTextField nbJours = new JTextField();
    private JLabel nbKmPrevu = new JLabel();
    private JLabel prixPrevu = new JLabel();
    private JTextField nbKmFinal = new JTextField();
    private JButton ajout = new JButton("Terminer");
    private JButton retour = new JButton("Retour");
    private FicheLocation ficheLocation;

    public PageRenduFiche(FicheLocation aFicheLocation){
        ficheLocation = aFicheLocation;

        slogan.setFont(new Font("TimesRoman", Font.ITALIC, 14));
        slogan.setForeground(Color.orange);
        question.setFont(new Font("Arial", Font.PLAIN, 16));

        dateFin.setPreferredSize(new Dimension(150,30));
        nbJours.setPreferredSize(new Dimension(150,30));
        nbKmFinal.setPreferredSize(new Dimension(150,30));

        panQuestion.add(question, BorderLayout.CENTER);
        panQuestion.setBackground(Color.white);
        panSlogan.add(slogan, BorderLayout.CENTER);
        panSlogan.setBackground(Color.white);
        panAjout.add(ajout,BorderLayout.CENTER);
        panAjout.setBackground(Color.white);
        panRetour.add(retour, BorderLayout.CENTER);
        panRetour.setBackground(Color.white);
        panTxtDateDebut.add(txtDateDebut, BorderLayout.CENTER);
        panTxtDateDebut.setBackground(Color.white);
        panTxtDateFin.add(txtDateFin, BorderLayout.CENTER);
        panTxtDateFin.setBackground(Color.white);
        panTxtNbJours.add(txtNbJours, BorderLayout.CENTER);
        panTxtNbJours.setBackground(Color.white);
        panTxtNbKmPrevu.add(txtNbKmPrevu, BorderLayout.CENTER);
        panTxtNbKmPrevu.setBackground(Color.white);
        panTxtPrixPrevu.add(txtPrixPrevu, BorderLayout.CENTER);
        panTxtPrixPrevu.setBackground(Color.white);
        panTxtNbKmFinal.add(txtNbKmFinal, BorderLayout.CENTER);
        panTxtNbKmFinal.setBackground(Color.white);
        panInfoDateDebut.add(dateDebut, BorderLayout.CENTER);
        panInfoDateDebut.setBackground(Color.white);
        panInfoDateFin.add(dateFin, BorderLayout.CENTER);
        panInfoDateFin.setBackground(Color.white);
        panInfoNbJours.add(nbJours, BorderLayout.CENTER);
        panInfoNbJours.setBackground(Color.white);
        panInfoNbKmPrevu.add(nbKmPrevu, BorderLayout.CENTER);
        panInfoNbKmPrevu.setBackground(Color.white);
        panInfoPrixPrevu.add(prixPrevu, BorderLayout.CENTER);
        panInfoPrixPrevu.setBackground(Color.white);
        panInfoNbKmFinal.add(nbKmFinal, BorderLayout.CENTER);
        panInfoNbKmFinal.setBackground(Color.white);

        this.setTitle("Page de rendu d'une fiche de location");
        this.setResizable(false);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel b1 = new JPanel();
        b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
        b1.add(panQuestion);

        JPanel bTxt = new JPanel();
        bTxt.setLayout(new BoxLayout(bTxt, BoxLayout.PAGE_AXIS));
        bTxt.add(panTxtDateDebut);
        bTxt.add(panTxtDateFin);
        bTxt.add(panTxtNbJours);
        bTxt.add(panTxtNbKmPrevu);
        bTxt.add(panTxtPrixPrevu);
        bTxt.add(panTxtNbKmFinal);

        JPanel bInfo = new JPanel();
        bInfo.setLayout(new BoxLayout(bInfo, BoxLayout.PAGE_AXIS));
        bInfo.add(panInfoDateDebut);
        bInfo.add(panInfoDateFin);
        bInfo.add(panInfoNbJours);
        bInfo.add(panInfoNbKmPrevu);
        bInfo.add(panInfoPrixPrevu);
        bInfo.add(panInfoNbKmFinal);

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

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==retour){
            //PageFiche pageFiche = new PageFiche();
            this.dispose();
        }else if(e.getSource() == ajout){
            if (dateFin.getText().equals("") || nbJours.getText().equals("")  || nbKmFinal.getText().equals("")){
                BlankPopUp blankPopUp = new BlankPopUp();
            } else {
                modifFiche(dateFin.getText(), nbJours.getText(), nbKmFinal.getText());
                this.dispose();
            }
        }
    }

    public void modifFiche(String dateFin, String nbJours, String nbKmFinal){
        double prixFinal = 0;
        int kmFinal = Integer.parseInt(nbKmFinal);
        int jours = Integer.parseInt(nbJours);
        Vehicules vehicule = ficheLocation.getaVehicule();
        boolean reduc;
        if (kmFinal < 50) {
            prixFinal = jours * vehicule.getPrixLocation();
        } else if (kmFinal <= 100) {
            prixFinal = jours * vehicule.getPrixLocation() + (kmFinal - 50) * 0.5;
        } else if (kmFinal <= 200) {
            prixFinal = jours * vehicule.getPrixLocation() + 50 * 0.5 + (kmFinal - 100) * 0.3;
        } else if (kmFinal <= 300) {
            prixFinal = jours * vehicule.getPrixLocation() + 50 * 0.5 + 100 * 0.3 + (kmFinal - 200) * 0.2;
        } else if (kmFinal >= 300) {
            prixFinal = jours * vehicule.getPrixLocation() + 50 * 0.5 + 100 * 0.3 + 100 * 0.2 + (kmFinal - 300) * 0.1;
        }
        if(jours>7){
            reduc = true;
        }else{
            reduc = false;
        }
        ficheLocation.setDateFin(dateFin);
        ficheLocation.setNbJours(jours);
        ficheLocation.setKmFinal(kmFinal);
        ficheLocation.setPrixFinal(prixFinal);
        vehicule.setDisponible(true);
    }
}
