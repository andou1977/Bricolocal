/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.controleur;

import ht.sys.sysgesbricolocal.amorce.IFonction;
import ht.sys.sysgesbricolocal.dal.DalFonction;
import ht.sys.sysgesbricolocal.domaine.Fonction;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Berling
 */
public class ControleurFonction extends UnicastRemoteObject implements IFonction {

    Fonction fon = new Fonction();

    public ControleurFonction() throws RemoteException {
    }

    @Override
    public void modifierNumerofonction(int numerofonction) throws RemoteException {
        fon.setNumerofonction(numerofonction);
    }

    @Override
    public void modifierNombreemploye(int nombreemploye) throws RemoteException {
        fon.setNombreemploye(nombreemploye);
    }

    @Override
    public void modifierFonction(String fonction) throws RemoteException {
        fon.setFonction(fonction);
    }

    @Override
    public int prendreNumerofonction() throws RemoteException {
        return fon.getNumerofonction();
    }

    @Override
    public String prendreFonction() throws RemoteException {
        return fon.getFonction();
    }

    @Override
    public int prendreNombreemploye() throws RemoteException {
        return fon.getNombreemploye();
    }

    @Override
    public String AjouterFonction(int numerofonction, String fonction, int nombreemploye) throws RemoteException {

        String message = null;
        message = DalFonction.EnregistrerFonction(numerofonction, fonction, nombreemploye);

        return message;
    }

    @Override
    public Boolean RechercherFonctionModifier(String fonction) throws RemoteException {
        Boolean trouve = false;
        fon = DalFonction.RechercherFonction(fonction);
        if (fon.getFonction().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }

    @Override
    public String ModifierFonction(String fonction, int quantiteemploye, int numerofonction) throws RemoteException {
        String message = "";
        message = DalFonction.ModifierFonction(fonction, quantiteemploye, numerofonction);
        return message;
    }

    @Override
    public Object[][] ListerFonction() throws RemoteException {
        Object[][] data;
        data = DalFonction.ListerFonction();
        return data;
    }

    @Override
    public Object[][] ChargerFonction() throws RemoteException {
        Object[][] data;
        data = DalFonction.ChargerFonction();
        return data;
    }

    @Override
    public String SuprimmerFonction(String fonction) throws RemoteException {
        String message = "";
        message = DalFonction.SupprimerFonction(fonction);
        return message;
    }
    
     @Override
    public Boolean RechercherQuantiteFonction(String fonction) throws RemoteException {
        Boolean trouve = false;
        fon = DalFonction.rechercherquantitefonc(fonction);
        if (fon.getFonction().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
        @Override
    public Boolean RechercherQuantiteFonctionEmp(String fonction) throws RemoteException {
        Boolean trouve = false;
        fon = DalFonction.RechercherQuantiteFonctionEmp(fonction);
        if (fon.getFonction().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
}
