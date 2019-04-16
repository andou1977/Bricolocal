/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.dal;

import ht.sys.sysgesbricolocal.domaine.Achat;
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
public class DalAchat extends Service {

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement pr = null;
    private static PreparedStatement pr1 = null;
    private static Achat acha = null;
    public static String mesaj = "";
    public static String mesaj1 = "";

    public static String EnregistrerAchat(String numeroachat, String numerofournisseur, String description, Float prix, int quantite, Float frais, String dateachat, String dateenregistrement) {
        String message = "";
        int rep = 0;
        //boolean val=false;
        try {
            con = DriverManager.getConnection(chaine);
            //`numerofournisseur`,  `numeroachaticle`,  `libelle`,  `categorie`,  `prixachaticle`
            pr = con.prepareStatement("insert into Achat(numeroemploye,numeroachat,numerofournisseur,description,quantite,prix,frais,dateachat,dateenregistrement) values('" + acha.getNumeroemploye() + "','" + acha.getNumeroachat() + "','" + acha.getNumerofournisseur() + "','" + acha.getDescription() + "','" + acha.getQuantite() + "','" + acha.getPrix() + "','" + acha.getFrais() + "','" + acha.getDateachat() + "','" + dateJ + "')");

            rep = pr.executeUpdate();

            if (rep != 0) {
                message = "L'achaticle numero:  '" + acha.getNumeroachat() + "'  a ete ajoute avec succes.";
            } else {
                message = "Enregistrement non reussi";
            }
            //val=true;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return message;
    }

    public static Object[][] RechercherAchat(String co) {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select  select  a.description,a.categorie,a.prixarticle,a.quantite,a.Frais,a.dateachat,a.dateenregistrement,f.nom,e.nom from Achat a,Fournisseur f,Employe e where f.numerofournisseur=a.numerofournisseur and e.numeroemploye=a.numeroemploye and a.description=?");
            //numeroemploye`,  `numeroachat`,  `numerofournisseur`,  `description`,  `quantite`,  `prix`,  `frais`,  `dateachat`,  `dateenregistrement`
            pr.setString(1, co);
            rs = pr.executeQuery();
            //technique pour touver dynamiquement la taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
            data = new Object[nn][9];
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getFloat(3);
                data[i][3] = rs.getInt(4);
                data[i][4] = rs.getFloat(5);
                data[i][5] = rs.getString(6);
                data[i][6] = rs.getString(7);
                data[i][7] = rs.getString(8);
                data[i][8] = rs.getString(9);
                i++;
                long totalTime = System.currentTimeMillis() - start;

                mesaj = "La listage a ete executee en " + totalTime + " millisecondes et a retourne " + nn + " ligne(s)";
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

    public static Object[][] RechercherAchatParDate(String dateachat) {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select   a.description,a.categorie,a.prixarticle,a.quantite,a.Frais,a.dateachat,a.dateenregistrement,f.nom,e.nom from Achat a,Fournisseur f,Employe e where f.numerofournisseur=a.numerofournisseur and e.numeroemploye=a.numeroemploye and a.dateachat=?");
            //numeroemploye`,  `numeroachat`,  `numerofournisseur`,  `description`,  `quantite`,  `prix`,  `frais`,  `dateachat`,  `dateenregistrement`
            pr.setString(1, dateachat);
            rs = pr.executeQuery();
            //technique pour touver dynamiquement la taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
            data = new Object[nn][9];
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getFloat(3);
                data[i][3] = rs.getInt(4);
                data[i][4] = rs.getFloat(5);
                data[i][5] = rs.getString(6);
                data[i][6] = rs.getString(7);
                data[i][7] = rs.getString(8);
                data[i][8] = rs.getString(9);
                i++;
                long totalTime = System.currentTimeMillis() - start;

//            mesaj="La listage a ete executee en " + totalTime + " millisecondes et a retourne " + nn + " ligne(s)";
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

    public static Object[][] ListerAchat() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            rs = st.executeQuery("select  a.description,a.categorie,a.prixarticle,a.quantite,a.Frais,a.dateachat,a.dateenregistrement,f.nom,e.nom from Achat a,Fournisseur f,Employe e where f.numerofournisseur=a.numerofournisseur and e.numeroemploye=a.numeroemploye");
            //numeroemploye`,  `numeroachat`,  `numerofournisseur`,  `description`,  `quantite`,  `prix`,  `frais`,  `dateachat`,  `dateenregistrement`
            //technique pour touver dynamiquement la taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
            data = new Object[nn][9];
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getFloat(3);
                data[i][3] = rs.getInt(4);
                data[i][4] = rs.getFloat(5);
                data[i][5] = rs.getString(6);
                data[i][6] = rs.getString(7);
                data[i][7] = rs.getString(8);
                data[i][8] = rs.getString(9);
                i++;
                long totalTime = System.currentTimeMillis() - start;

                mesaj = "La listage a ete executee en " + totalTime + " millisecondes et a retourne " + nn + " ligne(s)";
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

    public static Achat RechercherAchatModifier(String numero) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select  f.nom,e.nom,a.description,a.prixarticle,a.quantite,a.frais,a.dateachat,a.dateenregistrement from Achat a,Fournisseur f,Employe e where f.numerofournisseur=a.numerofournisseur and e.numeroemploye=a.numeroemploye and numeroachat=?");
            pr.setString(1, numero);
            rs = pr.executeQuery();
            while (rs.next()) {
                acha = new Achat(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getFloat(6), rs.getString(7), rs.getString(8));
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
            return acha;
        }
    }

    public static String ModifierAchat(String numeroemploye, String numeroachat, String numerofournisseur, String description, int quantite, Float prix, Float frais, String dateachat) {
        String message = "";
        int rep = 0;
        //boolean val=false;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("update  Achat set description='" + description + "',quantite='" + quantite + "',prix='" + prix + "',frais='" + frais + "',dateachat='" + dateachat + "' where numeroachat='" + numeroachat + "'");

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
}
