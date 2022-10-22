package base;
import java.util.Properties;
import java.util.Vector;

import appareil.Appareil;
import generateur.Batterie;
import generateur.Paneau;

import java.sql.*;
public class Base {
	String user;
	String dateBase;
	String password;
	public Base(String u,String mdp,String db)
	{
		user=u;
		dateBase=db;
		password=mdp;
	}

	public Connection connect(){
		Connection con=null;
		try{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dateBase,user,password);
 		}
		catch(Exception e){ 
			System.out.println(e);
		}
		return con;
	}

	public Statement statement(Connection con)
	{
		Statement stmt=null;
		try{
			stmt=con.createStatement();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return stmt;
	}

	public void debutPartie()
	{
		try{
			Connection con=connect();
			Statement stmt=statement(con);
			String sql="INSERT INTO partie(scorePlayer1,scorePlayer2) VALUES(0,0)";
			stmt.executeQuery(sql);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

    public void enregistrerAppareil(Vector<Appareil> appareil)
    {
        try{
                    Appareil[] app=new Appareil[appareil.size()];
            		Connection con=connect();
            		Statement stmt=statement(con);
                    for (int i = 0; i < app.length; i++) {
                        app[i]=appareil.elementAt(i);
                        String sql="INSERT INTO appareil(nom,intensite,tension,heureDebut,heureFin) VALUES ('"+app[i].getNom()+"',"+app[i].getIntensite()+","+app[i].getTension()+","+app[i].getHeureDebut()+","+app[i].getHeureFin()+")"; 
                        stmt.executeQuery(sql);  
                    }
            }catch (Exception e) {
                //TODO: handle exception
            }
    }
    public void enregistrerBatterie(Vector<Batterie> batterie)
    {
        try{
                    Batterie[] app=new Batterie[batterie.size()];
            		Connection con=connect();
            		Statement stmt=statement(con);
                    for (int i = 0; i < app.length; i++) {
                        app[i]=batterie.elementAt(i);
                        String sql="INSERT INTO batterie(puissance,prix) VALUES ("+app[i].getPuissance()+","+app[i].getPrix()+")"; 
                        stmt.executeQuery(sql);  
                    }
            }catch (Exception e) {
                //TODO: handle exception
            }
    }

    public void enregistrerPaneau(Vector<Paneau> paneau)
    {
        try{
                    Paneau[] app=new Paneau[paneau.size()];
            		Connection con=connect();
            		Statement stmt=statement(con);
                    for (int i = 0; i < app.length; i++) {
                        app[i]=paneau.elementAt(i);
                        String sql="INSERT INTO Paneau(puissance,prix) VALUES ("+app[i].getPuissance()+","+app[i].getPrix()+")"; 
                        stmt.executeQuery(sql);  
                    }
            }catch (Exception e) {
                //TODO: handle exception
            }
    }

    public void enregistrerPaneau(Vector<Appareil> appareil,Vector<Batterie> batterie,Vector<Paneau> paneau)
    {
            try{
            		Connection con=connect();
            		Statement stmt=statement(con);
                
                        String sql="INSERT INTO electro(nbrAppareil,nbrBatterie,nbrPaneau) VALUES ("+appareil.size()+","+batterie.size()+"'"+paneau.size()+")"; 
                        stmt.executeQuery(sql);  
                    
            }catch (Exception e) {
                //TODO: handle exception
            }
    }
    

	// public void save(String name,Vector<Appareil> appareil)
    // {
    //     try{
    //         Appareil[] app=new Appareil[appareil.size()];
    //         Batterie[] bat=new Batterie[batterie.size()];
            
    //         Paneau[] bat=new Paneau[paneau.size()];
	// 		Connection con=connect();
	// 		Statement stmt=statement(con);
    //         enregistrerAppareil(appareil);
    //         for (int i = 0; i < app.length; i++) {
    //             String sql="INSERT INTO utilisateur(nomUser,idAppareil,idBatterie,idPaneau) VALUES ('"+name+"';   
    //         }

	// 	}
	// 	catch (Exception e) {
	// 		System.out.println(e.getMessage());
	// 	}
    // }

}