package model;
import java.util.Comparator;

class ComparareGrade implements Comparator<Monom> {
    //returneaza un polinom rezultat prin adunarea termenilor din array-ul de monoame care au acelasi grad.
    public int compare(Monom a, Monom b) {
        return -a.getGrad() + b.getGrad();
    }
}
