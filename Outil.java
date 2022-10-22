package fenetre;
import generateur.*;
import appareil.*;
import java.awt.*;
public class Outil
{
	public Appareil[] appareil=new Appareil[5];
	public Batterie[] batterie=new Batterie[5];
	public Paneau[] paneau=new Paneau[5];

	public Outil()
	{
		//appareil
		appareil[0]=new Appareil(1150,100);
		appareil[1]=new Appareil(1150,200);
		appareil[2]=new Appareil(1150,300);
		appareil[3]=new Appareil(1150,400);
		appareil[4]=new Appareil(1150,500);
		
		//Batterie
		batterie[0]=new Batterie(50,10000,100);
		batterie[1]=new Batterie(500,30000,200);
		batterie[2]=new Batterie(1000,100000,300);
		batterie[3]=new Batterie(5000,500000,400);
		batterie[4]=new Batterie(10000,1000000,500);

		//paneau
		paneau[0]=new Paneau(50,10000,100);
		paneau[1]=new Paneau(500,30000,200);
		paneau[2]=new Paneau(1000,100000,300);
		paneau[3]=new Paneau(5000,500000,400);
		paneau[4]=new Paneau(10000,1000000,500);
		
	}	


	public void draw(Graphics g)
	{
		for (int i=0;i<paneau.length;i++) 
		{
			paneau[i].drawPaneau(g);	
		}
		for (int i=0;i<batterie.length;i++) 
		{
			batterie[i].drawBatterie(g);	
		}
		for (int i=0;i<appareil.length;i++) 
		{
			appareil[i].drawAppareil(g);	
		}
	}
}