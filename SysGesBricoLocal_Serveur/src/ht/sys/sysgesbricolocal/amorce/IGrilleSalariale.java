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
public interface IGrilleSalariale extends Remote {

    public void modifierFonction(String fonction) throws RemoteException;

    public void modifierSalaireminimal(Float salaireminimal) throws RemoteException;

    public void modifierSalairemaximal(Float Salairemaximal) throws RemoteException;

    public String prendreFonction() throws RemoteException;

    public Float prendreSalaireminimal() throws RemoteException;

    public Float prendreSalairemaximal() throws RemoteException;

    public String AjouterGrilleSalariale(String fonction, Float salaireminimal, Float Salairemaximal) throws RemoteException;

    public Boolean RechercherGrilleSalariale(String fonction) throws RemoteException;

    public String ModifierGrilleSalariale(String fonction, Float salaireminimal, Float Salairemaximal) throws RemoteException;

    public String SupprimerGrilleSalariale(String fonction) throws RemoteException;

    public Object[][] ListerGrilleSalariale(String numero) throws RemoteException;
}
