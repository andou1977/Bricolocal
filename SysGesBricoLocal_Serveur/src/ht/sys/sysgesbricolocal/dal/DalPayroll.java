/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.dal;

import ht.sys.sysgesbricolocal.domaine.Payroll;
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
public class DalPayroll extends Service {

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement pr = null;
    private static PreparedStatement pr1 = null;
    private static Payroll pay = null;
    public static String mesaj = "";
    public static String mesaj1 = "";

    public static String CodePayroll() {
        // lister trace systeme par date,heure,nom utilisateur,role
        int code = 0;
        String nomt = "codeautomatiquepayroll";
        String nomc = "codepayroll";
        code = recherchercode(nomt);
        String codevente = "BL-PAY-" + code + "" + Code;

        requetemodifiercode(nomt, nomc, code);
        return codevente;
    }

    public static String EnregistrerPayroll(String numeropayroll, String numeroemploye, String moispaye, String datepayroll, float taxe, String annee) {
        String mesage = "";

        int rep = 0;
        //boolean val=false;
        pay = new Payroll(numeropayroll, numeroemploye, moispaye, datepayroll, taxe, annee);

        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();

            rep = st.executeUpdate("insert into payroll(numeropayroll, numeroemploye, moispaye, datepayroll, taxe,annee) values('" + numeropayroll + "','" + pay.getNumeroemploye() + "','" + pay.getMoispaye() + "','" + dateJ + "','" + pay.getTaxe() + "','" + pay.getAnnee() + "')");


            if (rep != 0) {
                mesage = numeroemploye;
                con.close();

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

    public static Object[][] PreparerPayroll(String mois) {
        Object[][] data = null;
        float taxe = 0;
        String moi = mois;
        try {

            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select (tca+ona+sante+vie+mort) from prelevement");
            rs = pr.executeQuery();
            while (rs.next()) {
                taxe = rs.getFloat(1);
            }
            con.close();
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select  emp.numeroemploye,emp.nom,emp.prenom,sal.salaire from Employe emp,salaireemploye sal where emp.numeroemploye=sal.numeroemploye");

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
                data[i][4] = ((taxe * rs.getFloat(4)) / 100);
                data[i][5] = (rs.getFloat(4)) - ((taxe * rs.getFloat(4)) / 100);
                data[i][6] = mois;
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

    public static Object[][] ChargerMois() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select distinct(moispaye) from Payroll");
            //moispaye, datepayroll,
            rs = pr.executeQuery();
            // taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin 
            data = new Object[nn][1];
            while (rs.next()) {
                data[i][0] = rs.getString(1);

                i++;
                long totalTime = System.currentTimeMillis() - start;
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

    public static Object[][] ChargerDatePayroll() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select distinct(datepayroll) from Payroll");
            //moispaye, datepayroll,
            rs = pr.executeQuery();
            // taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin 
            data = new Object[nn][1];
            while (rs.next()) {
                data[i][0] = rs.getString(1);

                i++;
                long totalTime = System.currentTimeMillis() - start;
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

    public static Object[][] ListerPayrollParIndice(String ind) {
        Object[][] data = null;
        float taxe = 0;
        // String moi=mois;
        try {

            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select (tca+ona+sante+vie+mort) from prelevement");
            rs = pr.executeQuery();
            while (rs.next()) {
                taxe = rs.getFloat(1);
            }
            con.close();
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select   emp.numeroemploye,emp.nom,emp.prenom,sal.salaire,pay.moispaye,pay.datepayroll from Employe emp,salaireemploye sal,payroll pay where emp.numeroemploye=sal.numeroemploye and emp.numeroemploye=pay.numeroemploye and(moispaye=? or datepayroll=?)");
            pr.setString(1, ind);
            pr.setString(2, ind);
            //pr = con.prepareStatement("select  emp.numeroemploye,emp.nom,emp.prenom,sal.salaire,pay.moispaye,pay.datepayroll from Employe emp,salaireemploye sal,payroll pay where emp.numeroemploye=sal.numeroemploye and emp.numeroemploye=pay.numeroemploye");
            rs = pr.executeQuery();
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
                data[i][4] = ((taxe * rs.getFloat(4)) / 100);
                data[i][5] = (rs.getFloat(4)) - ((taxe * rs.getFloat(4)) / 100);
                data[i][6] = rs.getString(5);
                data[i][7] = rs.getString(6);
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
            return data;
        }
    }

    public static Object[][] ListerPayroll() {
        Object[][] data = null;
        float taxe = 0;
        // String moi=mois;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select (tca+ona+sante+vie+mort) from prelevement");
            rs = pr.executeQuery();
            while (rs.next()) {
                taxe = rs.getFloat(1);
            }
            con.close();
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select  emp.numeroemploye,emp.nom,emp.prenom,sal.salaire,pay.moispaye,pay.datepayroll from Employe emp,salaireemploye sal,payroll pay where emp.numeroemploye=sal.numeroemploye and emp.numeroemploye=pay.numeroemploye");
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
                data[i][4] = ((taxe * rs.getFloat(4)) / 100);
                data[i][5] = (rs.getFloat(4)) - ((taxe * rs.getFloat(4)) / 100);
                data[i][6] = rs.getString(5);
                data[i][7] = rs.getString(6);
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
            return data;
        }
    }

    public static String RechercherPayroll(String mois, String annee) {
        int i = 0;
        String resultat = "";
        String annee1 = "";
        String mois1 = "";
        String date = "";

        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select  distinct(moispaye), datepayroll,annee from Payroll where moispaye=?  and annee=?");
            //numerovente`,  `numeroarticle`,  `numeroClients`,  `nomrepresentant`,  `matriculerepresentant`,  `quantite`,  `datevente`,  `typevente
            pr.setString(1, mois);
            pr.setString(2, annee);
            rs = pr.executeQuery();
            while (rs.next()) {
                mois1 = rs.getString(1);
                annee1 = rs.getString(3);
                date = rs.getString(2);
                i++;
            }
            if (i > 0) {
                resultat = "On a deja effectue le payroll pour le mois de " + mois + " " + annee + " le " + date;
          } 
            //else {
//                resultat = "";
//            }
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
           
        }
         return resultat;
    }
}
