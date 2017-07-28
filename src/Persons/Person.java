package Persons;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import Trwalosc.ObjectPlus;


/************************************************************************
Opis : Klasa abstrakcyjna do rozszerzania innych klas
Stworzone przez : Dominik Deja (dddeja@wp.pl)
data swtorzenia : 2017-03-30
************************************************************************/

public abstract class Person extends ObjectPlus{
	private String imie;
	private String Nazwisko;
	private Date Data_Urodzenia;
        private Kontrakt kt;
	
	public Person(String _imie,String _nazwisko,Date _dataurodzenia,Kontrakt _kt){
                super();
		this.imie = _imie;
		this.Nazwisko = _nazwisko;
		this.Data_Urodzenia = _dataurodzenia;
                this.kt = _kt;
		
	}
	
	public int getWiek(){
		int result = 0;
		LocalDate today = LocalDate.now();
		LocalDate localDate = Data_Urodzenia.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate birthday = LocalDate.of(localDate.getYear(),localDate.getMonth() , localDate.getDayOfMonth());
		
		Period p = Period.between(birthday, today);
		result = p.getYears();
		return result;
	}

    public Kontrakt getKt() {
        return kt;
    }

    public void setKt(Kontrakt kt) {
        this.kt = kt;
    }
        
	public String getImie(){
		return imie;
	}
	public String getNazwisko(){
		return Nazwisko;
	}
	public Date getDataUrodzenia(){
		return Data_Urodzenia;
	}
	public String GetStringDataUrodzenia(){
		SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
		return sdfr.format(Data_Urodzenia);
	}

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String Nazwisko) {
        this.Nazwisko = Nazwisko;
    }

    public void setData_Urodzenia(Date Data_Urodzenia) {
        this.Data_Urodzenia = Data_Urodzenia;
    }
        
        
	
	public static Date SetDateFromString(String date){
		Date dt = null;
		try {
			DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
			String dateAsString = date;
			dt = sourceFormat.parse(dateAsString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dt;
	}
	
}
