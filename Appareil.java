package appareil;

import java.awt.*;
import javax.swing.*;

public class Appareil
{
	private String nom;
    private int tension;
    private int intensite;
    private int heureDebut;
    private int heureFin;
    private int posX;
    private int posY;
    private int posX_default;
    private int posY_default;
	public boolean deplacement=false;
	public boolean poser=false;
    public ImageIcon icon=new ImageIcon("image/appareil.png");
    public Image image=icon.getImage();

    public Appareil(String name,int volt,int amp,int hD,int hF)
    {
        setNom(name);
        setTension(volt);
        setIntensite(amp);
        setHeureDebut(hD);
        setHeureFin(hF);
    }

    public int getPosY_default() {
        return posY_default;
    }

    public void setPosY_default(int posY_default) {
        this.posY_default = posY_default;
    }

    public int getPosX_default() {
        return posX_default;
    }

    public void setPosX_default(int posX_default) {
        this.posX_default = posX_default;
    }

    public Appareil(int x,int y)
	{
		setPosX(x);
        setPosY(y);	
        setPosX_default(x);
        setPosY_default(y);	
	}

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(int heureFin) {
        this.heureFin = heureFin;
    }

    public int getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(int heureDebut) {
        this.heureDebut = heureDebut;
    }

    public int getIntensite() {
        return intensite;
    }

    public void setIntensite(int intensite) {
        this.intensite = intensite;
    }

    public int getTension() {
        return tension;
    }

    public void setTension(int tension) {
        this.tension = tension;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    

    public int puissance()
    {
        int p=getTension()*getIntensite();
        return p;
    }

    public int heureTotal()
    {
        int heure=getHeureFin()-getHeureDebut();
		if(heure<=0)
		{
			heure+=24;
		}
		return heure;
    }

    public int heureJour()
	{
		int h=0;
		int debut=getHeureDebut();
		int fin=getHeureFin();
		if(debut<fin)
		{
			for(int i=debut;i<fin;i++)
			{
				if(i>=6 && i<18)
				{
					h++;
				}
			}
		}
		if(debut>=fin)
		{
			h=12;
		}
		return h;
	}

    public int heureNuit()
	{
		int h=heureTotal()-heureJour();
		return h;
	}

    public int puissanceJour()
    {
        int p=heureJour()*puissance();
        return p;
    }

    public int puissanceNuit()
    {
        int p=heureNuit()*puissance();
        return p;
    }


    public boolean utilise(int hD,int hF)
    {
        boolean u=false;
        for(int i=getHeureDebut();i<=getHeureFin();i++)
        {
            if(i==hD)
            {
                for(int j=hD;j<=getHeureFin();j++)
                {
                    if(j==hF)
                    {
                        u=true;
                    }
                }
            }
        }
        return u;
    }

    public static void main(String[] args) {
        Appareil appareil=new Appareil("name", 20, 15, 3, 23);
    }

    public void drawAppareil(Graphics g)
    {
        g.drawImage(image, getPosX(), getPosY(), 50, 50, null);
		g.setColor(Color.BLACK);
		g.drawString("Appareil ",getPosX()+60,getPosY()+30);
    }
}	