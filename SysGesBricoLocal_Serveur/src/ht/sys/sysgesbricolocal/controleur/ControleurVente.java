/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.controleur;

import ht.sys.sysgesbricolocal.amorce.IVente;
import ht.sys.sysgesbricolocal.dal.DalVente;
import ht.sys.sysgesbricolocal.domaine.Vente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Berling
 */
public class ControleurVente extends UnicastRemoteObject implements IVente {
    
    Vente ven = new Vente();

    public ControleurVente() throws RemoteException {
    }
    
   
    
    @Override
    public void modifierNumerovente(String numerovente) throws RemoteException{
        ven.setNumerovente(numerovente);
    }
    
    @Override
    public void modifierNumeroarticle(String numeroarticle) throws RemoteException{
        ven.setNumeroarticle(numeroarticle);
    }
    
    @Override
    public void modifierNumeroClients(String numeroClients) throws RemoteException {
        ven.setNumeroClients(numeroClients);
    }
    
    
    @Override
    public void modifierQuantite(int quantite) throws RemoteException{
        ven.setQuantite(quantite);
    }
    @Override
    public void modifierMontant(float montant) throws RemoteException{
        ven.setMontant(montant);
    }
    
    @Override
    public void modifierDatevente(String datevente) throws RemoteException{
        ven.setDatevente(datevente);
    }
    
    @Override
    public void modifiernomutilisateur(String nomutilisateur) throws RemoteException{
        ven.setNomutilisateur(nomutilisateur);
    }
    
    @Override
    public String prendreNumerovente() throws RemoteException{
        return ven.getNumerovente();
    }
    
    @Override
    public String prendreNumeroarticle() throws RemoteException{
        return ven.getNumeroarticle();
    }
    
    @Override
    public String prendreNumeroClients() throws RemoteException{
        return ven.getNumeroClients();
    }
    
    @Override
    
    public int prendreQuantite() throws RemoteException{
        return ven.getQuantite();
    }
    @Override
    public float prendreMontant() throws RemoteException{
        return ven.getMontant();
    }
    @Override
    public String prendreDatevente() throws RemoteException{
        return ven.getDatevente();
    }
    
    
    @Override
    public String AjouterVente(String numerovente, String numeroarticle, String numeroClients, int quantite,float montant, String datevente, String nomutilisateur) throws RemoteException {
        
        String message = null;
        message = DalVente.EnregistrerVente(numerovente, numeroarticle, numeroClients, quantite,montant, datevente, nomutilisateur);
        return message;
    }
    @Override
    public String codeVente() throws RemoteException{
     String message = null;
     message = DalVente.CodeVente();
      return message;
    }
    @Override
    public Boolean RechercherVenteModifier(String code) throws RemoteException {
        Boolean trouve = false;
        ven = DalVente.RechercherVenteModifier(code);
        if (ven.getNumerovente().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
    
    @Override
    public Object[][] RechercherVente(String numero) throws RemoteException {
        Object[][] data;
        data = DalVente.Recherchervente(numero);
        return data;
    }
    
    @Override
    public String ModifierVente(String numerovente, String numeroarticle, String numeroClients,int quantite, String datevente, String nomutilisateur) throws RemoteException {
        String message = "";
        message = DalVente.ModifierVente(numerovente, numeroarticle, numeroClients,quantite, datevente, nomutilisateur);
        return message;
    }
    
    @Override
    public Object[][] RechercherVenteParDate(String datevente) throws RemoteException {
        Object[][] data;
        data = DalVente.RechercherventeParDate(datevente);
        return data;
    }
    
    @Override
    public Object[][] ListerVente() throws RemoteException {
        Object[][] data;
        data = DalVente.ListerVente();
        return data;
    }
    
     @Override
    public Boolean RechercherCodeVente() throws RemoteException {
        Boolean trouve = false;
        ven = DalVente.RechercherCodeVente();
        if (ven.getNumerovente().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
     
    
    @Override
    public Object[][] NomVendeur() throws RemoteException {
        Object[][] data;
        data = DalVente.ChargerNomVendeur();
        return data;
    }
 
    @Override
    public Object[][] DateVente() throws RemoteException {
        Object[][] data;
        data = DalVente.ChargerDateVente();
        return data;
    }


    @Override
    public Object[][] NumeroVente() throws RemoteException {
        Object[][] data;
        data = DalVente.ChargerNumeroVente();
        return data;
    }
    
   @Override
    public Object[][] RechercherVentePar(String co) throws RemoteException {
        Object[][] data;
        data = DalVente.RechercherVenteIndice(co);
        return data;
    } 
}
