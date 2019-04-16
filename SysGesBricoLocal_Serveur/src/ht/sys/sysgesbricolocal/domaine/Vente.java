/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class Vente {
    private String numerovente;
    private String numeroarticle;
    private String numeroClients;
    private int quantite;
    private float montant;
    private String datevente ;
    private String nomutilisateur;
    
    
    public Vente() {
    }

    public Vente(String numerovente) {
        this.numerovente = numerovente;
    }

    public Vente(String numerovente, String numeroarticle) {
        this.numerovente = numerovente;
        this.numeroarticle = numeroarticle;
    }

    public Vente(String numerovente, String numeroarticle, String numeroClients, int quantite, float montant, String datevente, String nomutilisateur) {
        this.numerovente = numerovente;
        this.numeroarticle = numeroarticle;
        this.numeroClients = numeroClients;
        this.quantite = quantite;
        this.montant = montant;
        this.datevente = datevente;
        this.nomutilisateur = nomutilisateur;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    
    

    public void setNumerovente(String numerovente) {
        this.numerovente = numerovente;
    }

    public void setNumeroarticle(String numeroarticle) {
        this.numeroarticle = numeroarticle;
    }

    public void setNumeroClients(String numeroClients) {
        this.numeroClients = numeroClients;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    
    

    public void setDatevente(String datevente) {
        this.datevente = datevente;
    }

    public void setNomutilisateur(String nomutilisateur) {
        this.nomutilisateur = nomutilisateur;
    }

    public String getNumerovente() {
        return numerovente;
    }

    public String getNumeroarticle() {
        return numeroarticle;
    }

    public String getNumeroClients() {
        return numeroClients;
    }

    public int getQuantite() {
        return quantite;
    }
    public float getMontant() {
        return montant;
    }

    public String getDatevente() {
        return datevente;
    }

    public String getNomutilisateur() {
        return nomutilisateur;
    }
    
    

}
