/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.amorce;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Berling
 */
public interface IUtilisateur extends Remote {

    public void modifierNumeroemploye(String numeroemploye) throws RemoteException;

    public void modifierNomutilisateur(String nomutilisateur) throws RemoteException;

    public void modifierMotdepasse(String motdepasse) throws RemoteException;

    public void modifierEtatutilisateur(String etatutilisateur) throws RemoteException;

    public void modifierEtatconnexion(String etatconnexion) throws RemoteException;

    public void modifierNommachine(String nommachine) throws RemoteException;

    public void modifierAdressemachine(String adressemachine) throws RemoteException;

    public void modifierRoleUtilisateur(String role) throws RemoteException;

    public String prendreNumeroemploye() throws RemoteException;

    public String prendreNomutilisateur() throws RemoteException;

    public String prendreMotdepasse() throws RemoteException;

    public String prendreEtatutilisateur() throws RemoteException;

    public String prendreEtatconnexion() throws RemoteException;

    public String prendreNommachine() throws RemoteException;

    public String prendreAdressemachine() throws RemoteException;

    public String prendreRoleUtilisateur() throws RemoteException;

    public String AjouterUtilisateur(String numeroemploye, String nomutilisateur, String motdepasse, String etatutilisateur, String role) throws RemoteException;

    public String Tracabilite(String nomutilisateur, String tableaffectee, String action, String numeroentite, String date, String heure, String nommachine, String adressemachine) throws RemoteException;

    public Boolean RechercherUtilisateur(String nomutilisateur) throws RemoteException;

    public Boolean RechercherMotDePasseUtilisateur(String nomutilisateur, String motdepasse) throws RemoteException;

    public String ModifierEtatUtilisateur(String nomutilisateur, String etatutilisateur) throws RemoteException;

    public String ModifierEtatConnexion(String nomutilisateur, String etatconnexion, String nommachine, String adressemachine) throws RemoteException;

    public String ModifierMotDEPasseUtilisateur(String nomutilisateur, String motdepasse) throws RemoteException;

    public Object[][] ListerUtilisateur() throws RemoteException;

    public Object[][] ListerUtilisateur1() throws RemoteException;

    public Object[][] ListerUtilisateurParIndice(String indicederecherche) throws RemoteException;

    public Object[][] ListerUtilisateurParIndice1(String indicederecherche) throws RemoteException;

    public Object[][] ChargerNomUtilisateur() throws RemoteException;

    public String ModifierUtilisateur(String numeroemploye, String nomutilisateur, String motdepasse, String role, String etatutilisateur) throws RemoteException;

    public Object[][] ListerTracee() throws RemoteException;

    public Object[][] ListerTracabiliteParIndice(String indicederecherche) throws RemoteException;

    public Object[][] ChargerNomUtilisateurTracee() throws RemoteException;

    public Object[][] ChargerTableAffectee() throws RemoteException;

    public Object[][] ChargerDateTracee() throws RemoteException;

    public Object[][] ChargerAction() throws RemoteException;
}
