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

public class PageClient extends JFrame implements ActionListener {

    public JComboBox listeClients;
    private JPanel panelListeClient;
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

    private JPanel panelNomF;
    private JPanel panelPrenomF;
    private JPanel panelDateDeNaissanceF;
    private JPanel panelAdresseF;
    private JPanel panelTelephoneF;
    private JPanel panelMailF;

    private JPanel panelNom;
    private JPanel panelPrenom;
    private JPanel panelDateDeNaissance;
    private JPanel panelAdresse;
    private JPanel panelTelephone;
    private JPanel panelMail;

    private JLabel nom;
    private JLabel prenom;
    private JLabel  dateDeNaissance;
    private JLabel adresse;
    private JLabel telephone;
    private JLabel mail;

    private JButton retour;
    private JButton suppr;
    private JButton ajout;
    private JButton modif;

    private Client leGars;

    private ArrayList<String> tabClients = new ArrayList<>();


    public PageClient(){

        BorderLayout borderPrincipal = new BorderLayout();
        BorderLayout borderFicheBoutons = new BorderLayout();
        GridLayout grilleFicheBoutons = new GridLayout(1,2);
        GridLayout grilleBoutons = new GridLayout(4,1);
        BorderLayout borderFiche = new BorderLayout();
        GridLayout grilleInfoF = new GridLayout(6,1);
        GridLayout grilleInfo = new GridLayout(6,1);

        JLabel nomF = new JLabel("Nom :");
        JLabel prenomF = new JLabel("Prénom :");
        JLabel dateDeNaissanceF = new JLabel("Date de Naissance (jj/mm/aaaa) :");
        JLabel adresseF = new JLabel("Adresse :");
        JLabel telephoneF = new JLabel("Téléphone :");
        JLabel mailF = new JLabel("Mail:");

        retour = new JButton("Retour");
        suppr = new JButton("Supprimer client");
        ajout = new JButton("Ajouter client");
        modif = new JButton("Consulter client");

        listeClients = new JComboBox();
        panelListeClient = new JPanel();
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

        panelNomF = new JPanel();
        panelPrenomF = new JPanel();
        panelDateDeNaissanceF = new JPanel();
        panelAdresseF = new JPanel();
        panelTelephoneF = new JPanel();
        panelMailF = new JPanel();


        panelNom = new JPanel();
        panelPrenom = new JPanel();
        panelDateDeNaissance = new JPanel();
        panelAdresse = new JPanel();
        panelTelephone = new JPanel();
        panelMail = new JPanel();
        ajoutListeClient();
        if(!tabClients.isEmpty()){
            comboBoxInit();
        }


        if(listeClients.getSelectedItem() != null) {
            leGars = ficheInit(listeClients.getSelectedItem().toString());
            nom = new JLabel(leGars.getNom());
            prenom = new JLabel(leGars.getPrenom());
            dateDeNaissance = new JLabel(leGars.getDateNaissance());
            adresse = new JLabel(leGars.getAdresse());
            telephone = new JLabel(leGars.getTelephone());
            mail = new JLabel(leGars.getMail());

            panelNom.add(nom);
            panelPrenom.add(prenom);
            panelAdresse.add(adresse);
            panelDateDeNaissance.add(dateDeNaissance);
            panelTelephone.add(telephone);
            panelMail.add(mail);

            panelInfo.setLayout(grilleInfo);
            panelInfo.add(panelNom);
            panelInfo.add(panelPrenom);
            panelInfo.add(panelDateDeNaissance);
            panelInfo.add(panelAdresse);
            panelInfo.add(panelTelephone);
            panelInfo.add(panelMail);

        }

        panelNomF.add(nomF);
        panelPrenomF.add(prenomF);
        panelAdresseF.add(adresseF);
        panelDateDeNaissanceF.add(dateDeNaissanceF);
        panelTelephoneF.add(telephoneF);
        panelMailF.add(mailF);


        panelInfoF.setLayout(grilleInfoF);
        panelInfoF.add(panelNomF);
        panelInfoF.add(panelPrenomF);
        panelInfoF.add(panelDateDeNaissanceF);
        panelInfoF.add(panelAdresseF);
        panelInfoF.add(panelTelephoneF);
        panelInfoF.add(panelMailF);



        panelListeClient.add(listeClients);
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

        panelListeClient.setSize(new Dimension(900,50));
        listeClients.setPreferredSize(new Dimension(900,50));
        panelBoutons.setPreferredSize(new Dimension(300,300));
        panelFiche.setPreferredSize(new Dimension(600,400));
        panelInfoF.setPreferredSize(new Dimension(300,400));
        panelInfo.setPreferredSize(new Dimension(300,400));

        panelPrincipal.setLayout(borderPrincipal);
        this.setContentPane(panelPrincipal);
        panelPrincipal.add(panelListeClient);
        panelPrincipal.add(panelFicheBoutons,BorderLayout.SOUTH);


        panelFiche.setBorder(BorderFactory.createLineBorder(Color.black));
        panelInfoF.setBorder(BorderFactory.createLineBorder(Color.black));
        panelInfo.setBorder(BorderFactory.createLineBorder(Color.black));

        retour.addActionListener(this);
        ajout.addActionListener(this);
        modif.addActionListener(this);
        suppr.addActionListener(this);
        listeClients.addActionListener(this);

        this.setBounds(500, 100, 900, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Page Client");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);


    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == retour){
            PageAccueil pageAccueil = new PageAccueil();
            this.setVisible(false);
        }

        if(e.getSource() == ajout){
            PageAjoutClient pageAjoutClient = new PageAjoutClient();
            this.setVisible(false);
        }

        if(e.getSource() == suppr){
            File file = new File("./Client/"+ (listeClients.getSelectedItem().toString()) +".xml");
            file.delete();
            this.dispose();
            PageClient pageClient = new PageClient();
        }

        if (e.getSource() == modif){
            leGars = ficheInit(listeClients.getSelectedItem().toString());
            PageConsultClient pageConsult = new PageConsultClient(leGars);
            this.setVisible(false);
        }

        if(e.getSource() == listeClients){
            leGars = ficheInit(listeClients.getSelectedItem().toString());
            nom.setText(leGars.getNom());
            prenom.setText(leGars.getPrenom());
            dateDeNaissance.setText(leGars.getDateNaissance());
            adresse.setText(leGars.getAdresse());
            telephone.setText(leGars.getTelephone());
            mail.setText(leGars.getMail());
            panelInfo.repaint();
        }

    }

    public Client ficheInit(String client) {

        Client mec = null;
        try {
            FileInputStream fichier = new FileInputStream("./Client/" + client + ".xml");
            XMLDecoder decoder = new XMLDecoder(fichier);
            mec = (Client) decoder.readObject();
            decoder.close();
            fichier.close();

        }

        catch(Exception e){
            System.out.println(e);
        }
        return mec;
    }

    // ============================================================
    public void ajoutListeClient(){

        FilenameFilter filtre = new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                return s.endsWith(".xml");
            }
        };

        int i;
        new File("./Client").mkdir();
        File dossier = new File("./Client/");
        File[] fichiersVoitures = dossier.listFiles(filtre);
        for (i = 0; i < fichiersVoitures.length; i++) {

            String[] tab = fichiersVoitures[i].toString().split("/");
            String[] nomFichier = tab[2].split(".xml");
            String[] nomFichierh = nomFichier[0].split(" ");
            String prenom = nomFichierh[1];
            String nom = nomFichierh[0];
            String mec = nom + " " + prenom;

            tabClients.add(mec);
        }

    }

    // ==========================================================================

    /**
     * Cette fonction permet de remplir la ComboBox des voitures
     */

    private void comboBoxInit() {
        listeClients.removeAllItems();
        for (String c : tabClients) {

            listeClients.addItem(c);

        }


    }






}
