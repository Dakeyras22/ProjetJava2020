import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageAccueil extends JFrame implements ActionListener{

    /* =================================================================================================*/
    /*========================Creation des JPanel,JButton et JLabel nécessaires=========================*/
    /* =================================================================================================*/
    private JPanel panClient = new JPanel();
    private JPanel panVehicule = new JPanel();
    private JPanel panFiche = new JPanel();
    private JPanel panBienvenue = new JPanel();
    private JPanel panSlogan = new JPanel();
    private JButton client = new JButton("Clients");
    private JButton vehicule = new JButton("Véhicules");
    private JButton fiche = new JButton("Fiches de location");
    private JLabel slogan = new JLabel("Nous redoublons d'effort pour vous proposer un service de qualité.");
    private JLabel bienvenue = new JLabel("Bienvenue chez : Plantet-Maubon Concession");

    public PageAccueil(){

        /*choix des polices d'écriture*/
        slogan.setFont(new Font("TimesRoman", Font.ITALIC, 14));
        slogan.setForeground(Color.orange);
        bienvenue.setFont(new Font("Arial", Font.PLAIN, 16));

        /*remplissage des panels et change la couleur du fond en blanc*/
        panClient.add(client, BorderLayout.CENTER);
        panClient.setBackground(Color.white);
        panVehicule.add(vehicule, BorderLayout.CENTER);
        panVehicule.setBackground(Color.white);
        panFiche.add(fiche, BorderLayout.CENTER);
        panFiche.setBackground(Color.white);
        panBienvenue.add(bienvenue, BorderLayout.CENTER);
        panBienvenue.setBackground(Color.white);
        panSlogan.add(slogan, BorderLayout.CENTER);
        panSlogan.setBackground(Color.white);

        /*paramètres de la frame*/
        this.setTitle("Page d'accueil");
        this.setResizable(false);
        this.setSize(500,200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*création de panels intermédiaires pour bien positionner les différents composants*/
        JPanel b1 = new JPanel();
        b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
        b1.add(panBienvenue);

        JPanel b2 = new JPanel();
        b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
        b2.add(panVehicule);
        b2.add(panFiche);
        b2.add((panClient));

        JPanel b3 = new JPanel();
        b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
        b3.add(panSlogan);

        /*création du panel final de la frame*/
        JPanel b4 = new JPanel();
        b4.setLayout(new BoxLayout(b4, BoxLayout.PAGE_AXIS));
        b4.add(b1);
        b4.add(b2);
        b4.add(b3);

        /*ajout d'action listener sur les boutons*/
        client.addActionListener(this);
        vehicule.addActionListener(this);
        fiche.addActionListener(this);

        /*ajout du panel final dans la frame et affichage de la frame*/
        this.getContentPane().add(b4);
        this.setVisible(true);
    }

    /* =================================================================================================*/
    /* ================ActionListener des boutons client, vehicule et fiche=============================*/
    /* ================Ouvre la page correspondant au bouton sélectionner===============================*/
    /* =================================================================================================*/
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == client){
            PageClient pageClient = new PageClient();
        }else if(e.getSource() == vehicule){
            PageVehicule pageVehicule = new PageVehicule();
        }else if(e.getSource() == fiche){
            new PageChoixVehiculeFiche();
        }
        this.dispose();
    }
}
