/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.controleur;

import ht.sys.sysgesbricolocal.amorce.IArticle;
import ht.sys.sysgesbricolocal.dal.DalArticle;
import ht.sys.sysgesbricolocal.domaine.Article;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Berling
 */
public class ControleurArticle extends UnicastRemoteObject implements IArticle {

    Article art = new Article();

    public ControleurArticle() throws RemoteException {
    }

    @Override
    public void modifierNumerofournisseur(String numeroartrnisseur) throws RemoteException {
        art.setNumerofournisseur(numeroartrnisseur);
    }

    @Override
    public void modifierNumeroarticle(String numeroarticle) throws RemoteException {
        art.setNumeroarticle(numeroarticle);
    }

    @Override
    public void modifierLibelle(String libelle) throws RemoteException {
        art.setLibelle(libelle);
    }

    @Override
    public void modifierCategorie(String categorie) throws RemoteException {
        art.setCategorie(categorie);
    }

    @Override
    public void modifierPrixarticle(Float prixarticle) throws RemoteException {
        art.setPrixarticle(prixarticle);
    }

    @Override
    public String prendreNumerofournisseur() throws RemoteException {
        return art.getNumerofournisseur();
    }

    @Override
    public String prendreNumeroarticle() throws RemoteException {
        return art.getNumeroarticle();
    }

    @Override
    public String prendreLibelle() throws RemoteException {
        return art.getLibelle();
    }

    @Override
    public String prendreCategorie() throws RemoteException {
        return art.getCategorie();
    }

    @Override
    public Float prendrePrixarticle() throws RemoteException {
        return art.getPrixarticle();
    }

    @Override
    public String AjouterArticle(String numeroartrnisseur, String numeroarticle, String libelle, String categorie, Float prixarticle) throws RemoteException {

        String message = null;
        message = DalArticle.EnregistrerArticle(numeroartrnisseur, numeroarticle, libelle, categorie, prixarticle);
        return message;
    }

    @Override
    public Boolean RechercherArticleModifier(String code) throws RemoteException {
        Boolean trouve = false;
        art = DalArticle.RechercherArticleModifier(code);
        if (art.getNumeroarticle().isEmpty()) {
            trouve = false;
        } else {
            trouve = true;
        }
        return trouve;
    }

 

    @Override
    public Object[][] RechercherArticle(String code) throws RemoteException {
        Object[][] data;
        data = DalArticle.RechercherArticle(code);
        return data;
    }

    @Override
    public String ModifierArticle(String numerofournisseur,String code, String libelle, String categorie, Float prix) throws RemoteException {
        String message = "";
        message = DalArticle.ModifierArticle(numerofournisseur, code, libelle, categorie, prix);
        return message;
    }

    @Override
    public Object[][] ChargerLibelleArticle() throws RemoteException {
        Object[][] data;
        data = DalArticle.ChargerLibelleArticle();
        return data;
    }

    @Override
    public Object[][] ListerArticle() throws RemoteException {
        Object[][] data;
        data = DalArticle.ListerArticle();
        return data;
    }
    @Override
    public Object[][] ChargerNomArticle() throws RemoteException {
        Object[][] data;
        data = DalArticle.ChargerNomArticle();
        return data;
}
}
