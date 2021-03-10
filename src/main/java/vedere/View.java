package vedere;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame {

    JButton adunare = new JButton(" + ");
    JButton scadere = new JButton(" - ");
    JButton impart = new JButton(" / ");
    JButton inmult = new JButton(" * ");
    JButton integr = new JButton(" ∫(polinom1)dx ");
    JButton deriv = new JButton(" ( polinom1 )' ");

    JTextField p1 = new JTextField(30);
    JTextField p2 = new JTextField(30);

    JLabel textul1 = new JLabel ("Primul polinom : ");
    JLabel textul2 = new JLabel ("Al doilea polinom: ");

    JTextField rez = new JTextField(65);
    JLabel rezul = new JLabel("Rezultatul este : ");

    public View(){

        this.setTitle("Operatii cu polinoame");
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel1.add(p1);
        panel2.add(p2);

        JPanel pan1 = new JPanel();
        JPanel pan2 = new JPanel();
        JPanel pan3 = new JPanel();
        JPanel pan4 = new JPanel();
        JPanel pan5 = new JPanel();
        JPanel pan6 = new JPanel();
        JPanel pan7 = new JPanel();
        JPanel pan8 = new JPanel();
        JPanel pan9 = new JPanel();
        JPanel pan10 = new JPanel();
        JPanel pan11 = new JPanel();
        JPanel pan12 = new JPanel();
        JPanel pan13 = new JPanel();

        rez.setEditable(false);
        panel3.add(rez);

        pan5.add(adunare);
        pan6.add(scadere);
        pan7.add(impart);
        pan8.add(inmult);
        pan9.add(integr);
        pan10.add(deriv);

        pan1.add(textul1);
        pan1.add(panel1);
        pan1.setLayout(new BoxLayout(pan1,BoxLayout.Y_AXIS));

        pan2.add(textul2);
        pan2.add(panel2);
        pan2.setLayout(new BoxLayout(pan2,BoxLayout.Y_AXIS));

        pan3.add(pan1);
        pan3.add(pan2);
        pan3.setLayout(new BoxLayout(pan3,BoxLayout.X_AXIS));

        pan4.add(pan5);
        pan4.add(pan6);
        pan4.add(pan8);
        pan4.setLayout(new BoxLayout(pan4,BoxLayout.X_AXIS));

        pan11.add(pan7);
        pan11.add(pan10);
        pan11.add(pan9);
        pan11.setLayout(new BoxLayout(pan11,BoxLayout.X_AXIS));

        pan12.add(rezul);
        pan12.add(panel3);
        pan12.setLayout(new BoxLayout(pan12,BoxLayout.Y_AXIS));

        pan13.add(pan3);
        pan13.add(pan4);
        pan13.add(pan11);
        pan13.add(pan12);
        pan13.setLayout(new BoxLayout(pan13,BoxLayout.Y_AXIS));

        this.add(pan13);

    }
    //adauga un ascultator la butonul destinat realizarii adunarii a doua polinoame date.
    public void adunareListener(ActionListener ButtonListener) {
        adunare.addActionListener(ButtonListener);
    }
    public void scadereListener(ActionListener ButtonListener) {
        scadere.addActionListener(ButtonListener);
    }
    public void derivListener(ActionListener ButtonListener) { deriv.addActionListener(ButtonListener); }
    public void impartListener(ActionListener ButtonListener) {
        impart.addActionListener(ButtonListener);
    }
    public void inmultListener(ActionListener ButtonListener) {
        inmult.addActionListener(ButtonListener);
    }
    public void integrListener(ActionListener ButtonListener) {
        integr.addActionListener(ButtonListener);
    }

    public String getTextPol1() { return p1.getText();}//returneaza String-ul din text field-ul destinat primului
    public String getTextPol2() {
        return p2.getText();
    }
    public void setTextRez(String s) { rez.setText(s); }//seteaza text field-ul destinat rezultatului cu un String dat ca parametru.

}
