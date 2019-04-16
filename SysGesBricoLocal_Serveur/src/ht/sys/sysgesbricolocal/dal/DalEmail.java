/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.dal;

import ht.sys.sysgesbricolocal.domaine.Email;
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
public class DalEmail extends Service {

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement pr = null;
    private static Email tel = null;
    public static String mesaj1 = "";
    public static String messagesup = "";
    public static String messagelister = "";

    public static String EnregistrerEmailFournisseur(String numero, String email, String email1, String email2) {
        String mesage = "";
        int repenreg = 0;

        tel = new Email(numero, email, email1, email2);
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            repenreg = st.executeUpdate("insert into EmailFournisseur(numero,email,email1,email2) values('" + tel.getNumero() + "','" + tel.getEmail() + "','" + tel.getEmail1() + "','" + tel.getEmail2() + "')");
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

    public static String EnregistrerEmailEmploye(String numero, String email, String email1, String email2) {
        String mesage = "";
        int repenreg = 0;
        tel = new Email(numero, email, email1, email2);
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();


            repenreg = st.executeUpdate("insert into EmailEmploye(numero,email,email1,email2) values('" + tel.getNumero() + "','" + tel.getEmail() + "','" + tel.getEmail1() + "','" + tel.getEmail2() + "')");
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

    public static String EnregistrerEmailClients(String numero, String email, String email1, String email2) {
        String mesage = "";
        int repenreg = 0;
        tel = new Email(numero, email, email1, email2);
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            repenreg = st.executeUpdate("insert into EmailEmploye(numero,email,email1,email2) values('" + tel.getNumero() + "','" + tel.getEmail() + "','" + tel.getEmail1() + "','" + tel.getEmail2() + "')");
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

    public static Email RechercherEmailFournisseur(String numero) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select numero,email,email1,email2 from EmailFournisseur where numero=?");
            pr.setString(1, numero);
            rs = pr.executeQuery();
            while (rs.next()) {
                tel = new Email(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
            return tel;
        }
    }

    public static Email RechercherEmailEmploye(String numero) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select numero,email,email1,email2 from EmailEmploye where numero=?");
            pr.setString(1, numero);
            rs = pr.executeQuery();
            while (rs.next()) {
                tel = new Email(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
            return tel;
        }
    }

    public static Email RechercherEmailClients(String numero) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select numero,email,email1,email2 from EmailClients where numero=?");
            pr.setString(1, numero);
            rs = pr.executeQuery();
            while (rs.next()) {
                tel = new Email(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
            return tel;
        }
    }

    public static String ModifierEmailFournisseur(String numero, String email, String email1, String email2) {
        String message = "";
        int rep = 0;

        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            st.executeUpdate("update  EmailFournisseur set email ='" + email + "',email1 ='" + email1 + "',email2 ='" + email2 + "' where numero='" + numero + "'");

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

    public static String ModifierEmailEmploye(String numero, String email, String email1, String email2) {
        String message = "";
        int rep = 0;

        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            st.executeUpdate("update  EmailEmploye set email ='" + email + "',email1 ='" + email1 + "',email2 ='" + email2 + "' where numero='" + numero + "'");

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

    public static String ModifierEmailClients(String numero, String email, String email1, String email2) {
        String message = "";
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            st.executeUpdate("update  EmailClients set email ='" + email + "',email1 ='" + email1 + "',email2 ='" + email2 + "' where numero='" + numero + "'");

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

    public static String SupprimerEmailFournisseur(String numero) {
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("delete from EmailFournisseur where numero='" + numero + "'");
            if (rep != 0) {
                messagesup = "La categorie numero:  '" + tel.getNumero() + "'  a ete supprimee avec succes.";
            } else {
                messagesup = "La suppression de la categorie numero:  '" + tel.getNumero() + "'  est echouee.";
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return messagesup;
    }

    public static String SupprimerEmailEmploye(String numero) {
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("delete from EmailEmploye where numero='" + numero + "'");
            if (rep != 0) {
                messagesup = "La categorie numero:  '" + tel.getNumero() + "'  a ete supprimee avec succes.";
            } else {
                messagesup = "La suppression de la categorie numero:  '" + tel.getNumero() + "'  est echouee.";
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return messagesup;
    }

    public static String SupprimerEmailClients(String numero) {
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("delete from EmailClients where numero='" + numero + "'");
            if (rep != 0) {
                messagesup = "La categorie numero:  '" + tel.getNumero() + "'  a ete supprimee avec succes.";
            } else {
                messagesup = "La suppression de la categorie numero:  '" + tel.getNumero() + "'  est echouee.";
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return messagesup;
    }
}
