/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.dal;

import ht.sys.sysgesbricolocal.domaine.Prelevement;
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
public class DalPrelevement extends Service {

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement pr = null;
    private static Prelevement preleve = null;
    public static String mesaj1 = "";
    public static String messagesup = "";
    public static String messagelister = "";

    public static String EnregistrerPrelevement(int numeroprelevement, Float tca, Float ona, Float sante, Float vie, Float mort) {
        String mesage = "";
        int repenreg = 0;
        try {
            con = DriverManager.getConnection(chaine);
            pr = con.prepareStatement("insert into Prelevement(numeroprelevement,  tca,  ona,  sante,  vie,  mort) values('" + preleve.getNumeroprelevement() + "','" + preleve.getTca() + "','" + preleve.getOna() + "',,'" + preleve.getSante() + "',,'" + preleve.getVie() + "',,'" + preleve.getMort() + "')");
            repenreg = pr.executeUpdate();
            if (repenreg != 0) {
                mesage = "Telephone: '" + preleve.getNumeroprelevement() + "'  a ete ajoutee avec succes.";
            } else {
                mesage = "Enregistrement non reussi";
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return mesage;
    }

    public static Prelevement RechercherPrelevement() {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select numeroprelevement,tca,ona,sante,vie,mort from Prelevement");
            rs = pr.executeQuery();
            while (rs.next()) {
                preleve = new Prelevement(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("SQLException: " + e.getMessage());
            }
            return preleve;
        }
    }
    
    public static Object[][] ListerPrelevement(){
        Object[][] data = null;
         try {
             long start = System.currentTimeMillis();
             int i=0;
            con=(Connection)DriverManager.getConnection(chaine);
            st=con.createStatement();
            pr=con.prepareStatement("select numeroprelevement,tca,ona,sante,vie,mort from Prelevement ");
            
            rs=pr.executeQuery();
           //taille du tableau retourné.
            rs.last();
            int nn=rs.getRow();
            rs.beforeFirst();
            //fin
            data=new Object[nn][6];
            while(rs.next()){
                data[i][0]=rs.getInt(1);
                data[i][1]=rs.getFloat(2);
                data[i][2]=rs.getFloat(3);
                data[i][3]=rs.getFloat(4);
                data[i][4]=rs.getFloat(5);
                data[i][5]=rs.getFloat(6);
                  
                i++;
                long totalTime = System.currentTimeMillis() - start;

          //  mesaj="La listage a ete executee en " + totalTime + " millisecondes et a retourne " + nn + " ligne(s)";
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

    public static String ModifierPrelevement( Float tca, Float ona, Float sante, Float vie, Float mort) {
        String message = "";
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("update  Prelevement set tca ='" + tca + "',ona ='" + ona + "',sante ='" + sante + "',vie ='" + vie + "',mort ='" + mort + "'");
            if (rep != 0) {
                message = "Modification reussie";
            } else {
                message="Modification echouee";
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return message;
    }

    public static String SupprimerPrelevement(String numero) {
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("delete from Prelevement where numeroprelevement='" + numero + "'");
            if (rep != 0) {
                messagesup = "Suppression reussie";
            } else {
                messagesup = "Suppression echouee.";
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return messagesup;
    }
}
