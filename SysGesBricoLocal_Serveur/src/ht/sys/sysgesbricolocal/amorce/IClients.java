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
public interface IClients extends Remote {

    public void modifierNumeroClients(String numeroClients) throws RemoteException;

    public void modifierNom(String nom) throws RemoteException;

    public void modifierTelephone(String telephone) throws RemoteException;

    public void modifierAdresse(String adresse) throws RemoteException;

    public void modifierEmail(String email) throws RemoteException;

    public String prendreNumeroClients() throws RemoteException;

    public String prendreNom() throws RemoteException;

    public String prendreTelephone() throws RemoteException;

    public String prendreAdresse() throws RemoteException;

    public String prendreEmail() throws RemoteException;

    public String AjouterClient(String numeroClients, String nom, String adresse, String telephone, String email) throws RemoteException;

    public Boolean RechercherClient(String code) throws RemoteException;

    public String ModifierClient(String numeroClients, String nom, String adresse, String telephone, String email) throws RemoteException;

    public Object[][] ListerClient() throws RemoteException;
}