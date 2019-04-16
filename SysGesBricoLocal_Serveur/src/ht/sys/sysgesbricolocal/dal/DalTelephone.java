/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.dal;

import ht.sys.sysgesbricolocal.domaine.Telephone;
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
public class DalTelephone extends Service {

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement pr = null;
    private static Telephone tel = null;
    public static String mesaj1 = "";
    public static String messagesup = "";
    public static String messagelister = "";

    public static String EnregistrerTelephoneFournisseur(String numero, String telephone, String telephone1, String telephone2) {
        String mesage = "";
        int repenreg = 0;
             tel = new Telephone(numero, telephone, telephone1, telephone2);
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            repenreg = st.executeUpdate("insert into TelephoneFournisseur(numero,telephone,telephone1,telephone2) values('" + tel.getNumero() + "','" + tel.getTelephone() + "','" + tel.getTelephone1() + "','" + tel.getTelephone2() + "')");
            if (repenreg != 0) {
                mesage = "Enregistrement reussi";
            } else {
                mesage = "Enregistrement non reussi";
            }

        } catch (SQLException e) {
             mesage ="SQLException: " + e.getMessage()+" SQLState: " + e.getSQLState()+"VendorError: " + e.getErrorCode();
         }
        return mesage;

    }

    public static String EnregistrerTelephoneEmploye(String numero, String telephone, String telephone1, String telephone2) {
        String mesage = "";
        int repenreg = 0;
         tel = new Telephone(numero, telephone, telephone1, telephone2);
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            repenreg = st.executeUpdate("insert into TelephoneEmploye(numero,telephone,telephone1,telephone2) values('" + tel.getNumero() + "','" + tel.getTelephone() + "','" + tel.getTelephone1() + "','" + tel.getTelephone2() + "')");
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

    public static String EnregistrerTelephoneClients(String numero, String telephone, String telephone1, String telephone2) {
        String mesage = "";
        int repenreg = 0;
         tel = new Telephone(numero, telephone, telephone1, telephone2);
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
             repenreg = st.executeUpdate("insert into TelephoneEmploye(numero,telephone,telephone1,telephone2) values('" + tel.getNumero() + "','" + tel.getTelephone() + "','" + tel.getTelephone1() + "','" + tel.getTelephone2() + "')");
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

    public static Telephone RechercherTelephoneFournisseur(String numero) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select numero,telephone,telephone1,telephone2 from TelephoneFournisseur where numero=?");
            pr.setString(1, numero);
            rs = pr.executeQuery();
            while (rs.next()) {
                tel = new Telephone(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
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

    public static Telephone RechercherTelephoneEmploye(String numero) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select numero,telephone,telephone1,telephone2 from TelephoneEmploye where numero=?");
            pr.setString(1, numero);
            rs = pr.executeQuery();
            while (rs.next()) {
                tel = new Telephone(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
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

    public static Telephone RechercherTelephoneClients(String numero) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select numero,telephone,telephone1,telephone2 from TelephoneClients where numero=?");
            pr.setString(1, numero);
            rs = pr.executeQuery();
            while (rs.next()) {
                tel = new Telephone(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
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

    public static String ModifierTelephoneFournisseur(String numero, String telephone, String telephone1, String telephone2) {
        String message = "";
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            st.executeUpdate("update  TelephoneFournisseur set telephone ='" + telephone + "',telephone1 ='" + telephone1 + "',telephone2 ='" + telephone2 + "' where numero='" + numero + "'");

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

    public static String ModifierTelephoneEmploye(String numero, String telephone, String telephone1, String telephone2) {
        String message = "";
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            st.executeUpdate("update  TelephoneEmploye set telephone ='" + telephone + "',telephone1 ='" + telephone1 + "',telephone2 ='" + telephone2 + "' where numero='" + numero + "'");
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

    public static String ModifierTelephoneClients(String numero, String telephone, String telephone1, String telephone2) {
        String message = "";
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            st.executeUpdate("update  TelephoneClients set telephone ='" + telephone + "',telephone1 ='" + telephone1 + "',telephone2 ='" + telephone2 + "' where numero='" + numero + "'");
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

    public static String SupprimerTelephoneFournisseur(String numero) {
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("delete from TelephoneFournisseur where numero='" + numero + "'");
             if (rep != 0) {
                messagesup = "Suppression reussie";
            } else {
                messagesup = "Suppression echouee.";
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return messagesup;
    }

    public static String SupprimerTelephoneEmploye(String numero) {
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("delete from TelephoneEmploye where numero='" + numero + "'");
            if (rep != 0) {
                messagesup = "Suppression reussie";
            } else {
                messagesup = "Suppression echouee.";
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return messagesup;
    }

    public static String SupprimerTelephoneClients(String numero) {
        int rep = 0;
        //  boolean val=false;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            rep = st.executeUpdate("delete from TelephoneClients where numero='" + numero + "'");
             if (rep != 0) {
                messagesup = "Suppression reussie";
            } else {
                messagesup = "Suppression echouee.";
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return messagesup;
    }
}
