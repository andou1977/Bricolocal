/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.dal;

import ht.sys.sysgesbricolocal.domaine.CommandeClients;
import ht.sys.sysgesbricolocal.servicetechnique.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Berling
 */
public class DalCommandeClients extends Service {
  private static Connection con=null;
    private static Statement st=null;
    private static ResultSet rs=null;
    private static PreparedStatement pr=null;
    private static PreparedStatement pr1=null;
    private static CommandeClients Comcli=null;
   
    public static String mesaj="";
    public static String mesaj1=""; 
    
     public static String EnregistrerCommandClients(String numerocommandeclients, String nomutilisateur, String numeroclients, String numeroarticle, int quantite, Float prix, String typecommande, String datecommande, String datelivraison){
        String message="";
    
       int rep=0;
        //boolean val=false;
        try {
            con=DriverManager.getConnection(chaine);
        
            pr=con.prepareStatement("insert into CommandClients(numerocommandeclients,nomutilisateur,numeroclients,numeroarticle,quantite,prix,typecommande,datecommande,datelivraison) values('"+Comcli.getNumerocommandeclients()+"','"+Comcli.getNomutilisateur()+"','"+Comcli.getNumeroclients()+"','"+Comcli.getNumeroarticle()+"','"+Comcli.getQuantite()+"','"+Comcli.getPrix()+"','"+Comcli.getTypecommande()+"','"+Comcli.getDatecommande()+"','"+Comcli.getDatelivraison()+"')");
                                                                                                                                                
          rep= pr.executeUpdate();
            
          if(rep!=0)
          { 
              message="Le numero:  '"+Comcli.getNumerocommandeclients()+"'  a ete ajoute avec succes.";
          }
          else{ message="Enregistrement non reussi";}
            //val=true;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return message;
    }

   public static Object[][] RechercherCommandeClients(String co){
        Object[][] data = null;
         try {
             long start = System.currentTimeMillis();
             int i=0;
            con=(Connection)DriverManager.getConnection(chaine);
            pr=con.prepareStatement("select  cl.nom,a.libelle,a.categorie,c.prixarticle,c.quantite,c.typecommande,c.datecommande,c.datelivraison from Article a,Clients cl,CommandeClients where cl.numeroClients=c.numeroClients and a.numeroarticle=c.numeroarticle and c.numerocommandeClients=?");
            // `numerocommandeclients`,  `nomutilisateur`,  `numeroclients`,  `numeroarticle`,  `quantite`,  `prix`,  `typecommande`,  `datecommande`,  `datelivraison`
            pr.setString(1, co);
            rs=pr.executeQuery();
           //technique pour touver dynamiquement la taille du tableau retourné.
            rs.last();
            int nn=rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
            data=new Object[nn][8];
            while(rs.next()){
                data[i][0]=rs.getString(1);
                data[i][1]=rs.getString(2);
                data[i][2]=rs.getString(3);
                data[i][3]=rs.getFloat(4);
                data[i][4]=rs.getInt(5);
                data[i][5]=rs.getString(6);
                data[i][6]=rs.getString(7);
              data[i][7]=rs.getString(8);
                i++;
                long totalTime = System.currentTimeMillis() - start;

           // mesaj="La listage a ete executee en " + totalTime + " millisecondes et a retourne " + nn + " ligne(s)";
            }
        } catch (SQLException e) {
           System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }finally{
            try{
                con.close();
            }catch(Exception e){
            System.out.println("SQLException: " + e.getMessage());
            }
        return data;
        }
   }
   
      public static Object[][] RechercherCommandeClientsParDate(String datecommande){
        Object[][] data = null;
         try {
             long start = System.currentTimeMillis();
             int i=0;
            con=(Connection)DriverManager.getConnection(chaine);
            pr=con.prepareStatement("select  cl.nom,a.libelle,a.categorie,c.prixarticle,c.quantite,c.typecommande,c.datecommande,c.datelivraison from Article a,Clients cl,CommandeClients where cl.numeroClients=c.numeroClients and a.numeroarticle=c.numeroarticle and c.datecommande=?");
            // `numerocommandeclients`,  `nomutilisateur`,  `numeroclients`,  `numeroarticle`,  `quantite`,  `prix`,  `typecommande`,  `datecommande`,  `datelivraison`
            pr.setString(1, datecommande);
            rs=pr.executeQuery();
           //technique pour touver dynamiquement la taille du tableau retourné.
            rs.last();
            int nn=rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
            data=new Object[nn][8];
            while(rs.next()){
                data[i][0]=rs.getString(1);
                data[i][1]=rs.getString(2);
                data[i][2]=rs.getString(3);
                data[i][3]=rs.getFloat(4);
                data[i][4]=rs.getInt(5);
                data[i][5]=rs.getString(6);
                data[i][6]=rs.getString(7);
              data[i][7]=rs.getString(8);
                i++;
                long totalTime = System.currentTimeMillis() - start;

           // mesaj="La listage a ete executee en " + totalTime + " millisecondes et a retourne " + nn + " ligne(s)";
            }
        } catch (SQLException e) {
           System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }finally{
            try{
                con.close();
            }catch(Exception e){
            System.out.println("SQLException: " + e.getMessage());
            }
        return data;
        }
   }
   
    public static Object[][] ListerCommandeClients(){
        Object[][] data = null;
         try {
             long start = System.currentTimeMillis();
             int i=0;
            con=(Connection)DriverManager.getConnection(chaine);
            st=con.createStatement();
            rs=st.executeQuery("select  cl.nom,a.libelle,a.categorie,c.prixarticle,c.quantite,c.typecommande,c.datecommande,c.datelivraison from Article a,Clients cl,CommandeClients where cl.numeroClients=c.numeroClients and a.numeroarticle=c.numeroarticle and c.numerocommandeClients=?");
           //`numerovente`,  `numeroarticle`,  `numeroClients`,  `nomrepresentant`,  `matriculerepresentant`,  `quantite`,  `datevente`,  `typevente`
            //technique pour touver dynamiquement la taille du tableau retourné.
            rs.last();
            int nn=rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
           data=new Object[nn][8];
            while(rs.next()){
                data[i][0]=rs.getString(1);
                data[i][1]=rs.getString(2);
                data[i][2]=rs.getString(3);
                data[i][3]=rs.getFloat(4);
                data[i][4]=rs.getInt(5);
                data[i][5]=rs.getString(6);
                data[i][6]=rs.getString(7);
              data[i][7]=rs.getString(8);
                i++;
                long totalTime = System.currentTimeMillis() - start;

           // mesaj="La listage a ete executee en " + totalTime + " millisecondes et a retourne " + nn + " ligne(s)";
            }
        } catch (SQLException e) {
           System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }finally{
            try{
                con.close();
            }catch(Exception e){
            System.out.println("SQLException: " + e.getMessage());
            }
        return data;
        }
   }
   
    public static CommandeClients  RechercherCommandeClientsMod(String co){
        try {
            con=(Connection)DriverManager.getConnection(chaine);
            pr=con.prepareStatement("select quantite,prix,typecommande,datecommande,datelivraison from CommandeClients where numerocommandeClients=?");
            pr.setString(1, co);
            rs=pr.executeQuery();
            while(rs.next()){
                 Comcli=new CommandeClients(rs.getInt(1),rs.getFloat(2),rs.getString(3),rs.getString(4),rs.getString(5));

            }
        } catch (SQLException e) {
           System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }finally{
            try{
                con.close();
            }catch(Exception e){
            System.out.println("SQLException: " + e.getMessage());
            }
        return Comcli;
        }
    }
    
     public static String ModifierCommandeClients(String numerocommandeclients,int quantite, Float prix, String typecommande, String datecommande, String datelivraison){
      
          //boolean val=false;
         String message="";
         int rep=0;
        try {
            con=DriverManager.getConnection(chaine);
            st=con.createStatement();
            rep=st.executeUpdate("update  CommandeClients set quantite='"+quantite+"',prix='"+prix+"',typecommande='"+typecommande+"',datecommande='"+datecommande+"',datelivraison='"+datelivraison+"' where numerocommandeClients='"+numerocommandeclients+"'");

           if(rep!=0){
           message="Modification reussite";
           }
           else{ message="Modification echouee";}
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return message;
    }
}
   
