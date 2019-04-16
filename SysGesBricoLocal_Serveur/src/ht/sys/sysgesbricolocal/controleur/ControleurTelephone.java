/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.controleur;


import ht.sys.sysgesbricolocal.amorce.ITelephone;
import ht.sys.sysgesbricolocal.dal.DalTelephone;
import ht.sys.sysgesbricolocal.domaine.Telephone;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Berling
 */
public class ControleurTelephone extends UnicastRemoteObject implements ITelephone {
    
    Telephone tel = new Telephone();
    
    public ControleurTelephone() throws RemoteException {
    }
    
    @Override
    public void modifierNumero(String numero) throws RemoteException {
        tel.setNumero(numero);
    }
    
    @Override
    public void modifierTelephone(String telephone) throws RemoteException {
        tel.setTelephone(telephone);
    }
    
    @Override
    public void modifierTelephone1(String telephone1) throws RemoteException {
        tel.setTelephone1(telephone1);
    }
    
    @Override
    public void modifierTelephone2(String telephone2) throws RemoteException {
        tel.setTelephone2(telephone2);
    }
    
    @Override
    public String prendreNumero() throws RemoteException {
        return tel.getNumero();
    }
    
    @Override
    public String prendreTelephone() throws RemoteException {
        return tel.getTelephone();
    }
    
    @Override
    public String prendreTelephone1() throws RemoteException {
        return tel.getTelephone1();
    }
    
    @Override
    public String prendreTelephone2() throws RemoteException {
        return tel.getTelephone2();
    }

    @Override
    public String AjouterTelephoneFournisseur(String numero, String telephone, String telephone1, String telephone2) throws RemoteException {
        
        String message = null;
        message = DalTelephone.EnregistrerTelephoneFournisseur(numero, telephone, telephone1, telephone2);
        
        return message;
    }
     @Override
     public String AjouterTelephoneEmploye(String numero, String telephone, String telephone1, String telephone2) throws RemoteException {
        
        String message = null;
        message = DalTelephone.EnregistrerTelephoneEmploye(numero, telephone, telephone1, telephone2);
        
        return message;
    }
     @Override
      public String AjouterTelephoneClients(String numero, String telephone, String telephone1, String telephone2) throws RemoteException {
        
        String message = null;
        message = DalTelephone.EnregistrerTelephoneClients(numero, telephone, telephone1, telephone2);
        
        return message;
    }
    @Override
    public Boolean RechercherTelephoneFournisseur(String numero) throws RemoteException {
        Boolean trouve = false;
        tel = DalTelephone.RechercherTelephoneFournisseur(numero);
        if (tel.getNumero().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
    
    @Override
    public Boolean RechercherTelephoneEmploye(String numero) throws RemoteException {
        Boolean trouve = false;
        tel = DalTelephone.RechercherTelephoneEmploye(numero);
        if (tel.getNumero().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
    
    @Override
    public Boolean RechercherTelephoneClients(String numero) throws RemoteException {
        Boolean trouve = false;
        tel = DalTelephone.RechercherTelephoneClients(numero);
        if (tel.getNumero().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
    
    @Override
    public String ModifierTelephoneFournisseur(String numero, String telephone, String telephone1, String telephone2) throws RemoteException {
        String message = null;
        message = DalTelephone.ModifierTelephoneFournisseur(numero, telephone, telephone1, telephone2);
        return message;
    }
    
    @Override
    public String ModifierTelephoneEmploye(String numero, String telephone, String telephone1, String telephone2) throws RemoteException {
        String message = null;
        message = DalTelephone.ModifierTelephoneEmploye(numero, telephone, telephone1, telephone2);
        return message;
    }
    
     @Override
    public String ModifierTelephoneClients(String numero, String telephone, String telephone1, String telephone2) throws RemoteException {
        String message = null;
        message = DalTelephone.ModifierTelephoneClients(numero, telephone, telephone1, telephone2);
        return message;
    }
    
    @Override
    public String SupprimerTelephoneFournisseur(String numero) throws RemoteException {
        String message = null;
        message = DalTelephone.SupprimerTelephoneFournisseur(numero);
        return message;
    }
    
    @Override
    public String SupprimerTelephoneEmploye(String numero) throws RemoteException {
        String message = null;
        message = DalTelephone.SupprimerTelephoneEmploye(numero);
        return message;
    }
    
    @Override
    public String SupprimerTelephoneClients(String numero) throws RemoteException {
        String message = null;
        message = DalTelephone.SupprimerTelephoneClients(numero);
        return message;
    }
}
