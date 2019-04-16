/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.controleur;

import ht.sys.sysgesbricolocal.amorce.IPayroll;
import ht.sys.sysgesbricolocal.dal.DalPayroll;
import ht.sys.sysgesbricolocal.domaine.Payroll;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Rose
 */
public class ControleurPayroll extends UnicastRemoteObject implements IPayroll {

    Payroll pay = new Payroll();

    public ControleurPayroll() throws RemoteException {
    }

    @Override
    public void modifierNumeropayroll(String numeropayroll) throws RemoteException {
        pay.setNumeropayroll(numeropayroll);
    }

    @Override
    public void modifierNumeroemploye(String numeroemploye) throws RemoteException {
        pay.setNumeroemploye(numeroemploye);
    }

    @Override
    public void modifierMoispaye(String moispaye) throws RemoteException {
        pay.setMoispaye(moispaye);
    }

    @Override
    public void modifierDatepayroll(String datepayroll) throws RemoteException {
        pay.setDatepayroll(datepayroll);
    }

    @Override
    public void modifierTaxe(float taxe) throws RemoteException {
        pay.setTaxe(taxe);
    }

    @Override
    public void modifierSalairebrut(float salairebrut) throws RemoteException {
        pay.setSalairebrut(salairebrut);
    }

    @Override
    public void modifierSalairenet(float salairenet) throws RemoteException {
        pay.setSalairenet(salairenet);
    }

    @Override
    public String prendreNumeropayroll() throws RemoteException {
        return pay.getNumeropayroll();
    }

    @Override
    public String prendreNumeroemploye() throws RemoteException {
        return pay.getNumeroemploye();
    }

    @Override
    public String prendreMoispaye() throws RemoteException {
        return pay.getMoispaye();
    }

    @Override
    public String prendreDatepayroll() throws RemoteException {
        return pay.getDatepayroll();
    }

    @Override
    public float prendreTaxe() throws RemoteException {
        return pay.getTaxe();
    }

    @Override
    public float prendreSalairebrut() throws RemoteException {
        return pay.getSalairebrut();
    }

    @Override
    public float prendreSalairenet() throws RemoteException {
        return pay.getSalairenet();
    }

    @Override
    public String AjouterPayroll(String numeropayroll, String numeroemploye, String moispaye, String datepayroll, float taxe,String annee) throws RemoteException {

        String message = null;
        message = DalPayroll.EnregistrerPayroll(numeropayroll, numeroemploye, moispaye, datepayroll, taxe,annee);
        return message;
    }

    @Override
    public Object[][] PreparerPayroll(String mois) throws RemoteException {
        Object[][] data;
        data = DalPayroll.PreparerPayroll(mois);
        return data;
    }

    @Override
    public Object[][] ChargerMois() throws RemoteException {
        Object[][] data;
        data = DalPayroll.ChargerMois();
        return data;
    }

    @Override
    public Object[][] ChargerDatePayroll() throws RemoteException {
        Object[][] data;
        data = DalPayroll.ChargerDatePayroll();
        return data;
    }

    @Override
    public Object[][]ListerPayrollParIndice(String ind) throws RemoteException {
        Object[][] data;
        data = DalPayroll.ListerPayrollParIndice(ind);
        return data;
    }

    @Override
    public Object[][] ListerPayroll() throws RemoteException {
        Object[][] data;
        data = DalPayroll.ListerPayroll();
        return data;
    }
    
     @Override
    public String codePayroll() throws RemoteException{
     String message = null;
     message = DalPayroll.CodePayroll();
      return message;
      
    }
     
       @Override
    public String RechercherPayroll(String mois,String annee) throws RemoteException {
        String message = null;
     message = DalPayroll.RechercherPayroll(mois, annee);
      return message;
    }
}
