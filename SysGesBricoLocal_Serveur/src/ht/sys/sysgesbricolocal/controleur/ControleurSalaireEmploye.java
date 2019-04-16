/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.controleur;

import ht.sys.sysgesbricolocal.amorce.ISalaireEmploye;
import ht.sys.sysgesbricolocal.dal.DalSalaireEmploye;
import ht.sys.sysgesbricolocal.domaine.SalaireEmploye;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Berling
 */
public class ControleurSalaireEmploye extends UnicastRemoteObject implements ISalaireEmploye {

    SalaireEmploye sal = new SalaireEmploye();

    public ControleurSalaireEmploye() throws RemoteException {
    }

    @Override
    public void modifierNumeroemploye(String numeroemploye) throws RemoteException {
        sal.setNumeroemploye(numeroemploye);
    }

    @Override
    public void modifierSalaire(Float salaire) throws RemoteException {
        sal.setSalaire(salaire);
    }

    @Override
    public String prendreNumeroemploye() throws RemoteException {
        return sal.getNumeroemploye();
    }

    @Override
    public Float prendreSalaire() throws RemoteException {
        return sal.getSalaire();
    }

    @Override
    public String AjouterSalaireEmploye(String numeroemploye, Float salaire) throws RemoteException {

        String message = null;
        message = DalSalaireEmploye.EnregistrerSalaireEmploye(numeroemploye, salaire);
        return message;
    }

    @Override
    public Boolean RechercherSalaireEmployeModifier(String numero) throws RemoteException {
        Boolean trouve = false;
        sal = DalSalaireEmploye.RechercherSalaireEmployeModififier(numero);
        if (sal.getNumeroemploye().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }

    @Override
    public Object[][] RechercherSalaireEmploye(String numero) throws RemoteException {
        Object[][] data;
        data = DalSalaireEmploye.RechercherSalaireEmploye(numero);
        return data;
    }

    @Override
    public String ModifierSalaireEmploye(String numeroemploye, Float salaire) throws RemoteException {
        String message = "";
        message = DalSalaireEmploye.ModifierSalaireEmploye(numeroemploye, salaire);
        return message;
    }

    @Override
    public Object[][] ListerSalaireEmploye(String numero) throws RemoteException {
        Object[][] data;
        data = DalSalaireEmploye.ListerSalaireEmploye();
        return data;
    }
}
