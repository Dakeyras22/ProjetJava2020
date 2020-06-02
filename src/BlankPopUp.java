import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlankPopUp extends JFrame implements ActionListener {
    private JLabel avertissement = new JLabel("Veuillez remplir toutes les informations.");
    private JButton fermer = new JButton("Retour");
    private JPanel panAvertissement = new JPanel();
    private JPanel panFermer = new JPanel();

    public BlankPopUp(){

        avertissement.setFont(new Font("Arial", Font.PLAIN, 16));

        panAvertissement.add(avertissement, BorderLayout.CENTER);
        panAvertissement.setBackground(Color.white);
        panFermer.add(fermer, BorderLayout.CENTER);
        panFermer.setBackground(Color.white);

        this.setTitle("WARNING");
        this.setResizable(false);
        this.setSize(500,100);
        this.setLocationRelativeTo(null);

        JPanel b1 = new JPanel();
        b1.setLayout(new BoxLayout(b1, BoxLayout.PAGE_AXIS));
        b1.add(panAvertissement);
        b1.add(panFermer);

        fermer.addActionListener(this);

        this.getContentPane().add(b1);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        this.dispose();
    }
}
