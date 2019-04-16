/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.controleur;

import ht.sys.sysgesbricolocal.amorce.IGrilleSalariale;
import ht.sys.sysgesbricolocal.dal.DalGrilleSalariale;
import ht.sys.sysgesbricolocal.domaine.GrilleSalariale;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Berling
 */
public class ControleurGrilleSalariale extends UnicastRemoteObject implements IGrilleSalariale{

    
    GrilleSalariale gri=new GrilleSalariale();
    public ControleurGrilleSalariale() throws RemoteException {
    }
    
     public void modifierFonction(String fonction) throws RemoteException {
        gri.setFonction(fonction);
    }

    public void modifierSalaireminimal(Float salaireminimal) throws RemoteException {
       gri.setSalaireminimal(salaireminimal);
    }

    public void modifierSalairemaximal(Float Salairemaximal) throws RemoteException {
        gri.setSalairemaximal(Salairemaximal);
    }

    public String prendreFonction() throws RemoteException {
        return gri.getFonction();
    }

    public Float prendreSalaireminimal() throws RemoteException {
        return gri.getSalaireminimal();
    }

    public Float prendreSalairemaximal() throws RemoteException {
        return gri.getSalairemaximal();
    }
    
    @Override
    public String AjouterGrilleSalariale(String fonction, Float salaireminimal, Float Salairemaximal) throws RemoteException {

        String message = null;
        message = DalGrilleSalariale.EnregistrerGrillerSalariale(fonction, salaireminimal, Salairemaximal);

        return message;
    }

    @Override
    public Boolean RechercherGrilleSalariale(String fonction) throws RemoteException {
        Boolean trouve = false;
        gri= DalGrilleSalariale.RechercherGrilleSalariale(fonction);
        if (gri.getFonction().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
    
   
     
    @Override
      public String ModifierGrilleSalariale(String fonction, Float salaireminimal, Float Salairemaximal) throws RemoteException {
        String message="";
        message =DalGrilleSalariale.ModifierGrilleSalariale(fonction, salaireminimal, Salairemaximal);
        return message;
    }
    
     public String SupprimerGrilleSalariale(String fonction) throws RemoteException {
        String message="";
        message =DalGrilleSalariale.SupprimerGrilleSalariale(fonction);
        return message;
    }
    
      
    @Override
     public Object[][] ListerGrilleSalariale(String numero) throws RemoteException {
       Object[][] data;
        data = DalGrilleSalariale.ListerGrilleSalariale();
        return data;
    }
    
}
