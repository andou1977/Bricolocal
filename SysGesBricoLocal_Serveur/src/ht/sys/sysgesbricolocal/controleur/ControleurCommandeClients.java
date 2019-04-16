/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.controleur;

import ht.sys.sysgesbricolocal.amorce.ICommandeClients;
import ht.sys.sysgesbricolocal.dal.DalCommandeClients;
import ht.sys.sysgesbricolocal.domaine.CommandeClients;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Berling
 */
public class ControleurCommandeClients extends UnicastRemoteObject implements ICommandeClients{
    
    public ControleurCommandeClients() throws RemoteException {
    }
    CommandeClients ccl=new CommandeClients();
    @Override
     public void modifierNumerocommandeclients(String numerocommandeclients) throws RemoteException{
        ccl.setNumerocommandeclients(numerocommandeclients);
    }

    @Override
    public void modifierNomutilisateur(String nomutilisateur) throws RemoteException{
       ccl.setNomutilisateur(nomutilisateur);
    }

    @Override
    public void modifierNumeroclients(String numeroclients) throws RemoteException{
       ccl.setNumeroclients(numeroclients);
    }

    @Override
    public void modifierNumeroarticle(String numeroarticle) throws RemoteException{
        ccl.getNumeroarticle();
    }

    @Override
    public void modifierQuantite(int quantite) throws RemoteException{
        ccl.setQuantite(quantite);
    }

    @Override
    public void modifierPrix(Float prix) throws RemoteException{
        ccl.setPrix(prix);
    }

    @Override
    public void modifierTypecommande(String typecommande) throws RemoteException{
        ccl.getTypecommande();
    }

    @Override
    public void modifierDatecommande(String datecommande) throws RemoteException{
        ccl.setDatecommande(datecommande);
    }

    @Override
    public void modifierDatelivraison(String datelivraison) throws RemoteException{
        ccl.setDatelivraison(datelivraison);
    }

    @Override
    public String prendreNumerocommandeclients() throws RemoteException{
        return ccl.getNumerocommandeclients();
    }

    @Override
    public String prendreNomutilisateur() throws RemoteException{
        return ccl.getNomutilisateur();
    }

    @Override
    public String prendreNumeroclients() throws RemoteException{
        return ccl.getNumeroclients();
    }

    @Override
    public String prendreNumeroarticle() throws RemoteException{
        return ccl.getNumeroarticle();
    }

    @Override
    public int prendreQuantite() throws RemoteException{
        return ccl.getQuantite();
    }

    @Override
    public Float prendrePrix() throws RemoteException{
        return ccl.getPrix();
    }

    @Override
    public String prendreTypecommande() throws RemoteException{
        return ccl.getTypecommande();
    }

    @Override
    public String prendreDatecommande() throws RemoteException{
        return ccl.getDatecommande();
    }

    @Override
    public String prendreDatelivraison() throws RemoteException{
        return ccl.getDatelivraison();
    }
    
    @Override
    public String AjouterCommandeClient(String numerocommandeclients, String nomutilisateur, String numeroclients, String numeroarticle, int quantite, Float prix, String typecommande, String datecommande, String datelivraison) throws RemoteException {

        String message = null;
        message = DalCommandeClients.EnregistrerCommandClients(numerocommandeclients, nomutilisateur, numeroclients, numeroarticle, quantite, prix, typecommande, datecommande, datelivraison);

        return message;
    }

    @Override
    public Boolean RechercherCommandeClientModifier(String code) throws RemoteException {
        Boolean trouve = false;
        ccl = DalCommandeClients.RechercherCommandeClientsMod(code);
        if (ccl.getNumerocommandeclients().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
    
    @Override
     public Object[][] RechercherCommandeClient(String numero) throws RemoteException {
       Object[][] data;
        data = DalCommandeClients.RechercherCommandeClients(numero);
        return data;
    }
     
    @Override
      public String ModifierCommandeClient(String numerocommandeclients,int quantite, Float prix, String typecommande, String datecommande, String datelivraison) throws RemoteException {
        String message="";
        message =DalCommandeClients.ModifierCommandeClients(numerocommandeclients, quantite, prix, typecommande, datecommande, datelivraison);
        return message;
    }
    
    @Override
     public Object[][] RechercherCommandeClientParDate(String datecommande) throws RemoteException {
       Object[][] data;
        data = DalCommandeClients.RechercherCommandeClientsParDate(datecommande);
        return data;
    }
      
    @Override
     public Object[][] ListerCommandeClient(String numero) throws RemoteException {
       Object[][] data;
        data = DalCommandeClients.ListerCommandeClients();
        return data;
    }
     
}
