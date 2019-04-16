/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.controleur;


import ht.sys.sysgesbricolocal.amorce.IEmail;
import ht.sys.sysgesbricolocal.dal.DalEmail;
import ht.sys.sysgesbricolocal.domaine.Email;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Berling
 */
public class ControleurEmail extends UnicastRemoteObject implements IEmail {
    
    Email tel = new Email();
    
    public ControleurEmail() throws RemoteException {
    }
    
    @Override
    public void modifierNumero(String numero) throws RemoteException {
        tel.setNumero(numero);
    }
    
    @Override
    public void modifierEmail(String email) throws RemoteException {
        tel.setEmail(email);
    }
    
    @Override
    public void modifierEmail1(String email1) throws RemoteException {
        tel.setEmail1(email1);
    }
    
    @Override
    public void modifierEmail2(String email2) throws RemoteException {
        tel.setEmail2(email2);
    }
    
    @Override
    public String prendreNumero() throws RemoteException {
        return tel.getNumero();
    }
    
    @Override
    public String prendreEmail() throws RemoteException {
        return tel.getEmail();
    }
    
    @Override
    public String prendreEmail1() throws RemoteException {
        return tel.getEmail1();
    }
    
    @Override
    public String prendreEmail2() throws RemoteException {
        return tel.getEmail2();
    }

    @Override
    public String AjouterEmailFournisseur(String numero, String email, String email1, String email2) throws RemoteException {
        
        String message = null;
        message = DalEmail.EnregistrerEmailFournisseur(numero, email, email1, email2);
        
        return message;
    }
     @Override
     public String AjouterEmailEmploye(String numero, String email, String email1, String email2) throws RemoteException {
        
        String message = null;
        message = DalEmail.EnregistrerEmailEmploye(numero, email, email1, email2);
        
        return message;
    }
     @Override
      public String AjouterEmailClients(String numero, String email, String email1, String email2) throws RemoteException {
        
        String message = null;
        message = DalEmail.EnregistrerEmailClients(numero, email, email1, email2);
        
        return message;
    }
    @Override
    public Boolean RechercherEmailFournisseur(String numero) throws RemoteException {
        Boolean trouve = false;
        tel = DalEmail.RechercherEmailFournisseur(numero);
        if (tel.getNumero().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
    
    @Override
    public Boolean RechercherEmailEmploye(String numero) throws RemoteException {
        Boolean trouve = false;
        tel = DalEmail.RechercherEmailEmploye(numero);
        if (tel.getNumero().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
    
    @Override
    public Boolean RechercherEmailClients(String numero) throws RemoteException {
        Boolean trouve = false;
        tel = DalEmail.RechercherEmailClients(numero);
        if (tel.getNumero().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
    
    @Override
    public String ModifierEmailFournisseur(String numero, String email, String email1, String email2) throws RemoteException {
        String message = null;
        message = DalEmail.ModifierEmailFournisseur(numero, email, email1, email2);
        return message;
    }
    
    @Override
    public String ModifierEmailEmploye(String numero, String email, String email1, String email2) throws RemoteException {
        String message = null;
        message = DalEmail.ModifierEmailEmploye(numero, email, email1, email2);
        return message;
    }
    
     @Override
    public String ModifierEmailClients(String numero, String email, String email1, String email2) throws RemoteException {
        String message = null;
        message = DalEmail.ModifierEmailClients(numero, email, email1, email2);
        return message;
    }
    
    @Override
    public String SupprimerEmailFournisseur(String numero) throws RemoteException {
        String message = null;
        message = DalEmail.SupprimerEmailFournisseur(numero);
        return message;
    }
    
    @Override
    public String SupprimerEmailEmploye(String numero) throws RemoteException {
        String message = null;
        message = DalEmail.SupprimerEmailEmploye(numero);
        return message;
    }
    
    @Override
    public String SupprimerEmailClients(String numero) throws RemoteException {
        String message = null;
        message = DalEmail.SupprimerEmailClients(numero);
        return message;
    }
}
