/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.amorce;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Berling
 */
public interface ISalaireEmploye extends Remote {

    public void modifierNumeroemploye(String numeroemploye) throws RemoteException;

    public void modifierSalaire(Float salaire) throws RemoteException;

    public String prendreNumeroemploye() throws RemoteException;

    public Float prendreSalaire() throws RemoteException;

    public String AjouterSalaireEmploye(String numeroemploye, Float salaire) throws RemoteException;

    public Boolean RechercherSalaireEmployeModifier(String numero) throws RemoteException;

    public Object[][] RechercherSalaireEmploye(String numero) throws RemoteException;

    public String ModifierSalaireEmploye(String numeroemploye, Float salaire) throws RemoteException;

    public Object[][] ListerSalaireEmploye(String numero) throws RemoteException;
}
