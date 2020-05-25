import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageAccueil extends JFrame{

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

        slogan.setFont(new Font("TimesRoman", Font.ITALIC, 14));
        slogan.setForeground(Color.orange);
        bienvenue.setFont(new Font("Arial", Font.PLAIN, 16));

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

        this.setTitle("Page d'accueil");
        this.setResizable(false);
        this.setSize(500,200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        JPanel b4 = new JPanel();
        b4.setLayout(new BoxLayout(b4, BoxLayout.PAGE_AXIS));
        b4.add(b1);
        b4.add(b2);
        b4.add(b3);

        client.addActionListener(new ClientListener());
        vehicule.addActionListener(new VehiculeListener());
        fiche.addActionListener(new FicheListener());

        this.getContentPane().add(b4);
        this.setVisible(true);
    }

    class ClientListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            slogan.setText("client");
        }
    }

    class VehiculeListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            slogan.setText("vehicule");
        }
    }

    class FicheListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            slogan.setText("fiche");
        }
    }
}
