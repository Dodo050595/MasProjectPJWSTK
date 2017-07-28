package Team;

import Persons.Coach;
import Persons.Pilkarz;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;
import Trening.TreningIndywidualny;
import Trwalosc.ObjectPlus;
import java.util.Collection;
import java.util.Vector;

/************************************************************************
Opis : Klasa do tworzenia druzyny z pilkarzami
Stworzone przez : Dominik Deja (dddeja@wp.pl)
data swtorzenia : 2017-03-30
************************************************************************/


public class Druzyna extends ObjectPlus{
	
	
	private String Nazwa;
	private String data_zalozenia;
	private Double Budzet;
        private League liga;
	private Coach GlownyTrener;
	private Hashtable<String,Pilkarz> listapilkarzy;
	private String DruzynaID;
	
	public void dodajPilkarz(Pilkarz pilkarz) {
		if(!listapilkarzy.containsKey(pilkarz.getPilkarzID())){
		 listapilkarzy.put (pilkarz.getPilkarzID(),pilkarz);
		 pilkarz.dodajDruzyne(this);
		}
	}
	public void pilkarze(){
		for(Pilkarz pilk : listapilkarzy.values()){
			System.out.println(pilk.toString());
		}
	}
	public static void showEkstensjaTrwalosc() throws Exception{
		ObjectPlus.pokazEkstensje(Druzyna.class);
	}
	
	public Pilkarz getPikarz(Pilkarz pilk) throws Exception{
		if(!listapilkarzy.containsKey(pilk.getPilkarzID())){
			Pilkarz pilkarz = listapilkarzy.get(pilk.getPilkarzID());
			return pilkarz;
		}else{
			//return null;
			throw new Exception("Brak takiego pilkarza w druzynie");
		}
	}
	
	public void usunPilkarzazDruzyny (Pilkarz pilkarz){
		
		if(listapilkarzy.containsKey(pilkarz.getPilkarzID())){
			listapilkarzy.remove(pilkarz.getPilkarzID());
			pilkarz.usunDruzyne(this);
		}
	}

	public static Vector<Druzyna> getEkstensjaDruzyna(){
            return getEkstensja(Druzyna.class);
        }
        
	public Druzyna(String _Nazwa,String _dt,Double _budzet,Coach _coach){
		this.Nazwa = _Nazwa;
		data_zalozenia = _dt;
		Budzet = _budzet;
		GlownyTrener = _coach;
		DruzynaID = UUID.randomUUID().toString();
		listapilkarzy = new Hashtable<String,Pilkarz>();
	}
        public Druzyna(String _Nazwa,String _dt,Double _budzet){
		this.Nazwa = _Nazwa;
		data_zalozenia = _dt;
		Budzet = _budzet;
		DruzynaID = UUID.randomUUID().toString();
		listapilkarzy = new Hashtable<String,Pilkarz>();
	}

    public void setNazwa(String Nazwa) {
        this.Nazwa = Nazwa;
    }

    public void setData_zalozenia(String data_zalozenia) {
        this.data_zalozenia = data_zalozenia;
    }

    public void setBudzet(Double Budzet) {
        this.Budzet = Budzet;
    }
        
        
        
        public Collection<Pilkarz> getPilkarze(){
              return listapilkarzy.values();
        }
        
        public void setLige(League lg){
           if(liga == null){
               liga = lg;
                lg.dodajDruzyne(this);
           }else{
                if(!liga.equals(lg)){
                liga = lg;
                lg.dodajDruzyne(this);
              }
           }
        }
        
        public void usunLige(League lg){
            if(liga != null){
                liga = lg;
                lg.usunDruzyne(this);
            }
        }
        
        public Coach getTrener(){
            return GlownyTrener;
        }
        
        public League getliga(){
            return liga;
        }
        
	public void DodajPieniadze(Double budz){
		Budzet += budz;
	}
	public void OdejmijPieniadze(Double budz){
		Budzet -= budz;
	}
	public String toString(){
		String result = Nazwa;
		
		return result;
	}
	public String getNazwa(){
		return Nazwa;
	}
	public String getDataZalozenia(){
		return data_zalozenia;
	}
	public Double getBudzet(){
		return Budzet;
	}
	public String getId(){
		return DruzynaID;
	}
	
	public void zwolnijTrenera(){
		if(GlownyTrener != null){
			GlownyTrener.usunDruzyneTrenera(this);
			GlownyTrener = null;
		}
	}
	
	public void ZatrudnijTrenera(Coach trener){
		if(GlownyTrener == null){
			GlownyTrener = trener;
			GlownyTrener.dodajDruzyneTrenera(this);
		}
	}
}
