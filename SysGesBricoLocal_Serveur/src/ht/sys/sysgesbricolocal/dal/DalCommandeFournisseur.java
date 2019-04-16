/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.dal;

import ht.sys.sysgesbricolocal.domaine.CommandeFournisseur;
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
public class DalCommandeFournisseur extends Service {
    private static Connection con=null;
    private static Statement st=null;
    private static ResultSet rs=null;
    private static PreparedStatement pr=null;
    private static PreparedStatement pr1=null;
    private static CommandeFournisseur Comcli=null;
   
    public static String mesaj="";
    public static String mesaj1=""; 
    
  public static String EnregistrerCommandeFournisseur(CommandeFournisseur Comfour){
        String mesage="";
    
       int rep=0;
        //boolean val=false;
        try {
            con=DriverManager.getConnection(chaine);
        
            pr=con.prepareStatement("insert into CommandeFournisseur(numerocommandefournisseur,nomutilisateur,description,typecommande,datelivraison,quantite,prix,datecommande) values('"+Comfour.getNumerocommandefournisseur()+"','"+Comfour.getNomutilisateur()+"','"+Comfour.getDescription()+"','"+Comfour.getTypecommande()+"','"+Comfour.getDatelivraison()+"','"+Comfour.getQuantite()+"','"+Comfour.getPrix()+"','"+Comfour.getDatecommande()+"')");
                                                                                                       
          rep= pr.executeUpdate();                                     
            
          if(rep!=0)
          { 
              mesage="Le numero:  '"+Comcli.getNumerocommandefournisseur()+"'  a ete ajoute avec succes.";
          }
          else{ mesage="Enregistrement non reussi";}
            //val=true;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return mesage;
    }
 public static Object[][] RechercherCommandeFournisseur(String co){
        Object[][] data = null;
         try {
             long start = System.currentTimeMillis();
             int i=0;
            con=(Connection)DriverManager.getConnection(chaine);
            pr=con.prepareStatement("select  f.nom,a.numeroarticle,a.libelle,a.categorie,a.prixarticle,s.quantite from Achat a,Fournisseur f,Stock s where f.numerofournisseur=a.numerofournisseur and a.numeroarticle=s.numeroarticle and a.numeroarticle=?");
            // `numerocommandefournisseur`,  `nomutilisateur`,  `description`,  `typecommande`,  `datelivraison`,  `quantite`,  `prix`,  `datecommande`
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
                data[i][3]=rs.getString(4);
                data[i][4]=rs.getFloat(5);
                data[i][5]=rs.getInt(6);
                data[i][6]=rs.getString(7);
                data[i][7]=rs.getString(8);
          
                i++;
                long totalTime = System.currentTimeMillis() - start;

            mesaj="La listage a ete executee en " + totalTime + " millisecondes et a retourne " + nn + " ligne(s)";
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
    public static Object[][] ListerCommandeFournisseur(){
        Object[][] data = null;
         try {
             long start = System.currentTimeMillis();
             int i=0;
            con=(Connection)DriverManager.getConnection(chaine);
            st=con.createStatement();
            rs=st.executeQuery("select  f.nom,a.numeroarticle,a.libelle,a.categorie,a.prixarticle,s.quantite from Achat a,Fournisseur f,Stock s where f.numerofournisseur=a.numerofournisseur and a.numeroarticle=s.numeroarticle");
           //`numerocommandefournisseur`,  `nomutilisateur`,  `description`,  `typecommande`,  `datelivraison`,  `quantite`,  `prix`,  `datecommande`
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
                data[i][3]=rs.getString(4);
                data[i][4]=rs.getFloat(5);
                data[i][5]=rs.getInt(6);
                   data[i][6]=rs.getInt(7);
                      data[i][7]=rs.getInt(8);
                   
                i++;
                long totalTime = System.currentTimeMillis() - start;

            mesaj="La listage a ete executee en " + totalTime + " millisecondes et a retourne " + nn + " ligne(s)";
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
         public static boolean ModifierCommandeFournisseur(String numerocommandefournisseur, String nomutilisateur, String description, String typecommande, String datelivraison, int quantite, Float prix, String datecommande){
      
          boolean val=false;
        try {
            con=DriverManager.getConnection(chaine);
            st=con.createStatement();
           // st.executeUpdate("update CommandeFournisseur  set nomrepresentant='"+nomrepresentant+"',matriculerepresentant='"+matriculerepresentant+"',quantite='"+quantite+"',datevente='"+datevente+"',typevente='"+typevente+"' where numerovente='"+numerovente+"'");
//`numerocommandefournisseur`,  `nomutilisateur`,  `description`,  `typecommande`,  `datelivraison`,  `quantite`,  `prix`,  `datecommande`
            val=true;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return val;
    }

    
}
