/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.dal;

import ht.sys.sysgesbricolocal.domaine.Article;
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
 * @author Rose
 */
public class DalArticle extends Service {

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement pr = null;
    private static PreparedStatement pr1 = null;
    private static Article art = null;
    private static Stock stk = null;
    public static String mesaj = "";
    public static String mesaj1 = "";

    public static String EnregistrerArticle(String numerofournisseur, String numeroarticle, String libelle, String categorie, Float prixarticle) {
        String mesage = "";

        int rep = 0;
        int code = 0;
        String nomt = "codeautomatiqueartitcle";
        String nomc = "codearticle";

        art = new Article(numerofournisseur, numeroarticle, libelle, categorie, prixarticle);
        try {
            code = recherchercode(nomt);
            numeroarticle = "BL-ART-" + code + "" + Code;
            //con.close();

            con = DriverManager.getConnection(chaine);
            //`numerofournisseur`,  `numeroarticle`,  `libelle`,  `categorie`,  `prixarticle`
            st = con.createStatement();
            rep = st.executeUpdate("insert into Article(numerofournisseur,numeroarticle,libelle,categorie,prixarticle) values('" + art.getNumerofournisseur() + "','" + numeroarticle + "','" + art.getLibelle() + "','" + art.getCategorie() + "','" + art.getPrixarticle() + "')");

            if (rep != 0) {
                con.close();
                requetemodifiercode(nomt, nomc, code);
                //con.close();
                mesage = numeroarticle;
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

    public static Object[][] RechercherArticle(String co) {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select  a.numeroarticle,a.libelle,a.categorie,a.prixarticle,s.quantite,s.dateajout,f.nom from Article a,Fournisseur f,Stock s where f.numerofournisseur=a.numerofournisseur and a.numeroarticle=s.numeroarticle and (a.libelle=? or s.dateajout=?)");
            pr.setString(1, co);
            pr.setString(2, co);
            rs = pr.executeQuery();
            //technique pour touver dynamiquement la taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
            data = new Object[nn][7];
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getFloat(4);
                data[i][4] = rs.getInt(5);
                data[i][5] = rs.getString(6);
                data[i][6] = rs.getString(7);

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

    public static Object[][] ChargerLibelleArticle() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select distinct(a.libelle),s.dateajout,a.numeroarticle from Article a,Stock s where a.numeroarticle=s.numeroarticle ");

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

    public static Object[][] ListerArticle() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            rs = st.executeQuery("select a.numeroarticle,a.libelle,a.categorie,a.prixarticle,s.quantite,s.dateajout from Article a,Stock s where  a.numeroarticle=s.numeroarticle");
            //technique pour touver dynamiquement la taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
            data = new Object[nn][6];
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getFloat(4);
                data[i][4] = rs.getInt(5);
                data[i][5] = rs.getString(6);

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

    public static Article RechercherArticleModifier(String co) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select numerofournisseur,numeroarticle,libelle,categorie,prixarticle from Article where (numeroarticle=? or libelle=?)");
            pr.setString(1, co);
            pr.setString(2, co);
            rs = pr.executeQuery();
            while (rs.next()) {
                art = new Article(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5));

            }
        } catch (SQLException e) {
            System.out.println("SQLException ART: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("SQLException: " + e.getMessage());
            }
            return art;
        }
    }

    public static String ModifierArticle(String numerofournisseur, String code, String libelle, String categorie, Float prix) {
        String message = "";
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("update  Article set numerofournisseur='" + numerofournisseur + "',categorie='" + categorie + "',libelle='" + libelle + "',prixarticle='" + prix + "' where numeroarticle='" + code + "'");
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
    
    public static Object[][] ChargerNomArticle() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select libelle from article ar,stock st where ar.numeroarticle=st.numeroarticle and st.quantite>0 ORDER BY libelle ");
            rs = pr.executeQuery();
            //technique pour touver dynamiquement la taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
            data = new Object[nn][1];
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                i++;
                long totalTime = System.currentTimeMillis() - start;

                //mesaj="La listage a ete executee en " + totalTime + " millisecondes et a retourne " + nn + " ligne(s)";
            }
        } catch (SQLException e) {
            System.out.println("Num emp SQLException: " + e.getMessage());
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
