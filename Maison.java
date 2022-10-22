package maison;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import appareil.Appareil;
import fenetre.Outil;
import generateur.Batterie;
import generateur.Paneau;

public class Maison {
    JPanel panel;
    public boolean supprimePanel=false;
    public Vector<Appareil> appareil=new Vector<>();
    public Vector<JButton> buttonAppareil=new Vector<>();
    public Vector<Batterie> batterie=new Vector<>();
    public Vector<JButton> buttonBatterie=new Vector<>();
    public Vector<Paneau> paneau=new Vector<>();
    public Vector<JButton> buttonPaneau=new Vector<>();
    JPanel appareilPanel=new JPanel(new GridLayout(0,1));
    JPanel batteriePanel=new JPanel(new GridLayout(0,1));
    JPanel paneauPanel=new JPanel(new GridLayout(1,0));
    JScrollPane paneauPane = new JScrollPane();
    JScrollPane appareilPane = new JScrollPane();
    JScrollPane batteriePane = new JScrollPane();

    private Image maison=new ImageIcon("image/image.png").getImage();

    ////puissance utilise par tous les appareils 
    private int puissanceAppareilJour;
    private int puissanceAppareilNuit;
    private int prixTotal=0;
    private boolean perfectJour=false;
    private boolean perfectNuit=false;
    private int puissancePaneau;

    //////
    

    /////
    public boolean isPerfectJour() {
        return perfectJour;
    }
    public boolean isPerfectNuit() {
        return perfectNuit;
    }

    public void setPerfectJour(boolean perfectJour) {
        this.perfectJour = perfectJour;
    }

    public void setPerfectNuit(boolean perfectNuit) {
        this.perfectNuit = perfectNuit;
    }

    //////
    public int getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal() {
        int p=0;
        Batterie[] bat=new Batterie[batterie.size()];
        for(int i=0;i<bat.length;i++)
        {
            bat[i]=batterie.elementAt(i);
            p+=bat[i].getPrix();
        }
        Paneau[] pan=new Paneau[paneau.size()];
        for(int i=0;i<pan.length;i++)
        {
            pan[i]=paneau.elementAt(i);
            p+=pan[i].getPrix();
        }
       prixTotal=p;
    }

    //////
    public int getPuissancePaneau() {
        return puissancePaneau;
    }

    public void setPuissancePaneau() {
        int p=0;
        Paneau[] pan=new Paneau[paneau.size()];
        for(int i=0;i<pan.length;i++)
        {
            pan[i]=paneau.elementAt(i);
            p+=pan[i].getPuissance();
        }
        this.puissancePaneau = p;
    }

    ///puissance utilise par les batteries
    private int puissanceBatterie;

    public int getPuissanceBatterie() {
        return puissanceBatterie;
    }

    public int getPuissanceAppareilJour() {
        return puissanceAppareilJour;
    }

    public int getPuissanceAppareilNuit() {
        return puissanceAppareilNuit;
    }

    public void setPuissanceAppareilJour() {
        int p=0;
        Appareil[] app=new Appareil[appareil.size()];
        for (int i=0;i<app.length;i++) 
		{
			app[i]=appareil.elementAt(i);
			p+=app[i].puissanceJour();
		}
        this.puissanceAppareilJour = p;
    }

    public void setPuissanceAppareilNuit() {
        int p=0;
        Appareil[] app=new Appareil[appareil.size()];
        for (int i=0;i<app.length;i++) 
		{
			app[i]=appareil.elementAt(i);
			p+=app[i].puissanceNuit();
		}
        this.puissanceAppareilNuit = p;
    }

    public void setPuissanceBatterie() {
        int p=0;
        Batterie[] batt=new Batterie[batterie.size()];
        for (int i=0;i<batterie.size();i++) 
		{
			batt[i]=batterie.elementAt(i);
			p+=batt[i].getPuissance();
		}
        this.puissanceBatterie = p;
    }

    
    public void drawMaison(Graphics g)
    {
        g.drawImage(maison,500,10,null);
        setPrixTotal();
        JButton[] appButton=new JButton[buttonAppareil.size()];
        for(int i=0;i<appButton.length;i++)
        {
            int indice=i;
            appButton[i]=buttonAppareil.elementAt(i);
            appButton[i].setBackground(new Color(0,100,190));
            appareilPanel.add(appButton[i]);
        }
        appareilPane.setViewportView(appareilPanel);
        JButton[] battButton=new JButton[buttonBatterie.size()];
        for(int i=0;i<buttonBatterie.size();i++)
        {
            int indice=i;
            battButton[i]=buttonBatterie.elementAt(i);
            battButton[i].setBackground(new Color(0,190,100));
            batteriePanel.add(battButton[i]);
        }
        batteriePane.setViewportView(batteriePanel);
        JButton[] panButton=new JButton[buttonPaneau.size()];
        for(int i=0;i<buttonPaneau.size();i++)
        {
            int indice=i;
            panButton[i]=buttonPaneau.elementAt(i);
            panButton[i].setBackground(new Color(190,100,100));
            paneauPanel.add(panButton[i]);
        }
        paneauPane.setViewportView(paneauPanel);
        
        
    }

    public Maison(JPanel panel)
    {
        this.panel=panel;
        appareilPane.setBounds(820, 250,110, 254);
        batteriePane.setBounds(580, 250,110, 254);
        paneauPane.setBounds(580, 140,350, 100);
        panel.add(appareilPane);
        panel.add(batteriePane);
        panel.add(paneauPane);
        
    }

    public Maison(){}

    public void addAppareil(String name,int intensite,int tension,int hD,int hF)
	{
		Appareil app=new Appareil(name,tension,intensite,hD,hF);
        appareil.add(app);
        appareilAjoute(app);
	}

    public void appareilAjoute(Appareil a)
    {
        JButton button=new JButton(a.getNom());
        buttonAppareil.add(button);
        panel.repaint();
        setPuissanceAppareilJour();
        setPuissanceAppareilNuit();
    }
    
    public void addBatterie(int p,int prix)
	{
		Batterie app=new Batterie(p,prix,0);
        batterie.add(app);
        batterieAjoute(app);
	}

    public void batterieAjoute(Batterie a)
    {
        JButton button=new JButton(""+a.getPuissance()+" W");
        buttonBatterie.add(button);
        panel.repaint();
        setPrixTotal();
        setPuissanceBatterie();
    }

    public void addPaneau(int p,int prix)
	{
		Paneau app=new Paneau(p,prix,0);
        paneau.add(app);
        paneauAjoute(app);
	}

    public void paneauAjoute(Paneau a)
    {
        JButton button=new JButton(""+a.getPuissance()+" W");
        buttonPaneau.add(button);
        panel.repaint();
        setPrixTotal();
        setPuissancePaneau();
    }

    public String getMessageJour() {
        String msg="";
        int pApp=getPuissanceAppareilJour();
        int pPan=getPuissancePaneau();
        if(pApp==pPan)
        {
            msg="";
            setPerfectJour(true);
        }
        else if(pApp>pPan)
        {
            msg="Circuit soustension le jour";
            setPerfectJour(false);
        }
        else{
            msg="Circuit surtension le jour";
            setPerfectJour(false);
        }
        return msg;
    }

    public String getMessageNuit() {
        String msg="";
        int pApp=getPuissanceAppareilJour();
        int pBatt=getPuissanceBatterie();
        if(pApp==pBatt)
        {
            msg="";
            setPerfectNuit(true);
        }
        else if(pApp>pBatt)
        {
            msg="Circuit soustension la nuit";
            setPerfectNuit(false);
        }
        else
        {
            msg="Circuit surtension la nuit";
            setPerfectNuit(false);
        }
        return msg;
    }

    public int nbrPaneau(Outil outil)
    {
        int p=0;
        int paneau=0;
        int pAppareil=getPuissanceAppareilJour();
        int reste=pAppareil;
        
        /////
        for(int i=outil.paneau.length-1;i>=0;i--)
        {
            paneau=reste/outil.paneau[i].getPuissance();
            reste=pAppareil%outil.paneau[i].getPuissance();
            p+=paneau;
            System.out.println("Nombre de paneau neccesaire a "+outil.paneau[i].getPuissance()+"W :"+paneau);
        }
        
        System.out.println("Donc il faut "+p+" Paneau");
        return p;
    }

    public int nbrBatterie(Outil outil)
    {
        int p=0;
        int batterie=0;
        int pAppareil=getPuissanceAppareilJour();
        int reste=pAppareil;
        
        /////
        for(int i=outil.batterie.length-1;i>=0;i--)
        {
            batterie=reste/outil.batterie[i].getPuissance();
            reste=pAppareil%outil.batterie[i].getPuissance();
            p+=batterie;
            System.out.println("Nombre de batterie neccesaire a "+outil.batterie[i].getPuissance()+"W :"+batterie);
        }
        
        System.out.println("Donc il faut "+p+" batterie");
        return p;
    }

}
