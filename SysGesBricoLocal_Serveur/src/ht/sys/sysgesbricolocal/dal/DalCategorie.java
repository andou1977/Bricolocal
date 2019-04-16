/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.dal;

import ht.sys.sysgesbricolocal.domaine.Categorie;
import ht.sys.sysgesbricolocal.servicetechnique.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rose
 */
public class DalCategorie extends Service {

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement pr = null;
    private static Categorie cate = null;
    public static String mesaj1 = "";
    public static String mesagesup = "";

    public static String EnregistrerCategorie(String numerocategorie, String description, String date_ajout) {

        String message = "";
        int repenreg = 0;
        int code = 0;
        String nomt = "codeautomatiquecategorie";
        String nomc = "codecategorie";
        // boolean val = false;
        cate = new Categorie(numerocategorie, description, date_ajout);
        try {


            code = recherchercode(nomt);
            numerocategorie = "BL-CAT-" + code + "" + Code;
            //con.close();
            //111111111111111111111111111111111111111111111111111111
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            //val = true;
            repenreg = st.executeUpdate("insert into Categorie(numerocategorie,description,date_ajout) values('" + numerocategorie + "','" + cate.getDescription() + "','" + cate.getDate_ajout() + "')");
            if (repenreg != 0) {
                // mesage=numeroemploye;
                con.close();
                requetemodifiercode(nomt, nomc, code);
                //con.close();
                message = numerocategorie;
            } else {

                message = "Enregistrement non reussi";
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return message;


    }

    public static Categorie RechercherCategorie(String code) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select numerocategorie,description,date_ajout from Categorie where numerocategorie=? or description=? or date_ajout=?");
            pr.setString(1, code);
            pr.setString(2, code);
            pr.setString(3, code);
            rs = pr.executeQuery();
            while (rs.next()) {
                cate = new Categorie(rs.getString(1), rs.getString(2), rs.getString(3));
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
            return cate;
        }
    }

    public static String ModifierCategorie(String code, String description) {
        String message = "";
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("update  Categorie set description='" + description + "' where numerocategorie='" + code + "'");
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

    public static String SupprimerCategorie(String code) {
        int rep = 0;
        //  boolean val=false;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("delete from Categorie where numerocategorie='" + code + "'");
            if (rep != 0) {
                mesagesup = "La categorie numero:  '" + cate.getNumerocategorie() + "'  a ete supprimee avec succes.";
            } else {
                mesagesup = "La suppression de la categorie numero:  '" + cate.getNumerocategorie() + "'  est echouee.";
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return mesagesup;
    }

    public static Object[][] ChargerCategorie() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            pr = con.prepareStatement("select description,date_ajout from Categorie");

            rs = pr.executeQuery();
            //technique pour touver dynamiquement la taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
            data = new Object[nn][2];
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
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

    public static Object[][] ListerCategorie() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            pr = con.prepareStatement("select numerocategorie,description,date_ajout from Categorie order by date_ajout");

            rs = pr.executeQuery();
            //technique pour touver dynamiquement la taille du tableau retourné.
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
}
