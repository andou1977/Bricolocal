/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class Utilisateur {

    private String numeroemploye;
    private String nomutilisateur;
    private String motdepasse;
    private String etatutilisateur;
    private String etatconnexion;
    private String nommachine;
    private String adressemachine;
    private String role;

    public Utilisateur() {
    }

    public Utilisateur(String numeroemploye) {
        this.numeroemploye = numeroemploye;
    }

    public Utilisateur(String nomutilisateur, String motdepasse) {
        this.nomutilisateur = nomutilisateur;
        this.motdepasse = motdepasse;
    }

    public Utilisateur(String numeroemploye, String nomutilisateur, String motdepasse, String etatutilisateur, String role) {
        this.numeroemploye = numeroemploye;
        this.nomutilisateur = nomutilisateur;
        this.motdepasse = motdepasse;
        this.etatutilisateur = etatutilisateur;
        this.role = role;
    }
    

    public Utilisateur(String numeroemploye, String nomutilisateur, String motdepasse, String etatutilisateur, String etatconnexion, String nommachine, String adressemachine, String role) {
        this.numeroemploye = numeroemploye;
        this.nomutilisateur = nomutilisateur;
        this.motdepasse = motdepasse;
        this.etatutilisateur = etatutilisateur;
        this.etatconnexion = etatconnexion;
        this.nommachine = nommachine;
        this.adressemachine = adressemachine;
        this.role = role;
    }

    public Utilisateur(String nomutilisateur, String etatutilisateur, String etatconnexion, String nommachine, String adressemachine, String role) {
        this.nomutilisateur = nomutilisateur;
        this.etatutilisateur = etatutilisateur;
        this.etatconnexion = etatconnexion;
        this.nommachine = nommachine;
        this.adressemachine = adressemachine;
        this.role=role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setNumeroemploye(String numeroemploye) {
        this.numeroemploye = numeroemploye;
    }

    public void setNomutilisateur(String nomutilisateur) {
        this.nomutilisateur = nomutilisateur;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public void setEtatutilisateur(String etatutilisateur) {
        this.etatutilisateur = etatutilisateur;
    }

    public void setEtatconnexion(String etatconnexion) {
        this.etatconnexion = etatconnexion;
    }

    public void setNommachine(String nommachine) {
        this.nommachine = nommachine;
    }

    public void setAdressemachine(String adressemachine) {
        this.adressemachine = adressemachine;
    }

    public String getNumeroemploye() {
        return numeroemploye;
    }

    public String getNomutilisateur() {
        return nomutilisateur;
    }

    public String getRole() {
        return role;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public String getEtatutilisateur() {
        return etatutilisateur;
    }

    public String getEtatconnexion() {
        return etatconnexion;
    }

    public String getNommachine() {
        return nommachine;
    }

    public String getAdressemachine() {
        return adressemachine;
    }
}
