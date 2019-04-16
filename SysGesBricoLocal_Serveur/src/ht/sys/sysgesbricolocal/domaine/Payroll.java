/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class Payroll {
    private String numeropayroll;
    private String numeroemploye;
    private String moispaye;
    private String datepayroll;
    private float taxe;
    private float salairebrut;
    private float salairenet;
    private String annee;

    public Payroll() {
    }

    public Payroll(String numeropayroll) {
        this.numeropayroll = numeropayroll;
    }

    public Payroll(String numeropayroll, String numeroemploye, String moispaye, String datepayroll, float taxe, String annee) {
        this.numeropayroll = numeropayroll;
        this.numeroemploye = numeroemploye;
        this.moispaye = moispaye;
        this.datepayroll = datepayroll;
        this.taxe = taxe;
        this.annee = annee;
    }

    public Payroll(String moispaye, String datepayroll, String annee) {
        this.moispaye = moispaye;
        this.datepayroll = datepayroll;
        this.annee=annee;
    }

    public void setNumeropayroll(String numeropayroll) {
        this.numeropayroll = numeropayroll;
    }

    public void setNumeroemploye(String numeroemploye) {
        this.numeroemploye = numeroemploye;
    }

    public void setMoispaye(String moispaye) {
        this.moispaye = moispaye;
    }

    public void setDatepayroll(String datepayroll) {
        this.datepayroll = datepayroll;
    }

    public void setTaxe(float taxe) {
        this.taxe = taxe;
    }

    public void setSalairebrut(float salairebrut) {
        this.salairebrut = salairebrut;
    }

    public void setSalairenet(float salairenet) {
        this.salairenet = salairenet;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getNumeropayroll() {
        return numeropayroll;
    }

    public String getNumeroemploye() {
        return numeroemploye;
    }

    public String getMoispaye() {
        return moispaye;
    }

    public String getDatepayroll() {
        return datepayroll;
    }

    public float getTaxe() {
        return taxe;
    }

    public float getSalairebrut() {
        return salairebrut;
    }

    public float getSalairenet() {
        return salairenet;
    }

    public String getAnnee() {
        return annee;
    }
    
    
    
    
    
    
    
    
}
