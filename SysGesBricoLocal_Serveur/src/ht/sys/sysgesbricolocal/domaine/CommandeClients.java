/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class CommandeClients {
  private String numerocommandeclients;
  private String nomutilisateur;
  private String numeroclients;
  private String numeroarticle;
  private int quantite;
  private Float prix;
  private String typecommande;
  private String datecommande;
  private String datelivraison;  

    public CommandeClients() {
    }

    public CommandeClients(String numerocommandeclients) {
        this.numerocommandeclients = numerocommandeclients;
    }

    public CommandeClients(String numerocommandeclients, String nomutilisateur) {
        this.numerocommandeclients = numerocommandeclients;
        this.nomutilisateur = nomutilisateur;
    }

    public CommandeClients(int quantite, Float prix, String typecommande, String datecommande, String datelivraison) {
        this.quantite = quantite;
        this.prix = prix;
        this.typecommande = typecommande;
        this.datecommande = datecommande;
        this.datelivraison = datelivraison;
    }
    
    

    public CommandeClients(String numerocommandeclients, String nomutilisateur, String numeroclients, String numeroarticle, int quantite, Float prix, String typecommande, String datecommande, String datelivraison) {
        this.numerocommandeclients = numerocommandeclients;
        this.nomutilisateur = nomutilisateur;
        this.numeroclients = numeroclients;
        this.numeroarticle = numeroarticle;
        this.quantite = quantite;
        this.prix = prix;
        this.typecommande = typecommande;
        this.datecommande = datecommande;
        this.datelivraison = datelivraison;
    }

    public void setNumerocommandeclients(String numerocommandeclients) {
        this.numerocommandeclients = numerocommandeclients;
    }

    public void setNomutilisateur(String nomutilisateur) {
        this.nomutilisateur = nomutilisateur;
    }

    public void setNumeroclients(String numeroclients) {
        this.numeroclients = numeroclients;
    }

    public void setNumeroarticle(String numeroarticle) {
        this.numeroarticle = numeroarticle;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public void setTypecommande(String typecommande) {
        this.typecommande = typecommande;
    }

    public void setDatecommande(String datecommande) {
        this.datecommande = datecommande;
    }

    public void setDatelivraison(String datelivraison) {
        this.datelivraison = datelivraison;
    }

    public String getNumerocommandeclients() {
        return numerocommandeclients;
    }

    public String getNomutilisateur() {
        return nomutilisateur;
    }

    public String getNumeroclients() {
        return numeroclients;
    }

    public String getNumeroarticle() {
        return numeroarticle;
    }

    public int getQuantite() {
        return quantite;
    }

    public Float getPrix() {
        return prix;
    }

    public String getTypecommande() {
        return typecommande;
    }

    public String getDatecommande() {
        return datecommande;
    }

    public String getDatelivraison() {
        return datelivraison;
    }
   
    
   
}
