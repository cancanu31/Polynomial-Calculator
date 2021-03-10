package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Polinom;
import vedere.View;

public class Controller {

    View view = new View();

    public Controller(View v) {
        this.view = v;
        this.view.adunareListener(new AdunareListener());
        this.view.scadereListener(new ScadereListener());
        this.view.impartListener(new ImpartListener());
        this.view.inmultListener(new InmultListener());
        this.view.derivListener(new DerivListener());
        this.view.integrListener(new IntegrListener());
    }

    class AdunareListener implements ActionListener {
    //ascultator pentru butonul destinat adunarii.
        public void actionPerformed(ActionEvent e) {
            Polinom pol1 = new Polinom();
            Polinom pol2 = new Polinom();
            String s1 = view.getTextPol1();
            String s2 = view.getTextPol2();
            pol1 = Polinom.mesajToPolinom(s1);
            pol2 = Polinom.mesajToPolinom(s2);
            Polinom rezultat = new Polinom();

            if (pol1 != null && pol2 != null) {
                rezultat = pol1.adunare(pol2);
                String rez = rezultat.polinomToMesaj().toString();
                view.setTextRez(rez);
            } else {
                JOptionPane.showMessageDialog(view, "Reintrodu polinomul astfel: \n  Ax^2+Bx^1+C", "EROARE", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    class ScadereListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Polinom pol1 = new Polinom();
            Polinom pol2 = new Polinom();
            String s1 = view.getTextPol1();
            String s2 = view.getTextPol2();
            pol1 = Polinom.mesajToPolinom(s1);
            pol2 = Polinom.mesajToPolinom(s2);
            Polinom rezultat = new Polinom();

            if (pol1 != null && pol2 != null) {
                rezultat = pol1.scadere(pol2);
                String rez = rezultat.polinomToMesaj().toString();
                view.setTextRez(rez);
            } else {
                JOptionPane.showMessageDialog(view, "Reintrodu polinomul astfel: \n  Ax^2+Bx^1+C", "EROARE", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    class ImpartListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Polinom pol1 = new Polinom();
            Polinom pol2 = new Polinom();
            String s1 = view.getTextPol1();
            String s2 = view.getTextPol2();
            pol1 = Polinom.mesajToPolinom(s1);
            pol2 = Polinom.mesajToPolinom(s2);
            Polinom rezultat = new Polinom();
            if (pol1 != null && pol2 != null) {
                rezultat = pol1.div(pol2);
                String rez = rezultat.polinomToMesaj().toString();
                view.setTextRez(rez);
            } else {
                JOptionPane.showMessageDialog(view,"Reintrodu polinomul astfel: \n Ax^2+Bx^1+C", "EROARE", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    class InmultListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Polinom pol1 = new Polinom();
            Polinom pol2 = new Polinom();
            String s1 = view.getTextPol1();
            String s2 = view.getTextPol2();
            pol1 = Polinom.mesajToPolinom(s1);
            pol2 = Polinom.mesajToPolinom(s2);
            Polinom rezultat = new Polinom();
            if (pol1 != null && pol2 != null) {
                rezultat = pol1.inmultire(pol2);
                String rez = rezultat.polinomToMesaj().toString();
                view.setTextRez(rez);
            } else {
                JOptionPane.showMessageDialog(view, "Reintrodu polinomul astfel: \n  Ax^2+Bx^1+C", "EROARE", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    class DerivListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Polinom pol1 = new Polinom();
            String s1 = view.getTextPol1();
            pol1 = Polinom.mesajToPolinom(s1);
            Polinom rezultat = new Polinom();
            if (pol1 != null) {
                rezultat = pol1.derivare();
                String rez = rezultat.polinomToMesaj().toString();
                view.setTextRez(rez);
            } else {
                JOptionPane.showMessageDialog(view, "Reintrodu polinomul astfel: \n Ax^2+Bx^1+C", "EROARE", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    class IntegrListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Polinom pol1 = new Polinom();
            String s1 = view.getTextPol1();
            pol1 = Polinom.mesajToPolinom(s1);
            Polinom rezultat = new Polinom();
            if (pol1 != null) {
                rezultat = pol1.integrare();
                String rez = rezultat.polinomToMesaj().toString();
                view.setTextRez(rez);
            } else {
                JOptionPane.showMessageDialog(view,"Reintrodu polinomul astfel: \n Ax^2+Bx^1+C", "EROARE", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
