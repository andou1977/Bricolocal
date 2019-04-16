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
public interface IEmploye extends Remote{
    
    public void modifierNumeroemploye(String numeroemploye) throws RemoteException;

    public void modifierNom(String nom) throws RemoteException;

    public void modifierPrenom(String prenom) throws RemoteException;

    public void modifierSexe(String sexe) throws RemoteException;

    public void modifierNif(String nif) throws RemoteException;

    public void modifierDatenaissance(String datenaissance) throws RemoteException;

    public void modifierAdresse(String adresse) throws RemoteException;

    public void modifierDateembauche(String dateembauche) throws RemoteException;

    public void modifierNumerodepartement(String numerodepartement) throws RemoteException;

    public void modifierFonction(String fonction) throws RemoteException;

    public String prendreNumeroemploye() throws RemoteException;

    public String prendreNom() throws RemoteException;

    public String prendrePrenom() throws RemoteException;

    public String prendreSexe() throws RemoteException;

    public String prendreNif() throws RemoteException;

    public String prendreDatenaissance() throws RemoteException;

    public String prendreAdresse() throws RemoteException;

    public String prendreDateembauche() throws RemoteException;

    public String prendreNumerodepartement() throws RemoteException;

    public String prendreFonction() throws RemoteException;
    
    
    public String AjouterEmploye( String numeroemploye,String nom, String prenom, String sexe, String nif, String datenaissance, String adresse, String dateembauche, String numerodepartement, String fonction) throws RemoteException;
    
    public Boolean RechercherEmployeModifier(String code) throws RemoteException;
    
     public Object[][] RechercherEmploye(String numero) throws RemoteException;
    
    public String ModifierEmploye(String numeroemploye, String nom, String prenom, String sexe, String nif, String datenaissance, String adresse, String dateembauche, String numerodepartement, String fonction) throws RemoteException;
     
    public Object[][] ListerEmploye() throws RemoteException;
    public Object[][] ChargerNumeroEmploye() throws RemoteException;
    public Object[][] RechercherEmployeUtil(String num) throws RemoteException;
     
    
}
