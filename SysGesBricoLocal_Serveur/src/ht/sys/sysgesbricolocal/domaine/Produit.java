/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

import java.rmi.RemoteException;

/**
 *
 * @author Rose
 */
public class Produit {
   private String code;
   private String libelle;
   private Float prix;
   private int quantite;
   

    public Produit() throws RemoteException{
    }

    public Produit( String code,String libelle, Float prix, int quantite) {
        this.libelle = libelle;
        this.prix = prix;
        this.quantite = quantite;
        this.code=code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getCode() {
        return code;
    }

    
    public String getLibelle() {
        return libelle;
    }

    public Float getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

   
  
   
   
}