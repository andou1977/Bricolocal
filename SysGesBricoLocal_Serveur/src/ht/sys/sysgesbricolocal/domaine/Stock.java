/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class Stock {

    private String numerostock;
    private String numeroarticle;
    private String dateajout;
    private int quantite;
    //pardon pour l'autre
    private float prix;

    public Stock() {
    }

    public Stock(String numerostock) {
        this.numerostock = numerostock;
    }

    public Stock(int quantite) {
        this.quantite = quantite;
    }
    

    public Stock(String numerostock, String numeroarticle, String dateajout, int quantite) {
        this.numerostock = numerostock;
        this.numeroarticle = numeroarticle;
        this.dateajout = dateajout;
        this.quantite = quantite;
    }

    public Stock(String numerostock, String numeroarticle, String dateajout, int quantite, float prix) {
        this.numerostock = numerostock;
        this.numeroarticle = numeroarticle;
        this.dateajout = dateajout;
        this.quantite = quantite;
        this.prix = prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setNumerostock(String numerostock) {
        this.numerostock = numerostock;
    }

    public void setNumeroarticle(String numeroarticle) {
        this.numeroarticle = numeroarticle;
    }

    public void setDateajout(String dateajout) {
        this.dateajout = dateajout;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Stock(String numeroarticle, String dateajout, int quantite) {
        this.numeroarticle = numeroarticle;
        this.dateajout = dateajout;
        this.quantite = quantite;
    }

    public String getNumerostock() {
        return numerostock;
    }

    public String getNumeroarticle() {
        return numeroarticle;
    }

    public String getDateajout() {
        return dateajout;
    }

    public int getQuantite() {
        return quantite;
    }

    public float getPrix() {
        return prix;
    }
    
    
}
