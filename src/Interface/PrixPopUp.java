package Interface;

import Classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrixPopUp extends JFrame implements ActionListener {
    private JLabel message = new JLabel();
    private JButton fermer = new JButton("Terminer");
    private JPanel panMessage = new JPanel();
    private JPanel panFermer = new JPanel();
    private JRadioButton oui = new JRadioButton("oui");
    private JRadioButton non = new JRadioButton("non");
    private JPanel panInfoReduc = new JPanel();
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JLabel txtPrixReduit = new JLabel();
    private JPanel panTxtPrixReduit = new JPanel();
    private double prixReduit;

    /**
     * Constructeur de la classe PagePopUp générant l'affichage de la fenêtre
     *
     * @param prix
     * @param reduc
     * @param ficheLocation
     * @param bPrixFinal
     */

    public PrixPopUp(double prix, boolean reduc, FicheLocation ficheLocation, boolean bPrixFinal){

        if(bPrixFinal==false) {
            message.setText("Le prix prévu est de " + prix + "€");
        }else if(bPrixFinal==true){
            message.setText("Le prix final est de " + prix + "€");
        }
        message.setFont(new Font("Arial", Font.PLAIN, 16));

        prixReduit = prix - 10*prix/100;
        txtPrixReduit.setText("Voulez vous appliquez la réduction pour un prix de " + prixReduit + "€");

        oui.setSelected(true);
        buttonGroup.add(oui);
        buttonGroup.add(non);
        panInfoReduc.setLayout(new BoxLayout(panInfoReduc, BoxLayout.LINE_AXIS));
        panInfoReduc.add(oui);
        panInfoReduc.add(non);
        panInfoReduc.setBackground(Color.white);

        panMessage.add(message, BorderLayout.CENTER);
        panMessage.setBackground(Color.white);
        panFermer.add(fermer, BorderLayout.CENTER);
        panFermer.setBackground(Color.white);
        panTxtPrixReduit.add(txtPrixReduit, BorderLayout.CENTER);
        panTxtPrixReduit.setBackground(Color.white);

        if(bPrixFinal==false){
            this.setTitle("Prix prévu");
        }else if(bPrixFinal==true){
            this.setTitle("Prix final");
        }
        this.setResizable(false);
        this.setSize(500,200);
        this.setLocationRelativeTo(null);

        JPanel bReduc = new JPanel();
        bReduc.setLayout(new BoxLayout(bReduc, BoxLayout.PAGE_AXIS));
        bReduc.add(panTxtPrixReduit);
        bReduc.add(panInfoReduc);

        JPanel b1 = new JPanel();
        b1.setLayout(new BoxLayout(b1, BoxLayout.PAGE_AXIS));
        b1.add(panMessage);
        if(reduc == true){
            b1.add(bReduc);
        }
        b1.add(panFermer);

        fermer.addActionListener(this);

        this.getContentPane().add(b1);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        PageAccueil pageAccueil = new PageAccueil();
        this.dispose();
    }
}