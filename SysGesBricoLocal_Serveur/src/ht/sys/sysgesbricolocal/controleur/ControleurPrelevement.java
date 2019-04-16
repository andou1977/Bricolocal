/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.controleur;

import ht.sys.sysgesbricolocal.amorce.IPrelevement;
import ht.sys.sysgesbricolocal.dal.DalPrelevement;
import ht.sys.sysgesbricolocal.domaine.Prelevement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Berling
 */
public class ControleurPrelevement extends UnicastRemoteObject implements IPrelevement {

    Prelevement pre = new Prelevement();

    public ControleurPrelevement() throws RemoteException {
    }

    @Override
    public void modifierNumeroprelevement(int numeroprelevement) throws RemoteException {
        pre.setNumeroprelevement(numeroprelevement);
    }

    @Override
    public void modifierTca(Float tca) throws RemoteException {
        pre.setTca(tca);
    }

    @Override
    public void modifierOna(Float ona) throws RemoteException {
        pre.setOna(ona);
    }

    @Override
    public void modifierSante(Float sante) throws RemoteException {
        pre.setSante(sante);
    }

    @Override
    public void modifierVie(Float vie) throws RemoteException {
        pre.setVie(vie);
    }

    @Override
    public void modifierMort(Float mort) throws RemoteException {
        pre.setMort(mort);
    }

    @Override
    public int prendreNumeroprelevement() throws RemoteException {
        return pre.getNumeroprelevement();
    }

    @Override
    public Float prendreTca() throws RemoteException {
        return pre.getTca();
    }

    @Override
    public Float prendreOna() throws RemoteException {
        return pre.getOna();
    }

    @Override
    public Float prendreSante() throws RemoteException {
        return pre.getSante();
    }

    @Override
    public Float prendreVie() throws RemoteException {
        return pre.getVie();
    }

    @Override
    public Float prendreMort() throws RemoteException {
        return pre.getMort();
    }

    @Override
    public String AjouterPrelevement(int numeroprelevement, Float tca, Float ona, Float sante, Float vie, Float mort) throws RemoteException {

        String message = null;
        message = DalPrelevement.EnregistrerPrelevement(numeroprelevement, tca, ona, sante, vie, mort);

        return message;
    }

    @Override
    public Boolean RechercherPrelevement() throws RemoteException {
        Boolean trouve = false;
        pre = DalPrelevement.RechercherPrelevement();
        if (pre.getNumeroprelevement() == 0) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }

    @Override
    public String ModifierPrelevement( Float tca, Float ona, Float sante, Float vie, Float mort) throws RemoteException {
        String message = "";
        message = DalPrelevement.ModifierPrelevement( tca, ona, sante, vie, mort);
        return message;
    }

    @Override
    public Object[][] ListerPrelevement(String numero) throws RemoteException {
        Object[][] data;
        data = DalPrelevement.ListerPrelevement();
        return data;
    }
}
