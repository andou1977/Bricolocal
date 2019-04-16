/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.controleur;

import ht.sys.sysgesbricolocal.amorce.IClients;
import ht.sys.sysgesbricolocal.dal.DalClients;
import ht.sys.sysgesbricolocal.domaine.Client;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Berling
 */
public class ControleurClients extends UnicastRemoteObject implements IClients{
    Client cli=new Client();
    public ControleurClients() throws RemoteException {
    }
 
    @Override
     public void modifierNumeroClients(String numeroClients) throws RemoteException{
        cli.setNumeroClients(numeroClients);
    }

    @Override
    public void modifierNom(String nom) throws RemoteException{
        cli.setNom(nom);
    }

    @Override
    public void modifierTelephone(String telephone) throws RemoteException{
        cli.setTelephone(telephone);
    }
 @Override
    public void modifierAdresse(String adresse) throws RemoteException{
        cli.setAdresse(adresse);
    }

    @Override
    public void modifierEmail(String email) throws RemoteException{
        cli.setEmail(email);
    }

    @Override
    public String prendreNumeroClients() throws RemoteException{
        return cli.getNumeroClients();
    }

    @Override
    public String prendreNom() throws RemoteException{
        return cli.getNom();
    }

    @Override
    public String prendreTelephone() throws RemoteException{
        return cli.getTelephone();
    }

    @Override
    public String prendreAdresse() throws RemoteException{
        return cli.getAdresse();
    }

    @Override
    public String prendreEmail() throws RemoteException{
        return cli.getEmail();
    }

    @Override
    public String AjouterClient(String numeroClients, String nom, String adresse, String telephone, String email) throws RemoteException {

        String message = null;
        message = DalClients.EnregistrerClient(numeroClients, nom, adresse, telephone, email);
        return message;
    }

    @Override
    public Boolean RechercherClient(String code) throws RemoteException {
        Boolean trouve = false;
        cli = DalClients.RechercherClient(code);
        if (cli.getNumeroClients().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
    
    @Override
      public String ModifierClient(String numeroClients, String nom, String adresse, String telephone, String email) throws RemoteException {
        String message="";
        message =DalClients.ModifierClient(numeroClients, nom, adresse, telephone, email);
        return message;
    }
   
      
    @Override
     public Object[][] ListerClient() throws RemoteException {
       Object[][] data;
        data = DalClients.ListerClient();
        return data;
    }
     
    
}
