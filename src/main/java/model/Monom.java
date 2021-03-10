package model;

public class Monom {
    private float coef;
    private int grad;

    public float getCoef() {
        return coef;
    }
    public void setCoef(float coef) {
        this.coef = coef;
    }
    public int getGrad() {
        return grad;
    }
    public void setGrad(int f) {
        this.grad = f;
    }
    public Monom(float a, int b) {
        this.coef = a;
        this.grad = b;
    }
}
