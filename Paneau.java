package generateur;
import java.awt.*;
import javax.swing.*;
import appareil.Appareil;
public class Paneau {
    private int puissance;
    private int prix;
    private int rendement;
    private int posX;
    private int posY;
    private int posX_default;
    private int posY_default;
	public boolean deplacement=false;
	public boolean poser=false;
    public ImageIcon icon=new ImageIcon("image/paneau.png");
    public Image image=icon.getImage();

    public Paneau(int puissance,int prix,int y)
    {
        setPuissance(puissance);
        setPrix(prix);
        setPosX(60);
        setPosX_default(60);
        setPosY(y);
        setPosY_default(y);
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public int getPrix()
    {
        return prix;
    }

    public void setPrix(int prix)
    {
        this.prix=prix;
    }

    public int getRendement()
    {
        return rendement;
    }

    public void setRendement(int rendement)
    {
        this.rendement=rendement;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX_default() {
        return posX_default;
    }

    public int getPosY_default() {
        return posY_default;
    }

    public void setPosX_default(int posX_default) {
        this.posX_default = posX_default;
    }

    public void setPosY_default(int posY_default) {
        this.posY_default = posY_default;
    }


    public int rendement(int hD,int hF)
    {
        int rend=0;
        if(hD>18 && hF<6)
        {
            rend=0;
        }
        if((hD==6 && hF==7)||(hD==17 && hF==18))
        {
            rend=20;
        }
        if((hD==7 && hF==8)||(hD==16 && hF==17))
        {
            rend=50;
        }
        if((hD==8 && hF==9)||(hD==15 && hF==16))
        {
            rend=80;
        }
        if((hD==9 && hF==10)||(hD==10 && hF==11)||(hD==11 && hF==12)||(hD==12 && hF==13)||(hD==13 && hF==14)||(hD==14 && hF==15))
        {
            rend=100;
        }
        return rend;
    }

    public int puissanceTotal(int hD,int hF)
    {
        int p=(getPuissance()*rendement(hD,hF))/100;
        return p;
    }

    public static void main(String[] args) {
        Appareil appareil=new Appareil("name", 15, 10, 2, 15);
        Paneau paneau=new Paneau(9600, 200, 2);
        for(int i=2;i<=15;i+=1)
        {
            System.out.println("puissance avec rendement de "+i+"h a "+(i+1)+"h");
            System.out.println(paneau.puissanceTotal(i,i+1)+"W");
        }
    }

    public void drawPaneau(Graphics g)
	{
        g.drawImage(image, getPosX(), getPosY(), 50, 50, null);
		g.setColor(Color.BLACK);
		g.drawString(getPuissance()+" W",getPosX()+60,getPosY()+30);
	}


}
