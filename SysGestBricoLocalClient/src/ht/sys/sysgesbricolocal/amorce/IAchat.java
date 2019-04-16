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
public interface IAchat extends Remote{
    
  public void modifierNumeroemploye(String numeroemploye) throws RemoteException;

    public void modifierNumeroachat(String numeroachat) throws RemoteException;

    public void modifierNumerofournisseur(String numerofournisseur) throws RemoteException;

    public void modifierDescription(String description)throws RemoteException;

    public void modifierQuantite(int quantite)throws RemoteException ;

    public void modifierPrix(Float prix)throws RemoteException;

    public void modifierFrais(Float frais)throws RemoteException ;
    public void modifierDateachat(String dateachat)throws RemoteException ;

    public void modifierDateenregistrement(String dateenregistrement) throws RemoteException;

    public String prendreNumeroemploye() throws RemoteException;

    public String prendreNumeroachat()throws RemoteException ;

    public String prendremodifierNumerofournisseur() throws RemoteException;

    public String prendreDescription()throws RemoteException ;

    public int prendreQuantite() throws RemoteException;
    public Float prendrePrix() throws RemoteException;

    public Float prendreFrais() throws RemoteException;

    public String prendreDateachat()throws RemoteException ;

    public String prendreDateenregistrement()throws RemoteException;  
    
     public String AjouterAchat(String numeroachat, String numerofournisseur, String description, Float prix, int quantite, Float frais, String dateachat, String dateenregistrement) throws RemoteException;

    public Boolean RechercherAchatModifier(String code) throws RemoteException;
    
     public Object[][] RechercherAchat(String numero) throws RemoteException;
     
      public String ModifierAchat(String numeroemploye, String numeroachat, String numerofournisseur, String description, int quantite, Float prix, Float frais, String dateachat) throws RemoteException;
    
     public Object[][] RechercherAchatParDate(String dateachat) throws RemoteException;
      
     public Object[][] ListerAchat(String numero) throws RemoteException;
    
}
