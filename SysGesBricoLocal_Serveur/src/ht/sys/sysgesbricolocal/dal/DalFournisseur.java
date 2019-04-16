/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.dal;

import ht.sys.sysgesbricolocal.domaine.Fournisseur;
import ht.sys.sysgesbricolocal.servicetechnique.Service;
import java.rmi.RemoteException;
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
public class DalFournisseur extends Service {

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement pr = null;
    private static Fournisseur four = null;
    public static String mesaj1 = "";
    public static String messagesup = "";
    public static String messagelister = "";

    public static String EnregistrerFournisseur(String numerofournisseur, String nom, String adresse, String dateajout) throws RemoteException {
        String mesage = "";
        int rep = 0;
        int code = 0;
        String nomt = "codeautomatiquefournisseur";
        String nomc = "codefournisseur";

        four = new Fournisseur(numerofournisseur, nom, adresse, dateajout);
        try {
            code = recherchercode(nomt);
            numerofournisseur = "BL-FOU-" + code + "" + Code;
            // con.close();
            con = DriverManager.getConnection(chaine);

            st = con.createStatement();
            rep = st.executeUpdate("insert into Fournisseur(numerofournisseur,nom,adresse,dateajout) values('" + numerofournisseur + "','" + four.getNom() + "','" + four.getAdresse() + "','" + four.getDateajout() + "')");

            // rep = pr.executeUpdate();

            if (rep != 0) {
                con.close();
                requetemodifiercode(nomt, nomc, code);
                //con.close();
                mesage = numerofournisseur;
            } else {
                mesage = "Enregistrement non reussi";
            }
            //val=true;
        } catch (SQLException e) {
            mesage = "SQLException: " + e.getMessage() + "\nSQLState: " + e.getSQLState() + "\nVendorError: " + e.getErrorCode();

        }


        return mesage;

    }

    public static Fournisseur RechercherFournisseurParNumero(String numero) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select numerofournisseur,nom,adresse,dateajout from Fournisseur where numerofournisseur=?  or nom=?");
            pr.setString(1, numero);
            pr.setString(2, numero);
            rs = pr.executeQuery();
            while (rs.next()) {
                four = new Fournisseur(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println("SQLExceptionfou: " + e.getMessage());
            System.out.println("SQLStatefou: " + e.getSQLState());
            System.out.println("VendorErrorfou: " + e.getErrorCode());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("SQLException: " + e.getMessage());
            }
            return four;
        }
    }

    public static Fournisseur RechercherFournisseurParNom(String nom) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select numerofournisseur,nom,adresse,dateajout from Fournisseur where nom=? ");
            pr.setString(1, nom);
            rs = pr.executeQuery();
            while (rs.next()) {
                four = new Fournisseur(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println("SQLExceptionfou: " + e.getMessage());
            System.out.println("SQLStatefou: " + e.getSQLState());
            System.out.println("VendorErrorfou: " + e.getErrorCode());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("SQLException: " + e.getMessage());
            }
            return four;
        }
    }

    public static String ModifierFournisseur(String numerofournisseur, String nom, String adresse, String dateajout) {
        String message = "";
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("update  Fournisseur set nom ='" + nom + "' ,adresse ='" + adresse + "'  ,dateajout ='" + dateajout + "'  where numerofournisseur='" + numerofournisseur + "'");
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

    public static String SupprimerFournisseur(String numero) {
        int rep = 0;
        //  boolean val=false;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("delete from Fournisseur where numerofournisseur='" + numero + "'");
            if (rep != 0) {
                messagesup = "Le fournisseur :  '" + four.getNom() + "'  a ete supprimee avec succes.";
            } else {
                messagesup = "La suppression du fournisseur:  '" + four.getNom() + "'  est echouee.";
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return messagesup;
    }

    public static Object[][] ListerFournisseur() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            pr = con.prepareStatement("select f.numerofournisseur,f.nom,f.adresse,t.telephone,t.telephone1,t.telephone2,e.email,e.email1,e.email2 from Fournisseur f,TelephoneFournisseur t,EmailFournisseur e where f.numerofournisseur=t.numero and f.numerofournisseur=e.numero");

            rs = pr.executeQuery();
            // taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin 
            data = new Object[nn][9];
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getString(4);
                data[i][4] = rs.getString(5);
                data[i][5] = rs.getString(6);
                data[i][6] = rs.getString(7);
                data[i][7] = rs.getString(8);
                data[i][8] = rs.getString(9);

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

    public static Object[][] ChargerFournisseur() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            pr = con.prepareStatement("select numerofournisseur,nom from Fournisseur");

            rs = pr.executeQuery();
            //taille du tableau retourné.
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
