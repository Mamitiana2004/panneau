package evenement;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;

import maison.Maison;
import fenetre.Outil;
import fenetre.Plateform;
import fenetre.Save;
import fenetre.Ajout;

public class Evenement {
    public void enregistrer(JButton button,Maison m)
    {
        button.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e)
            {
               if(m.isPerfectJour()==true && m.isPerfectNuit()==true)
			   {
                   new Save();
			   }
			   else{

			   }
            }
        });
    }
    
    public int appareil;
    public void deplacer(Plateform panel,Outil outil,Maison maison)	
	{
		panel.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e)
			{
				//appareil
				for(int v=0;v<outil.appareil.length;v++)
				{
					for (int i=outil.appareil[v].getPosX();i<=outil.appareil[v].getPosX()+100;i++) 
					{
						for (int j=outil.appareil[v].getPosY();j<=outil.appareil[v].getPosY()+40;j++) 
						{
							if(e.getX()==i && e.getY()==j)
							{
								outil.appareil[v].deplacement=true;
								appareil=v;
							}		
						}	
					}
				}

				//batterie
				for(int v=0;v<outil.batterie.length;v++)
				{
					for (int i=outil.batterie[v].getPosX();i<=outil.batterie[v].getPosX()+100;i++) 
					{
						for (int j=outil.batterie[v].getPosY();j<=outil.batterie[v].getPosY()+40;j++) 
						{
							if(e.getX()==i && e.getY()==j)
							{
								outil.batterie[v].deplacement=true;
							}		
						}	
					}
				}

				//paneau
				for(int v=0;v<outil.paneau.length;v++)
				{
					for (int i=outil.paneau[v].getPosX();i<=outil.paneau[v].getPosX()+100;i++) 
					{
						for (int j=outil.paneau[v].getPosY();j<=outil.paneau[v].getPosY()+40;j++) 
						{
							if(e.getX()==i && e.getY()==j)
							{
								outil.paneau[v].deplacement=true;
							}		
						}	
					}
				}
			}


			public void mouseReleased(MouseEvent e)
			{
				if (outil.appareil[appareil].deplacement==true) 
				{
					outil.appareil[appareil].deplacement=false;	
					if(outil.appareil[appareil].getPosX()>=810 && outil.appareil[appareil].getPosX()<=930 && outil.appareil[appareil].getPosY()>=200 && outil.appareil[appareil].getPosY()<=500)
					{
						outil.appareil[appareil].setPosX(outil.appareil[appareil].getPosX_default());
						outil.appareil[appareil].setPosY(outil.appareil[appareil].getPosY_default());
						new Ajout(maison);
						panel.repaint();
					}
					else 
					{
						outil.appareil[appareil].setPosX(outil.appareil[appareil].getPosX_default());
						outil.appareil[appareil].setPosY(outil.appareil[appareil].getPosY_default());
						panel.repaint();
                        
					}
				}

				for (int i=0;i<outil.batterie.length;i++) 
				{
					outil.batterie[i].deplacement=false;	
					if(outil.batterie[i].getPosX()>=480 && outil.batterie[i].getPosX()<=700 && outil.batterie[i].getPosY()>=200 && outil.batterie[i].getPosY()<=500)
					{
						maison.addBatterie(outil.batterie[i].getPuissance(),outil.batterie[i].getPrix());
						outil.batterie[i].setPosX(outil.batterie[i].getPosX_default());
						outil.batterie[i].setPosY(outil.batterie[i].getPosY_default());
						panel.repaint();
			
					}
					else 
					{
						outil.batterie[i].setPosX(outil.batterie[i].getPosX_default());
						outil.batterie[i].setPosY(outil.batterie[i].getPosY_default());
						panel.repaint();
					}
				}

				for (int i=0;i<outil.paneau.length;i++) 
				{
					outil.paneau[i].deplacement=false;	
					if(outil.paneau[i].getPosX()>=480 && outil.paneau[i].getPosX()<=1030 && outil.paneau[i].getPosY()>=40 && outil.paneau[i].getPosY()<=190)
					{
						maison.addPaneau(outil.paneau[i].getPuissance(),outil.paneau[i].getPrix());
						outil.paneau[i].setPosX(outil.paneau[i].getPosX_default());
						outil.paneau[i].setPosY(outil.paneau[i].getPosY_default());
						panel.repaint();
			
					}
					else 
					{
						outil.paneau[i].setPosX(outil.paneau[i].getPosX_default());
						outil.paneau[i].setPosY(outil.paneau[i].getPosY_default());
						panel.repaint();
					}
				}
				
            }

		});

		panel.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e)
			{
				for (int i=0;i<outil.appareil.length;i++) 
				{
					if(outil.appareil[i].deplacement==true)
					{
						outil.appareil[i].setPosX(e.getX());
						outil.appareil[i].setPosY(e.getY());
						panel.repaint();
					}
				}

				for (int i=0;i<outil.batterie.length;i++) 
				{
					if(outil.batterie[i].deplacement==true)
					{
						outil.batterie[i].setPosX(e.getX());
						outil.batterie[i].setPosY(e.getY());
						panel.repaint();
					}
				}

				for (int i=0;i<outil.paneau.length;i++) 
				{
					if(outil.paneau[i].deplacement==true)
					{
						outil.paneau[i].setPosX(e.getX());
						outil.paneau[i].setPosY(e.getY());
						panel.repaint();
					}
				}
			}
			
		});
	}
}
