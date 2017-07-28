package Team;

import Persons.Kontrakt;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import Persons.Person;
import Trwalosc.ObjectPlus;
import java.util.List;

/************************************************************************
Opis : Klasa do tworzenia ligi oraz do tworzenia zarzadu tej ligi
Stworzone przez : Dominik Deja (dddeja@wp.pl)
data swtorzenia : 2017-03-30
************************************************************************/

public class League extends ObjectPlus{
        
	private String NazwaLigi;
        private List<Druzyna> listaDruzyn = new ArrayList<Druzyna>();
        private Vector<CzlonekZarzaduLigi> Zarzad = new Vector<CzlonekZarzaduLigi>();
 
        
    public League(String _nazwaLigi) {
    	NazwaLigi = _nazwaLigi;
       // getEkstansjaLeague().add(this);
    }
    
    public String toString(){
        return NazwaLigi;
    }
    
    public static Vector<League> getEkstansjaLeague(){
        return getEkstensja(League.class);
    }
    
    public void dodajDruzyne(Druzyna dr){
        if(!listaDruzyn.contains(dr)){
        listaDruzyn.add(dr);
        dr.setLige(this);
        }
    }
    public void usunDruzyne(Druzyna dr){
        if(listaDruzyn.contains(dr)){
            listaDruzyn.remove(dr);
            dr.usunLige(this);
        }
    }
    
    public String getNazwaLigi(){
        return NazwaLigi;
    }
     public CzlonekZarzaduLigi utworzCzlonka(CzlonekZarzaduLigi cz) {
    	//CzlonekZarzaduLigi czlonek = new CzlonekZarzaduLigi(_Imie,_nazwisko,_dataurodzenia);
    	Zarzad.add(cz);
 
        return cz;
    }
    
    public CzlonekZarzaduLigi usunCzlonka(CzlonekZarzaduLigi czlonek){
    	if(Zarzad.contains(czlonek)){
    		Zarzad.remove(czlonek);
    		czlonek.usunzZarzaduLigi(this);
    	}
 
        return czlonek;
    }
    

    public class CzlonekZarzaduLigi extends Person{
		private ArrayList<League> ligi = new ArrayList<League>();
		
		public CzlonekZarzaduLigi(String _imie, String _nazwisko,
				Date _dataurodzenia,Kontrakt kt) {
			super(_imie, _nazwisko, _dataurodzenia,kt);
			Zarzad.add(this);
			// TODO Auto-generated constructor stub
		}
		public void usunzZarzaduLigi (League league){
			
			if(ligi.contains(league)){
				ligi.remove(league);
				league.usunCzlonka(this);
				
			}
		}
		public void DodajDozarzaduLigi(League league){
			
			if(!ligi.contains(league)){
				ligi.add(league);
				league.utworzCzlonka(this);
				
			}
		}
    }
}
