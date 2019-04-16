/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.servicetechnique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rose
 */
public class Service {
    
    private static Connection con = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement pr = null;
    private static Connection con1 = null;
    private static Statement st1 = null;
    private static ResultSet rs1 = null;
    private final static String ad="127.0.0.1";
    private final static String db="bricolocal";
    private final static String ut="root";
    private final static String passe="rose";
    public   static void variable(String adresse,String db,String utilisateur,String motpasse){
    
    }
    //Chaine de connexion
    protected static String chaine = "jdbc:mysql://"+ad+"/"+db+"?user="+ut+"&password="+passe+""; 
    
    //public static String chaine = "jdbc:Mysql://localhost/bricolocal?user=root&password=rose";
    
    //Methode permettant de capter la date du jour
    public static String datedujour(){
     
	Date dateactuelle = new Date();

//	* Definition du format utilise pour les dates
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd h:mm:ss");
        String date = dateFormat.format(dateactuelle);
        return date;
}
    public static String  dateJ=""+datedujour().toString();
    //fin methode de la date
    
    public static String CodeAleatoire(){
    
       String codegenere = "";
        String genererCode = "012345678901234567890123456789";
        int i;
        Random gn = new java.util.Random();

        for (int j = 0; j < 3; j++) {
            i = gn.nextInt(genererCode.length());

            codegenere += genererCode.charAt(i);
        }
        return codegenere;
    }
   
     public static String  Code=""+CodeAleatoire();
     
     public static int recherchercode(String nomtable){
         int modifier=0;
         try {
          
        con=DriverManager.getConnection(chaine);
               st=con.createStatement();
               //1111111111111111111111111111111111111111111111111
               rs = st.executeQuery("select * from "+nomtable+"");

               while (rs.next()) {
                   modifier = rs.getInt(1) + 1;
                   
               }
               
               con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        
               return modifier;
     }
     
     public static void requetemodifiercode(String nomta,String nomch, int val){
        try {
            con = DriverManager.getConnection(chaine);
              st = con.createStatement();
              st.executeUpdate("update "+nomta+" set "+nomch+"='"+val+"'");
              con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
    
}
