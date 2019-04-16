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
public interface ITelephone extends Remote {

    public void modifierNumero(String numero) throws RemoteException;

    public void modifierTelephone(String telephone) throws RemoteException;

    public void modifierTelephone1(String telephone1) throws RemoteException;

    public void modifierTelephone2(String telephone2) throws RemoteException;

    public String prendreNumero() throws RemoteException;

    public String prendreTelephone() throws RemoteException;

    public String prendreTelephone1() throws RemoteException;

    public String prendreTelephone2() throws RemoteException;

    public String AjouterTelephoneFournisseur(String numero, String telephone, String telephone1, String telephone2) throws RemoteException;

    public String AjouterTelephoneEmploye(String numero, String telephone, String telephone1, String telephone2) throws RemoteException;

    public String AjouterTelephoneClients(String numero, String telephone, String telephone1, String telephone2) throws RemoteException;

    public Boolean RechercherTelephoneFournisseur(String numero) throws RemoteException;

    public Boolean RechercherTelephoneEmploye(String numero) throws RemoteException;

    public Boolean RechercherTelephoneClients(String numero) throws RemoteException;

    public String ModifierTelephoneFournisseur(String numero, String telephone, String telephone1, String telephone2) throws RemoteException;

    public String ModifierTelephoneEmploye(String numero, String telephone, String telephone1, String telephone2) throws RemoteException;

    public String ModifierTelephoneClients(String numero, String telephone, String telephone1, String telephone2) throws RemoteException;

    public String SupprimerTelephoneFournisseur(String numero) throws RemoteException;

    public String SupprimerTelephoneEmploye(String numero) throws RemoteException;

    public String SupprimerTelephoneClients(String numero) throws RemoteException;
}
