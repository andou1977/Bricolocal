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
public interface IFonction extends Remote {

    public void modifierNumerofonction(int numerofonction) throws RemoteException;

    public void modifierNombreemploye(int nombreemploye) throws RemoteException;

    public void modifierFonction(String fonction) throws RemoteException;

    public int prendreNumerofonction() throws RemoteException;

    public String prendreFonction() throws RemoteException;

    public int prendreNombreemploye() throws RemoteException;

    public String AjouterFonction(int numerofonction, String fonction, int nombreemploye) throws RemoteException;

    public Boolean RechercherFonctionModifier(String fonction) throws RemoteException;

    public String ModifierFonction(String fonction, int quantiteemploye, int numerofonction) throws RemoteException;

    public Object[][] ListerFonction() throws RemoteException;

    public Object[][] ChargerFonction() throws RemoteException;

    public String SuprimmerFonction(String fonction) throws RemoteException;

    public Boolean RechercherQuantiteFonction(String fonction) throws RemoteException;

    public Boolean RechercherQuantiteFonctionEmp(String fonction) throws RemoteException;
}
