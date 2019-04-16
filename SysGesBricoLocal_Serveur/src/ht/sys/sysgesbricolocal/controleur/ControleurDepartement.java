/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.controleur;

import ht.sys.sysgesbricolocal.amorce.IDepartement;
import ht.sys.sysgesbricolocal.dal.DalDepartement;
import ht.sys.sysgesbricolocal.domaine.Departement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Berling
 */
public class ControleurDepartement extends UnicastRemoteObject implements IDepartement {

    Departement dep = new Departement();

    public ControleurDepartement() throws RemoteException {
    }

    @Override
    public void modifierNumerodepartement(String numerodepartement) throws RemoteException {
        dep.setNumerodepartement(numerodepartement);
    }

    @Override
    public void modifierDepartement(String Departement) throws RemoteException {
        dep.setDepartement(Departement);
    }

    @Override
    public String prendreNumerodepartement() throws RemoteException {
        return dep.getNumerodepartement();
    }

    @Override
    public String prendreDepartement() throws RemoteException {
        return dep.getDepartement();
    }

    @Override
    public String AjouterDepartement(String numerodepartement, String Departement) throws RemoteException {

        String message = null;
        message = DalDepartement.EnregistrerDepartement(numerodepartement, Departement);

        return message;
    }

    @Override
    public Boolean RechercherDepartement(String numero) throws RemoteException {
        Boolean trouve = false;
        dep = DalDepartement.RechercherDepartement(numero);
        if (dep.getNumerodepartement().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }

    @Override
    public String ModifierDepartement(String numerodepartement, String Departement) throws RemoteException {
        String message = "";
        message = DalDepartement.ModifierDepartement(message, Departement);
        return message;
    }

    @Override
    public String SuprimmerDepartement(String numero) throws RemoteException {
        String message = "";
        message = DalDepartement.SupprimerDepartement(numero);
        return message;
    }

    @Override
    public Object[][] ChargerDepartement() throws RemoteException {
        Object[][] data;
        data = DalDepartement.ChargerDepartement();
        return data;
    }
}
