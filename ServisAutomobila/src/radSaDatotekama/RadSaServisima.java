package radSaDatotekama;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import model.Automobil;
import model.Deo;
import model.Musterija;
import model.Servis;
import model.Serviser;

public class RadSaServisima {
	
	
	public static ArrayList<Servis> citanjeServisa(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy. HH:mm");
		ArrayList<Servis> servisi = new ArrayList<Servis>();
		try {
			File file = new File("src/txt/servisi.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] splittedLine = line.split("\\|");
				String id = splittedLine[0];
				Serviser serviser = RadSaServiserima.pronadjiServiseraPoId(splittedLine[1]);
				Automobil automobil = RadSaAutomobilima.pronadjiAutomobilPoId(splittedLine[2]);
				ArrayList<Deo> deloviZaServis = RadSaDelovima.pronadjiListuDelovaPoId(splittedLine[3]);
				String opis = splittedLine[4];
				String datumIzFajla = splittedLine[5];
				GregorianCalendar datum = new GregorianCalendar();
				try {
					datum.setTime(formatter.parse(datumIzFajla));
				}catch(ParseException p) {
					System.out.println("Datum nije u dobrom formatu!");
				}
				boolean obrisan = Boolean.parseBoolean(splittedLine[6]);
				Servis s = new Servis(id, serviser, automobil, deloviZaServis, opis, datum, obrisan);
				servisi.add(s);
			}
			reader.close();
			
		}catch(IOException e) {
			System.out.println("Greska pri ucitavanju iz fajla");
		}
		return servisi;
	}
	
	public static void ispisServisa() {
		ArrayList<Servis> servisi = neobrisaniServisi();
		for (Servis servis : servisi) {
			System.out.println(servis);
		}
		
	}
	
	public static void snimanjeServisa() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy. HH:mm");
		ArrayList<Servis> servisi = Vrednosti.servisi;
		try {
		File file = new File("src/txt/servisi.txt");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (Servis servis : servisi) {
			
			writer.write(servis.getId() + "|" + servis.getServiser().getId() + "|" + servis.getAutomobil().getId() + "|");
			for(Deo deo : servis.getDelovi()) {
				writer.write(deo.getId() + ";" );
			}
			writer.write("|" + servis.getOpis() + "|" + formatter.format(servis.getTermin().getTime()) + "|" + servis.isObrisan() + "|" + "\n");
		}
		writer.close();
	
		}catch(IOException e){
			System.out.println("Greska pri upisivanju u fajl");
		}
	}
	
	public static void dodajServis(Servis s) {
		Vrednosti.servisi.add(s);
	}
	
	public static ArrayList<Servis> pronadjiListuServisaPoId(String splittedLine){
		ArrayList<Servis> servisi = new ArrayList<Servis>();
		ArrayList<Servis> sviServisi = Vrednosti.servisi;
		String[] servisiIzFajla = splittedLine.split(";");
		for (Servis servis : sviServisi) {
			for (String string : servisiIzFajla) {
				if(servis.getId().equals(string)) {
					servisi.add(servis);
					return servisi;
				}
			}
		}
		return null;
	}
	
	public static Servis pronadjiServisPoId(String splittedLine) {
		ArrayList<Servis> servisi = Vrednosti.servisi;
		for (Servis s : servisi) {
			if(s.getId().equals(splittedLine)) {
				return s;
			}
		}
		return null;
		
	}
	
	public static ArrayList<Servis> neobrisaniServisi(){
		ArrayList<Servis> neobrisaniServisi = new ArrayList<Servis>();
		for(Servis s: Vrednosti.servisi) {
			if(s.isObrisan() == false) {
				neobrisaniServisi.add(s);
			}
		}
		return neobrisaniServisi;
	}
	
	public static void obrisiServis(Servis s) {
		s.setObrisan(true);
	}
	
	public static void izmeniServisera(Servis s, Serviser serviser) {
		s.setServiser(serviser);
	}
	
	public static void izmeniAutomobil(Servis s, Automobil a) {
		s.setAutomobil(a);
	}
	
	public static void izmeniDeloveZaServis(Servis s, ArrayList<Deo> delovi) {
		s.setDelovi(delovi);
	}
	
	public static void izmeniOpisServisa(Servis s, String opis) {
		s.setOpis(opis);
	}
	
	public static void izmeniTermin(Servis s, GregorianCalendar termin) {
		s.setTermin(termin);
	}

}
