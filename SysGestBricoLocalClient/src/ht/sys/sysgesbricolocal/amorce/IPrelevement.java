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
public interface IPrelevement extends Remote {

    public void modifierNumeroprelevement(int numeroprelevement) throws RemoteException;

    public void modifierTca(Float tca) throws RemoteException;

    public void modifierOna(Float ona) throws RemoteException;

    public void modifierSante(Float sante) throws RemoteException;

    public void modifierVie(Float vie) throws RemoteException;

    public void modifierMort(Float mort) throws RemoteException;

    public int prendreNumeroprelevement() throws RemoteException;

    public Float prendreTca() throws RemoteException;

    public Float prendreOna() throws RemoteException;

    public Float prendreSante() throws RemoteException;

    public Float prendreVie() throws RemoteException;

    public Float prendreMort() throws RemoteException;

    public String AjouterPrelevement(int numeroprelevement, Float tca, Float ona, Float sante, Float vie, Float mort) throws RemoteException;

    public Boolean RechercherPrelevement() throws RemoteException;

    public String ModifierPrelevement( Float tca, Float ona, Float sante, Float vie, Float mort) throws RemoteException;

    public Object[][] ListerPrelevement(String numero) throws RemoteException;
}
