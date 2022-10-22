package fenetre;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import java.awt.event.*;
import maison.Maison;
public class Ajout extends JFrame {

    Maison maison;
    private JTextField ampInput;
    private JButton button;
    private JLabel heure;
    private JComboBox<String> heureDebut;
    private JComboBox<String> heureFin;
    private JLabel intensite;
    private JLabel nom;
    private JTextField nomInput;
    private JPanel panel;
    private JLabel tension;
    private java.awt.Label title;
    private JLabel unitVolt;
    private JLabel uniteAmp;
    private JTextField voltInput;
    

    public Ajout(Maison m) {
        maison=m;
        initComponents();
    }
                       
    private void initComponents() {

        panel = new JPanel();
        title = new java.awt.Label();
        nom = new JLabel();
        nomInput = new JTextField();
        intensite = new JLabel();
        ampInput = new JTextField();
        uniteAmp = new JLabel();
        tension = new JLabel();
        voltInput = new JTextField();
        unitVolt = new JLabel();
        heure = new JLabel();
        heureDebut = new JComboBox<>();
        heureFin = new JComboBox<>();
        button = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); 
        title.setText("Appareil ");

        nom.setText("Nom de l'appareil :");

        intensite.setText("Intensite :");

     

        uniteAmp.setText("A");

        tension.setText("Tension :");


        unitVolt.setText("V");

        heure.setText("Heure d'utilisation :");

        /****heure*/
        String[] h=new String[24];

        for (int i=0;i<=23;i++)
        {
            h[i]=i+"";
        } 

        heureDebut.setModel(new DefaultComboBoxModel<>(h));

        heureFin.setModel(new DefaultComboBoxModel<>(h));

        button.setText("Ok");
        button.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e)
            {
                //ajouter un appareil dans la maison
                String nom=nomInput.getText();
                int amp=Integer.parseInt(ampInput.getText());
                int volt=Integer.parseInt(voltInput.getText());
                int debut=heureDebut.getSelectedIndex();
                int fin=heureFin.getSelectedIndex();
                System.out.println("Nom de l'appareil:"+nom);
                System.out.println("intensite de l'appareil:"+amp);
                System.out.println("tension de l'appareil:"+volt);
                System.out.println("heureDebut:"+debut);
                System.out.println("heureFin:"+fin);
                if(volt>=0 && amp>=0)
                {
                    maison.addAppareil(nom, amp, volt, debut,fin);
                    System.out.println("Ajout de l'appareil");
                }
                dispose();
            }
        });

        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom)
                    .addComponent(nomInput, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(intensite)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(ampInput, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(uniteAmp)))
                        .addGap(39, 39, 39)
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(tension)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(voltInput, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(heureFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unitVolt))))
                    .addComponent(heure)
                    .addComponent(heureDebut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(button))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(nom)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(intensite)
                    .addComponent(tension))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ampInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(uniteAmp, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addComponent(voltInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(unitVolt))
                .addGap(27, 27, 27)
                .addComponent(heure)
                .addGap(27, 27, 27)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(heureDebut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(heureFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(button)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setVisible(true);
    }                                                            

    
}
