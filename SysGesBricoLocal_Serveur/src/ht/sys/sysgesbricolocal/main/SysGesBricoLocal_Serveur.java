/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.main;

import ht.sys.sysgesbricolocal.controleur.ControleurAchat;
import ht.sys.sysgesbricolocal.controleur.ControleurArticle;
import ht.sys.sysgesbricolocal.controleur.ControleurCategorie;
import ht.sys.sysgesbricolocal.controleur.ControleurClients;
import ht.sys.sysgesbricolocal.controleur.ControleurCommandeClients;
import ht.sys.sysgesbricolocal.controleur.ControleurDepartement;
import ht.sys.sysgesbricolocal.controleur.ControleurEmail;
import ht.sys.sysgesbricolocal.controleur.ControleurEmploye;
import ht.sys.sysgesbricolocal.controleur.ControleurFonction;
import ht.sys.sysgesbricolocal.controleur.ControleurFournisseur;
import ht.sys.sysgesbricolocal.controleur.ControleurGrilleSalariale;
import ht.sys.sysgesbricolocal.controleur.ControleurPayroll;
import ht.sys.sysgesbricolocal.controleur.ControleurPrelevement;
import ht.sys.sysgesbricolocal.controleur.ControleurSalaireEmploye;
import ht.sys.sysgesbricolocal.controleur.ControleurStock;
import ht.sys.sysgesbricolocal.controleur.ControleurTelephone;
import ht.sys.sysgesbricolocal.controleur.ControleurUtilisateur;
import ht.sys.sysgesbricolocal.controleur.ControleurVente;
import ht.sys.sysgesbricolocal.ui.FrmServeur;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.ExportException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Rose
 */
public class SysGesBricoLocal_Serveur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // TODO code application logic here
                    InetAddress ida = null;
                    try {
                        ida = InetAddress.getLocalHost();
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(SysGesBricoLocal_Serveur.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println("initialisation de l'objet distant");
                    // ControleurProduit objProd = new ControleurProduit();
                    ControleurAchat objAchat = new ControleurAchat();
                    ControleurArticle objArticle = new ControleurArticle();
                    ControleurCategorie objCategorie = new ControleurCategorie();
                    ControleurClients objClients = new ControleurClients();
                    ControleurCommandeClients objCommandeClients = new ControleurCommandeClients();
                    ControleurDepartement objDepartement = new ControleurDepartement();
                    ControleurEmail objEmail = new ControleurEmail();
                    ControleurEmploye objEmploye = new ControleurEmploye();
                    ControleurFonction objfFonction = new ControleurFonction();
                    ControleurFournisseur objFournisseur = new ControleurFournisseur();
                    ControleurGrilleSalariale objGrilleSalariale = new ControleurGrilleSalariale();
                    ControleurPrelevement objPrelevement = new ControleurPrelevement();
                    ControleurSalaireEmploye objSalaireEmploye = new ControleurSalaireEmploye();
                    ControleurStock objStock = new ControleurStock();
                    ControleurTelephone objTelephone = new ControleurTelephone();
                    ControleurUtilisateur objUtilisateur = new ControleurUtilisateur();
                    ControleurVente objVente = new ControleurVente();
                    ControleurPayroll objPayroll=new ControleurPayroll();

                    try {
                        //System.out.println("initialisation du context");
                        Context ServeurBricoLocal = new InitialContext();
                        //System.out.println("lancement de la base de registre");
                        //try {
                        java.rmi.registry.LocateRegistry.createRegistry(1099);
                        //} 
                        // try {
                        ServeurBricoLocal.bind("rmi:SAchat:1071", objAchat);
                        ServeurBricoLocal.bind("rmi:SArticle:1072", objArticle);
                        ServeurBricoLocal.bind("rmi:SCategorie:1073", objCategorie);
                        ServeurBricoLocal.bind("rmi:SClients:1074", objClients);
                        ServeurBricoLocal.bind("rmi:SCommandeClients:1075", objCommandeClients);
                        ServeurBricoLocal.bind("rmi:SDepartement:1076", objDepartement);
                        ServeurBricoLocal.bind("rmi:SEmail:1077", objEmail);
                        ServeurBricoLocal.bind("rmi:SEmploye:1078", objEmploye);
                        ServeurBricoLocal.bind("rmi:SFonction:1079", objfFonction);
                        ServeurBricoLocal.bind("rmi:SFournisseur:1080", objFournisseur);
                        ServeurBricoLocal.bind("rmi:SGrilleSalariale:1081", objGrilleSalariale);
                        ServeurBricoLocal.bind("rmi:SPrelevement:1082", objPrelevement);
                        ServeurBricoLocal.bind("rmi:SSalaireEmploye:1083", objSalaireEmploye);
                        ServeurBricoLocal.bind("rmi:SStock:1084", objStock);
                        ServeurBricoLocal.bind("rmi:STelephone:1085", objTelephone);
                        ServeurBricoLocal.bind("rmi:SUtilisateur:1086", objUtilisateur);
                        ServeurBricoLocal.bind("rmi:SVente:1087", objVente);
                        ServeurBricoLocal.bind("rmi:SPayroll:1088", objPayroll);

                        FrmServeur gf = new FrmServeur();
                        gf.setLocationRelativeTo(null);
                        JFrame frame = new FrmServeur();
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        //frame.setVisible(true);
                        gf.setVisible(true);


                        //FrmServeur.lblLancerServeur.setText("Serveur disponible pour les demandes d'utilisateurs...");

                        //FrmServeur.txtLancerServeur.setEditable(false);

                    } catch (NamingException ex) {
                        Logger.getLogger(SysGesBricoLocal_Serveur.class.getName()).log(Level.SEVERE, null, ex);

                    } catch (IllegalArgumentException pe) {
                        JOptionPane.showMessageDialog(null, "Serveur " + ida.getHostAddress() + "\nObjet non serialise ", "Erreur de developpement", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                    } catch (ExportException e) {
                        //System.out.println("Le port du serveur est en ecoute:"+e.getMessage());
                        JOptionPane.showMessageDialog(null, "Machine Serveur identifie au : " + ida.getHostAddress() + ", nommee: " + ida.getCanonicalHostName().toUpperCase().toString() + "\nL'un de ces problemes a ete detecte lors du lancement du serveur Brico local:\n1- Port d'ecoute serveur occupé!\n2- D'autre application utilise ce port d'ecoute: " + 1099 + "\n3- Ou Le Serveur est deja disponible.", "Erreur de la base de registre", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);



                        //FenServeur.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(SysGesBricoLocal_Serveur.class.getName()).log(Level.SEVERE, null, ex);
                }

                //new FrmServeur().setVisible(true);
            }
        });
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmServeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmServeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmServeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmServeur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
