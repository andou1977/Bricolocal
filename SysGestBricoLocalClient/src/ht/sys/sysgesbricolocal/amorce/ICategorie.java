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
public interface ICategorie extends Remote {

    public void modifierNumerocategorie(String numerocategorie) throws RemoteException;

    public void modifierDescription(String description) throws RemoteException;

    public void modifierDate_ajout(String date_ajout) throws RemoteException;

    public String prendreNumerocategorie() throws RemoteException;

    public String prendreDescription() throws RemoteException;

    public String prendreDate_ajout() throws RemoteException;

    public String AjouterCategorie(String numerocategorie, String description, String date_ajout) throws RemoteException;

    public Boolean RechercherCategorie(String code) throws RemoteException;

    public String ModifierCategorie(String numerocategorie, String description) throws RemoteException;

    public String SuprimmerCategorie(String numero) throws RemoteException;

    public Boolean RechercherCodeCategorie() throws RemoteException;

    public Object[][] ListerCategorie() throws RemoteException;

    public Object[][] ChargerCategorie() throws RemoteException;
}
