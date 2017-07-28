package Trwalosc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;

/************************************************************************
Opis : Klasa do tworzenia trwalosci ekstensji
Stworzone przez : Dominik Deja (dddeja@wp.pl)
data swtorzenia : 2017-03-30
************************************************************************/

public class ObjectPlus implements Serializable{

	private static final long serialVersionUID = 6529685098267757690L;
	
	private static Hashtable ekstensje = new Hashtable();
        
	public ObjectPlus() {
		Vector ekstensja = null;
		Class klasa = this.getClass();
		if(ekstensje.containsKey(klasa)) {
		// Ekstensja tej klasy istnieje w kolekcji ekstensji
		ekstensja = (Vector) ekstensje.get(klasa);
		}
		else {
		// Ekstensji tej klasy jeszcze nie ma -> dodaj j�
		ekstensja = new Vector();
		ekstensje.put(klasa, ekstensja);
		}
		ekstensja.add(this);
		}
	
        public static Vector getEkstensja(Class klasa){
            Vector ekstensja = null;
            if(ekstensje.containsKey(klasa)) {
		// Ekstensja tej klasy istnieje w kolekcji ekstensji
		ekstensja = (Vector) ekstensje.get(klasa);
                return ekstensja;
            }
            return null;
        }
        
	public static void pokazEkstensje(Class klasa) throws Exception {
		Vector ekstensja = null;
		if(ekstensje.containsKey(klasa)) {
		// Ekstensja tej klasy istnieje w kolekcji ekstensji
		ekstensja = (Vector) ekstensje.get(klasa);
		}
		else{
			throw new Exception("Nieznana klasa " + klasa);
		}
		System.out.println("Ekstensja klasy: " + klasa.getSimpleName());
		for(Object obiekt : ekstensja) {
		System.out.println(obiekt);
		}
		}
	
	public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException {
		stream.writeObject(ekstensje);
		}
	public static void odczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		ekstensje =  (Hashtable) stream.readObject();
	}
	
	
}
