package Persons;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import Team.Druzyna;
import Trening.TreningIndywidualny;
import Trwalosc.ObjectPlus;

/************************************************************************
Opis : Klasa do tworzenia piłkarzy
Stworzone przez : Dominik Deja (dddeja@wp.pl)
data swtorzenia : 2017-03-30
************************************************************************/

public class Pilkarz extends Person{

	
	//Treningi Indywidualne w dwoch klasach
	private ArrayList<TreningIndywidualny> TrenerzyIndywidualni = new ArrayList<TreningIndywidualny>();
	private Druzyna druzyna;
	private Statystyki statystyki; 
	
	public static enum Noga {
		Lewa, Prawa, Obie;
	}

	public static enum Pozycja {
		Bramkarz, Obronca, Pomocnik, Napastnik;
	}

	public static enum Umiejetnosci{
		Szybkosc,Technika,Dosrodkowania,Strzal,Podania,Drybling,Obrona,Wslizgi
	}
	

	
	private String PilkarzID;
	private List<Umiejetnosci> ListaUmiejtnosci;
	private String Narodowosc;
	private Pozycja pozycja;
	private Noga noga;

	public Pilkarz(String _imie, String _nazwisko, Date _dataurodzenia,Kontrakt kt,
			Noga _noga, Pozycja _poz){
		super(_imie, _nazwisko, _dataurodzenia,kt);
		this.pozycja = _poz;
		this.noga = _noga;
		statystyki = new Statystyki();
		ListaUmiejtnosci = new ArrayList<Umiejetnosci>();
		PilkarzID = UUID.randomUUID().toString();
		dodajPilkarza(this);
		//ZapiszEkstensje();
	}
	public Pilkarz(String _imie, String _nazwisko, Date _dataurodzenia,Kontrakt kt,
			Noga _noga, Pozycja _poz,String _Narodowosc){
		super(_imie, _nazwisko, _dataurodzenia,kt);
		this.pozycja = _poz;
		this.noga = _noga;
		statystyki = new Statystyki();
		ListaUmiejtnosci = new ArrayList<Umiejetnosci>();
		PilkarzID = UUID.randomUUID().toString();
		Narodowosc = _Narodowosc;
		dodajPilkarza(this);
		//ZapiszEkstensje();
	}
        public Pilkarz(String _imie, String _nazwisko, Date _dataurodzenia,Kontrakt kt,
			Noga _noga, Pozycja _poz,Statystyki st){
		super(_imie, _nazwisko, _dataurodzenia,kt);
		this.pozycja = _poz;
		this.noga = _noga;
		statystyki = st;
		ListaUmiejtnosci = new ArrayList<Umiejetnosci>();
		PilkarzID = UUID.randomUUID().toString();
		dodajPilkarza(this);
		//ZapiszEkstensje();
	}
	

	public String toString() {
		String result = "Imie = " + this.getImie() + "\n" + "Nazwisko = "
				+ this.getNazwisko() + "\n"  
				+ ((this.GetNarodowosc() == null) ? "" : "Narodowo��: " + Narodowosc + "\n") + "Data Urodzenia = "
				+ this.GetStringDataUrodzenia() + "\n" + "Wiek = " + this.getWiek()
				+ "\n" + "Pozycja = " + this.getImie() + "\n" + "Noga = "
				+ this.getNoga() + "\n"
				+ this.getStatystyki().toString() + "\n" + "Umiejetnosci = "
				+ this.WypiszUmiejetnosci() + "\n";

		return result;

	}
	
	public static Double WyliczSredniaWieku(){
		Double result = 0.0;
		if(getEkstensja().size() == 0){
			return result;
		}
		
		for(Pilkarz eks : getEkstensja()){
			result += eks.getWiek();
		}
		result = result/getEkstensja().size();
		
		return result;
		
	}
	
	public Pozycja getPozycja() {
		return pozycja;
	}

	public Noga getNoga() {
		return noga;
	}


	public static void ShowEkstensja(){
		for(Pilkarz pilk : getEkstensja()){
			System.out.println(pilk.toString());
		}
	}
	
	private void dodajPilkarza(Pilkarz pilkarz) {
            if(!pilkarz.equals(pilkarz)){
		getEkstensja().add(pilkarz);
            }
	}

	public static void usunPilkarz(Pilkarz pilkarz) {
		getEkstensja().remove(pilkarz);
		
	}

	public static Vector<Pilkarz> getEkstensja(){
		return ObjectPlus.getEkstensja(Pilkarz.class);
	}
	
	//
	public void usunDruzyne(Druzyna dr){
            if(druzyna != null){
		if(druzyna.equals(dr)){
			druzyna = null;
                        dr.usunPilkarzazDruzyny(this);
		}
            }
	}
        
        public Druzyna getDruzyna(){
            return druzyna;
        }
        
	public void dodajDruzyne(Druzyna dr){
            if(druzyna == null){
                druzyna = dr;
                dr.dodajPilkarz(this);
            }else{
            if(!druzyna.equals(dr)){
                    druzyna.usunPilkarzazDruzyny(this);
                    druzyna = dr;
                    dr.dodajPilkarz(this);
                 }
               }
	}
	public void DodajTreningIndywidualny(TreningIndywidualny tr){
		if(!TrenerzyIndywidualni.contains(tr)){
			//tr.setCoach();
			tr.setCoach(tr.getCoach());
			tr.setPilkarz(tr.getPilkarz());
			tr.setdataTreningu(tr.getDatatreningu());
			tr.setRodzajTreningu(tr.getRodzaj());
			TrenerzyIndywidualni.add(tr);
			
		}
	}
	public void usunTreningIndywidualny(TreningIndywidualny tr){
		if(TrenerzyIndywidualni.contains(tr)){
			TrenerzyIndywidualni.remove(tr);
		}
	}
	
//	private static void LoadEkstensjePilkarz() throws FileNotFoundException, IOException{
//		Vector<Pilkarz> listapilkarzy = new Vector<Pilkarz>();
//		File yourFile = new File(System.getProperty("user.home") + "\\Pilkarz.txt");
//		
//		String line;
//		try (
//		    InputStream fis = new FileInputStream(System.getProperty("user.home") + "\\Pilkarz.txt");
//		    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
//		    BufferedReader br = new BufferedReader(isr);
//		) {
//		    while ((line = br.readLine()) != null) {
//		        String[] linia = line.split(";");
//		        Pilkarz pilkarz = new Pilkarz(linia[0],linia[1],Pilkarz.SetDateFromString(linia[2]),
//		        							  Pilkarz.Noga.valueOf(linia[3]),Pilkarz.Pozycja.valueOf(linia[4]));
//		        pilkarz.setNarodowosc(linia[5]);
//		        Statystyki st = new Statystyki(Integer.valueOf(linia[6]),Integer.valueOf(linia[7]),Integer.valueOf(linia[8])
//		        								,Integer.valueOf(linia[9]));
//		        pilkarz.setStatystyki(st);
//		        
//		        line = linia[10];
//		        line = line.replace("}","").replace("{", "");
//		        String[] um = line.split(",");
//		        for(String umiej : um){
//		        if(!umiej.equals("Brak")){
//		        pilkarz.DodajUmiejetnosc(Umiejetnosci.valueOf(umiej));
//		        }
//		        }
//		        listapilkarzy.add(pilkarz);
//		    }
//		}
//		ekstensja = listapilkarzy;
//	}
	
//	private String ZapiszEkstancj�Pracownika(Pilkarz pilk) throws IOException{
//		 
//		try {
//			File yourFile = new File(System.getProperty("user.home") + "\\Pilkarz.txt");
//			yourFile.createNewFile();
//			FileOutputStream oFile = new FileOutputStream(yourFile, true); 
//			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(oFile));
//				bw.write(pilk.getImie() + ";");
//				bw.write(pilk.getNazwisko()+";");
//				bw.write(pilk.GetStringDataUrodzenia()+ ";");
//				bw.write(pilk.getNoga()+ ";");
//				bw.write(pilk.getPozycja()+ ";");
//				bw.write((pilk.GetNarodowosc()==null) ? "" + ";" : pilk.GetNarodowosc() + ";");
//				bw.write(pilk.getStatystyki().getGole()+ ";");
//				bw.write(pilk.getStatystyki().getAsysty()+ ";");
//				bw.write(pilk.getStatystyki().getRozegraneMecze()+ ";");
//				bw.write(pilk.getStatystyki().getRozegraneMinuty()+ ";");
//				bw.write(pilk.WypiszUmiejetnosci());
//				bw.newLine();
//			bw.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} // if file already exists will do nothing 
//		
//		return "Dane Zapisane";
//	}
	

	public void UsunUmiejetnosc(Umiejetnosci umiej) {
		List<Integer> indexToRemove = new ArrayList<Integer>();
		for (int i = 0; i < ListaUmiejtnosci.size(); i++) {
			if (ListaUmiejtnosci.get(i).equals(umiej)) {
				indexToRemove.add(i);
			}
		}
		for (int i = indexToRemove.size() - 1; i >= 0; i--) {
			ListaUmiejtnosci.remove(i);
		}
	}

	public void DodajUmiejetnosc(Umiejetnosci umiej) {
		ListaUmiejtnosci.add(umiej);
	}

	public String WypiszUmiejetnosci() {
		if(ListaUmiejtnosci.size() == 0){
			return "Brak";
		}
		String result = "";
		result += "{";
		
		// System.out.print("{");
		for (Umiejetnosci um : ListaUmiejtnosci) {
			if (ListaUmiejtnosci.get(ListaUmiejtnosci.size() - 1).equals(um)) {
				// System.out.print(um);
				result += um;
			} else
				// System.out.print(um + " , ");
				result += um + " , ";
		}
		result += "}";
		return result;
	}

	public Statystyki getStatystyki() {
		return statystyki;
	}
	public List<Umiejetnosci> getUmiejetnosci(){
		return ListaUmiejtnosci;
	}
	public String GetNarodowosc(){
		return Narodowosc;
	}
        
	public void setStatystyki(Statystyki st){
		statystyki = st;
         }
	public void setNarodowosc(String _narod){
		Narodowosc = _narod;
	}
	public String getPilkarzID(){
		return PilkarzID;
	}

    public void setPozycja(Pozycja pozycja) {
        this.pozycja = pozycja;
        System.out.print(getEkstensja().size());
    }

    public void setNoga(Noga noga) {
        this.noga = noga;
    }
        

}
