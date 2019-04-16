/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.amorce;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Rose
 */
public interface IPayroll extends Remote {

    public void modifierNumeropayroll(String numeropayroll) throws RemoteException;

    public void modifierNumeroemploye(String numeroemploye) throws RemoteException;

    public void modifierMoispaye(String moispaye) throws RemoteException;

    public void modifierDatepayroll(String datepayroll) throws RemoteException;

    public void modifierTaxe(float taxe) throws RemoteException;

    public void modifierSalairebrut(float salairebrut) throws RemoteException;

    public void modifierSalairenet(float salairenet) throws RemoteException;

    public String prendreNumeropayroll() throws RemoteException;

    public String prendreNumeroemploye() throws RemoteException;

    public String prendreMoispaye() throws RemoteException;

    public String prendreDatepayroll() throws RemoteException;

    public float prendreTaxe() throws RemoteException;

    public float prendreSalairebrut() throws RemoteException;

    public float prendreSalairenet() throws RemoteException;

    public String AjouterPayroll(String numeropayroll, String numeroemploye, String moispaye, String datepayroll, float taxe, String annee) throws RemoteException;

    public Object[][] PreparerPayroll(String mois) throws RemoteException;

    public Object[][] ChargerMois() throws RemoteException;

    public Object[][] ChargerDatePayroll() throws RemoteException;

    public Object[][] ListerPayrollParIndice(String ind) throws RemoteException;

    public Object[][] ListerPayroll() throws RemoteException;

    public String codePayroll() throws RemoteException;

    public  String RechercherPayroll(String mois, String annee) throws RemoteException;
}
