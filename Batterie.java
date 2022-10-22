package generateur;
import java.awt.*;
import javax.swing.*;

public class Batterie {

    private int puissance;
    private int prix;
    private int posX;
    private int posX_default;
    private int posY_default;
    private int posY;
	public boolean deplacement=false;
	public boolean poser=false;
    
    public ImageIcon icon=new ImageIcon("image/batterie.png");
    public Image image=icon.getImage();
    
    public Batterie(int puissance,int prix,int posY)
    {
        setPuissance(puissance);
        setPrix(prix);
        setPosX(270);
        setPosX_default(270);
        setPosY(posY);
        setPosY_default(posY);
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
      
    
    public void drawBatterie(Graphics g)
	{
        g.drawImage(image, getPosX(), getPosY(), 50, 50, null);
		g.setColor(Color.BLACK);
		g.drawString(getPuissance()+" W",getPosX()+60,getPosY()+30);
	}


}
