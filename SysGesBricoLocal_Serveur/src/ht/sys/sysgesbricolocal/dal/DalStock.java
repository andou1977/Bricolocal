/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.dal;

import ht.sys.sysgesbricolocal.domaine.Stock;
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
public class DalStock extends Service {

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement pr = null;
    private static PreparedStatement pr1 = null;
    private static Stock stoc = null;
    public static String messagesup = "";
    public static String mesaj1 = "";

    public static String EnregistrerStock(String numerostock, String numeroarticle, String dateajout, int quantite) {
        String mesage = "";
        int code = 0;
        String nomt = "codeautomatiquestock";
        String nomc = "codestock";
        int rep = 0;
        stoc = new Stock(numerostock, numeroarticle, dateajout, quantite);
        try {
              code = recherchercode(nomt);
            numerostock="BL-STO-"+code+""+Code;
           // con.close();
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
             rep = st.executeUpdate("insert into Stock(numerostock,numeroarticle,dateajout,quantite ) values('" + numerostock + "','" + stoc.getNumeroarticle() + "','" + stoc.getDateajout() + "','" + stoc.getQuantite() + "')");
            //numerostock`,  `numeroarticle`,  `dateajout`,  `quantite`
            if (rep != 0) {
                 mesage = numerostock;
                 con.close();
                requetemodifiercode(nomt, nomc, code);
               // con.close();
            } else {
                mesage = "Enregistrement non reussi";
            }
            //val=true;
        } catch (SQLException e) {
            System.out.println("Stock SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return mesage;

    }

    public static Stock RechercherStock(String numero) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select st.numerostock,st.numeroarticle,st.dateajout,st.quantite,ar.prixarticle from stock st,article ar where st.numeroarticle=ar.numeroarticle and libelle=?");
            pr.setString(1, numero);
            rs = pr.executeQuery();
            while (rs.next()) {
                stoc = new Stock(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getFloat(5));
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
            return stoc;
        }
    }

    public static String ModifierStock(String numero, int quantite) {
        String message = "";
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("update  Stock set quantite =(quantite-'" + quantite + "') where numeroarticle='" + numero + "'");
            if (rep != 0) {
                message = "Modification reussie";
            } else {
                message = "Modification echouee";
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return message;
    }

    
    public static String ModifierStockA(String numero, int quantite) {
        String message = "";
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("update  Stock set quantite ='" + quantite + "' where numeroarticle='" + numero + "'");
            if (rep != 0) {
                message = "Modification reussie";
            } else {
                message = "Modification echouee";
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return message;
    }
    
    public static Object[][] ListerStock() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            rs = st.executeQuery("select s.numerostock,a.libelle,s.dateajout,s.quantite from Stock s,Article a where s.numeroarticle=a.numeroarticle");
            //numeroemploye`,  `numeroachat`,  `numerofournisseur`,  `description`,  `quantite`,  `prix`,  `frais`,  `dateachat`,  `dateenregistrement`
            //taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
            data = new Object[nn][4];
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getInt(4);
                i++;
                long totalTime = System.currentTimeMillis() - start;

                //  mesaj="La listage a ete executee en " + totalTime + " millisecondes et a retourne " + nn + " ligne(s)";
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
            return data;
        }
    }

    public static String SupprimerStock(String numero) {
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("delete from Stock where numeroarticle='" + numero + "'");
            if (rep != 0) {
                messagesup = "Suppression reussie";
            } else {
                messagesup = "Suppression echouee";
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return messagesup;
    }

   
}
