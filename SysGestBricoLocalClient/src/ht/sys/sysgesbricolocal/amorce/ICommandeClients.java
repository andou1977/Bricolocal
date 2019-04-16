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
public interface ICommandeClients extends Remote {
    
    public void modifierNumerocommandeclients(String numerocommandeclients) throws RemoteException;

    public void modifierNomutilisateur(String nomutilisateur) throws RemoteException;

    public void modifierNumeroclients(String numeroclients) throws RemoteException;

    public void modifierNumeroarticle(String numeroarticle) throws RemoteException;

    public void modifierQuantite(int quantite) throws RemoteException;

    public void modifierPrix(Float prix) throws RemoteException;

    public void modifierTypecommande(String typecommande) throws RemoteException;

    public void modifierDatecommande(String datecommande) throws RemoteException;

    public void modifierDatelivraison(String datelivraison) throws RemoteException;

    public String prendreNumerocommandeclients() throws RemoteException;

    public String prendreNomutilisateur() throws RemoteException;

    public String prendreNumeroclients() throws RemoteException;

    public String prendreNumeroarticle() throws RemoteException;

    public int prendreQuantite() throws RemoteException;

    public Float prendrePrix() throws RemoteException;

    public String prendreTypecommande() throws RemoteException;

    public String prendreDatecommande() throws RemoteException;

    public String prendreDatelivraison() throws RemoteException;
    
    public String AjouterCommandeClient(String numerocommandeclients, String nomutilisateur, String numeroclients, String numeroarticle, int quantite, Float prix, String typecommande, String datecommande, String datelivraison) throws RemoteException;
    
    public Boolean RechercherCommandeClientModifier(String code) throws RemoteException;
    
     public Object[][] RechercherCommandeClient(String numero) throws RemoteException;
    
      public String ModifierCommandeClient(String numerocommandeclients,int quantite, Float prix, String typecommande, String datecommande, String datelivraison) throws RemoteException;
    
     public Object[][] RechercherCommandeClientParDate(String datecommande) throws RemoteException;
    
     public Object[][] ListerCommandeClient(String numero) throws RemoteException;
}
