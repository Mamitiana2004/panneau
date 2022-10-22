package fenetre;

import javax.swing.JFrame;

import fenetre.Plateform;

public class Fenetre {
    public Fenetre()
    {
        JFrame f=new JFrame("Consomation");
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setSize(1360,700);
        Plateform p=new Plateform();
        f.getContentPane().add(p);
    }

    public static void main(String[] args) {
        new Fenetre();
    }
}
