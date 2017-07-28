package Trening;

import java.util.Date;

import Persons.Coach;
import Persons.Pilkarz;
import Trwalosc.ObjectPlus;

/************************************************************************
Opis : Klasa do tworzenia Treningow indywidualnych
Stworzone przez : Dominik Deja (dddeja@wp.pl)
data swtorzenia : 2017-03-30
************************************************************************/

public class TreningIndywidualny extends ObjectPlus{
	
	public static enum RodzajTreningu{
		Strzelecki,Dryblingowy,Podaniowy,Dosrodkowania,Karne,Wolne,Obronny,Bramkarski
	}
	
	private RodzajTreningu rodzajtreningu;
	private Pilkarz pilkarz;
	private Coach coach;
	private Date dataTreningu;
	
	public TreningIndywidualny(Pilkarz _pilkarz,Coach _coach,Date _datatreningu,RodzajTreningu _rodzajtreningu){
		pilkarz = _pilkarz;
		coach = _coach;
		dataTreningu = _datatreningu;
		rodzajtreningu = _rodzajtreningu;
		pilkarz.DodajTreningIndywidualny(this);
		coach.dodajDodajTreningIndywidualny(this);
	}
	
	public void setRodzajTreningu(RodzajTreningu tr){
		
		rodzajtreningu = tr;
		pilkarz.usunTreningIndywidualny(this);
		coach.usunTreningIndywidualny(this);
		pilkarz.DodajTreningIndywidualny(this);
		coach.dodajDodajTreningIndywidualny(this);
	}
	public void setPilkarz(Pilkarz pilk){
		pilkarz = pilk;
		pilkarz.usunTreningIndywidualny(this);
		coach.usunTreningIndywidualny(this);
		pilkarz.DodajTreningIndywidualny(this);
		coach.dodajDodajTreningIndywidualny(this);
	}
	public void setCoach(Coach co){
		coach = co;
		pilkarz.usunTreningIndywidualny(this);
		coach.usunTreningIndywidualny(this);
		pilkarz.DodajTreningIndywidualny(this);
		coach.dodajDodajTreningIndywidualny(this);
	}
	public void setdataTreningu(Date dt){
		dataTreningu = dt;
		pilkarz.usunTreningIndywidualny(this);
		coach.usunTreningIndywidualny(this);
		pilkarz.DodajTreningIndywidualny(this);
		coach.dodajDodajTreningIndywidualny(this);
	}
	public RodzajTreningu getRodzaj(){
		return rodzajtreningu;
	}
	public Pilkarz getPilkarz(){
		return pilkarz;
	}
	public Coach getCoach(){
		return coach;
	}
	public Date getDatatreningu(){
		return dataTreningu;
	}
}
