/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persons;

import Trwalosc.ObjectPlus;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/************************************************************************
Opis : Klasa do tworzenia kontraktów
Stworzone przez : Dominik Deja (dddeja@wp.pl)
data swtorzenia : 2017-03-30
************************************************************************/

/**
 *
 * @author Dominik Deja
 */
public class Kontrakt extends ObjectPlus {
   
    
    private Date poczatekKontraktu;
    private Date koniecKontraktu;
    private double zarobkiMiesieczne;
    
    
    public Kontrakt(Date _poczatekKontraktu,Date _koniecKontraktu,double _zarobkiMiesieczne){
        poczatekKontraktu = _poczatekKontraktu;
        koniecKontraktu = _koniecKontraktu;
        zarobkiMiesieczne = _zarobkiMiesieczne;
    }
    
    public Double wyliczKontrakt(){
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(poczatekKontraktu);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(koniecKontraktu);

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

    return zarobkiMiesieczne * diffMonth;
    }

    public Date getPoczatekKontraktu() {
        return poczatekKontraktu;
    }

    public void setPoczatekKontraktu(Date poczatekKontraktu) {
        this.poczatekKontraktu = poczatekKontraktu;
    }

    public Date getKoniecKontraktu() {
        return koniecKontraktu;
    }

    public void setKoniecKontraktu(Date koniecKontraktu) {
        this.koniecKontraktu = koniecKontraktu;
    }

    public double getZarobki() {
        return zarobkiMiesieczne;
    }

    public void setZarobki(double zarobki) {
        this.zarobkiMiesieczne = zarobki;
    }
    
    
}
