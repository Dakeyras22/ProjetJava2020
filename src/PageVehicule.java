import javax.swing.*;
import java.awt.*;

public class PageVehicule extends JFrame {

    private JPanel panTron = new JPanel();
    private JPanel panPlanes = new JPanel();
    private JPanel panInitialD = new JPanel();
    private JPanel panMoto = new JPanel();
    private JPanel panVoiture = new JPanel();
    private JPanel panAvion = new JPanel();
    private JPanel panQuestion = new JPanel();
    private JPanel panSlogan = new JPanel();
    private JLabel imageTron = new JLabel(new ImageIcon("Images/Tron.jpg"));
    private JLabel imagePlanes = new JLabel(new ImageIcon("Images/Planes.jpg"));
    private JLabel imageInitialD = new JLabel(new ImageIcon("Images/InitialD.jpg"));
    private JButton moto = new JButton("Motos");
    private JButton voiture = new JButton("Voitures");
    private JButton avion = new JButton("Avions");
    private JLabel question = new JLabel("Quel type de véhicule souhaitez vous ?");

    public PageVehicule(){

        question.setFont(new Font("Arial", Font.PLAIN, 16));

        panMoto.add(moto, BorderLayout.CENTER);
        panMoto.setBackground(Color.white);
        panVoiture.add(voiture, BorderLayout.CENTER);
        panVoiture.setBackground(Color.white);
        panAvion.add(avion, BorderLayout.CENTER);
        panAvion.setBackground(Color.white);
        panTron.add(imageTron, BorderLayout.SOUTH);
        panTron.setBackground(Color.white);
        panInitialD.add(imageInitialD, BorderLayout.SOUTH);
        panInitialD.setBackground(Color.white);
        panPlanes.add(imagePlanes, BorderLayout.SOUTH);
        panPlanes.setBackground(Color.white);
        panQuestion.add(question, BorderLayout.CENTER);
        panQuestion.setBackground(Color.white);

        this.setTitle("Page des véhicules");
        this.setResizable(false);
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel b1 = new JPanel();
        b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
        b1.add(panQuestion);

        /*JPanel bMoto = new JPanel();
        bMoto.setLayout(new BoxLayout(bMoto, BoxLayout.PAGE_AXIS));
        bMoto.add(panTron);
        bMoto.add(panMoto);

        JPanel bVoiture = new JPanel();
        bVoiture.setLayout(new BoxLayout(bVoiture, BoxLayout.PAGE_AXIS));
        bVoiture.add(panInitialD);
        bVoiture.add(panVoiture);

        JPanel bAvion = new JPanel();
        bAvion.setLayout(new BoxLayout(bAvion, BoxLayout.PAGE_AXIS));
        bAvion.add(panPlanes);
        bAvion.add(panAvion);*/

        JPanel b2 = new JPanel();
        b2.setLayout(new GridLayout(2,3));
        b2.add(panTron);
        b2.add(panInitialD);
        b2.add(panPlanes);
        b2.add(panMoto);
        b2.add(panVoiture);
        b2.add(panAvion);

        JPanel b3 = new JPanel();
        b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
        b3.add(panSlogan);

        JPanel b4 = new JPanel();
        b4.setLayout(new BoxLayout(b4, BoxLayout.PAGE_AXIS));
        b4.add(b1);
        b4.add(b2);
        b4.add(b3);

        this.getContentPane().add(b4);
        this.setVisible(true);

    }
}
