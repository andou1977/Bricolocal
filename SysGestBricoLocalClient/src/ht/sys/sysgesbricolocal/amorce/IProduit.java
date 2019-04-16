/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.amorce;


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Rose
 */
public interface IProduit extends Remote{
   
    public void ModifierCode(String code) throws RemoteException;

    public void ModifierLibelle(String libelle) throws RemoteException;

    public void ModifierPrix(Float prix) throws RemoteException;

    public void ModifierQuantite(int quantite) throws RemoteException;

    public String PrendreCode() throws RemoteException;
    
    public String PrendreLbelle() throws RemoteException;
    
    public Float PrendrePrix() throws RemoteException;
    
    public int PrendreQuantite() throws RemoteException;
    
    public String AjouterProduit(String libelle, Float prix, int quantite)throws RemoteException;
    
     public Boolean RechProduit(String code) throws RemoteException;
}


