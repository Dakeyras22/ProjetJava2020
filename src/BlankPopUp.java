import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlankPopUp extends JFrame implements ActionListener {

    /* =================================================================================================*/
    /*========================Creation des JPanel,JButton et JLabel nécessaires=========================*/
    /* =================================================================================================*/

    private JLabel avertissement = new JLabel("Veuillez remplir toutes les informations.");
    private JButton fermer = new JButton("Retour");
    private JPanel panAvertissement = new JPanel();
    private JPanel panFermer = new JPanel();

    public BlankPopUp(){

        avertissement.setFont(new Font("Arial", Font.PLAIN, 16)); //choix de la police d'écriture

        /*remplissage des panels et change la couleur du fond en blanc*/
        panAvertissement.add(avertissement, BorderLayout.CENTER);
        panAvertissement.setBackground(Color.white);
        panFermer.add(fermer, BorderLayout.CENTER);
        panFermer.setBackground(Color.white);

        /*paramètres de la frame*/
        this.setTitle("WARNING");
        this.setResizable(false);
        this.setSize(500,100);
        this.setLocationRelativeTo(null);

        /*création du panel final de la frame*/
        JPanel b1 = new JPanel();
        b1.setLayout(new BoxLayout(b1, BoxLayout.PAGE_AXIS));
        b1.add(panAvertissement);
        b1.add(panFermer);

        fermer.addActionListener(this); //ajout d'un action listener sur le bouton fermer

        /*ajout du panel final dans la frame et affichage de la frame*/
        this.getContentPane().add(b1);
        this.setVisible(true);
    }

    /* =================================================================================================*/
    /* ================ActionListener du bouton retour qui ferme la fenêtre=============================*/
    /* =================================================================================================*/
    public void actionPerformed(ActionEvent e){
        this.dispose();
    }
}
