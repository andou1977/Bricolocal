/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class Email {

   private String numero;
   private String email;
   private String email1;
   private String email2;

    public Email(String numero) {
        this.numero = numero;
    }

    public Email() {
    }

    public Email(String numero, String email) {
        this.numero = numero;
        this.email = email;
    }

    public Email(String numero, String email, String email1, String email2) {
        this.numero = numero;
        this.email = email;
        this.email1 = email1;
        this.email2 = email2;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }
    
    

    public String getNumero() {
        return numero;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }
 
}
