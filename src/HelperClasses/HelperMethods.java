/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/************************************************************************
Opis : Klasa do trzymania przydatnych statycznych metod
Stworzone przez : Dominik Deja (dddeja@wp.pl)
data swtorzenia : 2017-03-30
************************************************************************/

/**
 *
 * @author Dominik Deja
 */
public class HelperMethods {
    
    public static Date getDateFromString(String dtSt) throws Exception{
         
     Date date1 = null;
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dtSt);
        } catch (ParseException ex) {
            throw new Exception();
        }
     
     return date1;
    }
    
    public static String convertDateToString(Date indate) throws Exception 
{
   String dateString = null;
   SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
   /*you can also use DateFormat reference instead of SimpleDateFormat 
    * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
    */
   try{
	dateString = sdfr.format( indate );
   }catch (Exception ex ){
	throw new Exception();
   }
   return dateString;
}
}
