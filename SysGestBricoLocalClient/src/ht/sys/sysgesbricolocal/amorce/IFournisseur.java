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
public interface IFournisseur extends Remote {

    public void modifierNumerofournisseur(String numerofournisseur) throws RemoteException;

    public void modifierNom(String nom) throws RemoteException;

    public void modifierAdresse(String adresse) throws RemoteException;

    public void modifierDateajout(String dateajout) throws RemoteException;

    public String prendreNumerofournisseur() throws RemoteException;

    public String prendreNom() throws RemoteException;

    public String prendreAdresse() throws RemoteException;

    public String prendreDateajout() throws RemoteException;

    public String AjouterFournisseur(String numerofournisseur, String nom, String adresse, String dateajout) throws RemoteException;

    public Boolean RechercherFournisseurParNumero(String numero) throws RemoteException;

    public Boolean RechercherFournisseurParNom(String nom) throws RemoteException;

    public String ModifierFournisseur(String numerofournisseur, String nom, String adresse, String dateajout) throws RemoteException;

    public Object[][] ListerFournisseur() throws RemoteException;

    public Object[][] ChargerFournisseur() throws RemoteException;

    public String SuprimmerFournisseur(String numero) throws RemoteException;
}
