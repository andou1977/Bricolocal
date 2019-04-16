/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.dal;

import ht.sys.sysgesbricolocal.domaine.Fonction;
import ht.sys.sysgesbricolocal.domaine.GrilleSalariale;
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
public class DalGrilleSalariale extends Service {

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement pr = null;
    public static String mesaj1 = "";
    public static String messagesup = "";
    public static String messagelister = "";
    public static GrilleSalariale grsalaire = null;

    public static String EnregistrerGrillerSalariale(String fonction, Float salaireminimal, Float Salairemaximal) {
        String mesage = "";
        int repenreg = 0;
        grsalaire = new GrilleSalariale(fonction, salaireminimal, Salairemaximal);
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            repenreg = st.executeUpdate("insert into Grillesalariale(fonction,salaireminimal,Salairemaximal) values('" + grsalaire.getFonction() + "','" + grsalaire.getSalaireminimal() + "','" + grsalaire.getSalairemaximal() + "')");
            //fonction`,  `salaireminimal`,  `Salairemaximal
            if (repenreg != 0) {
                mesage = "Enregistrement reussi";
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

    public static GrilleSalariale RechercherGrilleSalariale(String fonction) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select fonction,salaireminimal,Salairemaximal from GrilleSalariale where fonction=?");
            pr.setString(1, fonction);
            rs = pr.executeQuery();
            while (rs.next()) {
                grsalaire = new GrilleSalariale(rs.getString(1), rs.getFloat(2), rs.getFloat(3));
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
            return grsalaire;
        }
    }

    public static String ModifierGrilleSalariale(String fonction, float salaireminimal, float Salairemaximal) {
        String message = "";
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("update  GrilleSalariale set salaireminimal='" + salaireminimal + "' ,salairemaximal='" + Salairemaximal + "' where fonction='" + fonction + "'");
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

    public static String SupprimerGrilleSalariale(String fonction) {
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("delete from GrilleSalariale where fonction='" + fonction + "'");
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

    public static Object[][] ListerGrilleSalariale() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            rs = st.executeQuery("select fonction,salaireminimal,Salairemaximal from GrilleSalaire");
            //taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
            data = new Object[nn][3];
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);

                i++;
                long totalTime = System.currentTimeMillis() - start;

                //messagelister="La listage a ete executee en " + totalTime + " millisecondes et a retourne " + nn + " ligne(s)";
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
}
