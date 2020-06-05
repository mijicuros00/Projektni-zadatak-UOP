package radSaDatotekama;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Deo;
import model.Musterija;

public class RadSaDelovima {
	public static ArrayList<Deo> citajDelove(){
		ArrayList<Deo> delovi = new ArrayList<Deo>();
		try {
			File file = new File("src/txt/delovi.txt");
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] splittedLine = line.split("\\|");
				String id = splittedLine[0];
				String marka = splittedLine[1];
				String model = splittedLine[2];
				String naziv = splittedLine[3];
				double cena = Double.parseDouble(splittedLine[4]);
				boolean obrisan = Boolean.parseBoolean(splittedLine[5]);
				
				Deo d = new Deo(id, marka, model, naziv, cena, obrisan);
				delovi.add(d);
			}
			reader.close();
		}catch(IOException e) {
			System.out.println("Greska pri citanju iz fajla!");
		}
		return delovi;
	}
	public static void ispisDelova() {
		ArrayList<Deo> delovi = neobrisaniDelovi();
		
		for (Deo deo : delovi) {
			System.out.println(deo);
		}
	}
	
	public static void snimanjeDelova() {
		ArrayList<Deo> delovi = Vrednosti.delovi;
		try {
		File file = new File("src/txt/delovi.txt");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (Deo deo : delovi) {
			writer.write(deo.getId() + "|" + deo.getMarka() + "|" + deo.getModel() + "|" + deo.getNaziv() + "|" + deo.getCena() + "|" + deo.isObrisan() + "|" + "\n"); 
		}
		writer.close();
	
		}catch(IOException e){
			System.out.println("Greska pri upisivanju u fajl");
		}
	}
	
	public static void dodajDeo(Deo d) {
		Vrednosti.delovi.add(d);
	}
	
	public static ArrayList<Deo> pronadjiListuDelovaPoId(String splittedLine){
		ArrayList<Deo> deloviZaServis = new ArrayList<Deo>();
		String[] deloviIzFajla = splittedLine.split(";");
		ArrayList<Deo> delovi = Vrednosti.delovi;
		for (Deo deo : delovi) {
			for (int i = 0; i < deloviIzFajla.length; i++) {
				String deoIzFajla = deloviIzFajla[i];
				if(deo.getId().equals(deoIzFajla)) {
					deloviZaServis.add(deo);
					return deloviZaServis;
				}
				
			}
		}
		return null;
	}
	
	public static Deo pronadjiDeoPoId(String splittedLine) {
		ArrayList<Deo> delovi = Vrednosti.delovi;
		for (Deo d : delovi) {
			if(d.getId().equals(splittedLine)) {
				return d;
			}
			
		}
		return null;
		
	}
	
	public static ArrayList<Deo> neobrisaniDelovi(){
		ArrayList<Deo> neobrisaniDelovi = new ArrayList<Deo>();
		for(Deo d: Vrednosti.delovi) {
			if(d.isObrisan() == false) {
				neobrisaniDelovi.add(d);
			}
		}
		return neobrisaniDelovi;
	}
	
	public static void obrisiDeo(Deo d) {
		d.setObrisan(true);
	}
	
	public static void izmeniMarkuDela(Deo d, String novaMarka) {
		d.setMarka(novaMarka);
	}
	
	public static void izmeniModelDela(Deo d, String noviModel) {
		d.setModel(noviModel);
	}
	
	public static void izmeniNazivDela(Deo d, String noviNaziv) {
		d.setNaziv(noviNaziv);
	}
	
	public static void izmeniCenuDela(Deo d, double novaCena) {
		d.setCena(novaCena);
	}

}
