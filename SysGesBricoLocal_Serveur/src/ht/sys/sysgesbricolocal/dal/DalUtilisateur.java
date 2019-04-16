/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.dal;

import ht.sys.sysgesbricolocal.domaine.Email;
import ht.sys.sysgesbricolocal.domaine.Telephone;
import ht.sys.sysgesbricolocal.domaine.Utilisateur;
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
public class DalUtilisateur extends Service {

    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement pr = null;
    private static PreparedStatement pr1 = null;
    private static Utilisateur uti = null;
    private static Email em = null;
    private static Telephone tel = null;
    public static String mesaj = "";
    public static String mesaj1 = "";

    public static String EnregistrerUtilisateur(String numeroemploye, String nomutilisateur, String motdepasse, String etatutilisateur, String role) {
        String mesage = "";
        int rep = 0;
        uti = new Utilisateur(numeroemploye, nomutilisateur, motdepasse, etatutilisateur, role);
        //boolean val=false;
        try {
            con = DriverManager.getConnection(chaine);

            pr = con.prepareStatement("insert into Utilisateur(numeroemploye,nomutilisateur,motdepasse,etatutilisateur,role,etatconnexion ) values('" + uti.getNumeroemploye() + "','" + uti.getNomutilisateur() + "','" + uti.getMotdepasse() + "','" + uti.getEtatutilisateur() + "','" + uti.getRole() + "','')");

            rep = pr.executeUpdate();

            if (rep != 0) {
                mesage = "Utilisateur :  '" + uti.getNomutilisateur() + "'  a ete ajoute avec succes.";
            } else {
                mesage = "Enregistrement non reussi";
            }
            //val=true;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            mesage = "SQLException: " + e.getMessage() + "\n SQLState: " + e.getSQLState() + "\n VendorError: " + e.getErrorCode();
        }
        return mesage;
    }

    public static Utilisateur RechercherUtilisateur(String nomutilisateur) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            // pr = con.prepareStatement("select numeroemploye, nomutilisateur,etatutilisateur,etatconnexion,nommachine,adressemachine,role,motdepasse from Utilisateur where nomutilisateur=?");
           pr = con.prepareStatement("select * from Utilisateur where nomutilisateur=?");
            pr.setString(1, nomutilisateur);
            rs = pr.executeQuery();
            while (rs.next()) {
                //uti = new Utilisateur(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                uti = new Utilisateur(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
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
            return uti;
        }
    }

    public static Utilisateur RechercherMotdePasseUtilisateur(String nomutilisateur, String motdepasse) {
        try {
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select nomutilisateur,motdepasse from Utilisateur where nomutilisateur=? and motdepasse=?");
            pr.setString(1, nomutilisateur);
            pr.setString(2, motdepasse);
            rs = pr.executeQuery();
            while (rs.next()) {
                uti = new Utilisateur(rs.getString(1), rs.getString(2));

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
            return uti;
        }
    }

    public static String ModifierMotDEPasseUtilisateur(String nomutilisateur, String motdepasse) {
        String message = "";
        int rep = 0;

        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            //
            rep = st.executeUpdate("update  Utilisateur set motdepasse='" + motdepasse + "' where nomutilisateur='" + nomutilisateur + "'");

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

    public static Object[][] ListerUtilisateur() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            pr = con.prepareStatement("select distinct(uti.nomutilisateur),emp.nom,emp.prenom,em.email,em.email1,tel.telephone,tel.telephone1 from Utilisateur uti,Employe emp,EmailEmploye em,TelephoneEmploye tel where em.numero=tel.numero and emp.numeroemploye=uti.numeroemploye ");
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
                data[i][3] = rs.getString(4);
                data[i][4] = rs.getString(5);
                data[i][5] = rs.getString(6);
                data[i][6] = rs.getString(7);
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

    public static Object[][] ListerUtilisateur1() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            pr = con.prepareStatement("select nomutilisateur,etatutilisateur,etatconnexion,nommachine,adressemachine,role from Utilisateur");

            rs = pr.executeQuery();
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
                data[i][3] = rs.getString(4);
                data[i][4] = rs.getString(5);
                data[i][5] = rs.getString(6);
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

    public static Object[][] ListerUtilisateurParIndice(String indicederecherche) {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            pr = con.prepareStatement("select distinct(uti.nomutilisateur),emp.nom,emp.prenom,em.email,em.email1,tel.telephone,tel.telephone1 from Utilisateur uti,Employe emp,EmailEmploye em,TelephoneEmploye tel where em.numero=tel.numero and emp.numeroemploye=uti.numeroemploye and (uti.nomutilisateur=? or uti.etatutilisateur=? or uti.etatconnexion=? or uti.role=?)");
             pr.setString(1, indicederecherche);
            pr.setString(2, indicederecherche);
            pr.setString(3, indicederecherche);
            pr.setString(4, indicederecherche);
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
                data[i][3] = rs.getString(4);
                data[i][4] = rs.getString(5);
                data[i][5] = rs.getString(6);
                data[i][6] = rs.getString(7);
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

    public static Object[][] ListerUtilisateurParIndice1(String indicederecherche) {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            pr = con.prepareStatement("select nomutilisateur,etatutilisateur,etatconnexion,nommachine,adressemachine,role from Utilisateur where  nomutilisateur=? or  etatutilisateur=? or  etatconnexion=? or role=?");
            pr.setString(1, indicederecherche);
            pr.setString(2, indicederecherche);
            pr.setString(3, indicederecherche);
            pr.setString(4, indicederecherche);
            rs = pr.executeQuery();
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
                data[i][3] = rs.getString(4);
                data[i][4] = rs.getString(5);
                data[i][5] = rs.getString(6);
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

    public static String ModifierEtatUtilisateur(String nomutilisateur, String etatutilisateur) {
        String message = "";
        int rep = 0;
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            //
            rep = st.executeUpdate("update  Utilisateur set etatutilisateur='" + etatutilisateur + "' where nomutilisateur='" + nomutilisateur + "'");

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

    public static String ModifierEtatConnexion(String nomutilisateur, String etatconnexion, String nommachine, String adressemachine) {
        String message = "";
        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            //
            st.executeUpdate("update  Utilisateur set etatconnexion='" + etatconnexion + "',nommachine='" + nommachine + "',adressemachine='" + adressemachine + "' where nomutilisateur='" + nomutilisateur + "'");


        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return message;
    }

    public static Object[][] ChargerNomUtilisateur() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select nomutilisateur from utilisateur");
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

    public static String ModifierUtilisateur(String numeroemploye, String nomutilisateur, String motdepasse, String role, String etatutilisateur) {
        String message = "";
        int rep = 0;

        try {
            con = DriverManager.getConnection(chaine);
            st = con.createStatement();
            //
            rep = st.executeUpdate("update  Utilisateur set motdepasse='" + motdepasse + "',role='" + role + "',etatutilisateur='" + etatutilisateur + "' where numeroemploye='" + numeroemploye + "'");

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
  
     public static String Tracabilite(String nomutilisateur,String tableaffectee,String action,String numeroentite,String date,String heure,String nommachine,String adressemachine) {
        String mesage = "";
        int rep = 0;
       // uti = new Utilisateur(nomutilisateur, tableaffectee,, nomutilisateur, action, nommachine, adressemachine, Code)
        //boolean val=false;
        try {
            con = DriverManager.getConnection(chaine);

            pr = con.prepareStatement("insert into Historique(nomutilisateur,tableaffectee,action,numeroentite,date,heure,nommachine,adressemachine) values('" + nomutilisateur + "','" + tableaffectee + "','" + action+ "','" + numeroentite + "','" + date + "','" + heure+ "','" + nommachine + "','" + adressemachine + "')");

            rep = pr.executeUpdate();

            if (rep != 0) {
                mesage = "Enregistrement reussi";
            } else {
                mesage = "Enregistrement non reussi";
            }
            //val=true;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            mesage = "SQLException: " + e.getMessage() + "\n SQLState: " + e.getSQLState() + "\n VendorError: " + e.getErrorCode();
        }
        return mesage;
    }

public static Object[][] ListerTracabiliteParIndice(String indicederecherche) {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            pr = con.prepareStatement("select * from Historique where nomutilisateur=? or date=? or action=? or tableaffectee=?");
            pr.setString(1, indicederecherche);
            pr.setString(2, indicederecherche);
            pr.setString(3, indicederecherche);
            pr.setString(4, indicederecherche);
            rs = pr.executeQuery();
          //  nomutilisateur,tableaffectee,action,numeroentite,date,heure,nommachine,adressemachine
            //technique pour touver dynamiquement la taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
            data = new Object[nn][8];
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getString(4);
                data[i][4] = rs.getString(5);
                data[i][5] = rs.getString(6);
                data[i][6] = rs.getString(7);
                data[i][7] = rs.getString(8);
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
      
       public static Object[][] ListerTracee() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            st = con.createStatement();
            pr = con.prepareStatement("select * from Historique ");
            rs = pr.executeQuery();
            //taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
            data = new Object[nn][8];
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getString(4);
                data[i][4] = rs.getString(5);
                data[i][5] = rs.getString(6);
                data[i][6] = rs.getString(7);
                data[i][7] = rs.getString(8);
                i++;
                long totalTime = System.currentTimeMillis() - start;
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
 
     public static Object[][] ChargerNomUtilisateurTracee() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select nomutilisateur from Historique");
            rs = pr.executeQuery();
            //taille du tableau retourné.
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
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
       
        public static Object[][] ChargerTableAffectee() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select tableaffectee from Historique");
            rs = pr.executeQuery();
            rs.last();
            int nn = rs.getRow();
            rs.beforeFirst();
            //fin de la procedure
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
        
        public static Object[][] ChargerDateTracee() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select date from Historique");
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
        
        public static Object[][] ChargerAction() {
        Object[][] data = null;
        try {
            long start = System.currentTimeMillis();
            int i = 0;
            con = (Connection) DriverManager.getConnection(chaine);
            pr = con.prepareStatement("select action from Historique");
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
