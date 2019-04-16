 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicetechnique;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Rose
 */
public class Service {

    //public static String chaine = "jdbc:Mysql://localhost/bricolocal?user=root&password=rose";
    
    //Methode permettant de capter la date du jour
    public static String datedujour(){
     
	Date dateactuelle = new Date();

//	* Definition du format utilise pour les dates
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy h:mm:ss",Locale.FRANCE);

        String date = dateFormat.format(dateactuelle);
        return date;
}
     public static String  dateJ=""+datedujour().toString();
     
        public static String anneedatedujour(){
     
	Date dateactuelle = new Date();

//	* Definition du format utilise pour les dates
	DateFormat dateFormat = new SimpleDateFormat("yyyy",Locale.FRANCE);

        String date = dateFormat.format(dateactuelle);
        return date;
}
    public static String  annee=""+anneedatedujour().toString();
    
      public static String date(){
     
	Date dateactuelle = new Date();

//	* Definition du format utilise pour les dates
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy",Locale.FRANCE);

        String date = dateFormat.format(dateactuelle);
        return date;
}
       public static String  date1=""+date().toString();
      
     public static String heure(){
     
	Date dateactuelle = new Date();

	DateFormat dateFormat = new SimpleDateFormat("H:m:s",Locale.FRANCE);

        String date = dateFormat.format(dateactuelle);
        return date;
}
     public static String  heure1=""+heure().toString();
     
     
     

public static String patternnom="^[A-Za-z][a-z]+[/-]?[']?[ ]?[A-za-z]+$";
public static String  patternprenom="^[A-Za-z][a-z]+[/-]?[']?[ ]?[A-za-z]+$";
public static String  patterntelephone="^[2-4][0-9][0-9]{2}[0-9]{4}$";
public static String patternemail= "^[a-zA-Z0-9_.-]+@{1}[za-zA-Z.]{2,}\\.[za-zA-Z0-9_.-]{2,3}$";
//^[a-zA-Z0-9_.-]+@{1}[za-zA-Z.]{2,}\\.[za-zA-Z0-9_.-]{2,3}$";
public static String paternprix="^([1-9]{5}\\.[0-9])+$";

    
}
