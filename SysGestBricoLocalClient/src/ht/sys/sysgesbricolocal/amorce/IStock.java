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
public interface IStock extends Remote {

    public void modifierNumerostock(String numerostock) throws RemoteException;

    public void modifierNumeroarticle(String numeroarticle) throws RemoteException;

    public void modifierDateajout(String dateajout) throws RemoteException;

    public void modifierQuantite(int quantite) throws RemoteException;

    public void modifierPrix(float p) throws RemoteException;

    public float prendrePrix() throws RemoteException;

    public String prendreNumerostock() throws RemoteException;

    public String prendreNumeroarticle() throws RemoteException;

    public String prendreDateajout() throws RemoteException;

    public int prendreQuantite() throws RemoteException;

    public String AjouterStock(String numerostock, String numeroarticle, String dateajout, int quantitet) throws RemoteException;

    public Boolean RechercherStock(String code) throws RemoteException;

    public Boolean RechercherCodeStock() throws RemoteException;

    public String ModifierStock(String numeroarticle, int quantite) throws RemoteException;
    
    public String ModifierStockA(String numeroarticle, int quantite) throws RemoteException ;

    public String SupprimerStock(String numeroarticle) throws RemoteException;

    public Object[][] ListerStock(String numero) throws RemoteException;
}
