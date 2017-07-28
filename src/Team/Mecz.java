package Team;

import Trwalosc.ObjectPlus;

/************************************************************************
Opis : Klasa do tworzenia meczów
Stworzone przez : Dominik Deja (dddeja@wp.pl)
data swtorzenia : 2017-03-30
************************************************************************/

public class Mecz extends ObjectPlus{
	
	private static int premia = 10000;
	private Druzyna Gospodarze;
	private Druzyna Goscie;
	private String wynik;
	
	public Mecz(Druzyna _gospodarze,Druzyna _goscie){
		Gospodarze = _gospodarze;
		Goscie = _goscie;
	}
	public void WygranaGospodarzy(){
		Gospodarze.DodajPieniadze((double) premia);
	}
	public void WygranaGosci(){
		Goscie.DodajPieniadze((double) premia);
	}
	public static int getPremia(){
		return premia;
	}
}
