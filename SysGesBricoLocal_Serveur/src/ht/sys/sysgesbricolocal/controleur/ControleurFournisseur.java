/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.controleur;

import ht.sys.sysgesbricolocal.amorce.IFournisseur;
import ht.sys.sysgesbricolocal.dal.DalFournisseur;
import ht.sys.sysgesbricolocal.domaine.Fournisseur;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Berling
 */
public class ControleurFournisseur extends UnicastRemoteObject implements IFournisseur {

    Fournisseur fou = new Fournisseur();

    public ControleurFournisseur() throws RemoteException {
    }

    @Override
    public void modifierNumerofournisseur(String numerofournisseur) throws RemoteException {
        fou.setNumerofournisseur(numerofournisseur);
    }

    @Override
    public void modifierNom(String nom) throws RemoteException {
        fou.setNom(nom);
    }

    @Override
    public void modifierAdresse(String adresse) throws RemoteException {
        fou.setAdresse(adresse);
    }

    @Override
    public void modifierDateajout(String dateajout) throws RemoteException {
        fou.setDateajout(dateajout);
    }

    @Override
    public String prendreNumerofournisseur() throws RemoteException {
        return fou.getNumerofournisseur();
    }

    @Override
    public String prendreNom() throws RemoteException {
        return fou.getNom();
    }

    @Override
    public String prendreAdresse() throws RemoteException {
        return fou.getAdresse();
    }

    @Override
    public String prendreDateajout() throws RemoteException {
        return fou.getDateajout();
    }

    @Override
    public String AjouterFournisseur(String numerofournisseur, String nom, String adresse, String dateajout) throws RemoteException {

        String message = "";
        message = DalFournisseur.EnregistrerFournisseur(numerofournisseur, nom, adresse, dateajout);

        return message;
    }

    @Override
    public Boolean RechercherFournisseurParNumero(String numero) throws RemoteException {
        Boolean trouve = false;
        fou = DalFournisseur.RechercherFournisseurParNumero(numero);
        if (fou.getNumerofournisseur().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
    
     @Override
    public Boolean RechercherFournisseurParNom(String nom) throws RemoteException {
        Boolean trouve = false;
        fou = DalFournisseur.RechercherFournisseurParNom(nom);
        if (fou.getNom().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }
 

    @Override
    public String ModifierFournisseur(String numerofournisseur, String nom, String adresse, String dateajout) throws RemoteException {
        String message = "";
        message = DalFournisseur.ModifierFournisseur(numerofournisseur, nom, adresse, dateajout);
        return message;
    }

    @Override
    public Object[][] ListerFournisseur() throws RemoteException {
        Object[][] data;
        data = DalFournisseur.ListerFournisseur();
        return data;
    }
    
     @Override
    public Object[][] ChargerFournisseur() throws RemoteException {
        Object[][] data;
        data = DalFournisseur.ListerFournisseur();
        return data;
    }

    @Override
    public String SuprimmerFournisseur(String numero) throws RemoteException {
        String message = "";
        message = DalFournisseur.SupprimerFournisseur(numero);
        return message;
    }
}
