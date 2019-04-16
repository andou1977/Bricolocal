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
public interface IVente extends Remote {

    public void modifierNumerovente(String numerovente) throws RemoteException;

    public void modifierNumeroarticle(String numeroarticle) throws RemoteException;

    public void modifierNumeroClients(String numeroClients) throws RemoteException;

    public void modifierQuantite(int quantite) throws RemoteException;

    public float prendreMontant() throws RemoteException;

    public void modifierDatevente(String datevente) throws RemoteException;

    public void modifiernomutilisateur(String nomutilisateur) throws RemoteException;

    public String prendreNumerovente() throws RemoteException;

    public String prendreNumeroarticle() throws RemoteException;

    public String prendreNumeroClients() throws RemoteException;

    public int prendreQuantite() throws RemoteException;

    public void modifierMontant(float montant) throws RemoteException;

    public String prendreDatevente() throws RemoteException;

    public String AjouterVente(String numerovente, String numeroarticle, String numeroClients, int quantite, float montant, String datevente, String nomutilisateur) throws RemoteException;

    public Boolean RechercherVenteModifier(String code) throws RemoteException;

    public Object[][] RechercherVente(String numero) throws RemoteException;

    public String ModifierVente(String numerovente, String numeroarticle, String numeroClients, int quantite, String datevente, String nomutilisateur) throws RemoteException;

    public Object[][] RechercherVenteParDate(String datevente) throws RemoteException;

    public Object[][] ListerVente() throws RemoteException;

    public Boolean RechercherCodeVente() throws RemoteException;

    public String codeVente() throws RemoteException;

    public Object[][] NumeroVente() throws RemoteException;

    public Object[][] DateVente() throws RemoteException;

    public Object[][] NomVendeur() throws RemoteException;
    
     public Object[][] RechercherVentePar(String co) throws RemoteException ;
}
