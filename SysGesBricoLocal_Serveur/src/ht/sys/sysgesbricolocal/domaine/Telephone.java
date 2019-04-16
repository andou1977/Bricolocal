/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class Telephone {
    private String numero;
   private String telephone;
   private String telephone1;
   private String telephone2;

    public Telephone(String numero) {
        this.numero = numero;
    }

    public Telephone() {
    }

    public Telephone(String numero, String telephone) {
        this.numero = numero;
        this.telephone = telephone;
    }

    public Telephone(String numero, String telephone, String telephone1, String telephone2) {
        this.numero = numero;
        this.telephone = telephone;
        this.telephone1 = telephone1;
        this.telephone2 = telephone2;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }
    
    

    public String getNumero() {
        return numero;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }
   
    
    
}
