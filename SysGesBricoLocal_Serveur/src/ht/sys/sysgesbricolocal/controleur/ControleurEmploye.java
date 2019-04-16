/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.controleur;

import ht.sys.sysgesbricolocal.amorce.IEmploye;
import ht.sys.sysgesbricolocal.dal.DalEmploye;
import ht.sys.sysgesbricolocal.domaine.Employe;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Berling
 */
public class ControleurEmploye extends UnicastRemoteObject implements IEmploye{
    Employe emp=new Employe();
    
    
    public ControleurEmploye() throws RemoteException {
    }
    
    @Override
    public void modifierNumeroemploye(String numeroemploye) throws RemoteException{
        emp.setNumeroemploye(numeroemploye);
    }

    @Override
    public void modifierNom(String nom) throws RemoteException{
        emp.setNom(nom);
    }

    @Override
    public void modifierPrenom(String prenom) throws RemoteException{
        emp.setPrenom(prenom);
    }

    @Override
    public void modifierSexe(String sexe) throws RemoteException{
        emp.setSexe(sexe);
    }

    @Override
    public void modifierNif(String nif) throws RemoteException{
        emp.setNif(nif);
    }

    @Override
    public void modifierDatenaissance(String datenaissance) throws RemoteException{
        emp.setDatenaissance(datenaissance);
    }

    @Override
    public void modifierAdresse(String adresse) throws RemoteException{
        emp.setAdresse(adresse);
    }

    @Override
    public void modifierDateembauche(String dateembauche) throws RemoteException{
        emp.setDateembauche(dateembauche);
    }

    @Override
    public void modifierNumerodepartement(String numerodepartement) throws RemoteException{
        emp.setNumerodepartement(numerodepartement);
    }

    @Override
    public void modifierFonction(String fonction) throws RemoteException{
        emp.setFonction(fonction);
    }

    @Override
    public String prendreNumeroemploye() throws RemoteException{
        return emp.getNumeroemploye();
    }

    @Override
    public String prendreNom() throws RemoteException{
        return emp.getNom();
    }

    @Override
    public String prendrePrenom() throws RemoteException{
        return emp.getPrenom();
    }

    @Override
    public String prendreSexe() throws RemoteException{
        return emp.getSexe();
    }

    @Override
    public String prendreNif() throws RemoteException{
        return emp.getNif();
    }

    @Override
    public String prendreDatenaissance() throws RemoteException{
        return emp.getDatenaissance();
    }

    @Override
    public String prendreAdresse() throws RemoteException{
        return emp.getAdresse();
    }

    @Override
    public String prendreDateembauche() throws RemoteException{
        return emp.getDateembauche();
    }

    @Override
    public String prendreNumerodepartement() throws RemoteException{
        return emp.getNumerodepartement();
    }

    @Override
    public String prendreFonction() throws RemoteException{
        return emp.getFonction();
    }
    
    
    @Override
    public String AjouterEmploye( String numeroemploye,String nom, String prenom, String sexe, String nif, String datenaissance, String adresse, String dateembauche, String numerodepartement, String fonction) throws RemoteException {

        String message = null;
        message = DalEmploye.EnregistrerEmploye(numeroemploye, nom, prenom, sexe, nif, datenaissance, adresse, dateembauche, numerodepartement, fonction);
        return message;
    }

    @Override
    public Boolean RechercherEmployeModifier(String code) throws RemoteException {
        Boolean trouve = false;
        emp = DalEmploye.RechercherEmployeModifier(code);
        if (emp.getNumeroemploye().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
    
    @Override
     public Object[][] RechercherEmploye(String numero) throws RemoteException {
       Object[][] data;
        data = DalEmploye.RechercherEmploye(numero);
        return data;
    }
     
    @Override
      public String ModifierEmploye(String numeroemploye, String nom, String prenom, String sexe, String nif, String datenaissance, String adresse, String dateembauche, String numerodepartement, String fonction) throws RemoteException {
        String message="";
        message =DalEmploye.ModifierEmploye(numeroemploye, nom, prenom, sexe, nif, datenaissance, adresse, dateembauche, numerodepartement, fonction);
        return message;
    }
    
    
      
    @Override
     public Object[][] ListerEmploye() throws RemoteException {
       Object[][] data;
        data = DalEmploye.ListerEmploye();
        return data;
    }
    @Override
    public Object[][] ChargerNumeroEmploye() throws RemoteException {
       Object[][] data;
        data = DalEmploye.ChargerNumeroEmploye();
        return data;
    }
    
    @Override
    public Object[][] RechercherEmployeUtil(String num) throws RemoteException {
       Object[][] data;
        data = DalEmploye.RechercherEmployeUtil(num);
        return data;
    }
    
}
