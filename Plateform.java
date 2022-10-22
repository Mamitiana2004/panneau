package fenetre;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;

import evenement.Evenement;
import fenetre.Outil;
import maison.Maison;


public class Plateform extends JPanel
{
    Outil outil=new Outil();
    Evenement event=new Evenement();
    Maison maison=new Maison(this);
    public void init()
    {
        setLayout(null);
        JButton enregistrerButton=new JButton("Enregistrer");
        enregistrerButton.setBounds(430,570,100,40);
        event.enregistrer(enregistrerButton,maison);
        add(enregistrerButton);
    }

	public void paintComponent(Graphics g)
    {
        g.setColor(Color.WHITE);
		g.fillRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(Color.GRAY);
		g.drawRoundRect(10,10,200,600,40,40);
		g.drawRoundRect(220,10,200,600,40,40);
		g.drawRoundRect(1100,10,200,600,40,40);
        outil.draw(g);
        maison.drawMaison(g);

        ///texte
		g.setColor(Color.BLACK);
		g.drawString("Paneau",60,40);
		g.drawString("Batterie",270,40);
		g.drawString("Appareil",1150,40);

        
        String prix="Prix total :"+maison.getPrixTotal()+" Ar";
        String puissanceAppareilJour="Puissance  des appareils/jour :"+maison.getPuissanceAppareilJour()+" W";
        String puissanceAppareilNuit="Puissance  des appareils/jour :"+maison.getPuissanceAppareilNuit()+" W";
        String puissancePaneau="Puissance  des paneaux :"+maison.getPuissancePaneau()+" W";
        String puissanceBatterie="Puissance  des batteries :"+maison.getPuissanceBatterie()+" W";

        g.setColor(Color.BLACK);
        g.drawString(prix,450,30);
        g.drawString(puissanceAppareilJour,450,50);
        g.drawString(puissanceAppareilNuit,450,70);
        g.drawString(puissancePaneau,450,90);
        g.drawString(puissanceBatterie,450,110);
        g.drawRoundRect(440, 10, 250, 120,20,20);

        ////
        ///message
        String messageJour=maison.getMessageJour();
        String messageNuit=maison.getMessageNuit();
        g.drawRect(810, 550, 200, 100);
        g.setColor(Color.RED);
        g.drawString(messageJour, 820, 570);
        g.drawString(messageNuit, 820, 590);
        String nbr="panneau necesaire :"+maison.nbrPaneau(outil);
        
        String nb2="panneau necesaire :"+maison.nbrBatterie(outil);
        
    }
    static Plateform plateform;
    public Plateform()
    {
		plateform=this;
        init();
		event.deplacer(this,outil,maison);
    }
}
