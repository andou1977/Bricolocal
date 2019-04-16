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
public interface IEmail extends Remote {

    public void modifierNumero(String numero) throws RemoteException;

    public void modifierEmail(String email) throws RemoteException;

    public void modifierEmail1(String email1) throws RemoteException;

    public void modifierEmail2(String email2) throws RemoteException;

    public String prendreNumero() throws RemoteException;

    public String prendreEmail() throws RemoteException;

    public String prendreEmail1() throws RemoteException;

    public String prendreEmail2() throws RemoteException;

    public String AjouterEmailFournisseur(String numero, String email, String email1, String email2) throws RemoteException;

    public String AjouterEmailEmploye(String numero, String email, String email1, String email2) throws RemoteException;

    public String AjouterEmailClients(String numero, String email, String email1, String email2) throws RemoteException;

    public Boolean RechercherEmailFournisseur(String numero) throws RemoteException;

    public Boolean RechercherEmailEmploye(String numero) throws RemoteException;

    public Boolean RechercherEmailClients(String numero) throws RemoteException;

    public String ModifierEmailFournisseur(String numero, String email, String email1, String email2) throws RemoteException;

    public String ModifierEmailEmploye(String numero, String email, String email1, String email2) throws RemoteException;

    public String ModifierEmailClients(String numero, String email, String email1, String email2) throws RemoteException;

    public String SupprimerEmailFournisseur(String numero) throws RemoteException;

    public String SupprimerEmailEmploye(String numero) throws RemoteException;

    public String SupprimerEmailClients(String numero) throws RemoteException;
}
