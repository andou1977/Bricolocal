/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.controleur;

import ht.sys.sysgesbricolocal.amorce.IUtilisateur;
import ht.sys.sysgesbricolocal.dal.DalUtilisateur;
import ht.sys.sysgesbricolocal.domaine.Utilisateur;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Berling
 */
public class ControleurUtilisateur extends UnicastRemoteObject implements IUtilisateur {
    
    Utilisateur util = new Utilisateur();
    
    public ControleurUtilisateur() throws RemoteException {
    }
    
    @Override
    public void modifierNumeroemploye(String numeroemploye) throws RemoteException {
        util.setNumeroemploye(numeroemploye);
    }
    
    @Override
    public void modifierNomutilisateur(String nomutilisateur) throws RemoteException {
        util.setNomutilisateur(nomutilisateur);
    }
    
    @Override
    public void modifierMotdepasse(String motdepasse) throws RemoteException {
        util.setMotdepasse(motdepasse);
    }
    
    @Override
    public void modifierEtatutilisateur(String etatutilisateur) throws RemoteException {
        util.setEtatutilisateur(etatutilisateur);
    }
    
    @Override
    public void modifierEtatconnexion(String etatconnexion) throws RemoteException {
        util.setEtatconnexion(etatconnexion);
    }
    
    @Override
    public void modifierNommachine(String nommachine) throws RemoteException {
        util.setNommachine(nommachine);
    }
    
    @Override
    public void modifierAdressemachine(String adressemachine) throws RemoteException {
        util.setAdressemachine(adressemachine);
    }
    @Override
    public void modifierRoleUtilisateur(String role) throws RemoteException {
        util.setAdressemachine(role);
    }
    
    @Override
    public String prendreNumeroemploye() throws RemoteException {
        return util.getNumeroemploye();
    }
    
    @Override
    public String prendreNomutilisateur() throws RemoteException {
        return util.getNomutilisateur();
    }
    
    @Override
    public String prendreMotdepasse() throws RemoteException {
        return util.getMotdepasse();
    }
    
    @Override
    public String prendreEtatutilisateur() throws RemoteException {
        return util.getEtatutilisateur();
    }
    
    @Override
    public String prendreEtatconnexion() throws RemoteException {
        return util.getEtatconnexion();
    }
    
    @Override
    public String prendreNommachine() throws RemoteException {
        return util.getNommachine();
    }
    
    @Override
    public String prendreAdressemachine() throws RemoteException {
        return util.getAdressemachine();
    }
    @Override
    public String prendreRoleUtilisateur() throws RemoteException {
        return util.getRole();
    }
    
    @Override
    public String AjouterUtilisateur(String numeroemploye, String nomutilisateur, String motdepasse, String etatutilisateur, String role) throws RemoteException {
        
        String message = null;
        message = DalUtilisateur.EnregistrerUtilisateur(numeroemploye, nomutilisateur, motdepasse, etatutilisateur, role);
        
        return message;
    }
    
      @Override
    public String Tracabilite(String nomutilisateur,String tableaffectee,String action,String numeroentite,String date,String heure,String nommachine,String adressemachine) throws RemoteException {
        
        String message = null;
        message = DalUtilisateur.Tracabilite(nomutilisateur, tableaffectee, action, numeroentite, date, heure, nommachine, adressemachine);
        
        return message;
    }
    
    @Override
    public Boolean RechercherUtilisateur(String nomutilisateur) throws RemoteException {
        Boolean trouve = false;
        util = DalUtilisateur.RechercherUtilisateur(nomutilisateur);
        if (util.getNomutilisateur().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
    
    @Override
    public Boolean RechercherMotDePasseUtilisateur(String nomutilisateur,String motdepasse) throws RemoteException {
        Boolean trouve = false;
        util = DalUtilisateur.RechercherMotdePasseUtilisateur(nomutilisateur,motdepasse);
        if (util.getNomutilisateur().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
    
    @Override
    public String ModifierEtatUtilisateur(String nomutilisateur, String etatutilisateur) throws RemoteException {
        String message = "";
        message = DalUtilisateur.ModifierEtatUtilisateur(nomutilisateur, etatutilisateur);
        return message;
    }
    
    @Override
    public String ModifierEtatConnexion(String nomutilisateur, String etatconnexion, String nommachine, String adressemachine) throws RemoteException {
        String message = "";
        message = DalUtilisateur.ModifierEtatConnexion(nomutilisateur, etatconnexion, nommachine, adressemachine);
        return message;
    }
    
    @Override
    public String ModifierMotDEPasseUtilisateur(String nomutilisateur, String motdepasse) throws RemoteException {
        String message = "";
        message = DalUtilisateur.ModifierMotDEPasseUtilisateur(nomutilisateur, motdepasse);
        return message;
    }
    // {
    @Override
   public String ModifierUtilisateur(String numeroemploye,String nomutilisateur,String motdepasse,String role,String etatutilisateur) throws RemoteException {
        String message = "";
        message = DalUtilisateur.ModifierUtilisateur(numeroemploye, nomutilisateur, motdepasse, role, etatutilisateur);
        return message;
    }
    @Override
    public Object[][] ListerUtilisateur() throws RemoteException {
        Object[][] data;
        data = DalUtilisateur.ListerUtilisateur();
        return data;
    }
    @Override
    public Object[][] ListerUtilisateur1() throws RemoteException {
        Object[][] data;
        data = DalUtilisateur.ListerUtilisateur1();
        return data;
    }
    
        @Override
    public Object[][] ListerUtilisateurParIndice(String indicederecherche) throws RemoteException {
        Object[][] data;
        data = DalUtilisateur.ListerUtilisateurParIndice(indicederecherche);
        return data;
    }
    @Override
    public Object[][] ListerUtilisateurParIndice1(String indicederecherche) throws RemoteException {
        Object[][] data;
        data = DalUtilisateur.ListerUtilisateurParIndice1(indicederecherche);
        return data;
    }
    @Override
     public Object[][] ChargerNomUtilisateur() throws RemoteException {
        Object[][] data;
        data = DalUtilisateur.ChargerNomUtilisateur();
        return data;
    }
    
    @Override
    public Object[][] ListerTracee() throws RemoteException {
        Object[][] data;
        data = DalUtilisateur.ListerTracee();
        return data;
    }
    
        @Override
    public Object[][] ListerTracabiliteParIndice(String indicederecherche) throws RemoteException {
        Object[][] data;
        data = DalUtilisateur.ListerTracabiliteParIndice(indicederecherche);
        return data;
    }
	
	     @Override
     public Object[][] ChargerNomUtilisateurTracee() throws RemoteException {
        Object[][] data;
        data = DalUtilisateur.ChargerNomUtilisateurTracee();
        return data;
    }
         
          @Override
     public Object[][] ChargerTableAffectee() throws RemoteException {
        Object[][] data;
        data = DalUtilisateur.ChargerTableAffectee();
        return data;
    }
          
           @Override
     public Object[][] ChargerDateTracee() throws RemoteException {
        Object[][] data;
        data = DalUtilisateur.ChargerDateTracee();
        return data;
    }
           
            @Override
     public Object[][] ChargerAction() throws RemoteException {
        Object[][] data;
        data = DalUtilisateur.ChargerAction();
        return data;
    }
   
}
