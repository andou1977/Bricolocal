/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.dal;

import ht.sys.sysgesbricolocal.domaine.Achat;
import ht.sys.sysgesbricolocal.domaine.Vente;

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
public class DalVente extends Service {

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement pr = null;
    private static PreparedStatement pr1 = null;
    private static Vente vent = null;
    public static String mesaj = "";
    public static String mesaj1 = "";

    public static String CodeVente() {
        // lister trace systeme par date,heure,nom utilisateur,role
        int code = 0;
        String nomt = "codeautomatiquevente";
        String nomc = "codevente";
        code = recherchercode(nomt);
        String codevente = "BL-VEN-" + code + "" + Code;

        requetemodifiercode(nomt, nomc, code);
        return codevente;
    }

    public static String EnregistrerVente(String numerovente, String numeroarticle, String numeroClients, int quantite, float montant, String datevente, String nomutilisateur) {
        String mesage = "";
        int rep = 0;
        vent = new Vente(numerovente, numeroarticle, numeroClients, quantite, montant, dateJ, nomutilisateur);
        try {
       
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();

            rep = st.executeUpdate("insert into Vente(numerovente,numeroarticle,numeroClients,quantite, montant,datevente,nomutilisateur) values('" + numerovente + "','" + vent.getNumeroarticle() + "','" + vent.getNumeroClients() + "','" + vent.getQuantite() + "','" + vent.getMontant() + "','" + vent.getDatevente() + "','" + vent.getNomutilisateur() + "')");
            //`numerovente`,  `numeroarticle`,  `numeroClients`,  `nomrepresentant`,  `matriculerepresentant`,  `quantite`,  `datevente`,  `typevente`


            if (rep != 0) {
                mesage = "code vente: " + numerovente;
                con.close();

            } else {
                mesage = "Vente non effectue";
            }
            //val=true;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return mesage;
    }

    public static Object[][] Recherchervente(String co) {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select  cl.nom,a.libelle,a.categorie,a.prixarticle,v.quantite,v.datevente,v.nomutilisateur from vente v,Article a,Clients cl where cl.numeroClients=v.numeroClients and v.numeroarticle=a.numeroarticle and a.numeroarticle=?");
            //numerovente`,  `numeroarticle`,  `numeroClients`,  `nomrepresentant`,  `matriculerepresentant`,  `quantite`,  `datevente`,  `typevente
            pr.setString(1, co);
            rs = pr.executeQuery();
            // taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin 
            data = new Object[nn][8];
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

    public static Object[][] RechercherventeParDate(String datevente) {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select  cl.nom,a.libelle,a.categorie,a.prixarticle,v.quantite,v.datevente,v.typevente from vente v,Article a,Clients cl where cl.numeroClients=v.numeroClients and v.numeroarticle=a.numeroarticle and v.datevente=?");
            //numerovente`,  `numeroarticle`,  `numeroClients`,  `nomrepresentant`,  `matriculerepresentant`,  `quantite`,  `datevente`,  `typevente
            pr.setString(1, datevente);
            rs = pr.executeQuery();
            //taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin 
            data = new Object[nn][8];
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

    public static Vente RechercherVenteModifier(String numero) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select   numerovente,  numeroarticle,  numeroClients,  nomrepresentant,  matriculerepresentant,quantite,datevente, typevente from Vente  where numerovente=? ");
            //numerovente`,  `numeroarticle`,  `numeroClients`,  `nomrepresentant`,  `matriculerepresentant`,  `quantite`,  `datevente`,  `typevente
            pr.setString(1, numero);
            rs = pr.executeQuery();
            while (rs.next()) {
                vent = new Vente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(6), rs.getFloat(7), rs.getString(8), rs.getString(9));
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
            return vent;
        }
    }

    public static Object[][] ListerVente() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            rs = st.executeQuery("select  cl.nom,cl.telephone,a.libelle,v.quantite,v.montant,v.numerovente,v.datevente,v.nomutilisateur from vente v,Article a,Clients cl where cl.numeroClients=v.numeroClients and v.numeroarticle=a.numeroarticle ");
            //`numerovente`,  `numeroarticle`,  `numeroClients`,  `nomrepresentant`,  `matriculerepresentant`,  `quantite`,  `datevente`,  `typevente`
            //taille du tableau retourné.  "Client", "telephone", "Article", "Quantite", "Montant", "Code_Vente", "date_Vente","Vendeur"
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin 
            data = new Object[nn][8];
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getInt(4);
                data[i][4] = rs.getFloat(5);
                data[i][5] = rs.getString(6);
                data[i][6] = rs.getString(7);
                data[i][7] = rs.getString(8);
                

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

    
    public static Object[][] RechercherVenteIndice(String co) {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            pr = con.prepareStatement("select  cl.nom,cl.telephone,a.libelle,v.quantite,v.montant,v.numerovente,v.datevente,v.nomutilisateur from vente v,Article a,Clients cl where cl.numeroClients=v.numeroClients and v.numeroarticle=a.numeroarticle and(nomutilisateur=? or datevente=? or numerovente=?)");
            pr.setString(1, co);
            pr.setString(2, co);
            pr.setString(3, co);
            rs = pr.executeQuery();
            //`numerovente`,  `numeroarticle`,  `numeroClients`,  `nomrepresentant`,  `matriculerepresentant`,  `quantite`,  `datevente`,  `typevente`
            //taille du tableau retourné.  "Client", "telephone", "Article", "Quantite", "Montant", "Code_Vente", "date_Vente","Vendeur"
           
//            pr = con.prepareStatement("select  cl.nom,a.libelle,a.categorie,a.prixarticle,v.quantite,v.datevente,v.nomutilisateur from vente v,Article a,Clients cl where cl.numeroClients=v.numeroClients and v.numeroarticle=a.numeroarticle and a.numeroarticle=?");
//            //numerovente`,  `numeroarticle`,  `numeroClients`,  `nomrepresentant`,  `matriculerepresentant`,  `quantite`,  `datevente`,  `typevente
//            pr.setString(1, co);
//            rs = pr.executeQuery();
            
            
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin 
            data = new Object[nn][8];
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getInt(4);
                data[i][4] = rs.getFloat(5);
                data[i][5] = rs.getString(6);
                data[i][6] = rs.getString(7);
                data[i][7] = rs.getString(8);
                

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
    
    public static String ModifierVente(String numerovente, String numeroarticle, String numeroClients, int quantite, String datevente, String nomutilisateur) {

        String message = "";
        int mod = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            mod = st.executeUpdate("update  Vente set quantite='" + quantite + "',datevente='" + datevente + "' where numerovente='" + numerovente + "'");
            if (mod != 0) {
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

    public static Vente RechercherCodeVente() {
        int code = 0;
        String nomt = "codeautomatiquevente";
        String nomc = "codevente";
        int rep = 0;
        //try {
        code = recherchercode(nomt);
        if (code != 0) {
            vent.setNumerovente("BL-VEN-" + code + "" + Code);

            requetemodifiercode(nomt, nomc, code);
        }
        return vent;
    }

    public static Object[][] ChargerNomVendeur() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select distinct(nomutilisateur) from vente");
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

    public static Object[][] ChargerDateVente() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select distinct(datevente) from vente");
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

    public static Object[][] ChargerNumeroVente() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select distinct(numerovente) from vente");
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
