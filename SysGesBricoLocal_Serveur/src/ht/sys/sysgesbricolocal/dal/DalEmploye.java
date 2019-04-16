/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.dal;

import ht.sys.sysgesbricolocal.domaine.Employe;
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
public class DalEmploye extends Service {

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement pr = null;
    private static PreparedStatement pr1 = null;
    private static Employe emp = null;
    public static String mesaj = "";
    public static String mesaj1 = "";

    public static String EnregistrerEmploye(String numeroemploye, String nom, String prenom, String sexe, String nif, String datenaissance, String adresse, String dateembauche, String numerodepartement, String fonction) {
        String mesage = "";
        String nomt = "codeautomatiqueemploye";
        String nomc = "codeemploye";
        int code = 0;

        int rep = 0;
        //boolean val=false;
        emp = new Employe(numeroemploye, nom, prenom, sexe, nif, datenaissance, adresse, dateembauche, numerodepartement, fonction);
        //   numeroemploye="BL-Emp"+Code;
        try {
            code = recherchercode(nomt);
            numeroemploye = "BL-EMP-" + code + "" + Code;
            con.close();
            //111111111111111111111111111111111111111111111111111111
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();

            rep = st.executeUpdate("insert into Employe(numeroemploye,nom,prenom,sexe,nif,datenaissance,adresse,dateembauche,numerodepartement,fonction ) values('" + numeroemploye + "','" + emp.getNom() + "','" + emp.getPrenom() + "','" + emp.getSexe() + "','" + emp.getNif() + "','" + emp.getDatenaissance() + "','" + emp.getAdresse() + "','" + emp.getDateembauche() + "','" + emp.getNumerodepartement() + "','" + emp.getFonction() + "')");


            if (rep != 0) {
                mesage = numeroemploye;
                con.close();
                requetemodifiercode(nomt, nomc, code);
                con.close();

                //22222222222222222222222222222222222222222222222222222222
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

    public static Object[][] RechercherEmploye(String emp) {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select  emp.numeroemploye,emp.nom,emp.prenom,emp.sexe,emp.nif,emp.datenaissance,emp.adresse,emp.dateembauche,emp.numerodepartement,emp.fonction,em.email,em.email1,tel.telephone,tel.telephone1 from Employe emp,emailemploye em,telephoneemploye tel where emp.numeroemploye=em.numero and em.numero=tel.numero and (emp.numeroemploye=? or emp.nom=? or emp.prenom=? or tel.telephone=? or tel.telephone1=?)");
            pr.setString(1, emp);
            pr.setString(2, emp);
            pr.setString(3, emp);
            pr.setString(4, emp);
            pr.setString(5, emp);
            rs = pr.executeQuery();
            //technique pour touver dynamiquement la taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
            data = new Object[nn][12];
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
                data[i][9] = rs.getString(10);
                data[i][10] = rs.getString(11);
                data[i][11] = rs.getString(12);
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

    public static Object[][] RechercherEmployeUtil(String numero) {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            pr = con.prepareStatement("select emp.numeroemploye,emp.nom,emp.prenom,dep.Departement,emp.fonction from employe emp,departement dep where emp.numerodepartement=dep.numerodepartement and (numeroemploye='" + numero + "'or nom ='" + numero + "')");
            //pr=con.prepareStatement("select * from employe");

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

    public static Object[][] ListerEmploye() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            pr = con.prepareStatement("select  emp.numeroemploye,emp.nom,emp.prenom,emp.sexe,emp.nif,emp.datenaissance,emp.adresse,emp.dateembauche,emp.numerodepartement,emp.fonction,em.email,em.email1,tel.telephone,tel.telephone1,salaire from Employe emp,emailemploye em,telephoneemploye tel ,salaireemploye sal where emp.numeroemploye=em.numero and em.numero=tel.numero and emp.numeroemploye=sal.numeroemploye");
            //pr=con.prepareStatement("select * from employe");

            rs = pr.executeQuery();
            //technique pour touver dynamiquement la taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
            data = new Object[nn][14];
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
                data[i][9] = rs.getString(10);
                data[i][10] = rs.getString(11);
                data[i][11] = rs.getString(12);
                data[i][12] = rs.getString(13);
                data[i][13] = rs.getString(14);
                data[i][14] = rs.getString(15);
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

    public static Employe RechercherEmployeModifier(String co) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select numeroemploye,nom,prenom,sexe,nif,datenaissance,adresse,dateembauche,numerodepartement,fonction from employe where numeroemploye=?");

            pr.setString(1, co);
            rs = pr.executeQuery();
            while (rs.next()) {
                emp = new Employe(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
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
            return emp;
        }
    }

    public static String ModifierEmploye(String numeroemploye, String nom, String prenom, String sexe, String nif, String datenaissance, String adresse, String dateembauche, String numerodepartement, String fonction) {

        String message = "";
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            //
            rep = st.executeUpdate("update  Employe set nom='" + nom + "',prenom='" + prenom + "',sexe='" + sexe + "',nif='" + nif + "',datenaissance='" + datenaissance + "',adresse='" + adresse + "',dateembauche='" + dateembauche + "',numerodepartement='" + numerodepartement + "',fonction='" + fonction + "' where numeroemploye='" + numeroemploye + "'");

            if (rep != 0) {
                message = "Modification reussie";
            } else {
                message = "Modification echouee";
            }
        } catch (SQLException e) {
            System.out.println("SQLException: Emp " + e.getMessage());
            System.out.println("SQLState: Emp" + e.getSQLState());
            System.out.println("VendorError: Emp" + e.getErrorCode());
        }
        return message;
    }

    public static Object[][] ChargerNumeroEmploye() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select numeroemploye from employe");

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
