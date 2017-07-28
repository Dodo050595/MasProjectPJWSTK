/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persons;

import java.util.Date;


/************************************************************************
Opis : Klasa do tworzenia lekarzy
Stworzone przez : Dominik Deja (dddeja@wp.pl)
data swtorzenia : 2017-03-30
************************************************************************/

/**
 *
 * @author Dominik Deja
 */
public class Lekarz extends Person{
    
    public static enum RodzajLekarza{
        Rechabilitant,Masazysta,Pierwszego_kontaktu,Dietetyk
    }
    
    private RodzajLekarza lekRodz;

    public RodzajLekarza getLekRodz() {
        return lekRodz;
    }

    public void setLekRodz(RodzajLekarza lekRodz) {
        this.lekRodz = lekRodz;
    }
      
    public Lekarz(String _imie, String _nazwisko, Date _dataurodzenia, Kontrakt _kt,RodzajLekarza lk) {
        super(_imie, _nazwisko, _dataurodzenia, _kt);
        lekRodz = lk;
    }
      
    
}
