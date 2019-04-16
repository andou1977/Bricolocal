/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.controleur;

import ht.sys.sysgesbricolocal.amorce.ICategorie;
import ht.sys.sysgesbricolocal.dal.DalCategorie;
import ht.sys.sysgesbricolocal.domaine.Categorie;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Berling
 */
public class ControleurCategorie extends UnicastRemoteObject implements ICategorie{
   Categorie cat=new Categorie();
    public ControleurCategorie() throws RemoteException {
    }
    @Override
    public void modifierNumerocategorie(String numerocategorie) throws RemoteException {
        cat.setNumerocategorie(numerocategorie);
    }

    @Override
    public void modifierDescription(String description) throws RemoteException {
        cat.setDescription(description);
    }

    @Override
    public void modifierDate_ajout(String date_ajout) throws RemoteException {
        cat.setDate_ajout(date_ajout);
    }

    @Override
    public String prendreNumerocategorie() throws RemoteException {
        return cat.getNumerocategorie();
    }

    @Override
    public String prendreDescription() throws RemoteException {
        return cat.getDescription();
    }

    @Override
    public String prendreDate_ajout() throws RemoteException {
        return cat.getDate_ajout();
    }
    
    @Override
    public String AjouterCategorie(String numerocategorie, String description, String date_ajout) throws RemoteException {

        String message = null;
        message = DalCategorie.EnregistrerCategorie(numerocategorie,description,date_ajout);

        return message;
    }

  
    @Override
    public Boolean RechercherCategorie(String code) throws RemoteException {
        Boolean trouve = false;
        cat = DalCategorie.RechercherCategorie(code);
        if (cat.getNumerocategorie().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
  
     @Override
    public Object[][] ListerCategorie() throws RemoteException {
        Object[][] data;
        data = DalCategorie.ListerCategorie();
        return data;
    }
    
  @Override
    public Object[][] ChargerCategorie() throws RemoteException {
        Object[][] data;
        data = DalCategorie.ChargerCategorie();
        return data;
    }
     

    @Override
      public String ModifierCategorie(String numerocategorie, String description) throws RemoteException {
        String message="";
        message =DalCategorie.ModifierCategorie(numerocategorie,description);
        return message;
    }
    
    @Override
    public String SuprimmerCategorie(String numero)throws RemoteException{
    String message="";
    message=DalCategorie.SupprimerCategorie(numero);
    return message;
}
    
}
