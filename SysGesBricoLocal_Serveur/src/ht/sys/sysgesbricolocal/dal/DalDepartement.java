/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.dal;

import ht.sys.sysgesbricolocal.domaine.Departement;
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
public class DalDepartement extends Service {

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement pr = null;
    private static Departement depart = null;
    public static String mesaj1 = "";
    public static String mesagesup = "";

    public static String EnregistrerDepartement(String numerodepartement, String Departement) {

        String mesage = "";
        int repenreg = 0;
        int code = 0;
        String nomt = "codeautomatiquedepartement";
        String nomc = "codedepartement";
        // boolean val = false;
        depart = new Departement(numerodepartement, Departement);
        try {
            code = recherchercode(nomt);
            numerodepartement = "BL-DEP-" + code + "" + Code;
            con.close();

            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            repenreg = st.executeUpdate("insert into Departement(numerodepartement,Departement) values('" + numerodepartement + "','" + depart.getDepartement() + "')");

            if (repenreg != 0) {
                mesage = numerodepartement;
                con.close();
                requetemodifiercode(nomt, nomc, code);
                //mesage = "Le departement  numero: '" + numerodepartement + "'  a ete ajoute avec succes.";
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

    public static Departement RechercherDepartement(String code) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select numerodepartement,Departement from Departement where numerodepartement=? or Departement=?");
            pr.setString(1, code);
            pr.setString(2, code);
            rs = pr.executeQuery();
            while (rs.next()) {
                depart = new Departement(rs.getString(1), rs.getString(2));
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
            return depart;
        }
    }

    public static String ModifierDepartement(String code, String departement) {
        String message = "";
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("update  Departement set Departement='" + departement + "' where numerodepartement='" + code + "'");
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

    public static String SupprimerDepartement(String code) {
        int rep = 0;
        //  boolean val=false;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("delete from Departement where numerodepartement='" + code + "'");
            if (rep != 0) {
                mesagesup = "Le departement '" + depart.getDepartement() + "'  a ete supprimee avec succes.";
            } else {
                mesagesup = "La suppression du departement  '" + depart.getDepartement() + "'  est echouee.";
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return mesagesup;
    }

    public static Object[][] ChargerDepartement() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            pr = con.prepareStatement("select numerodepartement,departement from Departement");

            rs = pr.executeQuery();
            //taille du tableau retourné.
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
}
