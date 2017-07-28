/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persons;

import java.util.Date;

/************************************************************************
Opis : Klasa do tworzenia skautów
Stworzone przez : Dominik Deja (dddeja@wp.pl)
data swtorzenia : 2017-03-30
************************************************************************/

/**
 *
 * @author Dominik Deja
 */
public class Skaut extends Person{

    public static enum RodzajSzukany{
        Napastnik,Pomocnik,Obronca,Bramkarz;
    }
    
    private RodzajSzukany szukRodz;
    
    
    public Skaut(String _imie, String _nazwisko, Date _dataurodzenia, Kontrakt _kt,RodzajSzukany _szukRodz) {
        super(_imie, _nazwisko, _dataurodzenia, _kt);
        this.szukRodz = _szukRodz;
    }
    
    
    
}
