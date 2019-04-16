/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class CommandeFournisseur {
      private String numerocommandefournisseur;
      private String nomutilisateur; 
      private String description;
      private String typecommande;
      private String datelivraison;
      private int quantite;
      private Float prix;
      private String datecommande;  

    public CommandeFournisseur() {
    }

    public CommandeFournisseur(String numerocommandefournisseur) {
        this.numerocommandefournisseur = numerocommandefournisseur;
    }

    public CommandeFournisseur(String numerocommandefournisseur, String nomutilisateur, String description, String typecommande, String datelivraison, int quantite, Float prix, String datecommande) {
        this.numerocommandefournisseur = numerocommandefournisseur;
        this.nomutilisateur = nomutilisateur;
        this.description = description;
        this.typecommande = typecommande;
        this.datelivraison = datelivraison;
        this.quantite = quantite;
        this.prix = prix;
        this.datecommande = datecommande;
    }

    public void setNumerocommandefournisseur(String numerocommandefournisseur) {
        this.numerocommandefournisseur = numerocommandefournisseur;
    }

    public void setNomutilisateur(String nomutilisateur) {
        this.nomutilisateur = nomutilisateur;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTypecommande(String typecommande) {
        this.typecommande = typecommande;
    }

    public void setDatelivraison(String datelivraison) {
        this.datelivraison = datelivraison;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public void setDatecommande(String datecommande) {
        this.datecommande = datecommande;
    }

    public String getNumerocommandefournisseur() {
        return numerocommandefournisseur;
    }

    public String getNomutilisateur() {
        return nomutilisateur;
    }

    public String getDescription() {
        return description;
    }

    public String getTypecommande() {
        return typecommande;
    }

    public String getDatelivraison() {
        return datelivraison;
    }

    public int getQuantite() {
        return quantite;
    }

    public Float getPrix() {
        return prix;
    }

    public String getDatecommande() {
        return datecommande;
    }
      
      
}
