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
public interface IArticle extends Remote {

    public void modifierNumerofournisseur(String numerofournisseur) throws RemoteException;

    public void modifierNumeroarticle(String numeroarticle) throws RemoteException;

    public void modifierLibelle(String libelle) throws RemoteException;

    public void modifierCategorie(String categorie) throws RemoteException;

    public void modifierPrixarticle(Float prixarticle) throws RemoteException;

    public String prendreNumerofournisseur() throws RemoteException;

    public String prendreNumeroarticle() throws RemoteException;

    public String prendreLibelle() throws RemoteException;

    public String prendreCategorie() throws RemoteException;

    public Float prendrePrixarticle() throws RemoteException;

    public String AjouterArticle(String numerofournisseur, String numeroarticle, String libelle, String categorie, Float prixarticle) throws RemoteException;

    public Boolean RechercherArticleModifier(String code) throws RemoteException;

    public Object[][] RechercherArticle(String code) throws RemoteException;

    public String ModifierArticle(String numerofournisseur, String code, String libelle, String categorie, Float prix) throws RemoteException;

    public Object[][] ChargerLibelleArticle() throws RemoteException;

    public Object[][] ListerArticle() throws RemoteException;
    
    public Object[][] ChargerNomArticle() throws RemoteException ;
}
