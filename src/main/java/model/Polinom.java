package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Polinom {

    private ArrayList<Monom> monoame;
    public Polinom() {
        //constructor fara parametru care creeaza un obiect de tip Polinom
        this.monoame = new ArrayList<Monom>();
    }
    public ArrayList<Monom> getMonoame() {
        //returneaza array-ul de monoame al polinomului dat.
        return monoame;
    }
    public void setPolinoame(ArrayList<Monom> monoame) {
        //seteaza array-ul de monoame al polinomului dat.
        this.monoame = monoame;
    }
    public Polinom(String s) {
        //constructor care creeaza un obiect de tip Polinom, in functie de String-ul dat
        Polinom p = new Polinom();
        p=mesajToPolinom(s);
        this.monoame=p.monoame;
    }

    public Polinom adunare(Polinom p2) {
        Polinom rezultat = new Polinom();
        for (Monom m1 : p2.monoame) {   ///in p2 avem monom din al doilea polinom
            rezultat.monoame.add(new Monom(m1.getCoef(), m1.getGrad()));
        }
        for (Monom m2 : this.monoame) { ///in this avem monom din primul polinom
            rezultat.monoame.add(new Monom(m2.getCoef(), m2.getGrad()));
        }
        rezultat = rezultat.comprimare();
        return rezultat;
    }

    public Polinom scadere(Polinom p2) {
        Polinom rezultat = new Polinom();

        for (Monom m1 : this.monoame) {
            rezultat.monoame.add(new Monom(m1.getCoef(), m1.getGrad()));
        }
        for (Monom m2 : p2.monoame) {
            float v = m2.getCoef();
            m2.setCoef(-v);
            rezultat.monoame.add(m2);
        }
        rezultat = rezultat.comprimare();
        return rezultat;
    }

    public Polinom derivare() {
        Polinom rezultat = new Polinom();

        for (Monom m : this.monoame) {
            if (m.getGrad() != 0) {
                int g = m.getGrad();
                m.setCoef(m.getCoef() * g);
                m.setGrad(g - 1);
            } else {
                m.setCoef(0);
            }
            rezultat.monoame.add(m);
        }
        return rezultat;
    }

    public Polinom integrare() {
        Polinom rezultat = new Polinom();

        for (Monom m : this.monoame) {
            if (m.getGrad() != 0) {
                int deg = m.getGrad();
                m.setGrad(deg + 1);
                m.setCoef(m.getCoef() / (float) m.getGrad());
            } else {
                int deg = m.getGrad();
                m.setGrad(deg + 1);
            }
            rezultat.monoame.add(m);
        }
        return rezultat;
    }

    public Polinom comprimare() {
        //in aceasta metoda se face adunarea celor cu grad egal
        //in rezultat in loc de 2x^2+3x^2... vom avea 5x^2
        Polinom rezultat = new Polinom();
        Collections.sort(this.monoame, new ComparareGrade());

        boolean ok = false;

        for (Monom m : this.monoame) {
            ok = false;
            for (Monom n : rezultat.monoame) {
                if (m.getGrad() == n.getGrad()) {
                    n.setCoef(n.getCoef() + m.getCoef());
                    ok = true;
                }
            }
            if (!ok) {
                rezultat.monoame.add(m);
            }
        }
        return rezultat;
    }

    public Polinom inmultire(Polinom p2) {
        Polinom rezultat = new Polinom();
        Polinom aux = new Polinom();

        for (Monom m1 : p2.monoame) {
            for (Monom m2 : this.monoame) {
                Monom m = new Monom(m1.getCoef() * m2.getCoef(), m1.getGrad() + m2.getGrad());
                aux.monoame.add(m);
            }
        }
        rezultat = aux.comprimare();
        return rezultat;
    }

    static int gradPolinom(Polinom p) {
        //returneaza gradul unui polinom dat(gradul unui polinom = cel mai mare grad al unui monom din array)
        Collections.sort(p.monoame, new ComparareGrade());
        int i = 0;
        while (i < p.monoame.size()) {
            if (p.monoame.get(i).getCoef() != 0)
                return p.monoame.get(i).getGrad();
            i++;
        }
        return 0;
    }

    public boolean esteZero() {// aceasta metoda returneaza 0 daca un polinom dat este 0
        boolean ok = true;
        int k = 0;
        for (Monom m : this.monoame) {
            if (m.getGrad() == 0 && m.getCoef() == 0)
                k++;
        }
        if (k != this.monoame.size())
            ok = false;
        else
            ok = true;
        return ok;
    }

    boolean isCoefZero(int i) {
        // returneaza true daca un coeficient al unui monom este zero
        boolean ok = false;
        if (this.monoame.get(i).getCoef() == 0) {
            ok = true;
        }
        return ok;
    }

    public ArrayList<Polinom> impartire(Polinom p) {
        ArrayList<Polinom> rezultat = new ArrayList<Polinom>();
        Polinom rest = new Polinom();
        Polinom cat = new Polinom();
        rest = this;
        if (p.esteZero())
            return null;
        Collections.sort(this.monoame, new ComparareGrade());
        Collections.sort(p.monoame, new ComparareGrade());

        while (!rest.esteZero() && gradPolinom(rest) >= gradPolinom(p)) {
            int i = 0;
            while (rest.isCoefZero(i)) {
                i++;
            }
            Monom t = new Monom(rest.monoame.get(i).getCoef() / p.monoame.get(0).getCoef(),
                    rest.monoame.get(i).getGrad() - p.monoame.get(0).getGrad());
            Polinom aux = new Polinom();
            aux.monoame.add(t);
            cat.monoame.add(t);
            Polinom newRest = rest.scadere(aux.inmultire(p));
            rest = newRest;
            aux.monoame.clear();
        }
        rezultat.add(cat);
        rezultat.add(rest);
        return rezultat;
    }

    public Polinom div(Polinom p) {
        //doar catul ne intereseaza pentru implementarea acestei operatii si folosim functia div pentru a extrage doar catul
        return this.impartire(p).get(0);
    }

    public static ArrayList<Integer> coeficienti(String s) {
        ArrayList<Integer> coeficienti = new ArrayList<Integer>();

        String[] coef = s.split("x\\^\\d+\\+?");
        for (String str : coef) {
            coeficienti.add(Integer.parseInt(str));
        }

        return coeficienti;
    }

    public static ArrayList<Integer> puteri(String s) {
        //returneaza un array de integeri -> puterile polinomului pe care vrem sa-l formam.
        ArrayList<Integer> puteri = new ArrayList<Integer>();
        String[] termeni = s.split("(-|\\+)");
        for (String term : termeni) {
            String[] parti = term.split("\\^");
            if (parti[0] != " ") {
                if (parti.length > 1) {
                    puteri.add(Integer.parseInt(parti[1]));
                } else {
                    puteri.add(0);
                }
            }
        }

        return puteri;
    }

    public static Polinom mesajToPolinom(String s) {
        //transforma un String intr-un polinom dat
        Polinom rez = new Polinom();
        try {
            ArrayList<Integer> coeficienti = coeficienti(s);
            ArrayList<Integer> puteri = puteri(s);
            int size = coeficienti.size();
            if (s.startsWith("-") || s.startsWith("+")) {
                for (int i = 0; i < size; i++) {
                    Monom m = new Monom(coeficienti.get(i), puteri.get(i + 1));
                    rez.monoame.add(m);
                }
            } else {
                for (int i = 0; i < size; i++) {
                    Monom m = new Monom(coeficienti.get(i), puteri.get(i));
                    rez.monoame.add(m);
                }
            }
        } catch (Exception e) {
            System.out.println("Nu e ok!!");
            return null;
        }
        return rez;
    }

    public StringBuilder polinomToMesaj() {
        //aceasta metoda transforma un polinom dat intr-un String
        //daca arg lui signum>0 -> 1.0
        //daca arg lui signum=0 -> 0
        //daca arg lui signum<0 ->-1.0
        StringBuilder s = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.0");
        for (int i = 0; i < this.monoame.size(); i++) {
            int grad = this.monoame.get(i).getGrad();
            float coeficient = this.monoame.get(i).getCoef();
            coeficient = Float.parseFloat(df.format(coeficient));
            if (i == 0) {
                if ((coeficient == 1 && grad == 0) || (grad == 0)) {
                    s.append(coeficient + " ");
                } else if (coeficient == 1 || coeficient == -1) {
                    s.append(Math.signum(coeficient) + "x^" + grad);
                } else if (coeficient == 0) {
                    s.append(" ");
                } else
                    s.append(coeficient + "x^" + grad);
            } else {
                if ((coeficient == 1 && grad == 0) || (grad == 0)) {
                    s.append(" + " + coeficient + " ");
                } else if (coeficient == 1 || coeficient == -1) {
                    s.append(" + " + Math.signum(coeficient) + "x^" + grad);
                } else if (coeficient == 0) {
                    s.append(" ");
                } else
                    s.append(" + " + coeficient + "x^" + grad);
            }
        }
        return s;
    }
}
