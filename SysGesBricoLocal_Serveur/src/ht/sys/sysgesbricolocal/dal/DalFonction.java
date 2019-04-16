/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.dal;

import ht.sys.sysgesbricolocal.domaine.Fonction;
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
public class DalFonction extends Service {

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement pr = null;
    private static Fonction fonc = null;
    public static String mesaj1 = "";
    public static String messagesup = "";
    public static String messagelister = "";

    public static String EnregistrerFonction(int numerofonction, String fonction, int nombreemploye) {
        String mesage = "";
        int repenreg = 0;
        int code = 0;
        String nomt = "codeautomatiquefonction";
        String nomc = "codefonction";
        fonc = new Fonction(fonction, nombreemploye);
        try {

            code = recherchercode(nomt);
            numerofonction = code;
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            repenreg = st.executeUpdate("insert into Fonction(numerofonction,fonction,quantiteemploye) values('" + numerofonction + "','" + fonc.getFonction() + "','" + fonc.getNombreemploye() + "')");
            if (repenreg != 0) {
                con.close();
                requetemodifiercode(nomt, nomc, code);
                mesage = "" + code;
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

    public static Fonction RechercherFonction(String fonction) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select fonction,quantiteemploye,numerofonction from Fonction where fonction=?");
            pr.setString(1, fonction);
            rs = pr.executeQuery();
            while (rs.next()) {
                fonc = new Fonction(rs.getString(1), rs.getInt(2), rs.getInt(3));
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
            return fonc;
        }
    }

    public static String ModifierFonction(String fonction, int quantiteemploye, int numerofonction) {
        String message = "";
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("update  Fonction set fonction='" + fonction + "',quantiteemploye='" + quantiteemploye + "' where numerofonction='" + numerofonction + "'");
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

    public static String SupprimerFonction(String fonction) {
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("delete from Fonction where fonction='" + fonction + "'");
            if (rep != 0) {
                messagesup = "La fonction:  '" + fonc.getFonction() + "'  a ete supprimee avec succes.";
            } else {
                messagesup = "La suppression de la fonction:  '" + fonc.getFonction() + "'  est echouee.";
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return messagesup;
    }

    public static Object[][] ListerFonction() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            rs = st.executeQuery("select fonction,quantiteemploye from Fonction");
            // taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin 
            data = new Object[nn][2];
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);

                i++;
                long totalTime = System.currentTimeMillis() - start;

                messagelister = "La listage a ete executee en " + totalTime + " millisecondes et a retourne " + nn + " ligne(s)";
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

    public static Object[][] ChargerFonction() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select distinct(fonction),numerofonction from Fonction");
            rs = pr.executeQuery();
            //taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin 
            data = new Object[nn][2];
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getInt(2);
                i++;
                long totalTime = System.currentTimeMillis() - start;
                //mesaj="La listage a ete executee en " + totalTime + " millisecondes et a retourne " + nn + " ligne(s)";
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
    
    
    
     public static Fonction RechercherQuantiteFonctionEmp(String fonction) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select count(fonction) from  Employe  where fonction=?");
            pr.setString(1, fonction);
            rs = pr.executeQuery();
            while (rs.next()) {
                fonc = new Fonction(rs.getInt(1));
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
            return fonc;
        }
    }
 public static Fonction rechercherquantitefonc(String co) {
        int i = 0;
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select quantiteemploye from Fonction  where fonction=?");
            pr.setString(1, co);
            rs = pr.executeQuery();
            while (rs.next()) {
               fonc = new Fonction(rs.getInt(1));
//                prod.setCode(rs.getString(1));
//                prod.setLibelle(rs.getString(2));
//                prod.setPrix(rs.getFloat(3));
//                prod.setQuantite(rs.getInt(4));

                i++;
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
            return fonc;
        }
    }
}
