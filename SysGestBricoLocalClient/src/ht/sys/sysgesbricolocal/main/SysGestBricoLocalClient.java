/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.main;

import ht.sys.sysgesbricolocal.amorce.IAchat;
import ht.sys.sysgesbricolocal.amorce.IArticle;
import ht.sys.sysgesbricolocal.amorce.ICategorie;
import ht.sys.sysgesbricolocal.amorce.IClients;
import ht.sys.sysgesbricolocal.amorce.ICommandeClients;
import ht.sys.sysgesbricolocal.amorce.IDepartement;
import ht.sys.sysgesbricolocal.amorce.IEmail;
import ht.sys.sysgesbricolocal.amorce.IEmploye;
import ht.sys.sysgesbricolocal.amorce.IFonction;
import ht.sys.sysgesbricolocal.amorce.IFournisseur;
import ht.sys.sysgesbricolocal.amorce.IGrilleSalariale;
import ht.sys.sysgesbricolocal.amorce.IPayroll;
import ht.sys.sysgesbricolocal.amorce.IPrelevement;
import ht.sys.sysgesbricolocal.amorce.IProduit;
import ht.sys.sysgesbricolocal.amorce.ISalaireEmploye;
import ht.sys.sysgesbricolocal.amorce.IStock;
import ht.sys.sysgesbricolocal.amorce.ITelephone;
import ht.sys.sysgesbricolocal.amorce.IUtilisateur;
import ht.sys.sysgesbricolocal.amorce.IVente;
import ht.sys.sysgesbricolocal.vue.FrmAdresseServeurApplication;
import ht.sys.sysgesbricolocal.vue.FrmPrincipal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

/**
 *
 * @author scharlyne
 */
public class SysGestBricoLocalClient extends servicetechnique.Service {

    public static IPayroll pay;
    public static IAchat ach;
    public static IArticle art;
    public static ICategorie cat;
    public static IClients cli;
    public static ICommandeClients ccl;
    public static IDepartement dep;
    public static IEmail ema;
    public static IEmploye emp;
    public static IFonction fon;
    public static IFournisseur fou;
    public static IGrilleSalariale gri;
    public static IPrelevement pre;
    public static ISalaireEmploye sal;
    public static IStock sto;
    public static ITelephone tel;
    public static IUtilisateur uti;
    public static IVente ven;
    public static IProduit prod;
    public static DefaultTableModel modelP;
    private static String entetep[] = {"Categorie", "Article", "Prix Unitaire", "Date Ajout Article"};
    private static Object datap[][] = null;
    String mesaj = "";

    public static void chargerfournisseur(JComboBox combo, JComboBox combo1, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.fou.ChargerFournisseur();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);

            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 0));
                    combo1.addItem(tableau.getValueAt(i, 1));
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                //  JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            //JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void chargerfournisseurArticle(JComboBox combo, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.fou.ChargerFournisseur();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);
            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 1));
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                // JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void chargerfonction(JComboBox combo, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.fon.ChargerFonction();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);
            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 0));
                    //cbxTesterCharge.addItem(TbTest.getRowCount());
                    //JOptionPane.showMessageDialog(null, "" + GestionProduitClient.pd.testerChCombo());
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                //  JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void chargerNumEmploye(JComboBox combo, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.emp.ChargerNumeroEmploye();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);
            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 0));
                    //cbxTesterCharge.addItem(TbTest.getRowCount());
                    //JOptionPane.showMessageDialog(null, "" + GestionProduitClient.pd.testerChCombo());
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            //  JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void chargerCategorie(JComboBox combo, JComboBox combo1, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.cat.ChargerCategorie();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);
            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 0));
                    combo1.addItem(tableau.getValueAt(i, 1));
                    //cbxTesterCharge.addItem(TbTest.getRowCount());
                    //JOptionPane.showMessageDialog(null, "" + GestionProduitClient.pd.testerChCombo());
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de charger les categories!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void chargerCategorieArticle(JComboBox combo, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.cat.ChargerCategorie();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);

            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 0));

                    //cbxTesterCharge.addItem(TbTest.getRowCount());
                    //JOptionPane.showMessageDialog(null, "" + GestionProduitClient.pd.testerChCombo());
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                //  JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ListerVente(String tete[], JTable tableau) {

        try {

            datap = SysGestBricoLocalClient.ven.ListerVente();
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void RechercherVenteIndice(String tete[], JTable tableau, String indice) {

        try {

            datap = SysGestBricoLocalClient.ven.RechercherVentePar(indice);
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void chargerVendeur(JComboBox combo, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.ven.NomVendeur();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);

            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 1));

                    //cbxTesterCharge.addItem(TbTest.getRowCount());
                    //JOptionPane.showMessageDialog(null, "" + GestionProduitClient.pd.testerChCombo());
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                //  JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            //JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void chargerDateVente(JComboBox combo, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.ven.DateVente();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);

            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 1));

                    //cbxTesterCharge.addItem(TbTest.getRowCount());
                    //JOptionPane.showMessageDialog(null, "" + GestionProduitClient.pd.testerChCombo());
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                //  JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void chargerNumeroVente(JComboBox combo, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.ven.NumeroVente();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);

            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 1));

                    //cbxTesterCharge.addItem(TbTest.getRowCount());
                    //JOptionPane.showMessageDialog(null, "" + GestionProduitClient.pd.testerChCombo());
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void chargerDepartement(JComboBox combo, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.dep.ChargerDepartement();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);

            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 1));

                    //cbxTesterCharge.addItem(TbTest.getRowCount());
                    //JOptionPane.showMessageDialog(null, "" + GestionProduitClient.pd.testerChCombo());
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                //  JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void chargerArticle(JComboBox combo, JComboBox combo1, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.art.ChargerLibelleArticle();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);
            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 0));
                    combo1.addItem(tableau.getValueAt(i, 1));

                    //cbxTesterCharge.addItem(TbTest.getRowCount());
                    //JOptionPane.showMessageDialog(null, "" + GestionProduitClient.pd.testerChCombo());
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                //  JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void chargerArticleMod(JComboBox combo, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.art.ChargerLibelleArticle();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);
            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 0));


                    //cbxTesterCharge.addItem(TbTest.getRowCount());
                    //JOptionPane.showMessageDialog(null, "" + GestionProduitClient.pd.testerChCombo());
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                // JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void chargerArticleSup(JComboBox combo, JComboBox combo1, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.art.ChargerLibelleArticle();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);
            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 0));
                    combo1.addItem(tableau.getValueAt(i, 2));

                    //cbxTesterCharge.addItem(TbTest.getRowCount());
                    //JOptionPane.showMessageDialog(null, "" + GestionProduitClient.pd.testerChCombo());
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                // JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            //JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ListerFournisseur(String tete[], JTable tableau) {

        try {

            datap = SysGestBricoLocalClient.fou.ListerFournisseur();
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (RemoteException ex) {
            //  JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ListerCategorie(String tete[], JTable tableau) {

        try {

            datap = SysGestBricoLocalClient.cat.ListerCategorie();
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (RemoteException ex) {
            //  JOptionPane.showMessageDialog(null, "Impossible de charger les categories!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void RechercherArticle(String ind, String tete[], JTable tableau) {

        try {

            datap = SysGestBricoLocalClient.art.RechercherArticle(ind);
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de charger les categories!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ListerArticle(String tete[], JTable tableau) {

        try {

            datap = SysGestBricoLocalClient.art.ListerArticle();
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void RechercherEmployeUtil(String tete[], JTable tableau, String numero) {

        try {

            datap = SysGestBricoLocalClient.emp.RechercherEmployeUtil(numero);
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (RemoteException ex) {
            //  JOptionPane.showMessageDialog(null, "Impossible de lister les employes!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ListerEmploye(String tete[], JTable tableau) {

        try {

            datap = SysGestBricoLocalClient.emp.ListerEmploye();
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (RemoteException ex) {
            //JOptionPane.showMessageDialog(null, "Impossible de lister les employes!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ListerUtilisateur(String tete[], JTable tableau) {

        try {

            datap = SysGestBricoLocalClient.uti.ListerUtilisateur();
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (RemoteException ex) {
            //  JOptionPane.showMessageDialog(null, "Impossible de lister les employes!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ListerUtilisateur1(String tete[], JTable tableau) {

        try {

            datap = SysGestBricoLocalClient.uti.ListerUtilisateur1();
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (RemoteException ex) {
            //  JOptionPane.showMessageDialog(null, "Impossible de lister les employes!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void chargerNomUtilisateur(JComboBox combo, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.uti.ChargerNomUtilisateur();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);

            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 0));
                    //cbxTesterCharge.addItem(TbTest.getRowCount());
                    //JOptionPane.showMessageDialog(null, "" + GestionProduitClient.pd.testerChCombo());
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void chargerNomArticle(JComboBox combo, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.art.ChargerNomArticle();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);

            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 0));
                    //cbxTesterCharge.addItem(TbTest.getRowCount());
                    //JOptionPane.showMessageDialog(null, "" + GestionProduitClient.pd.testerChCombo());
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                // JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ListerUtilisateurParindice(String ind, String tete[], JTable tableau) {

        try {

            datap = SysGestBricoLocalClient.uti.ListerUtilisateurParIndice(ind);
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (RemoteException ex) {
            //JOptionPane.showMessageDialog(null, "Impossible de lister les employes!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ListerUtilisateurParindice1(String ind, String tete[], JTable tableau) {

        try {

            datap = SysGestBricoLocalClient.uti.ListerUtilisateurParIndice1(ind);
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (RemoteException ex) {
            //JOptionPane.showMessageDialog(null, "Impossible de lister les employes!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void RechercherEmploye(String tete[], JTable tableau, String numero) {

        try {

            datap = SysGestBricoLocalClient.emp.RechercherEmploye(numero);
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de lister les employes!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ModifierEtatConnexion(String nomutilisateur, String etatconnexion) throws RemoteException {
        InetAddress ida = null;
        try {
            ida = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(SysGestBricoLocalClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        SysGestBricoLocalClient.uti.ModifierEtatConnexion(nomutilisateur, etatconnexion, ida.getHostName(), ida.getHostAddress());

    }

    public static void traceeutilisateur(String nomutilisateur, String tableaffectee, String action, String numeroentite) throws RemoteException {
        InetAddress ida = null;
        try {
            ida = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(SysGestBricoLocalClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        //String nomutilisateur,String tableaffectee,String action,String numeroentite,String date,String heure,String nommachine,String adressemachine
        SysGestBricoLocalClient.uti.Tracabilite(nomutilisateur, tableaffectee, action, numeroentite, date1, heure1, ida.getHostName(), ida.getHostAddress());

    }

    public static void ListerTraceeParindice(String ind, String tete[], JTable tableau) {

        try {

            datap = SysGestBricoLocalClient.uti.ListerTracabiliteParIndice(ind);
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (RemoteException ex) {
            //JOptionPane.showMessageDialog(null, "Impossible de lister les employes!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ListerTracee(String tete[], JTable tableau) {

        try {

            datap = SysGestBricoLocalClient.uti.ListerTracee();
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (RemoteException ex) {
            //JOptionPane.showMessageDialog(null, "Impossible de lister les employes!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ChargerAction(JComboBox combo, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.uti.ChargerAction();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);
            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 1));
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                // JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ChargerDateTracee(JComboBox combo, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.uti.ChargerDateTracee();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);
            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 1));
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                // JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            //JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ChargerNomUtilisateurTracee(JComboBox combo, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.uti.ChargerNomUtilisateurTracee();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);
            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 1));
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                // JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ChargerTableAffectee(JComboBox combo, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.uti.ChargerTableAffectee();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);
            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 1));
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                // JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de charger les articles!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void PreparerPayroll(String tete[], JTable tableau, String mois) {

        try {

            datap = SysGestBricoLocalClient.pay.PreparerPayroll(mois);
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (RemoteException ex) {
            // JOptionPane.showMessageDialog(null, "Impossible de preparer payroll!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void chargerMoisPayroll(JComboBox combo, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.pay.ChargerMois();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);
            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 0));
                    //cbxTesterCharge.addItem(TbTest.getRowCount());
                    //JOptionPane.showMessageDialog(null, "" + GestionProduitClient.pd.testerChCombo());
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                //  JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            //JOptionPane.showMessageDialog(null, "Impossible de charger les mois!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void chargerDatePayroll(JComboBox combo, JTable tableau) {
        try {

            datap = SysGestBricoLocalClient.pay.ChargerDatePayroll();
            modelP = new DefaultTableModel(datap, entetep);
            tableau.setModel(modelP);
            try {
                int i = 0;
                while (i < tableau.getRowCount()) {
                    combo.addItem(tableau.getValueAt(i, 0));
                    //cbxTesterCharge.addItem(TbTest.getRowCount());
                    //JOptionPane.showMessageDialog(null, "" + GestionProduitClient.pd.testerChCombo());
                    i++;
                }
                i = 0;
            } catch (Exception e) {
                // JOptionPane.showMessageDialog(null, "Prob combo  " + e.getMessage());
            }
        } catch (RemoteException ex) {
            //JOptionPane.showMessageDialog(null, "Impossible de charger les mois!!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ListerPayroll(String tete[], JTable tableau) {

        try {

            datap = SysGestBricoLocalClient.pay.ListerPayroll();
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (RemoteException ex) {
            //JOptionPane.showMessageDialog(null, "Impossible de lister les employes!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void ListerPayrollParIndice(String tete[], JTable tableau, String ind) {

        try {

            datap = SysGestBricoLocalClient.pay.ListerPayrollParIndice(ind);
            modelP = new DefaultTableModel(datap, tete);
            tableau.setModel(modelP);

        } catch (RemoteException ex) {
            //JOptionPane.showMessageDialog(null, "Impossible de lister les employes!", "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void demarrer() {
        try {
            FrmPrincipal fn = new FrmPrincipal();

            fn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // this.dispose();
            fn.setSize(325, 310);
            //fn.TbArticle.remove(1);
            //fn.remove(panCorpsConnexion);
            fn.remove(fn.panpiedImage);
            fn.remove(fn.BMnMenuPrincipal);
            fn.mnEmploye.setVisible(false);
            fn.mnUtilisateur.setVisible(false);
            fn.MnVente.setVisible(false);
            fn.mnAchat.setVisible(false);
            fn.mnArticle.setVisible(false);
            fn.mnCategorie.setVisible(false);
            //   fn.mnCommande.setVisible(false);
            fn.mnFournisseur.setVisible(false);
            fn.mnFournisseur.setVisible(false);
            fn.mnPayroll.setVisible(false);
            fn.mnOutil.setVisible(false);
            fn.remove(fn.TbArticle);
            fn.remove(fn.panTete);
            //fn.panCorpsConnexion.setVisible(true);


            fn.setLocationRelativeTo(null);
            fn.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Attention, " + e.getMessage(), "Information demarrrage", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static String adr = "127.0.0.1";
    public static String adrc = "";

    public static void ObjectExp() throws NamingException {
        Context cntBricolocal;
        try {
            if (adrc != "") {
                adr = adrc;

            }
            cntBricolocal = new InitialContext();
            ach = (IAchat) cntBricolocal.lookup("rmi://" + adr + "/SAchat:1071");
            art = (IArticle) cntBricolocal.lookup("rmi://" + adr + "/SArticle:1072");
            cat = (ICategorie) cntBricolocal.lookup("rmi://" + adr + "/SCategorie:1073");
            cli = (IClients) cntBricolocal.lookup("rmi://" + adr + "/SClients:1074");
            ccl = (ICommandeClients) cntBricolocal.lookup("rmi://" + adr + "/SCommandeClients:1075");
            dep = (IDepartement) cntBricolocal.lookup("rmi://" + adr + "/SDepartement:1076");
            ema = (IEmail) cntBricolocal.lookup("rmi://" + adr + "/SEmail:1077");
            emp = (IEmploye) cntBricolocal.lookup("rmi://" + adr + "/SEmploye:1078");
            fon = (IFonction) cntBricolocal.lookup("rmi://" + adr + "/SFonction:1079");
            fou = (IFournisseur) cntBricolocal.lookup("rmi://" + adr + "/SFournisseur:1080");
            gri = (IGrilleSalariale) cntBricolocal.lookup("rmi://" + adr + "/SGrilleSalariale:1081");
            pre = (IPrelevement) cntBricolocal.lookup("rmi://" + adr + "/SPrelevement:1082");
            sal = (ISalaireEmploye) cntBricolocal.lookup("rmi://" + adr + "/SSalaireEmploye:1083");
            sto = (IStock) cntBricolocal.lookup("rmi://" + adr + "/SStock:1084");
            tel = (ITelephone) cntBricolocal.lookup("rmi://" + adr + "/STelephone:1085");
            uti = (IUtilisateur) cntBricolocal.lookup("rmi://" + adr + "/SUtilisateur:1086");
            ven = (IVente) cntBricolocal.lookup("rmi://" + adr + "/SVente:1087");
            pay = (IPayroll) cntBricolocal.lookup("rmi://" + adr + "/SPayroll:1088");
        } catch (NameNotFoundException g) {
            // InetAddress ida = null;
            JOptionPane.showMessageDialog(null, "Les objets ne sont pas disponibles tous pour le moment\nSvp,contactez l'administrateur systeme!", "Indisponibilite Serveur", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Context cntBricolocal;
        try {

            try {
                cntBricolocal = new InitialContext();
                ObjectExp();

            } catch (NameNotFoundException g) {
                // InetAddress ida = null;
                JOptionPane.showMessageDialog(null, "Les objets ne sont pas disponibles tous pour le moment\nSvp,contactez l'administrateur systeme!", "Indisponibilite Serveur", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            // TODO code application logic here
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    int i = JOptionPane.showConfirmDialog(null, "Vous pouvez configurer l'adresse IP du serveur?", "Confirmer", 2);
                    if (i == 0) {
                        FrmAdresseServeurApplication as = new FrmAdresseServeurApplication();
                        //as.txtAdresseServeur.setText(SysGestBricoLocalClient.adr);
                        as.setLocationRelativeTo(null);
                        as.setResizable(false);
                        as.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        as.setVisible(true);
                    } else {
                        demarrer();
                    }

                }
            });
            //Junior est Programmeur concepteur or Rose est un developpeur...Hm

            //connexion 

            // code design...................................................
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //   Eh bien l'equipe est la et en travaillant...
        } catch (javax.naming.ServiceUnavailableException cx) {
            //System.out.println("Serveur non disponible"+cx.getMessage());
            InetAddress ida = null;
            try {
                ida = InetAddress.getLocalHost();
            } catch (UnknownHostException ex) {
                Logger.getLogger(SysGestBricoLocalClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Client " + ida.getHostName() + " identifie par l'adresse  " + ida.getHostAddress() + "\nProbleme de non disponibilite du serveur d'application Brico Local\nSvp,contactez l'administrateur systeme!", "Indisponibilite", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);

        } catch (NamingException ex) {
            Logger.getLogger(SysGestBricoLocalClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
