/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.controleur;

import ht.sys.sysgesbricolocal.amorce.IAchat;
import ht.sys.sysgesbricolocal.dal.DalAchat;
import ht.sys.sysgesbricolocal.domaine.Achat;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Berling
 */
public class ControleurAchat extends UnicastRemoteObject implements IAchat{
    Achat ach=new Achat();
    
    public ControleurAchat() throws RemoteException{}
    @Override
   public void modifierNumeroemploye(String numeroemploye) throws RemoteException{
        ach.setNumeroemploye(numeroemploye);
    }

    @Override
    public void modifierNumeroachat(String numeroachat) throws RemoteException{
       ach.setNumeroachat(numeroachat);
    }

    @Override
    public void modifierNumerofournisseur(String numerofournisseur) throws RemoteException{
      ach.setNumerofournisseur(numerofournisseur);
    }

    @Override
    public void modifierDescription(String description)throws RemoteException {
       ach.setDescription(description);
    }

    @Override
    public void modifierQuantite(int quantite)throws RemoteException {
        ach.setQuantite(quantite);
    }

    @Override
    public void modifierPrix(Float prix)throws RemoteException {
       ach.setPrix(prix);
    }

    @Override
    public void modifierFrais(Float frais)throws RemoteException {
      ach.setFrais(frais);
    }
  @Override
    public void modifierDateachat(String dateachat)throws RemoteException {
        ach.setDateachat(dateachat);
    }

    @Override
    public void modifierDateenregistrement(String dateenregistrement) throws RemoteException{
        ach.setDateenregistrement(dateenregistrement);
    }

    @Override
    public String prendreNumeroemploye() throws RemoteException{
        return  ach.getNumeroemploye();
    }

    @Override
    public String prendreNumeroachat()throws RemoteException {
        return ach.getNumeroachat();
    }

    @Override
    public String prendremodifierNumerofournisseur() throws RemoteException{
        return ach.getNumerofournisseur();
    }

    @Override
    public String prendreDescription()throws RemoteException {
        return ach.getDescription();
    }

    @Override
    public int prendreQuantite() throws RemoteException{
        return ach.getQuantite();
    }

    @Override
    public Float prendrePrix() throws RemoteException{
        return ach.getPrix();
    }

    @Override
    public Float prendreFrais() throws RemoteException{
        return ach.getFrais();
    }

    @Override
    public String prendreDateachat()throws RemoteException {
        return ach.getDateachat();
    }

    @Override
    public String prendreDateenregistrement()throws RemoteException {
        return ach.getDateenregistrement();
    }
    
    @Override
    public String AjouterAchat(String numeroachat, String numerofournisseur, String description, Float prix, int quantite, Float frais, String dateachat, String dateenregistrement) throws RemoteException {

        String message = null;
        message = DalAchat.EnregistrerAchat(numeroachat,numerofournisseur,description,prix,quantite,frais,dateachat,dateenregistrement);

        return message;
    }

    @Override
    public Boolean RechercherAchatModifier(String code) throws RemoteException {
        Boolean trouve = false;
        ach = DalAchat.RechercherAchatModifier(code);
        if (ach.getNumeroachat().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
    
    @Override
     public Object[][] RechercherAchat(String numero) throws RemoteException {
       Object[][] data;
        data = DalAchat.RechercherAchat(numero);
        return data;
    }
     
    @Override
      public String ModifierAchat(String numeroemploye, String numeroachat, String numerofournisseur, String description, int quantite, Float prix, Float frais, String dateachat) throws RemoteException {
        String message="";
        message =DalAchat.ModifierAchat(numeroemploye, numeroachat, numerofournisseur, description, quantite, prix, frais, dateachat);
        return message;
    }
    
    @Override
     public Object[][] RechercherAchatParDate(String dateachat) throws RemoteException {
       Object[][] data;
        data = DalAchat.RechercherAchatParDate(dateachat);
        return data;
    }
      
    @Override
     public Object[][] ListerAchat(String numero) throws RemoteException {
       Object[][] data;
        data = DalAchat.ListerAchat();
        return data;
    }
     
  
   
}
