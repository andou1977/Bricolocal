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
public interface IDepartement extends Remote {

    public void modifierNumerodepartement(String numerodepartement) throws RemoteException;

    public void modifierDepartement(String Departement) throws RemoteException;

    public String prendreNumerodepartement() throws RemoteException;

    public String prendreDepartement() throws RemoteException;

    public String AjouterDepartement(String numerodepartement, String Departement) throws RemoteException;

    public Boolean RechercherDepartement(String numero) throws RemoteException;

    public String ModifierDepartement(String numerodepartement, String Departement) throws RemoteException;

    public String SuprimmerDepartement(String numero) throws RemoteException;

    public Object[][] ChargerDepartement() throws RemoteException;
}
