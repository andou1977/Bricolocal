/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.dal;

import ht.sys.sysgesbricolocal.domaine.Client;
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
public class DalClients extends Service {

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement pr = null;
    private static Client cli = null;
    public static String mesaj1 = "";
    public static String messagesup = "";
    public static String messagelister = "";

    public static String EnregistrerClient(String numeroClients, String nom, String adresse, String telephone, String emai) {
        String mesage = "";

        int rep = 0;
        //boolean val=false;
        int code = 0;
        String nomt = "codeautomatiquevente";
        String nomc = "codevente";
        cli=new Client(numeroClients, nom, adresse, telephone, emai);
        try {
            code = recherchercode(nomt);
            numeroClients="BL-CLI-"+code+""+Code;
            con = DriverManager.getConnection(chaine);
            st=con.createStatement();

            rep = st.executeUpdate("insert into Clients( numeroClients,nom,adresse,telephone,email) values('" + numeroClients + "','" + cli.getNom() + "','" + cli.getAdresse() + "','" + cli.getTelephone() + "','" + cli.getEmail() + "')");

            
            if (rep != 0) {
                  mesage = numeroClients;
                 con.close();
                requetemodifiercode(nomt, nomc, code);
            } else {
                mesage = "Enregistrement non reussi";
            }
            //val=true;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return mesage;

    }

    public static Client RechercherClient(String numero) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select * from Clients where numeroClients=? or nom=? or telephone=?");
            pr.setString(1, numero);
            pr.setString(2, numero);
            pr.setString(3, numero);
            rs = pr.executeQuery();
            while (rs.next()) {
                cli = new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
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
            return cli;
        }
    }

    public static String ModifierClient(String numeroClients, String nom, String adresse, String telephone, String emai) {
        String message = "";
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("update  Clients set nom ='" + nom + "' ,adresse ='" + adresse + "'  ,telephone ='" + telephone + "',email = '" +emai + "' where numeronumeroClients='" + numeroClients + "'");

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

    public static Object[][] ListerClient() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            pr = con.prepareStatement("select * from Clients");

            rs = pr.executeQuery();
            //technique pour touver dynamiquement la taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
            data = new Object[nn][5];
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getString(4);
                data[i][4] = rs.getString(5);
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