/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.controleur;

import ht.sys.sysgesbricolocal.amorce.IStock;
import ht.sys.sysgesbricolocal.dal.DalStock;
import ht.sys.sysgesbricolocal.domaine.Stock;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Berling
 */
public class ControleurStock extends UnicastRemoteObject implements IStock {

    Stock sto = new Stock();

    public ControleurStock() throws RemoteException {
    }

    @Override
    public void modifierNumerostock(String numerostock) throws RemoteException {
        sto.setNumerostock(numerostock);
    }

    @Override
    public void modifierNumeroarticle(String numeroarticle) throws RemoteException {
        sto.setNumeroarticle(numeroarticle);
    }

    @Override
    public void modifierDateajout(String dateajout) throws RemoteException {
        sto.setDateajout(dateajout);
    }

    @Override
    public void modifierQuantite(int quantite) throws RemoteException {
        sto.setQuantite(quantite);
        
    }
    @Override
    public void modifierPrix(float p) throws RemoteException {
        sto.setPrix(p);
}
    @Override
    public float prendrePrix() throws RemoteException {
        return sto.getPrix();
    }
    @Override
    public String prendreNumerostock() throws RemoteException {
        return sto.getNumerostock();
    }

    @Override
    public String prendreNumeroarticle() throws RemoteException {
        return sto.getNumeroarticle();
    }

    @Override
    public String prendreDateajout() throws RemoteException {
        return sto.getDateajout();
    }

    @Override
    public int prendreQuantite() throws RemoteException {
        return sto.getQuantite();
    }

    @Override
    public String AjouterStock(String numerostock, String numeroarticle, String dateajout, int quantitet) throws RemoteException {

        String message = null;
        message = DalStock.EnregistrerStock(numerostock, numeroarticle, dateajout, quantitet);

        return message;
    }

    @Override
    public Boolean RechercherStock(String code) throws RemoteException {
        Boolean trouve = false;
        sto = DalStock.RechercherStock(code);
        if (sto.getNumerostock().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }

    @Override
    public String ModifierStock(String numeroarticle, int quantite) throws RemoteException {
        String message = "";
        message = DalStock.ModifierStock(numeroarticle, quantite);
        return message;
    }
    
    @Override
    public String ModifierStockA(String numeroarticle, int quantite) throws RemoteException {
        String message = "";
        message = DalStock.ModifierStockA(numeroarticle, quantite);
        return message;
    }

    @Override
    public String SupprimerStock(String numeroarticle) throws RemoteException {
        String message = "";
        message = DalStock.SupprimerStock(numeroarticle);
        return message;
    }

    @Override
    public Object[][] ListerStock(String numero) throws RemoteException {
        Object[][] data;
        data = DalStock.ListerStock();
        return data;
    }
}
