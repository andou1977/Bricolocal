/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class Client {
  private String  numeroClients;
  private String  nom;
  private String  adresse;
  private String telephone;
  private String  email;

    public Client() {
    }
  
  

    public Client(String numeroClients) {
        this.numeroClients = numeroClients;
    }

    public Client(String numeroClients, String nom, String adresse, String telephone, String email) {
        this.numeroClients = numeroClients;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }

    public void setNumeroClients(String numeroClients) {
        this.numeroClients = numeroClients;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroClients() {
        return numeroClients;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

  
  
    
}
