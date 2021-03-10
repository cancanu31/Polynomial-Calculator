package model;

import vedere.View;
import control.Controller;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Controller c = new Controller(view);
        view.setVisible(true);
    }
}
