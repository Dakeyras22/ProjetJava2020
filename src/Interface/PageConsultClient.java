package Interface;

import Classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;

public class PageConsultClient extends JFrame implements ActionListener {
    private JPanel panQuestion = new JPanel();
    private JPanel panSlogan = new JPanel();
    private JPanel panAjout = new JPanel();
    private JPanel panRetour = new JPanel();
    private JPanel panTxtNom = new JPanel();
    private JPanel panTxtPrenom = new JPanel();
    private JPanel panTxtDateNaissance = new JPanel();
    private JPanel panTxtAdresse = new JPanel();
    private JPanel panTxtTelephone = new JPanel();
    private JPanel panTxtMail = new JPanel();
    private JPanel panInfoNom = new JPanel();
    private JPanel panInfoPrenom = new JPanel();
    private JPanel panInfoDateNaissance = new JPanel();
    private JPanel panInfoAdresse = new JPanel();
    private JPanel panInfoTelephone = new JPanel();
    private JPanel panInfoMail = new JPanel();
    private JLabel slogan = new JLabel("Nous redoublons d'effort pour vous proposer un service de qualité.");
    private JLabel question = new JLabel("Voici les infos du client que vous pouvez modifier");
    private JLabel txtNom = new JLabel("Nom :");
    private JLabel txtPrenom = new JLabel("Prénom :");
    private JLabel txtDateNaissance = new JLabel("Date de naissance :");
    private JLabel txtAdresse = new JLabel("Adresse :");
    private JLabel txtTelephone = new JLabel("Téléphone :");
    private JLabel txtMail = new JLabel("Mail :");
    private JTextField nom = new JTextField("");
    private JTextField prenom = new JTextField("");
    private JTextField dateNaissance = new JTextField("");
    private JTextField adresse = new JTextField("");
    private JTextField telephone = new JTextField("");
    private JTextField mail = new JTextField("");
    private JButton ajout = new JButton("Terminer les modifications");
    private JButton retour = new JButton("Retour");

    /**
     * Constructeur de la classe Interface.PageConsultClient générant l'affichage de la fenêtre
     *
     * @param aClient
     */

    public PageConsultClient(Client aClient){

        nom.setText(aClient.getNom());
        prenom.setText(aClient.getPrenom());
        dateNaissance.setText(aClient.getDateNaissance());
        adresse.setText(aClient.getAdresse());
        telephone.setText(aClient.getTelephone());
        mail.setText(aClient.getMail());

        slogan.setFont(new Font("TimesRoman", Font.ITALIC, 14));
        slogan.setForeground(Color.orange);
        question.setFont(new Font("Arial", Font.PLAIN, 16));

        nom.setPreferredSize(new Dimension(150,30));
        prenom.setPreferredSize(new Dimension(150,30));
        dateNaissance.setPreferredSize(new Dimension(150,30));
        adresse.setPreferredSize(new Dimension(150,30));
        telephone.setPreferredSize(new Dimension(150,30));
        mail.setPreferredSize(new Dimension(150,30));

        panQuestion.add(question, BorderLayout.CENTER);
        panQuestion.setBackground(Color.white);
        panSlogan.add(slogan, BorderLayout.CENTER);
        panSlogan.setBackground(Color.white);
        panAjout.add(ajout,BorderLayout.CENTER);
        panAjout.setBackground(Color.white);
        panRetour.add(retour, BorderLayout.CENTER);
        panRetour.setBackground(Color.white);
        panTxtNom.add(txtNom, BorderLayout.CENTER);
        panTxtNom.setBackground(Color.white);
        panTxtPrenom.add(txtPrenom, BorderLayout.CENTER);
        panTxtPrenom.setBackground(Color.white);
        panTxtDateNaissance.add(txtDateNaissance, BorderLayout.CENTER);
        panTxtDateNaissance.setBackground(Color.white);
        panTxtAdresse.add(txtAdresse, BorderLayout.CENTER);
        panTxtAdresse.setBackground(Color.white);
        panTxtTelephone.add(txtTelephone, BorderLayout.CENTER);
        panTxtTelephone.setBackground(Color.white);
        panTxtMail.add(txtMail, BorderLayout.CENTER);
        panTxtMail.setBackground(Color.white);
        panInfoNom.add(nom, BorderLayout.CENTER);
        panInfoNom.setBackground(Color.white);
        panInfoPrenom.add(prenom, BorderLayout.CENTER);
        panInfoPrenom.setBackground(Color.white);
        panInfoDateNaissance.add(dateNaissance, BorderLayout.CENTER);
        panInfoDateNaissance.setBackground(Color.white);
        panInfoAdresse.add(adresse, BorderLayout.CENTER);
        panInfoAdresse.setBackground(Color.white);
        panInfoTelephone.add(telephone, BorderLayout.CENTER);
        panInfoTelephone.setBackground(Color.white);
        panInfoMail.add(mail, BorderLayout.CENTER);
        panInfoMail.setBackground(Color.white);

        this.setTitle("Page de consultation d'un client");
        this.setResizable(false);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel b1 = new JPanel();
        b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
        b1.add(panQuestion);

        JPanel bTxt = new JPanel();
        bTxt.setLayout(new BoxLayout(bTxt, BoxLayout.PAGE_AXIS));
        bTxt.add(panTxtNom);
        bTxt.add(panTxtPrenom);
        bTxt.add(panTxtDateNaissance);
        bTxt.add(panTxtAdresse);
        bTxt.add(panTxtTelephone);
        bTxt.add(panTxtMail);

        JPanel bInfo = new JPanel();
        bInfo.setLayout(new BoxLayout(bInfo, BoxLayout.PAGE_AXIS));
        bInfo.add(panInfoNom);
        bInfo.add(panInfoPrenom);
        bInfo.add(panInfoDateNaissance);
        bInfo.add(panInfoAdresse);
        bInfo.add(panInfoTelephone);
        bInfo.add(panInfoMail);

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
            if (nom.getText().equals("") || prenom.getText().equals("") || dateNaissance.getText().equals("")
                    || adresse.getText().equals("") || telephone.getText().equals("") || mail.getText().equals("")){
                BlankPopUp blankPopUp = new BlankPopUp();
            } else {
                ajoutClient(nom.getText(), prenom.getText(),dateNaissance.getText(),adresse.getText(),
                        telephone.getText(), mail.getText());
                PageClient pageClient = new PageClient();
                this.dispose();
            }
        } else if (e.getSource() == retour) {
            PageClient pageClient = new PageClient();
        }
        this.dispose();
    }

    /**
     * Méthode créant un client en fonction des informations modifiées
     *
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param adresse
     * @param telephone
     * @param mail
     */

    public void ajoutClient(String nom, String prenom, String dateNaissance, String adresse, String telephone,
                            String mail){
        Client aClient = new Client(nom,prenom,dateNaissance,adresse,telephone,mail);
        ecrireClient(aClient);
    }

    /**
     * Méthode transformant un objet Classes.Client en fichier .xml
     *
     * @param aClient
     */

    public void ecrireClient(Client aClient) {

        try {
            FileOutputStream mec = new FileOutputStream("./Classes.Client/"+aClient.getNom()+" "+aClient.getPrenom()+".xml");
            XMLEncoder encoder = new XMLEncoder(mec);
            encoder.writeObject(aClient);
            encoder.close();
            mec.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
