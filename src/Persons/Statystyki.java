package Persons;

import Trwalosc.ObjectPlus;

/************************************************************************
Opis : Klasa do tworzenia statystyk dla piłkarzy
Stworzone przez : Dominik Deja (dddeja@wp.pl)
data swtorzenia : 2017-03-30
************************************************************************/

public class Statystyki extends ObjectPlus{
	
	private int iloscGoli;
	private int iloscAsyst;
	private int rozegranemecze;
	private int rozegraneminuty;
        private Pilkarz pilk;
	
	//Przeci��ony konstruktor
	
	public Statystyki(int _iloscGoli,int _iloscAsyst, int _rozegranemecze,int _rozegraneminuty){
		this.iloscGoli = _iloscGoli;
		this.iloscAsyst = _iloscAsyst;
		this.rozegranemecze = _rozegranemecze;
		this.rozegraneminuty = _rozegraneminuty;
	}
	public Statystyki(){
		this.iloscGoli = 0;
		this.iloscAsyst = 0;
		this.rozegranemecze = 0;
		this.rozegraneminuty = 0;
	}
	
	public String toString(){
		String result = "Gole = " + this.getGole() + "\n" +
						"Asysty = " + this.getAsysty() + "\n" +
						"Rozegrane mecze = " + this.getRozegraneMecze() + "\n" +
						"Rozegrane minuty = " + this.getRozegraneMinuty();
				
				return result;
	}
	//metody przeci��one
	
	public void DodajGola(int liczbaGoli){
		iloscGoli += liczbaGoli;
	}
	public void DodajGola(){
		iloscGoli++;
	}
	public void dodajAsyste(int liczbaAsyst){
		iloscAsyst += liczbaAsyst;
	}
	public void dodajAsyste(){
		iloscAsyst++;
	}
	public void dodajMecz(int liczbaMeczy){
		rozegranemecze += liczbaMeczy;
	}
	public void dodajMecz(){
		rozegranemecze++;
	}
	public void dodajMecze(int liczbaminut){
		rozegraneminuty += liczbaminut;
	}
	public int getGole(){
		return iloscGoli;
	}
	public int getAsysty(){
		return iloscAsyst;
	}
	public int getRozegraneMecze(){
		return rozegranemecze;
	}
	public int getRozegraneMinuty(){
		return rozegraneminuty;
	}
        
        public void setPilkarz(Pilkarz pk){
            pilk = pk;
        }

        public Pilkarz getPilkarz(){
            return pilk;
        }
        
    public int getIloscGoli() {
        return iloscGoli;
    }

    public void setIloscGoli(int iloscGoli) {
       this.iloscGoli = iloscGoli;;
    }

    public int getIloscAsyst() {
        return iloscAsyst;
    }

    public void setIloscAsyst(int iloscAsyst) {
        this.iloscAsyst = iloscAsyst;
        
    }

    public int getRozegranemecze() {
        return rozegranemecze;
    }

    public void setRozegranemecze(int rozegranemecze) {
        this.rozegranemecze = rozegranemecze;
    }

    public int getRozegraneminuty() {
        return rozegraneminuty;
    }

    public void setRozegraneminuty(int rozegraneminuty) {
        this.rozegraneminuty = rozegraneminuty;
    }
        
        
	
}
