package Interface;

import Classes.*;
import Classes.FicheLocation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;

public class PageAjoutFiche extends JFrame implements ActionListener {
    private JPanel panQuestion = new JPanel();
    private JPanel panSlogan = new JPanel();
    private JPanel panAjout = new JPanel();
    private JPanel panRetour = new JPanel();
    private JPanel panTxtDateDebut = new JPanel();
    private JPanel panTxtDateFin = new JPanel();
    private JPanel panTxtNbJours = new JPanel();
    private JPanel panTxtNbKmPrevu = new JPanel();
    private JPanel panInfoDateDebut = new JPanel();
    private JPanel panInfoDateFin = new JPanel();
    private JPanel panInfoNbJours = new JPanel();
    private JPanel panInfoNbKmPrevu = new JPanel();
    private JLabel question = new JLabel("Veuillez rentrer les informations de la fiche de location.");
    private JLabel slogan = new JLabel("Nous redoublons d'effort pour vous proposer un service de qualité.");
    private JLabel txtDateDebut = new JLabel("Date de début : ");
    private JLabel txtDateFin = new JLabel("Date de fin : ");
    private JLabel txtNbJours = new JLabel("Nombre de jours : ");
    private JLabel txtNbKmPrevu = new JLabel("Nombre de Km prévus : ");
    private JTextField dateDebut = new JTextField();
    private JTextField dateFin = new JTextField();
    private JTextField nbJours = new JTextField();
    private JTextField nbKmPrevu = new JTextField();
    private JButton ajout = new JButton("Ajouter");
    private JButton retour = new JButton("Retour");
    private String Sclient;
    private String Svehicule;
    private Client client;
    private Vehicules vehicule;

    /**
     * Constructeur de la classe Interface.PageAjoutFiche générant l'affichage de la fenêtre
     *
     * @param aClient
     * @param aVehicule
     */

    public PageAjoutFiche(Client aClient, Vehicules aVehicule){
        client = aClient;
        vehicule = aVehicule;

        Sclient = aClient.getNom() + " " + aClient.getPrenom();
        Svehicule = aVehicule.getMarque() + " "+aVehicule.getModele();

        slogan.setFont(new Font("TimesRoman", Font.ITALIC, 14));
        slogan.setForeground(Color.orange);
        question.setFont(new Font("Arial", Font.PLAIN, 16));

        dateDebut.setPreferredSize(new Dimension(150,30));
        dateFin.setPreferredSize(new Dimension(150,30));
        nbJours.setPreferredSize(new Dimension(150,30));
        nbKmPrevu.setPreferredSize(new Dimension(150,30));
        
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
        panInfoDateDebut.add(dateDebut, BorderLayout.CENTER);
        panInfoDateDebut.setBackground(Color.white);
        panInfoDateFin.add(dateFin, BorderLayout.CENTER);
        panInfoDateFin.setBackground(Color.white);
        panInfoNbJours.add(nbJours, BorderLayout.CENTER);
        panInfoNbJours.setBackground(Color.white);
        panInfoNbKmPrevu.add(nbKmPrevu, BorderLayout.CENTER);
        panInfoNbKmPrevu.setBackground(Color.white);

        this.setTitle("Page d'ajout d'une fiche de location");
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

        JPanel bInfo = new JPanel();
        bInfo.setLayout(new BoxLayout(bInfo, BoxLayout.PAGE_AXIS));
        bInfo.add(panInfoDateDebut);
        bInfo.add(panInfoDateFin);
        bInfo.add(panInfoNbJours);
        bInfo.add(panInfoNbKmPrevu);

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
        if(e.getSource()==retour){
            PageAccueil pageAccueil = new PageAccueil();
            this.dispose();
        }else if(e.getSource()==ajout){
            if (dateDebut.getText().equals("") || dateFin.getText().equals("") || nbJours.getText().equals("")
                    || nbKmPrevu.getText().equals("")){
                BlankPopUp blankPopUp = new BlankPopUp();
            } else {
                ajoutFiche(dateDebut.getText(), dateFin.getText(),nbJours.getText(), nbKmPrevu.getText());
                PageAccueil pageAccueil = new PageAccueil();
                this.dispose();
            }
        }
    }

    /**
     * Méthode générant une fiche de location et calculant le prix en fonction des informations transmises
     *
     * @param dateDebut
     * @param dateFin
     * @param nbJours
     * @param nbKmPrevu
     */

    public void ajoutFiche(String dateDebut, String dateFin, String nbJours, String nbKmPrevu) {
        double prixPrevu = 0;
        int kmPrevu = Integer.parseInt(nbKmPrevu);
        int jours = Integer.parseInt(nbJours);
        boolean reduc;
        if (kmPrevu < 50) {
            prixPrevu = jours * vehicule.getPrixLocation();
        } else if (kmPrevu <= 100) {
            prixPrevu = jours * vehicule.getPrixLocation() + (kmPrevu - 50) * 0.5;
        } else if (kmPrevu <= 200) {
            prixPrevu = jours * vehicule.getPrixLocation() + 50 * 0.5 + (kmPrevu - 100) * 0.3;
        } else if (kmPrevu <= 300) {
            prixPrevu = jours * vehicule.getPrixLocation() + 50 * 0.5 + 100 * 0.3 + (kmPrevu - 200) * 0.2;
        } else if (kmPrevu >= 300) {
            prixPrevu = jours * vehicule.getPrixLocation() + 50 * 0.5 + 100 * 0.3 + 100 * 0.2 + (kmPrevu - 300) * 0.1;
        }
        if(jours>7){
            reduc = true;
        }else{
            reduc = false;
        }
        FicheLocation ficheLocation = new FicheLocation(Sclient, Svehicule, dateDebut, dateFin, Integer.parseInt(nbJours),
                Integer.parseInt(nbKmPrevu), prixPrevu);

        ecrireLocation(ficheLocation);

        PrixPopUp prixPrevuPopUp = new PrixPopUp(prixPrevu, reduc, ficheLocation, false);
        vehicule.setDisponible(false);
    }

    /**
     * Méthode transformant un objet Classes.FicheLocation en fichier .xml
     *
     * @param aLoc
     */

    public void ecrireLocation(FicheLocation aLoc) {

        try {
            FileOutputStream fiche = new FileOutputStream("./Location/"+aLoc.getaClient()+" "+aLoc.getaVehicule()+".xml");
            XMLEncoder encoder = new XMLEncoder(fiche);
            encoder.writeObject(aLoc);
            encoder.close();
            fiche.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
